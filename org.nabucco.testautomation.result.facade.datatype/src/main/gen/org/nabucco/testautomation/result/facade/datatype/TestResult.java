/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Duration;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.property.facade.datatype.base.HierarchyLevelType;
import org.nabucco.testautomation.property.facade.datatype.base.LongText;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigElementStatusType;

/**
 * TestResult<p/>A basic TestResult<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public class TestResult extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m0,1;", "l0,255;u0,n;m1,1;",
            "l0,16;u0,n;m0,1;", "l0,255;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,10000;u0,n;m0,1;", "l0,100000;u0,n;m0,1;", "l0,n;u0,n;m1,1;",
            "m0,n;", "m0,n;" };

    public static final String LEVEL = "level";

    public static final String STATUS = "status";

    public static final String BRANDTYPE = "brandType";

    public static final String NAME = "name";

    public static final String TESTCONFIGELEMENTKEY = "testConfigElementKey";

    public static final String TESTCONFIGELEMENTNAME = "testConfigElementName";

    public static final String TESTCONFIGELEMENTID = "testConfigElementId";

    public static final String SCHEMAELEMENTID = "schemaElementId";

    public static final String STARTTIME = "startTime";

    public static final String ENDTIME = "endTime";

    public static final String DURATION = "duration";

    public static final String MESSAGE = "message";

    public static final String ERRORMESSAGE = "errorMessage";

    public static final String JIRAEXPORT = "jiraExport";

    public static final String TESTRESULTLIST = "testResultList";

    public static final String TESTSCRIPTRESULTLIST = "testScriptResultList";

    private HierarchyLevelType level;

    private TestConfigElementStatusType status;

    private Code brandType;

    private Long brandTypeRefId;

    protected static final String BRANDTYPE_CODEPATH = "nabucco.testautomation.brand";

    private Name name;

    private Key testConfigElementKey;

    private Name testConfigElementName;

    private Identifier testConfigElementId;

    private Identifier schemaElementId;

    private Date startTime;

    private Date endTime;

    private Duration duration;

    private LongText message;

    private LongText errorMessage;

    private Flag jiraExport;

    private NabuccoList<TestResultContainer> testResultList;

    private NabuccoList<TestScriptResult> testScriptResultList;

    /** Constructs a new TestResult instance. */
    public TestResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the TestResult.
     */
    protected void cloneObject(TestResult clone) {
        super.cloneObject(clone);
        clone.setLevel(this.getLevel());
        clone.setStatus(this.getStatus());
        if ((this.getBrandType() != null)) {
            clone.setBrandType(this.getBrandType().cloneObject());
        }
        if ((this.getBrandTypeRefId() != null)) {
            clone.setBrandTypeRefId(this.getBrandTypeRefId());
        }
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getTestConfigElementKey() != null)) {
            clone.setTestConfigElementKey(this.getTestConfigElementKey().cloneObject());
        }
        if ((this.getTestConfigElementName() != null)) {
            clone.setTestConfigElementName(this.getTestConfigElementName().cloneObject());
        }
        if ((this.getTestConfigElementId() != null)) {
            clone.setTestConfigElementId(this.getTestConfigElementId().cloneObject());
        }
        if ((this.getSchemaElementId() != null)) {
            clone.setSchemaElementId(this.getSchemaElementId().cloneObject());
        }
        if ((this.getStartTime() != null)) {
            clone.setStartTime(this.getStartTime().cloneObject());
        }
        if ((this.getEndTime() != null)) {
            clone.setEndTime(this.getEndTime().cloneObject());
        }
        if ((this.getDuration() != null)) {
            clone.setDuration(this.getDuration().cloneObject());
        }
        if ((this.getMessage() != null)) {
            clone.setMessage(this.getMessage().cloneObject());
        }
        if ((this.getErrorMessage() != null)) {
            clone.setErrorMessage(this.getErrorMessage().cloneObject());
        }
        if ((this.getJiraExport() != null)) {
            clone.setJiraExport(this.getJiraExport().cloneObject());
        }
        if ((this.testResultList != null)) {
            clone.testResultList = this.testResultList.cloneCollection();
        }
        if ((this.testScriptResultList != null)) {
            clone.testScriptResultList = this.testScriptResultList.cloneCollection();
        }
    }

    /**
     * Getter for the TestResultListJPA.
     *
     * @return the List<TestResultContainer>.
     */
    List<TestResultContainer> getTestResultListJPA() {
        if ((this.testResultList == null)) {
            this.testResultList = new NabuccoListImpl<TestResultContainer>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<TestResultContainer>) this.testResultList).getDelegate();
    }

    /**
     * Setter for the TestResultListJPA.
     *
     * @param testResultList the List<TestResultContainer>.
     */
    void setTestResultListJPA(List<TestResultContainer> testResultList) {
        if ((this.testResultList == null)) {
            this.testResultList = new NabuccoListImpl<TestResultContainer>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<TestResultContainer>) this.testResultList).setDelegate(testResultList);
    }

    /**
     * Getter for the TestScriptResultListJPA.
     *
     * @return the List<TestScriptResult>.
     */
    List<TestScriptResult> getTestScriptResultListJPA() {
        if ((this.testScriptResultList == null)) {
            this.testScriptResultList = new NabuccoListImpl<TestScriptResult>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<TestScriptResult>) this.testScriptResultList).getDelegate();
    }

    /**
     * Setter for the TestScriptResultListJPA.
     *
     * @param testScriptResultList the List<TestScriptResult>.
     */
    void setTestScriptResultListJPA(List<TestScriptResult> testScriptResultList) {
        if ((this.testScriptResultList == null)) {
            this.testScriptResultList = new NabuccoListImpl<TestScriptResult>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<TestScriptResult>) this.testScriptResultList).setDelegate(testScriptResultList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(LEVEL, PropertyDescriptorSupport.createEnumeration(LEVEL, HierarchyLevelType.class, 3,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(STATUS, PropertyDescriptorSupport.createEnumeration(STATUS, TestConfigElementStatusType.class,
                4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(BRANDTYPE, PropertyDescriptorSupport.createDatatype(BRANDTYPE, Code.class, 5,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT, BRANDTYPE_CODEPATH));
        propertyMap.put(NAME,
                PropertyDescriptorSupport.createBasetype(NAME, Name.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(TESTCONFIGELEMENTKEY, PropertyDescriptorSupport.createBasetype(TESTCONFIGELEMENTKEY, Key.class,
                7, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(TESTCONFIGELEMENTNAME, PropertyDescriptorSupport.createBasetype(TESTCONFIGELEMENTNAME,
                Name.class, 8, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(TESTCONFIGELEMENTID, PropertyDescriptorSupport.createBasetype(TESTCONFIGELEMENTID,
                Identifier.class, 9, PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(SCHEMAELEMENTID, PropertyDescriptorSupport.createBasetype(SCHEMAELEMENTID, Identifier.class,
                10, PROPERTY_CONSTRAINTS[7], false));
        propertyMap.put(STARTTIME,
                PropertyDescriptorSupport.createBasetype(STARTTIME, Date.class, 11, PROPERTY_CONSTRAINTS[8], false));
        propertyMap.put(ENDTIME,
                PropertyDescriptorSupport.createBasetype(ENDTIME, Date.class, 12, PROPERTY_CONSTRAINTS[9], false));
        propertyMap
                .put(DURATION, PropertyDescriptorSupport.createBasetype(DURATION, Duration.class, 13,
                        PROPERTY_CONSTRAINTS[10], false));
        propertyMap.put(MESSAGE,
                PropertyDescriptorSupport.createBasetype(MESSAGE, LongText.class, 14, PROPERTY_CONSTRAINTS[11], false));
        propertyMap.put(ERRORMESSAGE, PropertyDescriptorSupport.createBasetype(ERRORMESSAGE, LongText.class, 15,
                PROPERTY_CONSTRAINTS[12], false));
        propertyMap.put(JIRAEXPORT,
                PropertyDescriptorSupport.createBasetype(JIRAEXPORT, Flag.class, 16, PROPERTY_CONSTRAINTS[13], false));
        propertyMap.put(TESTRESULTLIST, PropertyDescriptorSupport.createCollection(TESTRESULTLIST,
                TestResultContainer.class, 17, PROPERTY_CONSTRAINTS[14], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(TESTSCRIPTRESULTLIST, PropertyDescriptorSupport.createCollection(TESTSCRIPTRESULTLIST,
                TestScriptResult.class, 18, PROPERTY_CONSTRAINTS[15], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(LEVEL), this.getLevel(), null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(STATUS), this.getStatus(), null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(BRANDTYPE), this.getBrandType(),
                this.brandTypeRefId));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(NAME), this.name, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(TESTCONFIGELEMENTKEY),
                this.testConfigElementKey, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(TESTCONFIGELEMENTNAME),
                this.testConfigElementName, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(TESTCONFIGELEMENTID),
                this.testConfigElementId, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(SCHEMAELEMENTID), this.schemaElementId,
                null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(STARTTIME), this.startTime, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(ENDTIME), this.endTime, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(DURATION), this.duration, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(MESSAGE), this.message, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(ERRORMESSAGE), this.errorMessage, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(JIRAEXPORT), this.jiraExport, null));
        properties
                .add(super.createProperty(TestResult.getPropertyDescriptor(TESTRESULTLIST), this.testResultList, null));
        properties.add(super.createProperty(TestResult.getPropertyDescriptor(TESTSCRIPTRESULTLIST),
                this.testScriptResultList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(LEVEL) && (property.getType() == HierarchyLevelType.class))) {
            this.setLevel(((HierarchyLevelType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STATUS) && (property.getType() == TestConfigElementStatusType.class))) {
            this.setStatus(((TestConfigElementStatusType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(BRANDTYPE) && (property.getType() == Code.class))) {
            this.setBrandType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTCONFIGELEMENTKEY) && (property.getType() == Key.class))) {
            this.setTestConfigElementKey(((Key) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTCONFIGELEMENTNAME) && (property.getType() == Name.class))) {
            this.setTestConfigElementName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTCONFIGELEMENTID) && (property.getType() == Identifier.class))) {
            this.setTestConfigElementId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SCHEMAELEMENTID) && (property.getType() == Identifier.class))) {
            this.setSchemaElementId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STARTTIME) && (property.getType() == Date.class))) {
            this.setStartTime(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENDTIME) && (property.getType() == Date.class))) {
            this.setEndTime(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DURATION) && (property.getType() == Duration.class))) {
            this.setDuration(((Duration) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MESSAGE) && (property.getType() == LongText.class))) {
            this.setMessage(((LongText) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ERRORMESSAGE) && (property.getType() == LongText.class))) {
            this.setErrorMessage(((LongText) property.getInstance()));
            return true;
        } else if ((property.getName().equals(JIRAEXPORT) && (property.getType() == Flag.class))) {
            this.setJiraExport(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTRESULTLIST) && (property.getType() == TestResultContainer.class))) {
            this.testResultList = ((NabuccoList<TestResultContainer>) property.getInstance());
            return true;
        } else if ((property.getName().equals(TESTSCRIPTRESULTLIST) && (property.getType() == TestScriptResult.class))) {
            this.testScriptResultList = ((NabuccoList<TestScriptResult>) property.getInstance());
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final TestResult other = ((TestResult) obj);
        if ((this.level == null)) {
            if ((other.level != null))
                return false;
        } else if ((!this.level.equals(other.level)))
            return false;
        if ((this.status == null)) {
            if ((other.status != null))
                return false;
        } else if ((!this.status.equals(other.status)))
            return false;
        if ((this.brandType == null)) {
            if ((other.brandType != null))
                return false;
        } else if ((!this.brandType.equals(other.brandType)))
            return false;
        if ((this.brandTypeRefId == null)) {
            if ((other.brandTypeRefId != null))
                return false;
        } else if ((!this.brandTypeRefId.equals(other.brandTypeRefId)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.testConfigElementKey == null)) {
            if ((other.testConfigElementKey != null))
                return false;
        } else if ((!this.testConfigElementKey.equals(other.testConfigElementKey)))
            return false;
        if ((this.testConfigElementName == null)) {
            if ((other.testConfigElementName != null))
                return false;
        } else if ((!this.testConfigElementName.equals(other.testConfigElementName)))
            return false;
        if ((this.testConfigElementId == null)) {
            if ((other.testConfigElementId != null))
                return false;
        } else if ((!this.testConfigElementId.equals(other.testConfigElementId)))
            return false;
        if ((this.schemaElementId == null)) {
            if ((other.schemaElementId != null))
                return false;
        } else if ((!this.schemaElementId.equals(other.schemaElementId)))
            return false;
        if ((this.startTime == null)) {
            if ((other.startTime != null))
                return false;
        } else if ((!this.startTime.equals(other.startTime)))
            return false;
        if ((this.endTime == null)) {
            if ((other.endTime != null))
                return false;
        } else if ((!this.endTime.equals(other.endTime)))
            return false;
        if ((this.duration == null)) {
            if ((other.duration != null))
                return false;
        } else if ((!this.duration.equals(other.duration)))
            return false;
        if ((this.message == null)) {
            if ((other.message != null))
                return false;
        } else if ((!this.message.equals(other.message)))
            return false;
        if ((this.errorMessage == null)) {
            if ((other.errorMessage != null))
                return false;
        } else if ((!this.errorMessage.equals(other.errorMessage)))
            return false;
        if ((this.jiraExport == null)) {
            if ((other.jiraExport != null))
                return false;
        } else if ((!this.jiraExport.equals(other.jiraExport)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.level == null) ? 0 : this.level.hashCode()));
        result = ((PRIME * result) + ((this.status == null) ? 0 : this.status.hashCode()));
        result = ((PRIME * result) + ((this.brandType == null) ? 0 : this.brandType.hashCode()));
        result = ((PRIME * result) + ((this.brandTypeRefId == null) ? 0 : this.brandTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.testConfigElementKey == null) ? 0 : this.testConfigElementKey.hashCode()));
        result = ((PRIME * result) + ((this.testConfigElementName == null) ? 0 : this.testConfigElementName.hashCode()));
        result = ((PRIME * result) + ((this.testConfigElementId == null) ? 0 : this.testConfigElementId.hashCode()));
        result = ((PRIME * result) + ((this.schemaElementId == null) ? 0 : this.schemaElementId.hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.endTime == null) ? 0 : this.endTime.hashCode()));
        result = ((PRIME * result) + ((this.duration == null) ? 0 : this.duration.hashCode()));
        result = ((PRIME * result) + ((this.message == null) ? 0 : this.message.hashCode()));
        result = ((PRIME * result) + ((this.errorMessage == null) ? 0 : this.errorMessage.hashCode()));
        result = ((PRIME * result) + ((this.jiraExport == null) ? 0 : this.jiraExport.hashCode()));
        return result;
    }

    @Override
    public TestResult cloneObject() {
        TestResult clone = new TestResult();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getLevel.
     *
     * @return the HierarchyLevelType.
     */
    public HierarchyLevelType getLevel() {
        return this.level;
    }

    /**
     * Missing description at method setLevel.
     *
     * @param level the HierarchyLevelType.
     */
    public void setLevel(HierarchyLevelType level) {
        this.level = level;
    }

    /**
     * Missing description at method setLevel.
     *
     * @param level the String.
     */
    public void setLevel(String level) {
        if ((level == null)) {
            this.level = null;
        } else {
            this.level = HierarchyLevelType.valueOf(level);
        }
    }

    /**
     * Missing description at method getStatus.
     *
     * @return the TestConfigElementStatusType.
     */
    public TestConfigElementStatusType getStatus() {
        return this.status;
    }

    /**
     * Missing description at method setStatus.
     *
     * @param status the TestConfigElementStatusType.
     */
    public void setStatus(TestConfigElementStatusType status) {
        this.status = status;
    }

    /**
     * Missing description at method setStatus.
     *
     * @param status the String.
     */
    public void setStatus(String status) {
        if ((status == null)) {
            this.status = null;
        } else {
            this.status = TestConfigElementStatusType.valueOf(status);
        }
    }

    /**
     * Missing description at method setBrandType.
     *
     * @param brandType the Code.
     */
    public void setBrandType(Code brandType) {
        this.brandType = brandType;
        if ((brandType != null)) {
            this.setBrandTypeRefId(brandType.getId());
        } else {
            this.setBrandTypeRefId(null);
        }
    }

    /**
     * Missing description at method getBrandType.
     *
     * @return the Code.
     */
    public Code getBrandType() {
        return this.brandType;
    }

    /**
     * Getter for the BrandTypeRefId.
     *
     * @return the Long.
     */
    public Long getBrandTypeRefId() {
        return this.brandTypeRefId;
    }

    /**
     * Setter for the BrandTypeRefId.
     *
     * @param brandTypeRefId the Long.
     */
    public void setBrandTypeRefId(Long brandTypeRefId) {
        this.brandTypeRefId = brandTypeRefId;
    }

    /**
     * Missing description at method getName.
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Missing description at method setName.
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Missing description at method setName.
     *
     * @param name the String.
     */
    public void setName(String name) {
        if ((this.name == null)) {
            if ((name == null)) {
                return;
            }
            this.name = new Name();
        }
        this.name.setValue(name);
    }

    /**
     * Missing description at method getTestConfigElementKey.
     *
     * @return the Key.
     */
    public Key getTestConfigElementKey() {
        return this.testConfigElementKey;
    }

    /**
     * Missing description at method setTestConfigElementKey.
     *
     * @param testConfigElementKey the Key.
     */
    public void setTestConfigElementKey(Key testConfigElementKey) {
        this.testConfigElementKey = testConfigElementKey;
    }

    /**
     * Missing description at method setTestConfigElementKey.
     *
     * @param testConfigElementKey the String.
     */
    public void setTestConfigElementKey(String testConfigElementKey) {
        if ((this.testConfigElementKey == null)) {
            if ((testConfigElementKey == null)) {
                return;
            }
            this.testConfigElementKey = new Key();
        }
        this.testConfigElementKey.setValue(testConfigElementKey);
    }

    /**
     * Missing description at method getTestConfigElementName.
     *
     * @return the Name.
     */
    public Name getTestConfigElementName() {
        return this.testConfigElementName;
    }

    /**
     * Missing description at method setTestConfigElementName.
     *
     * @param testConfigElementName the Name.
     */
    public void setTestConfigElementName(Name testConfigElementName) {
        this.testConfigElementName = testConfigElementName;
    }

    /**
     * Missing description at method setTestConfigElementName.
     *
     * @param testConfigElementName the String.
     */
    public void setTestConfigElementName(String testConfigElementName) {
        if ((this.testConfigElementName == null)) {
            if ((testConfigElementName == null)) {
                return;
            }
            this.testConfigElementName = new Name();
        }
        this.testConfigElementName.setValue(testConfigElementName);
    }

    /**
     * Missing description at method getTestConfigElementId.
     *
     * @return the Identifier.
     */
    public Identifier getTestConfigElementId() {
        return this.testConfigElementId;
    }

    /**
     * Missing description at method setTestConfigElementId.
     *
     * @param testConfigElementId the Identifier.
     */
    public void setTestConfigElementId(Identifier testConfigElementId) {
        this.testConfigElementId = testConfigElementId;
    }

    /**
     * Missing description at method setTestConfigElementId.
     *
     * @param testConfigElementId the Long.
     */
    public void setTestConfigElementId(Long testConfigElementId) {
        if ((this.testConfigElementId == null)) {
            if ((testConfigElementId == null)) {
                return;
            }
            this.testConfigElementId = new Identifier();
        }
        this.testConfigElementId.setValue(testConfigElementId);
    }

    /**
     * Missing description at method getSchemaElementId.
     *
     * @return the Identifier.
     */
    public Identifier getSchemaElementId() {
        return this.schemaElementId;
    }

    /**
     * Missing description at method setSchemaElementId.
     *
     * @param schemaElementId the Identifier.
     */
    public void setSchemaElementId(Identifier schemaElementId) {
        this.schemaElementId = schemaElementId;
    }

    /**
     * Missing description at method setSchemaElementId.
     *
     * @param schemaElementId the Long.
     */
    public void setSchemaElementId(Long schemaElementId) {
        if ((this.schemaElementId == null)) {
            if ((schemaElementId == null)) {
                return;
            }
            this.schemaElementId = new Identifier();
        }
        this.schemaElementId.setValue(schemaElementId);
    }

    /**
     * Missing description at method getStartTime.
     *
     * @return the Date.
     */
    public Date getStartTime() {
        return this.startTime;
    }

    /**
     * Missing description at method setStartTime.
     *
     * @param startTime the Date.
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Missing description at method setStartTime.
     *
     * @param startTime the java.util.Date.
     */
    public void setStartTime(java.util.Date startTime) {
        if ((this.startTime == null)) {
            if ((startTime == null)) {
                return;
            }
            this.startTime = new Date();
        }
        this.startTime.setValue(startTime);
    }

    /**
     * Missing description at method getEndTime.
     *
     * @return the Date.
     */
    public Date getEndTime() {
        return this.endTime;
    }

    /**
     * Missing description at method setEndTime.
     *
     * @param endTime the Date.
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Missing description at method setEndTime.
     *
     * @param endTime the java.util.Date.
     */
    public void setEndTime(java.util.Date endTime) {
        if ((this.endTime == null)) {
            if ((endTime == null)) {
                return;
            }
            this.endTime = new Date();
        }
        this.endTime.setValue(endTime);
    }

    /**
     * Missing description at method getDuration.
     *
     * @return the Duration.
     */
    public Duration getDuration() {
        return this.duration;
    }

    /**
     * Missing description at method setDuration.
     *
     * @param duration the Duration.
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    /**
     * Missing description at method setDuration.
     *
     * @param duration the Long.
     */
    public void setDuration(Long duration) {
        if ((this.duration == null)) {
            if ((duration == null)) {
                return;
            }
            this.duration = new Duration();
        }
        this.duration.setValue(duration);
    }

    /**
     * Missing description at method getMessage.
     *
     * @return the LongText.
     */
    public LongText getMessage() {
        return this.message;
    }

    /**
     * Missing description at method setMessage.
     *
     * @param message the LongText.
     */
    public void setMessage(LongText message) {
        this.message = message;
    }

    /**
     * Missing description at method setMessage.
     *
     * @param message the String.
     */
    public void setMessage(String message) {
        if ((this.message == null)) {
            if ((message == null)) {
                return;
            }
            this.message = new LongText();
        }
        this.message.setValue(message);
    }

    /**
     * Missing description at method getErrorMessage.
     *
     * @return the LongText.
     */
    public LongText getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Missing description at method setErrorMessage.
     *
     * @param errorMessage the LongText.
     */
    public void setErrorMessage(LongText errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Missing description at method setErrorMessage.
     *
     * @param errorMessage the String.
     */
    public void setErrorMessage(String errorMessage) {
        if ((this.errorMessage == null)) {
            if ((errorMessage == null)) {
                return;
            }
            this.errorMessage = new LongText();
        }
        this.errorMessage.setValue(errorMessage);
    }

    /**
     * Missing description at method getJiraExport.
     *
     * @return the Flag.
     */
    public Flag getJiraExport() {
        return this.jiraExport;
    }

    /**
     * Missing description at method setJiraExport.
     *
     * @param jiraExport the Flag.
     */
    public void setJiraExport(Flag jiraExport) {
        this.jiraExport = jiraExport;
    }

    /**
     * Missing description at method setJiraExport.
     *
     * @param jiraExport the Boolean.
     */
    public void setJiraExport(Boolean jiraExport) {
        if ((this.jiraExport == null)) {
            if ((jiraExport == null)) {
                return;
            }
            this.jiraExport = new Flag();
        }
        this.jiraExport.setValue(jiraExport);
    }

    /**
     * Missing description at method getTestResultList.
     *
     * @return the NabuccoList<TestResultContainer>.
     */
    public NabuccoList<TestResultContainer> getTestResultList() {
        if ((this.testResultList == null)) {
            this.testResultList = new NabuccoListImpl<TestResultContainer>(NabuccoCollectionState.INITIALIZED);
        }
        return this.testResultList;
    }

    /**
     * Missing description at method getTestScriptResultList.
     *
     * @return the NabuccoList<TestScriptResult>.
     */
    public NabuccoList<TestScriptResult> getTestScriptResultList() {
        if ((this.testScriptResultList == null)) {
            this.testScriptResultList = new NabuccoListImpl<TestScriptResult>(NabuccoCollectionState.INITIALIZED);
        }
        return this.testScriptResultList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestResult.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestResult.class).getAllProperties();
    }

    /**
     * Getter for the BrandTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getBrandTypeCodePath() {
        return new CodePath(BRANDTYPE_CODEPATH);
    }
}
