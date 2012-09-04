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
import org.nabucco.framework.base.facade.datatype.Identifier;
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
import org.nabucco.testautomation.property.facade.datatype.base.TestAutomationDatatype;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigurationStatusType;

/**
 * TestConfigurationResult<p/>The result list of the execution of a TestConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public class TestConfigurationResult extends TestAutomationDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;", "m0,1;", "l0,255;u0,n;m1,1;",
            "l0,255;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "m0,n;" };

    public static final String STATUS = "status";

    public static final String ENVIRONMENTTYPE = "environmentType";

    public static final String RELEASETYPE = "releaseType";

    public static final String NAME = "name";

    public static final String TESTCONFIGURATIONNAME = "testConfigurationName";

    public static final String TESTCONFIGURATIONID = "testConfigurationId";

    public static final String STARTTIME = "startTime";

    public static final String ENDTIME = "endTime";

    public static final String DURATION = "duration";

    public static final String TESTRESULTLIST = "testResultList";

    private TestConfigurationStatusType status;

    private Code environmentType;

    private Long environmentTypeRefId;

    protected static final String ENVIRONMENTTYPE_CODEPATH = "nabucco.testautomation.environment";

    private Code releaseType;

    private Long releaseTypeRefId;

    protected static final String RELEASETYPE_CODEPATH = "nabucco.testautomation.release";

    private Name name;

    private Name testConfigurationName;

    private Identifier testConfigurationId;

    private Date startTime;

    private Date endTime;

    private Duration duration;

    private NabuccoList<TestResultContainer> testResultList;

    /** Constructs a new TestConfigurationResult instance. */
    public TestConfigurationResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the TestConfigurationResult.
     */
    protected void cloneObject(TestConfigurationResult clone) {
        super.cloneObject(clone);
        clone.setStatus(this.getStatus());
        if ((this.getEnvironmentType() != null)) {
            clone.setEnvironmentType(this.getEnvironmentType().cloneObject());
        }
        if ((this.getEnvironmentTypeRefId() != null)) {
            clone.setEnvironmentTypeRefId(this.getEnvironmentTypeRefId());
        }
        if ((this.getReleaseType() != null)) {
            clone.setReleaseType(this.getReleaseType().cloneObject());
        }
        if ((this.getReleaseTypeRefId() != null)) {
            clone.setReleaseTypeRefId(this.getReleaseTypeRefId());
        }
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getTestConfigurationName() != null)) {
            clone.setTestConfigurationName(this.getTestConfigurationName().cloneObject());
        }
        if ((this.getTestConfigurationId() != null)) {
            clone.setTestConfigurationId(this.getTestConfigurationId().cloneObject());
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
        if ((this.testResultList != null)) {
            clone.testResultList = this.testResultList.cloneCollection();
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
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(TestAutomationDatatype.class).getPropertyMap());
        propertyMap.put(STATUS, PropertyDescriptorSupport.createEnumeration(STATUS, TestConfigurationStatusType.class,
                4, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ENVIRONMENTTYPE, PropertyDescriptorSupport.createDatatype(ENVIRONMENTTYPE, Code.class, 5,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT, ENVIRONMENTTYPE_CODEPATH));
        propertyMap.put(RELEASETYPE, PropertyDescriptorSupport.createDatatype(RELEASETYPE, Code.class, 6,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT, RELEASETYPE_CODEPATH));
        propertyMap.put(NAME,
                PropertyDescriptorSupport.createBasetype(NAME, Name.class, 7, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(TESTCONFIGURATIONNAME, PropertyDescriptorSupport.createBasetype(TESTCONFIGURATIONNAME,
                Name.class, 8, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(TESTCONFIGURATIONID, PropertyDescriptorSupport.createBasetype(TESTCONFIGURATIONID,
                Identifier.class, 9, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(STARTTIME,
                PropertyDescriptorSupport.createBasetype(STARTTIME, Date.class, 10, PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(ENDTIME,
                PropertyDescriptorSupport.createBasetype(ENDTIME, Date.class, 11, PROPERTY_CONSTRAINTS[7], false));
        propertyMap.put(DURATION,
                PropertyDescriptorSupport.createBasetype(DURATION, Duration.class, 12, PROPERTY_CONSTRAINTS[8], false));
        propertyMap.put(TESTRESULTLIST, PropertyDescriptorSupport.createCollection(TESTRESULTLIST,
                TestResultContainer.class, 13, PROPERTY_CONSTRAINTS[9], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(STATUS), this.getStatus(),
                null));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(ENVIRONMENTTYPE),
                this.getEnvironmentType(), this.environmentTypeRefId));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(RELEASETYPE),
                this.getReleaseType(), this.releaseTypeRefId));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(NAME), this.name, null));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(TESTCONFIGURATIONNAME),
                this.testConfigurationName, null));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(TESTCONFIGURATIONID),
                this.testConfigurationId, null));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(STARTTIME), this.startTime,
                null));
        properties
                .add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(ENDTIME), this.endTime, null));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(DURATION), this.duration,
                null));
        properties.add(super.createProperty(TestConfigurationResult.getPropertyDescriptor(TESTRESULTLIST),
                this.testResultList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(STATUS) && (property.getType() == TestConfigurationStatusType.class))) {
            this.setStatus(((TestConfigurationStatusType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENVIRONMENTTYPE) && (property.getType() == Code.class))) {
            this.setEnvironmentType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELEASETYPE) && (property.getType() == Code.class))) {
            this.setReleaseType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTCONFIGURATIONNAME) && (property.getType() == Name.class))) {
            this.setTestConfigurationName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTCONFIGURATIONID) && (property.getType() == Identifier.class))) {
            this.setTestConfigurationId(((Identifier) property.getInstance()));
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
        } else if ((property.getName().equals(TESTRESULTLIST) && (property.getType() == TestResultContainer.class))) {
            this.testResultList = ((NabuccoList<TestResultContainer>) property.getInstance());
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
        final TestConfigurationResult other = ((TestConfigurationResult) obj);
        if ((this.status == null)) {
            if ((other.status != null))
                return false;
        } else if ((!this.status.equals(other.status)))
            return false;
        if ((this.environmentType == null)) {
            if ((other.environmentType != null))
                return false;
        } else if ((!this.environmentType.equals(other.environmentType)))
            return false;
        if ((this.environmentTypeRefId == null)) {
            if ((other.environmentTypeRefId != null))
                return false;
        } else if ((!this.environmentTypeRefId.equals(other.environmentTypeRefId)))
            return false;
        if ((this.releaseType == null)) {
            if ((other.releaseType != null))
                return false;
        } else if ((!this.releaseType.equals(other.releaseType)))
            return false;
        if ((this.releaseTypeRefId == null)) {
            if ((other.releaseTypeRefId != null))
                return false;
        } else if ((!this.releaseTypeRefId.equals(other.releaseTypeRefId)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.testConfigurationName == null)) {
            if ((other.testConfigurationName != null))
                return false;
        } else if ((!this.testConfigurationName.equals(other.testConfigurationName)))
            return false;
        if ((this.testConfigurationId == null)) {
            if ((other.testConfigurationId != null))
                return false;
        } else if ((!this.testConfigurationId.equals(other.testConfigurationId)))
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
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.status == null) ? 0 : this.status.hashCode()));
        result = ((PRIME * result) + ((this.environmentType == null) ? 0 : this.environmentType.hashCode()));
        result = ((PRIME * result) + ((this.environmentTypeRefId == null) ? 0 : this.environmentTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.releaseType == null) ? 0 : this.releaseType.hashCode()));
        result = ((PRIME * result) + ((this.releaseTypeRefId == null) ? 0 : this.releaseTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.testConfigurationName == null) ? 0 : this.testConfigurationName.hashCode()));
        result = ((PRIME * result) + ((this.testConfigurationId == null) ? 0 : this.testConfigurationId.hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.endTime == null) ? 0 : this.endTime.hashCode()));
        result = ((PRIME * result) + ((this.duration == null) ? 0 : this.duration.hashCode()));
        return result;
    }

    @Override
    public TestConfigurationResult cloneObject() {
        TestConfigurationResult clone = new TestConfigurationResult();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getStatus.
     *
     * @return the TestConfigurationStatusType.
     */
    public TestConfigurationStatusType getStatus() {
        return this.status;
    }

    /**
     * Missing description at method setStatus.
     *
     * @param status the TestConfigurationStatusType.
     */
    public void setStatus(TestConfigurationStatusType status) {
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
            this.status = TestConfigurationStatusType.valueOf(status);
        }
    }

    /**
     * Missing description at method setEnvironmentType.
     *
     * @param environmentType the Code.
     */
    public void setEnvironmentType(Code environmentType) {
        this.environmentType = environmentType;
        if ((environmentType != null)) {
            this.setEnvironmentTypeRefId(environmentType.getId());
        } else {
            this.setEnvironmentTypeRefId(null);
        }
    }

    /**
     * Missing description at method getEnvironmentType.
     *
     * @return the Code.
     */
    public Code getEnvironmentType() {
        return this.environmentType;
    }

    /**
     * Getter for the EnvironmentTypeRefId.
     *
     * @return the Long.
     */
    public Long getEnvironmentTypeRefId() {
        return this.environmentTypeRefId;
    }

    /**
     * Setter for the EnvironmentTypeRefId.
     *
     * @param environmentTypeRefId the Long.
     */
    public void setEnvironmentTypeRefId(Long environmentTypeRefId) {
        this.environmentTypeRefId = environmentTypeRefId;
    }

    /**
     * Missing description at method setReleaseType.
     *
     * @param releaseType the Code.
     */
    public void setReleaseType(Code releaseType) {
        this.releaseType = releaseType;
        if ((releaseType != null)) {
            this.setReleaseTypeRefId(releaseType.getId());
        } else {
            this.setReleaseTypeRefId(null);
        }
    }

    /**
     * Missing description at method getReleaseType.
     *
     * @return the Code.
     */
    public Code getReleaseType() {
        return this.releaseType;
    }

    /**
     * Getter for the ReleaseTypeRefId.
     *
     * @return the Long.
     */
    public Long getReleaseTypeRefId() {
        return this.releaseTypeRefId;
    }

    /**
     * Setter for the ReleaseTypeRefId.
     *
     * @param releaseTypeRefId the Long.
     */
    public void setReleaseTypeRefId(Long releaseTypeRefId) {
        this.releaseTypeRefId = releaseTypeRefId;
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
     * Missing description at method getTestConfigurationName.
     *
     * @return the Name.
     */
    public Name getTestConfigurationName() {
        return this.testConfigurationName;
    }

    /**
     * Missing description at method setTestConfigurationName.
     *
     * @param testConfigurationName the Name.
     */
    public void setTestConfigurationName(Name testConfigurationName) {
        this.testConfigurationName = testConfigurationName;
    }

    /**
     * Missing description at method setTestConfigurationName.
     *
     * @param testConfigurationName the String.
     */
    public void setTestConfigurationName(String testConfigurationName) {
        if ((this.testConfigurationName == null)) {
            if ((testConfigurationName == null)) {
                return;
            }
            this.testConfigurationName = new Name();
        }
        this.testConfigurationName.setValue(testConfigurationName);
    }

    /**
     * Missing description at method getTestConfigurationId.
     *
     * @return the Identifier.
     */
    public Identifier getTestConfigurationId() {
        return this.testConfigurationId;
    }

    /**
     * Missing description at method setTestConfigurationId.
     *
     * @param testConfigurationId the Identifier.
     */
    public void setTestConfigurationId(Identifier testConfigurationId) {
        this.testConfigurationId = testConfigurationId;
    }

    /**
     * Missing description at method setTestConfigurationId.
     *
     * @param testConfigurationId the Long.
     */
    public void setTestConfigurationId(Long testConfigurationId) {
        if ((this.testConfigurationId == null)) {
            if ((testConfigurationId == null)) {
                return;
            }
            this.testConfigurationId = new Identifier();
        }
        this.testConfigurationId.setValue(testConfigurationId);
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
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestConfigurationResult.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestConfigurationResult.class).getAllProperties();
    }

    /**
     * Getter for the EnvironmentTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getEnvironmentTypeCodePath() {
        return new CodePath(ENVIRONMENTTYPE_CODEPATH);
    }

    /**
     * Getter for the ReleaseTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getReleaseTypeCodePath() {
        return new CodePath(RELEASETYPE_CODEPATH);
    }
}
