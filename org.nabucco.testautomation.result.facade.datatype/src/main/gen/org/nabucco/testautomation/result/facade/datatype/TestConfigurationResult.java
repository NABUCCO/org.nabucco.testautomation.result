/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Duration;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.base.DateValue;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigurationStatusType;

/**
 * TestConfigurationResult<p/>The result list of the execution of a TestConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public class TestConfigurationResult extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "status", "environmentType", "releaseType",
            "name", "testConfigurationName", "testConfigurationId", "startTime", "endTime",
            "duration", "testResultList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;", "m0,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "m0,n;" };

    private TestConfigurationStatusType status;

    private Code environmentType;

    private Long environmentTypeRefId;

    private static final String ENVIRONMENTTYPE_CODEPATH = "nabucco.testautomation.environment";

    private Code releaseType;

    private Long releaseTypeRefId;

    private static final String RELEASETYPE_CODEPATH = "nabucco.testautomation.release";

    private Name name;

    private Name testConfigurationName;

    private Identifier testConfigurationId;

    private DateValue startTime;

    private DateValue endTime;

    private Duration duration;

    private List<TestResultContainer> testResultList;

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
        if ((this.testResultList instanceof NabuccoList<?>)) {
            clone.testResultList = ((NabuccoList<TestResultContainer>) this.testResultList)
                    .cloneCollection();
        }
    }

    /**
     * Getter for the TestResultListJPA.
     *
     * @return the List<TestResultContainer>.
     */
    List<TestResultContainer> getTestResultListJPA() {
        if ((this.testResultList == null)) {
            this.testResultList = new NabuccoList<TestResultContainer>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<TestResultContainer>) this.testResultList).getDelegate();
    }

    /**
     * Setter for the TestResultListJPA.
     *
     * @param testResultList the List<TestResultContainer>.
     */
    void setTestResultListJPA(List<TestResultContainer> testResultList) {
        if ((this.testResultList == null)) {
            this.testResultList = new NabuccoList<TestResultContainer>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<TestResultContainer>) this.testResultList).setDelegate(testResultList);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<TestConfigurationStatusType>(PROPERTY_NAMES[0],
                TestConfigurationStatusType.class, PROPERTY_CONSTRAINTS[0], this.status));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[1], Code.class,
                PROPERTY_CONSTRAINTS[1], this.environmentType));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[2], Code.class,
                PROPERTY_CONSTRAINTS[2], this.releaseType));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[3], Name.class,
                PROPERTY_CONSTRAINTS[3], this.name));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[4], Name.class,
                PROPERTY_CONSTRAINTS[4], this.testConfigurationName));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[5], Identifier.class,
                PROPERTY_CONSTRAINTS[5], this.testConfigurationId));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[6], DateValue.class,
                PROPERTY_CONSTRAINTS[6], this.startTime));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[7], DateValue.class,
                PROPERTY_CONSTRAINTS[7], this.endTime));
        properties.add(new BasetypeProperty<Duration>(PROPERTY_NAMES[8], Duration.class,
                PROPERTY_CONSTRAINTS[8], this.duration));
        properties.add(new ListProperty<TestResultContainer>(PROPERTY_NAMES[9],
                TestResultContainer.class, PROPERTY_CONSTRAINTS[9], this.testResultList));
        return properties;
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
        result = ((PRIME * result) + ((this.environmentType == null) ? 0 : this.environmentType
                .hashCode()));
        result = ((PRIME * result) + ((this.environmentTypeRefId == null) ? 0
                : this.environmentTypeRefId.hashCode()));
        result = ((PRIME * result) + ((this.releaseType == null) ? 0 : this.releaseType.hashCode()));
        result = ((PRIME * result) + ((this.releaseTypeRefId == null) ? 0 : this.releaseTypeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.testConfigurationName == null) ? 0
                : this.testConfigurationName.hashCode()));
        result = ((PRIME * result) + ((this.testConfigurationId == null) ? 0
                : this.testConfigurationId.hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.endTime == null) ? 0 : this.endTime.hashCode()));
        result = ((PRIME * result) + ((this.duration == null) ? 0 : this.duration.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestConfigurationResult>\n");
        appendable.append(super.toString());
        appendable.append((("<status>" + this.status) + "</status>\n"));
        appendable.append((("<environmentType>" + this.environmentType) + "</environmentType>\n"));
        appendable
                .append((("<environmentTypeRefId>" + this.environmentTypeRefId) + "</environmentTypeRefId>\n"));
        appendable.append((("<releaseType>" + this.releaseType) + "</releaseType>\n"));
        appendable
                .append((("<releaseTypeRefId>" + this.releaseTypeRefId) + "</releaseTypeRefId>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable
                .append((("<testConfigurationName>" + this.testConfigurationName) + "</testConfigurationName>\n"));
        appendable
                .append((("<testConfigurationId>" + this.testConfigurationId) + "</testConfigurationId>\n"));
        appendable.append((("<startTime>" + this.startTime) + "</startTime>\n"));
        appendable.append((("<endTime>" + this.endTime) + "</endTime>\n"));
        appendable.append((("<duration>" + this.duration) + "</duration>\n"));
        appendable.append("</TestConfigurationResult>\n");
        return appendable.toString();
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
            this.testConfigurationId = new Identifier();
        }
        this.testConfigurationId.setValue(testConfigurationId);
    }

    /**
     * Missing description at method getStartTime.
     *
     * @return the DateValue.
     */
    public DateValue getStartTime() {
        return this.startTime;
    }

    /**
     * Missing description at method setStartTime.
     *
     * @param startTime the DateValue.
     */
    public void setStartTime(DateValue startTime) {
        this.startTime = startTime;
    }

    /**
     * Missing description at method setStartTime.
     *
     * @param startTime the java.util.Date.
     */
    public void setStartTime(java.util.Date startTime) {
        if ((this.startTime == null)) {
            this.startTime = new DateValue();
        }
        this.startTime.setValue(startTime);
    }

    /**
     * Missing description at method getEndTime.
     *
     * @return the DateValue.
     */
    public DateValue getEndTime() {
        return this.endTime;
    }

    /**
     * Missing description at method setEndTime.
     *
     * @param endTime the DateValue.
     */
    public void setEndTime(DateValue endTime) {
        this.endTime = endTime;
    }

    /**
     * Missing description at method setEndTime.
     *
     * @param endTime the java.util.Date.
     */
    public void setEndTime(java.util.Date endTime) {
        if ((this.endTime == null)) {
            this.endTime = new DateValue();
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
            this.duration = new Duration();
        }
        this.duration.setValue(duration);
    }

    /**
     * Missing description at method getTestResultList.
     *
     * @return the List<TestResultContainer>.
     */
    public List<TestResultContainer> getTestResultList() {
        if ((this.testResultList == null)) {
            this.testResultList = new NabuccoList<TestResultContainer>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.testResultList;
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
