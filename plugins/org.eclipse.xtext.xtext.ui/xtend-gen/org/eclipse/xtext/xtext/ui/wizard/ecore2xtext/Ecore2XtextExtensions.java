package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.EPackageInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.Ecore2XtextProjectInfo;
import org.eclipse.xtext.xtext.ui.wizard.ecore2xtext.UniqueNameUtil;

/**
 * Originally written with M2T Xtend. (Ecore2Xtext.ext)<br>
 * Translated to Tools Xtend mostly 1:1.<br>
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("all")
public class Ecore2XtextExtensions {
  /**
   * cached Collection[EClassifier] allConcreteRuleClassifiers(Ecore2XtextProjectInfo this) :
   *  rootElementClass == null
   * 	? EPackageInfos.EPackage.allReferencedClassifiers(false).flatten().toSet().select(c|c.needsConcreteRule())
   *   : (let c = { rootElementClass } : rootElementClass.allAssignedClassifiers(c) -> c.select(c|c.needsConcreteRule()).toSet());
   */
  public static Iterable<EClassifier> allConcreteRuleClassifiers(final Ecore2XtextProjectInfo it) {
    Iterable<EClassifier> _xifexpression = null;
    EClass _rootElementClass = it.getRootElementClass();
    boolean _equals = ObjectExtensions.operator_equals(_rootElementClass, null);
    if (_equals) {
      Collection<EPackageInfo> _ePackageInfos = it.getEPackageInfos();
      final Function1<EPackageInfo,Set<EClassifier>> _function = new Function1<EPackageInfo,Set<EClassifier>>() {
          public Set<EClassifier> apply(final EPackageInfo it) {
            EPackage _ePackage = it.getEPackage();
            Set<EClassifier> _allReferencedClassifiers = Ecore2XtextExtensions.allReferencedClassifiers(_ePackage, false);
            return _allReferencedClassifiers;
          }
        };
      Iterable<Set<EClassifier>> _map = IterableExtensions.<EPackageInfo, Set<EClassifier>>map(_ePackageInfos, _function);
      Iterable<EClassifier> _flatten = Iterables.<EClassifier>concat(_map);
      Set<EClassifier> _set = IterableExtensions.<EClassifier>toSet(_flatten);
      final Function1<EClassifier,Boolean> _function_1 = new Function1<EClassifier,Boolean>() {
          public Boolean apply(final EClassifier it) {
            boolean _needsConcreteRule = Ecore2XtextExtensions.needsConcreteRule(it);
            return Boolean.valueOf(_needsConcreteRule);
          }
        };
      Iterable<EClassifier> _filter = IterableExtensions.<EClassifier>filter(_set, _function_1);
      _xifexpression = _filter;
    } else {
      Set<EClassifier> _xblockexpression = null;
      {
        EClass _rootElementClass_1 = it.getRootElementClass();
        EClassifier _cast = EClassifier.class.cast(_rootElementClass_1);
        final ArrayList<EClassifier> c = CollectionLiterals.<EClassifier>newArrayList(_cast);
        EClass _rootElementClass_2 = it.getRootElementClass();
        Ecore2XtextExtensions.allAssignedClassifiers(_rootElementClass_2, c);
        final Function1<EClassifier,Boolean> _function_2 = new Function1<EClassifier,Boolean>() {
            public Boolean apply(final EClassifier cl) {
              boolean _needsConcreteRule = Ecore2XtextExtensions.needsConcreteRule(cl);
              return Boolean.valueOf(_needsConcreteRule);
            }
          };
        Iterable<EClassifier> _filter_1 = IterableExtensions.<EClassifier>filter(c, _function_2);
        Set<EClassifier> _set_1 = IterableExtensions.<EClassifier>toSet(_filter_1);
        _xblockexpression = (_set_1);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  /**
   * cached Collection[EClass] allDispatcherRuleClasses(Ecore2XtextProjectInfo this) :
   * rootElementClass == null
   * ? EPackageInfos.EPackage.allReferencedClassifiers(false).flatten().toSet().select(c|c.needsDispatcherRule())
   * : allConcreteRuleClassifiers().typeSelect(EClass).collect(c|c.EAllReferences.select(r|r.needsAssignment()).EType).flatten().toSet();
   */
  public static Collection<EClass> allDispatcherRuleClasses(final Ecore2XtextProjectInfo it) {
    Set<EClass> _xifexpression = null;
    EClass _rootElementClass = it.getRootElementClass();
    boolean _equals = ObjectExtensions.operator_equals(_rootElementClass, null);
    if (_equals) {
      Collection<EPackageInfo> _ePackageInfos = it.getEPackageInfos();
      final Function1<EPackageInfo,Set<EClassifier>> _function = new Function1<EPackageInfo,Set<EClassifier>>() {
          public Set<EClassifier> apply(final EPackageInfo it) {
            EPackage _ePackage = it.getEPackage();
            Set<EClassifier> _allReferencedClassifiers = Ecore2XtextExtensions.allReferencedClassifiers(_ePackage, false);
            return _allReferencedClassifiers;
          }
        };
      Iterable<Set<EClassifier>> _map = IterableExtensions.<EPackageInfo, Set<EClassifier>>map(_ePackageInfos, _function);
      Iterable<EClassifier> _flatten = Iterables.<EClassifier>concat(_map);
      Set<EClassifier> _set = IterableExtensions.<EClassifier>toSet(_flatten);
      final Function1<EClassifier,Boolean> _function_1 = new Function1<EClassifier,Boolean>() {
          public Boolean apply(final EClassifier c) {
            boolean _needsDispatcherRule = Ecore2XtextExtensions.needsDispatcherRule(c);
            return Boolean.valueOf(_needsDispatcherRule);
          }
        };
      Iterable<EClassifier> _filter = IterableExtensions.<EClassifier>filter(_set, _function_1);
      Iterable<EClass> _filter_1 = Iterables.<EClass>filter(_filter, EClass.class);
      Set<EClass> _set_1 = IterableExtensions.<EClass>toSet(_filter_1);
      _xifexpression = _set_1;
    } else {
      Iterable<EClassifier> _allConcreteRuleClassifiers = Ecore2XtextExtensions.allConcreteRuleClassifiers(it);
      Iterable<EClass> _filter_2 = Iterables.<EClass>filter(_allConcreteRuleClassifiers, EClass.class);
      final Function1<EClass,Iterable<EClassifier>> _function_2 = new Function1<EClass,Iterable<EClassifier>>() {
          public Iterable<EClassifier> apply(final EClass c) {
            EList<EReference> _eAllReferences = c.getEAllReferences();
            final Function1<EReference,Boolean> _function = new Function1<EReference,Boolean>() {
                public Boolean apply(final EReference r) {
                  boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(r);
                  return Boolean.valueOf(_needsAssignment);
                }
              };
            Iterable<EReference> _filter = IterableExtensions.<EReference>filter(_eAllReferences, _function);
            final Function1<EReference,EClassifier> _function_1 = new Function1<EReference,EClassifier>() {
                public EClassifier apply(final EReference it) {
                  EClassifier _eType = it.getEType();
                  return _eType;
                }
              };
            Iterable<EClassifier> _map = IterableExtensions.<EReference, EClassifier>map(_filter, _function_1);
            return _map;
          }
        };
      Iterable<Iterable<EClassifier>> _map_1 = IterableExtensions.<EClass, Iterable<EClassifier>>map(_filter_2, _function_2);
      Iterable<EClassifier> _flatten_1 = Iterables.<EClassifier>concat(_map_1);
      Iterable<EClass> _filter_3 = Iterables.<EClass>filter(_flatten_1, EClass.class);
      Set<EClass> _set_2 = IterableExtensions.<EClass>toSet(_filter_3);
      _xifexpression = _set_2;
    }
    return _xifexpression;
  }
  
  /**
   * cached Collection[EPackage] allReferencedEPackages(Ecore2XtextProjectInfo this) :
   * 	EPackageInfos.EPackage.allReferencedEPackages(true).flatten().toSet();
   */
  public static Collection<EPackage> allReferencedEPackages(final Ecore2XtextProjectInfo prjInfo) {
    Collection<EPackageInfo> _ePackageInfos = prjInfo.getEPackageInfos();
    final Function1<EPackageInfo,Set<EPackage>> _function = new Function1<EPackageInfo,Set<EPackage>>() {
        public Set<EPackage> apply(final EPackageInfo it) {
          EPackage _ePackage = it.getEPackage();
          Set<EPackage> _allReferencedEPackages = Ecore2XtextExtensions.allReferencedEPackages(_ePackage, true);
          return _allReferencedEPackages;
        }
      };
    Iterable<Set<EPackage>> _map = IterableExtensions.<EPackageInfo, Set<EPackage>>map(_ePackageInfos, _function);
    Iterable<EPackage> _flatten = Iterables.<EPackage>concat(_map);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_flatten);
    return _set;
  }
  
  /**
   * private cached Collection[EPackage] allReferencedEPackages(EPackage this, boolean includeCrossRefs) :
   *  allReferencedClassifiers(includeCrossRefs).EPackage.toSet();
   */
  public static Set<EPackage> allReferencedEPackages(final EPackage ePack, final boolean includeCrossRefs) {
    Set<EClassifier> _allReferencedClassifiers = Ecore2XtextExtensions.allReferencedClassifiers(ePack, includeCrossRefs);
    final Function1<EClassifier,EPackage> _function = new Function1<EClassifier,EPackage>() {
        public EPackage apply(final EClassifier it) {
          EPackage _ePackage = it.getEPackage();
          return _ePackage;
        }
      };
    Iterable<EPackage> _map = IterableExtensions.<EClassifier, EPackage>map(_allReferencedClassifiers, _function);
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(_map);
    return _set;
  }
  
  public static Set<EClassifier> allReferencedClassifiers(final EPackage ePack, final boolean includeCrossRefs) {
    EList<EClassifier> _eClassifiers = ePack.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Function1<EClass,Iterable<EStructuralFeature>> _function = new Function1<EClass,Iterable<EStructuralFeature>>() {
        public Iterable<EStructuralFeature> apply(final EClass it) {
          EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
          final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
              public Boolean apply(final EStructuralFeature f) {
                boolean _and = false;
                boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(f);
                if (!_needsAssignment) {
                  _and = false;
                } else {
                  boolean _or = false;
                  if (includeCrossRefs) {
                    _or = true;
                  } else {
                    boolean _isContainment = Ecore2XtextExtensions.isContainment(f);
                    _or = (includeCrossRefs || _isContainment);
                  }
                  _and = (_needsAssignment && _or);
                }
                return Boolean.valueOf(_and);
              }
            };
          Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
          return _filter;
        }
      };
    final Iterable<Iterable<EStructuralFeature>> strFeatures = IterableExtensions.<EClass, Iterable<EStructuralFeature>>map(_filter, _function);
    Iterable<EStructuralFeature> _flatten = Iterables.<EStructuralFeature>concat(strFeatures);
    final Function1<EStructuralFeature,EClassifier> _function_1 = new Function1<EStructuralFeature,EClassifier>() {
        public EClassifier apply(final EStructuralFeature it) {
          EClassifier _eType = it.getEType();
          return _eType;
        }
      };
    Iterable<EClassifier> _map = IterableExtensions.<EStructuralFeature, EClassifier>map(_flatten, _function_1);
    final Set<EClassifier> refTypes = IterableExtensions.<EClassifier>toSet(_map);
    EList<EClassifier> _eClassifiers_1 = ePack.getEClassifiers();
    Iterable<EClassifier> _plus = Iterables.<EClassifier>concat(_eClassifiers_1, refTypes);
    final Set<EClassifier> retVal = IterableExtensions.<EClassifier>toSet(_plus);
    EClassifier _eString = UniqueNameUtil.eString();
    retVal.add(_eString);
    return retVal;
  }
  
  /**
   * private cached allAssignedClassifiers(EClass this, Collection acceptor) :
   * (let classifiers = (EAllStructuralFeatures.select(f|f.needsAssignment()).EType).union(subClasses()).removeAll(acceptor) :
   * classifiers.isEmpty
   * ? null
   * : (acceptor.addAll(classifiers) ->
   * classifiers.typeSelect(EClass).collect(c|c.allAssignedClassifiers(acceptor))));
   */
  private static void allAssignedClassifiers(final EClass eClazz, final Collection acceptor) {
    EList<EStructuralFeature> _eAllStructuralFeatures = eClazz.getEAllStructuralFeatures();
    final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
        public Boolean apply(final EStructuralFeature f) {
          boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(f);
          return Boolean.valueOf(_needsAssignment);
        }
      };
    Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
    final Function1<EStructuralFeature,EClassifier> _function_1 = new Function1<EStructuralFeature,EClassifier>() {
        public EClassifier apply(final EStructuralFeature it) {
          EClassifier _eType = it.getEType();
          return _eType;
        }
      };
    Iterable<EClassifier> _map = IterableExtensions.<EStructuralFeature, EClassifier>map(_filter, _function_1);
    final List<EClassifier> classifiers = IterableExtensions.<EClassifier>toList(_map);
    Iterable<EClass> _subClasses = Ecore2XtextExtensions.subClasses(eClazz);
    Iterables.<EClassifier>addAll(classifiers, _subClasses);
    classifiers.removeAll(acceptor);
    boolean _isEmpty = classifiers.isEmpty();
    if (_isEmpty) {
      return;
    } else {
      Iterables.<EClassifier>addAll(acceptor, classifiers);
      Iterable<EClass> _filter_1 = Iterables.<EClass>filter(classifiers, EClass.class);
      final Procedure1<EClass> _function_2 = new Procedure1<EClass>() {
          public void apply(final EClass c) {
            Ecore2XtextExtensions.allAssignedClassifiers(c, acceptor);
          }
        };
      IterableExtensions.<EClass>forEach(_filter_1, _function_2);
    }
  }
  
  public static String fqn(final EClassifier it) {
    String _xifexpression = null;
    EPackage _ePackage = it.getEPackage();
    String _uniqueName = UniqueNameUtil.uniqueName(_ePackage);
    boolean _equals = ObjectExtensions.operator_equals(_uniqueName, null);
    if (_equals) {
      String _name = it.getName();
      String _quoteIfNeccesary = Ecore2XtextExtensions.quoteIfNeccesary(_name);
      _xifexpression = _quoteIfNeccesary;
    } else {
      EPackage _ePackage_1 = it.getEPackage();
      String _uniqueName_1 = UniqueNameUtil.uniqueName(_ePackage_1);
      String _plus = (_uniqueName_1 + "::");
      String _name_1 = it.getName();
      String _quoteIfNeccesary_1 = Ecore2XtextExtensions.quoteIfNeccesary(_name_1);
      String _plus_1 = (_plus + _quoteIfNeccesary_1);
      _xifexpression = _plus_1;
    }
    return _xifexpression;
  }
  
  public static Iterable<EStructuralFeature> prefixFeatures(final EClass it) {
    EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
    final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
        public Boolean apply(final EStructuralFeature f) {
          boolean _and = false;
          boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(f);
          if (!_needsAssignment) {
            _and = false;
          } else {
            boolean _isPrefixBooleanFeature = Ecore2XtextExtensions.isPrefixBooleanFeature(f);
            _and = (_needsAssignment && _isPrefixBooleanFeature);
          }
          return Boolean.valueOf(_and);
        }
      };
    Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
    return _filter;
  }
  
  /**
   * cached inlinedFeatures(EClass this) :
   * EAllStructuralFeatures.select(f|f.needsAssignment()).remove(idAttribute()).removeAll(prefixFeatures());
   */
  public static Iterable<EStructuralFeature> inlinedFeatures(final EClass it) {
    EList<EStructuralFeature> _eAllStructuralFeatures = it.getEAllStructuralFeatures();
    final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
        public Boolean apply(final EStructuralFeature f) {
          boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(f);
          return Boolean.valueOf(_needsAssignment);
        }
      };
    Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(_eAllStructuralFeatures, _function);
    final List<EStructuralFeature> features = IterableExtensions.<EStructuralFeature>toList(_filter);
    EAttribute _idAttribute = Ecore2XtextExtensions.idAttribute(it);
    features.remove(_idAttribute);
    Iterable<EStructuralFeature> _prefixFeatures = Ecore2XtextExtensions.prefixFeatures(it);
    List<EStructuralFeature> _list = IterableExtensions.<EStructuralFeature>toList(_prefixFeatures);
    features.removeAll(_list);
    return features;
  }
  
  public static boolean onlyOptionalFeatures(final EClass it) {
    boolean _xblockexpression = false;
    {
      Iterable<EStructuralFeature> _prefixFeatures = Ecore2XtextExtensions.prefixFeatures(it);
      Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
      final Iterable<EStructuralFeature> features = Iterables.<EStructuralFeature>concat(_prefixFeatures, _inlinedFeatures);
      final Function1<EStructuralFeature,Boolean> _function = new Function1<EStructuralFeature,Boolean>() {
          public Boolean apply(final EStructuralFeature f) {
            boolean _isRequired = f.isRequired();
            return Boolean.valueOf(_isRequired);
          }
        };
      Iterable<EStructuralFeature> _filter = IterableExtensions.<EStructuralFeature>filter(features, _function);
      boolean _isEmpty = IterableExtensions.isEmpty(_filter);
      _xblockexpression = (_isEmpty);
    }
    return _xblockexpression;
  }
  
  /**
   * assignedRuleCall(EAttribute this):
   * (isPrefixBooleanFeature()) ? "'"+name+"'" : EType.uniqueName();
   */
  public static String assignedRuleCall(final EAttribute it) {
    String _xifexpression = null;
    boolean _isPrefixBooleanFeature = Ecore2XtextExtensions.isPrefixBooleanFeature(it);
    if (_isPrefixBooleanFeature) {
      String _name = it.getName();
      String _plus = ("\'" + _name);
      String _plus_1 = (_plus + "\'");
      _xifexpression = _plus_1;
    } else {
      EClassifier _eType = it.getEType();
      String _uniqueName = UniqueNameUtil.uniqueName(_eType);
      _xifexpression = _uniqueName;
    }
    return _xifexpression;
  }
  
  public static String concreteRuleName(final EClass it) {
    String _xifexpression = null;
    boolean _needsDispatcherRule = Ecore2XtextExtensions.needsDispatcherRule(it);
    if (_needsDispatcherRule) {
      String _uniqueImplName = UniqueNameUtil.uniqueImplName(it);
      _xifexpression = _uniqueImplName;
    } else {
      String _uniqueName = UniqueNameUtil.uniqueName(it);
      _xifexpression = _uniqueName;
    }
    return _xifexpression;
  }
  
  public static String dataTypeRuleBody(final EDataType it) {
    String _switchResult = null;
    String _name = it.getName();
    final String getName = _name;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(getName,"EBigDecimal")) {
        _matched=true;
        _switchResult = "INT? \'.\' INT";
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EBigInteger")) {
        _matched=true;
        String _intRuleBody = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EBoolean")) {
        _matched=true;
        String _booleanRuleBody = Ecore2XtextExtensions.booleanRuleBody();
        _switchResult = _booleanRuleBody;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EBooleanObject")) {
        _matched=true;
        String _booleanRuleBody_1 = Ecore2XtextExtensions.booleanRuleBody();
        _switchResult = _booleanRuleBody_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EByte")) {
        _matched=true;
        String _intRuleBody_1 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EByteObject")) {
        _matched=true;
        String _intRuleBody_2 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_2;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EChar")) {
        _matched=true;
        String _intRuleBody_3 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_3;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"ECharObject")) {
        _matched=true;
        String _intRuleBody_4 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_4;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EDouble")) {
        _matched=true;
        String _decimalRuleBody = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EDoubleObject")) {
        _matched=true;
        String _decimalRuleBody_1 = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody_1;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EFloat")) {
        _matched=true;
        String _decimalRuleBody_2 = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody_2;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EFloatObject")) {
        _matched=true;
        String _decimalRuleBody_3 = Ecore2XtextExtensions.decimalRuleBody();
        _switchResult = _decimalRuleBody_3;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EInt")) {
        _matched=true;
        String _intRuleBody_5 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_5;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EIntegerObject")) {
        _matched=true;
        String _intRuleBody_6 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_6;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"ELong")) {
        _matched=true;
        String _intRuleBody_7 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_7;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"ELongObject")) {
        _matched=true;
        String _intRuleBody_8 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_8;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EShort")) {
        _matched=true;
        String _intRuleBody_9 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_9;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EShortObject")) {
        _matched=true;
        String _intRuleBody_10 = Ecore2XtextExtensions.intRuleBody();
        _switchResult = _intRuleBody_10;
      }
    }
    if (!_matched) {
      if (Objects.equal(getName,"EString")) {
        _matched=true;
        _switchResult = "STRING | ID";
      }
    }
    if (!_matched) {
      String _name_1 = it.getName();
      String _plus = ("\'" + _name_1);
      String _plus_1 = (_plus + "\' /* TODO: implement this rule and an appropriate IValueConverter */");
      _switchResult = _plus_1;
    }
    return _switchResult;
  }
  
  public static String intRuleBody() {
    return "\'-\'? INT";
  }
  
  public static String decimalRuleBody() {
    return "\'-\'? INT? \'.\' INT ((\'E\'|\'e\') \'-\'? INT)?";
  }
  
  public static String booleanRuleBody() {
    return "\'true\' | \'false\'";
  }
  
  /**
   * assignmentKeyword(EStructuralFeature this) :
   * isPrefixBooleanFeature() ? "" : "'" + name + "' ";
   */
  public static String assignmentKeyword(final EStructuralFeature it) {
    String _xifexpression = null;
    boolean _isPrefixBooleanFeature = Ecore2XtextExtensions.isPrefixBooleanFeature(it);
    if (_isPrefixBooleanFeature) {
      _xifexpression = "";
    } else {
      String _name = it.getName();
      String _plus = ("\'" + _name);
      String _plus_1 = (_plus + "\' ");
      _xifexpression = _plus_1;
    }
    return _xifexpression;
  }
  
  /**
   * quoteIfNeccesary(String this) :
   * isXtextKeyword() ? '^' + this : this;
   */
  public static String quoteIfNeccesary(final String str) {
    String _xifexpression = null;
    boolean _isXtextKeyword = Ecore2XtextExtensions.isXtextKeyword(str);
    if (_isXtextKeyword) {
      String _plus = ("^" + str);
      _xifexpression = _plus;
    } else {
      _xifexpression = str;
    }
    return _xifexpression;
  }
  
  public static boolean isXtextKeyword(final String str) {
    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("returns", "generate", "terminal", "with", "hidden", "enum", "grammar", 
      "import", "as", "current", "fragment", "EOF");
    boolean _contains = _newArrayList.contains(str);
    return _contains;
  }
  
  public static EAttribute idAttribute(final EClass it) {
    EAttribute _xblockexpression = null;
    {
      final EAttribute idAttr = Ecore2XtextExtensions.idAttributeInternal(it);
      EAttribute _xifexpression = null;
      boolean _notEquals = ObjectExtensions.operator_notEquals(idAttr, null);
      if (_notEquals) {
        _xifexpression = idAttr;
      } else {
        EList<EAttribute> _eAllAttributes = it.getEAllAttributes();
        final Function1<EAttribute,Boolean> _function = new Function1<EAttribute,Boolean>() {
            public Boolean apply(final EAttribute a) {
              boolean _and = false;
              boolean _and_1 = false;
              boolean _and_2 = false;
              boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(a);
              if (!_needsAssignment) {
                _and_2 = false;
              } else {
                String _name = a.getName();
                boolean _equals = ObjectExtensions.operator_equals(_name, "name");
                _and_2 = (_needsAssignment && _equals);
              }
              if (!_and_2) {
                _and_1 = false;
              } else {
                EClassifier _eType = a.getEType();
                String _name_1 = _eType.getName();
                boolean _equals_1 = ObjectExtensions.operator_equals(_name_1, "EString");
                _and_1 = (_and_2 && _equals_1);
              }
              if (!_and_1) {
                _and = false;
              } else {
                boolean _isMany = a.isMany();
                boolean _not = (!_isMany);
                _and = (_and_1 && _not);
              }
              return Boolean.valueOf(_and);
            }
          };
        EAttribute _findFirst = IterableExtensions.<EAttribute>findFirst(_eAllAttributes, _function);
        _xifexpression = _findFirst;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  private static EAttribute idAttributeInternal(final EClass it) {
    EList<EAttribute> _eAllAttributes = it.getEAllAttributes();
    final Function1<EAttribute,Boolean> _function = new Function1<EAttribute,Boolean>() {
        public Boolean apply(final EAttribute a) {
          boolean _and = false;
          boolean _needsAssignment = Ecore2XtextExtensions.needsAssignment(a);
          if (!_needsAssignment) {
            _and = false;
          } else {
            boolean _isID = a.isID();
            _and = (_needsAssignment && _isID);
          }
          return Boolean.valueOf(_and);
        }
      };
    EAttribute _findFirst = IterableExtensions.<EAttribute>findFirst(_eAllAttributes, _function);
    return _findFirst;
  }
  
  public static boolean isBoolean(final EClassifier it) {
    boolean _and = false;
    boolean _and_1 = false;
    if (!(it instanceof EDataType)) {
      _and_1 = false;
    } else {
      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("EBoolean", "EBooleanObject");
      String _name = it.getName();
      boolean _contains = _newArrayList.contains(_name);
      _and_1 = ((it instanceof EDataType) && _contains);
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isEcoreType = Ecore2XtextExtensions.isEcoreType(it);
      _and = (_and_1 && _isEcoreType);
    }
    return _and;
  }
  
  public static boolean isPrefixBooleanFeature(final EStructuralFeature it) {
    boolean _and = false;
    boolean _and_1 = false;
    EClassifier _eType = it.getEType();
    boolean _isBoolean = Ecore2XtextExtensions.isBoolean(_eType);
    if (!_isBoolean) {
      _and_1 = false;
    } else {
      boolean _isMany = it.isMany();
      boolean _not = (!_isMany);
      _and_1 = (_isBoolean && _not);
    }
    if (!_and_1) {
      _and = false;
    } else {
      String _defaultValueLiteral = it.getDefaultValueLiteral();
      boolean _notEquals = ObjectExtensions.operator_notEquals(_defaultValueLiteral, "true");
      _and = (_and_1 && _notEquals);
    }
    return _and;
  }
  
  public static boolean isString(final EClassifier it) {
    boolean _and = false;
    boolean _and_1 = false;
    if (!(it instanceof EDataType)) {
      _and_1 = false;
    } else {
      String _name = it.getName();
      boolean _equals = ObjectExtensions.operator_equals(_name, "EString");
      _and_1 = ((it instanceof EDataType) && _equals);
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isEcoreType = Ecore2XtextExtensions.isEcoreType(it);
      _and = (_and_1 && _isEcoreType);
    }
    return _and;
  }
  
  public static boolean isEcoreType(final EClassifier it) {
    EPackage _ePackage = it.getEPackage();
    String _nsURI = _ePackage.getNsURI();
    boolean _equals = ObjectExtensions.operator_equals(_nsURI, "http://www.eclipse.org/emf/2002/Ecore");
    return _equals;
  }
  
  public static boolean isID(final EStructuralFeature it) {
    boolean _and = false;
    if (!(it instanceof EAttribute)) {
      _and = false;
    } else {
      EAttribute _cast = EAttribute.class.cast(it);
      boolean _isID = _cast.isID();
      _and = ((it instanceof EAttribute) && _isID);
    }
    return _and;
  }
  
  public static boolean needsAssignment(final EStructuralFeature it) {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _isDerived = it.isDerived();
    boolean _not = (!_isDerived);
    if (!_not) {
      _and_2 = false;
    } else {
      boolean _isTransient = it.isTransient();
      boolean _not_1 = (!_isTransient);
      _and_2 = (_not && _not_1);
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _and_3 = false;
      if (!(it instanceof EReference)) {
        _and_3 = false;
      } else {
        EReference _cast = EReference.class.cast(it);
        boolean _isContainer = _cast.isContainer();
        _and_3 = ((it instanceof EReference) && _isContainer);
      }
      boolean _not_2 = (!_and_3);
      _and_1 = (_and_2 && _not_2);
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _and_4 = false;
      EClassifier _eType = it.getEType();
      if (!(_eType instanceof EDataType)) {
        _and_4 = false;
      } else {
        EClassifier _eType_1 = it.getEType();
        EDataType _cast_1 = EDataType.class.cast(_eType_1);
        boolean _isSerializable = _cast_1.isSerializable();
        boolean _not_3 = (!_isSerializable);
        _and_4 = ((_eType instanceof EDataType) && _not_3);
      }
      boolean _not_4 = (!_and_4);
      _and = (_and_1 && _not_4);
    }
    return _and;
  }
  
  /**
   * boolean needsConcreteRule(EClass this) :
   * 	!abstract && !interface;
   */
  public static boolean needsConcreteRule(final EClassifier eClassifier) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (eClassifier instanceof EClass) {
        final EClass _eClass = (EClass)eClassifier;
        _matched=true;
        boolean _and = false;
        boolean _isAbstract = _eClass.isAbstract();
        boolean _not = (!_isAbstract);
        if (!_not) {
          _and = false;
        } else {
          boolean _isInterface = _eClass.isInterface();
          boolean _not_1 = (!_isInterface);
          _and = (_not && _not_1);
        }
        _switchResult = _and;
      }
    }
    if (!_matched) {
      if (eClassifier instanceof EClassifier) {
        final EClassifier _eClassifier = (EClassifier)eClassifier;
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      _switchResult = true;
    }
    return _switchResult;
  }
  
  public static boolean needsDispatcherRule(final EClassifier eClassifier) {
    Boolean _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (eClassifier instanceof EClass) {
        final EClass _eClass = (EClass)eClassifier;
        _matched=true;
        Iterable<EClass> _subClasses = Ecore2XtextExtensions.subClasses(_eClass);
        final Function1<EClass,Boolean> _function = new Function1<EClass,Boolean>() {
            public Boolean apply(final EClass c) {
              boolean _needsConcreteRule = Ecore2XtextExtensions.needsConcreteRule(c);
              return Boolean.valueOf(_needsConcreteRule);
            }
          };
        Iterable<EClass> _filter = IterableExtensions.<EClass>filter(_subClasses, _function);
        boolean _isEmpty = IterableExtensions.isEmpty(_filter);
        boolean _not = (!_isEmpty);
        _switchResult = _not;
      }
    }
    if (!_matched) {
      if (eClassifier instanceof EClassifier) {
        final EClassifier _eClassifier = (EClassifier)eClassifier;
        _matched=true;
        _switchResult = false;
      }
    }
    return (_switchResult).booleanValue();
  }
  
  /**
   * isContainment(EStructuralFeature this) : false;
   * isContainment(EAttribute this) : true;
   * isContainment(EReference this) : containment;
   */
  public static boolean isContainment(final EStructuralFeature eStrFeat) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (eStrFeat instanceof EAttribute) {
        final EAttribute _eAttribute = (EAttribute)eStrFeat;
        _matched=true;
        _switchResult = true;
      }
    }
    if (!_matched) {
      if (eStrFeat instanceof EReference) {
        final EReference _eReference = (EReference)eStrFeat;
        _matched=true;
        boolean _isContainment = _eReference.isContainment();
        _switchResult = _isContainment;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  /**
   * cached subClasses(EClass this):
   * EPackage.EClassifiers.typeSelect(EClass).select(c|c.EAllSuperTypes.contains(this));
   */
  public static Iterable<EClass> subClasses(final EClass it) {
    EPackage _ePackage = it.getEPackage();
    EList<EClassifier> _eClassifiers = _ePackage.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Function1<EClass,Boolean> _function = new Function1<EClass,Boolean>() {
        public Boolean apply(final EClass c) {
          EList<EClass> _eAllSuperTypes = c.getEAllSuperTypes();
          boolean _contains = _eAllSuperTypes.contains(it);
          return Boolean.valueOf(_contains);
        }
      };
    Iterable<EClass> _filter_1 = IterableExtensions.<EClass>filter(_filter, _function);
    return _filter_1;
  }
  
  /**
   * allAttributes(EClass this) :
   * inlinedFeatures().typeSelect(EAttribute);
   * 
   * allCrossReferences(EClass this) :
   * inlinedFeatures().typeSelect(EReference).select(r|!r.isContainment());
   * 
   * allContainmentReferences(EClass this) :
   * inlinedFeatures().typeSelect(EReference).select(r|r.isContainment());
   */
  public static Iterable<EAttribute> allAttributes(final EClass it) {
    Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
    Iterable<EAttribute> _filter = Iterables.<EAttribute>filter(_inlinedFeatures, EAttribute.class);
    return _filter;
  }
  
  public static Iterable<EReference> allCrossReferences(final EClass it) {
    Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
    Iterable<EReference> _filter = Iterables.<EReference>filter(_inlinedFeatures, EReference.class);
    final Function1<EReference,Boolean> _function = new Function1<EReference,Boolean>() {
        public Boolean apply(final EReference f) {
          boolean _isContainment = f.isContainment();
          boolean _not = (!_isContainment);
          return Boolean.valueOf(_not);
        }
      };
    Iterable<EReference> _filter_1 = IterableExtensions.<EReference>filter(_filter, _function);
    return _filter_1;
  }
  
  public static Iterable<EReference> allContainmentReferences(final EClass it) {
    Iterable<EStructuralFeature> _inlinedFeatures = Ecore2XtextExtensions.inlinedFeatures(it);
    Iterable<EReference> _filter = Iterables.<EReference>filter(_inlinedFeatures, EReference.class);
    final Function1<EReference,Boolean> _function = new Function1<EReference,Boolean>() {
        public Boolean apply(final EReference f) {
          boolean _isContainment = f.isContainment();
          return Boolean.valueOf(_isContainment);
        }
      };
    Iterable<EReference> _filter_1 = IterableExtensions.<EReference>filter(_filter, _function);
    return _filter_1;
  }
}
