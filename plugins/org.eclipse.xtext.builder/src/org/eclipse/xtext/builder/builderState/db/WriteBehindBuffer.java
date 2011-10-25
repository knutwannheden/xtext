/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState.db;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.Maps;

/**
 * Asynchronous write behind buffer which periodically (every 100 ms) flushes the buffered resources to the DB.
 * 
 * @author Knut Wannheden - Initial contribution and API
 */
class WriteBehindBuffer implements Runnable {

	private static final Logger LOG = Logger.getLogger(WriteBehindBuffer.class);

	private static final int DELAY = 100;

	private final DBBasedBuilderState index;
	private final IAcceptor<Collection<IResourceDescription>> flushAcceptor;

	/**
	 * Creates a new instance of {@link WriteBehindBuffer}.
	 * 
	 * @param index
	 *            index
	 * @param flushAcceptor
	 *            acceptor to accept flushed resources
	 */
	public WriteBehindBuffer(final DBBasedBuilderState index, final IAcceptor<Collection<IResourceDescription>> flushAcceptor) {
		this.index = index;
		this.flushAcceptor = flushAcceptor;
	}

	private Map<URI, IResourceDescription> buffer = Maps.newLinkedHashMap();

	private final Lock bufferFlushLock = new ReentrantLock();
	private final Condition bufferFlushed = bufferFlushLock.newCondition();

	private ScheduledExecutorService bufferFlushScheduler;

	/**
	 * Starts the write behind buffer thread.
	 */
	public void start() {
		bufferFlushScheduler = Executors.newSingleThreadScheduledExecutor();
		bufferFlushScheduler.scheduleWithFixedDelay(this, DELAY, DELAY, TimeUnit.MILLISECONDS);
	}

	/**
	 * Immediately stops the write behind buffer thread.
	 */
	public void stop() {
		bufferFlushScheduler.shutdownNow();
	}

	/** {@inheritDoc} */
	public void run() {
		bufferFlushLock.lock();
		Collection<IResourceDescription> bufferCopy = clear();
		try {
			if (!bufferCopy.isEmpty()) {
				index.updateResources(bufferCopy);
			}
		} catch (Exception e) {
			LOG.error("Failed flushing buffer " + bufferCopy, e);
		} finally {
			bufferFlushed.signalAll();
			bufferFlushLock.unlock();
		}
		flushAcceptor.accept(bufferCopy);
	}

	/**
	 * Adds a resource description to the buffer.
	 * 
	 * @param uri
	 *            uri of resource
	 * @param description
	 *            resource description
	 */
	public synchronized void put(final URI uri, final IResourceDescription description) {
		buffer.put(uri, description);
	}

	/**
	 * Blocks until the current buffer contents have been flushed. It is not specified whether concurrently
	 * {@link #put(URI, IResourceDescription) added resources} will be flushed or not.
	 */
	public void flush() {
		// TODO simplify locking
		bufferFlushLock.lock();
		boolean awaitFlush;
		synchronized (this) {
			awaitFlush = !buffer.isEmpty(); // NOPMD
		}
		try {
			if (awaitFlush) {
				bufferFlushed.await();
			}
		} catch (InterruptedException e) {
			throw new IllegalStateException(e);
		} finally {
			bufferFlushLock.unlock();
		}
	}

	/**
	 * Clears and returns old buffer contents.
	 * 
	 * @return old buffer contents
	 */
	private Collection<IResourceDescription> clear() {
		Map<URI, IResourceDescription> oldBuffer = null;
		synchronized (this) {
			oldBuffer = buffer;
			buffer = Maps.newLinkedHashMap();
		}
		return oldBuffer.values();
	}
}
