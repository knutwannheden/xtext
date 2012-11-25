<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version="1.0">
	<xsl:output encoding="UTF-8" method="xml" indent="yes" />
	<xsl:strip-space elements="*" />
	<xsl:param name="qualifier" />

	<xsl:template match="/">
		<xsl:processing-instruction name="artifactRepository">version='1.1.0'</xsl:processing-instruction>
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="repository/properties">
		<properties size='{@size+1}'>
			<xsl:copy-of select="property" />
			<property name='p2.statsURI' value='http://download.eclipse.org/stats/xtext' />
		</properties>
	</xsl:template>

	<xsl:template match="artifact[@classifier='org.eclipse.update.feature' and @id='org.eclipse.xtext.sdk']/properties">
		<xsl:call-template name="artifact_properties" />
	</xsl:template>

	<xsl:template
		match="artifact[@classifier='org.eclipse.update.feature' and @id='org.eclipse.xtext.runtime']/properties">
		<xsl:call-template name="artifact_properties" />
	</xsl:template>

	<xsl:template match="artifact[@classifier='org.eclipse.update.feature' and @id='org.eclipse.xtext.ui']/properties">
		<xsl:call-template name="artifact_properties" />
	</xsl:template>

	<xsl:template
		match="artifact[@classifier='org.eclipse.update.feature' and @id='org.eclipse.xtext.xbase']/properties">
		<xsl:call-template name="artifact_properties" />
	</xsl:template>

	<xsl:template
		match="artifact[@classifier='org.eclipse.update.feature' and @id='org.eclipse.xtext.docs']/properties">
		<xsl:call-template name="artifact_properties" />
	</xsl:template>

	<xsl:template
		match="artifact[@classifier='org.eclipse.update.feature' and @id='org.eclipse.xtext.examples']/properties">
		<xsl:call-template name="artifact_properties" />
	</xsl:template>

	<xsl:template
		match="artifact[@classifier='org.eclipse.update.feature' and @id='org.eclipse.xtend.sdk']/properties">
		<xsl:call-template name="artifact_properties" />
	</xsl:template>

	<xsl:template name="artifact_properties">
		<properties size='{@size+1}'>
			<xsl:copy-of select="property" />
			<property name='download.stats' value='{../@id}.feature{$qualifier}' />
		</properties>
	</xsl:template>

	<xsl:template match="*">
		<xsl:copy>
			<xsl:for-each select="@*">
				<xsl:copy-of select="." />
			</xsl:for-each>
			<xsl:apply-templates />
		</xsl:copy>
	</xsl:template>

</xsl:stylesheet>
