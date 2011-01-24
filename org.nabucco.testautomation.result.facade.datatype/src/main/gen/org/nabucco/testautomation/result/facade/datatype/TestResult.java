/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.List;
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
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.base.DateValue;
import org.nabucco.testautomation.facade.datatype.base.HierarchyLevelType;
import org.nabucco.testautomation.facade.datatype.base.Text;
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

    private static final String[] PROPERTY_NAMES = { "level", "status", "brandType", "name",
            "testConfigElementKey", "testConfigElementName", "testConfigElementId",
            "schemaElementId", "startTime", "endTime", "duration", "message", "errorMessage",
            "jiraExport", "testResultList", "testScriptResultList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m0,1;", "l0,n;m1,1;",
            "l0,16;m0,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "l0,n;m0,1;", "l0,n;m0,1;", "l0,n;m1,1;", "m0,n;", "m0,n;" };

    private HierarchyLevelType level;

    private TestConfigElementStatusType status;

    private Code brandType;

    private Long brandTypeRefId;

    private static final String BRANDTYPE_CODEPATH = "nabucco.testautomation.brand";

    private Name name;

    private Key testConfigElementKey;

    private Name testConfigElementName;

    private Identifier testConfigElementId;

    private Identifier schemaElementId;

    private DateValue startTime;

    private DateValue endTime;

    private Duration duration;

    private Text message;

    private Text errorMessage;

    private Flag jiraExport;

    private List<TestResultContainer> testResultList;

    private List<TestScriptResult> testScriptResultList;

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
        if ((this.testResultList instanceof NabuccoList<?>)) {
            clone.testResultList = ((NabuccoList<TestResultContainer>) this.testResultList)
                    .cloneCollection();
        }
        if ((this.testScriptResultList instanceof NabuccoList<?>)) {
            clone.testScriptResultList = ((NabuccoList<TestScriptResult>) this.testScriptResultList)
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

    /**
     * Getter for the TestScriptResultListJPA.
     *
     * @return the List<TestScriptResult>.
     */
    List<TestScriptResult> getTestScriptResultListJPA() {
        if ((this.testScriptResultList == null)) {
            this.testScriptResultList = new NabuccoList<TestScriptResult>(
                    NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<TestScriptResult>) this.testScriptResultList).getDelegate();
    }

    /**
     * Setter for the TestScriptResultListJPA.
     *
     * @param testScriptResultList the List<TestScriptResult>.
     */
    void setTestScriptResultListJPA(List<TestScriptResult> testScriptResultList) {
        if ((this.testScriptResultList == null)) {
            this.testScriptResultList = new NabuccoList<TestScriptResult>(
                    NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<TestScriptResult>) this.testScriptResultList)
                .setDelegate(testScriptResultList);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<HierarchyLevelType>(PROPERTY_NAMES[0],
                HierarchyLevelType.class, PROPERTY_CONSTRAINTS[0], this.level));
        properties.add(new EnumProperty<TestConfigElementStatusType>(PROPERTY_NAMES[1],
                TestConfigElementStatusType.class, PROPERTY_CONSTRAINTS[1], this.status));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[2], Code.class,
                PROPERTY_CONSTRAINTS[2], this.brandType));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[3], Name.class,
                PROPERTY_CONSTRAINTS[3], this.name));
        properties.add(new BasetypeProperty<Key>(PROPERTY_NAMES[4], Key.class,
                PROPERTY_CONSTRAINTS[4], this.testConfigElementKey));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[5], Name.class,
                PROPERTY_CONSTRAINTS[5], this.testConfigElementName));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[6], Identifier.class,
                PROPERTY_CONSTRAINTS[6], this.testConfigElementId));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[7], Identifier.class,
                PROPERTY_CONSTRAINTS[7], this.schemaElementId));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[8], DateValue.class,
                PROPERTY_CONSTRAINTS[8], this.startTime));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[9], DateValue.class,
                PROPERTY_CONSTRAINTS[9], this.endTime));
        properties.add(new BasetypeProperty<Duration>(PROPERTY_NAMES[10], Duration.class,
                PROPERTY_CONSTRAINTS[10], this.duration));
        properties.add(new BasetypeProperty<Text>(PROPERTY_NAMES[11], Text.class,
                PROPERTY_CONSTRAINTS[11], this.message));
        properties.add(new BasetypeProperty<Text>(PROPERTY_NAMES[12], Text.class,
                PROPERTY_CONSTRAINTS[12], this.errorMessage));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[13], Flag.class,
                PROPERTY_CONSTRAINTS[13], this.jiraExport));
        properties.add(new ListProperty<TestResultContainer>(PROPERTY_NAMES[14],
                TestResultContainer.class, PROPERTY_CONSTRAINTS[14], this.testResultList));
        properties.add(new ListProperty<TestScriptResult>(PROPERTY_NAMES[15],
                TestScriptResult.class, PROPERTY_CONSTRAINTS[15], this.testScriptResultList));
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
        result = ((PRIME * result) + ((this.brandTypeRefId == null) ? 0 : this.brandTypeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.testConfigElementKey == null) ? 0
                : this.testConfigElementKey.hashCode()));
        result = ((PRIME * result) + ((this.testConfigElementName == null) ? 0
                : this.testConfigElementName.hashCode()));
        result = ((PRIME * result) + ((this.testConfigElementId == null) ? 0
                : this.testConfigElementId.hashCode()));
        result = ((PRIME * result) + ((this.schemaElementId == null) ? 0 : this.schemaElementId
                .hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.endTime == null) ? 0 : this.endTime.hashCode()));
        result = ((PRIME * result) + ((this.duration == null) ? 0 : this.duration.hashCode()));
        result = ((PRIME * result) + ((this.message == null) ? 0 : this.message.hashCode()));
        result = ((PRIME * result) + ((this.errorMessage == null) ? 0 : this.errorMessage
                .hashCode()));
        result = ((PRIME * result) + ((this.jiraExport == null) ? 0 : this.jiraExport.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestResult>\n");
        appendable.append(super.toString());
        appendable.append((("<level>" + this.level) + "</level>\n"));
        appendable.append((("<status>" + this.status) + "</status>\n"));
        appendable.append((("<brandType>" + this.brandType) + "</brandType>\n"));
        appendable.append((("<brandTypeRefId>" + this.brandTypeRefId) + "</brandTypeRefId>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable
                .append((("<testConfigElementKey>" + this.testConfigElementKey) + "</testConfigElementKey>\n"));
        appendable
                .append((("<testConfigElementName>" + this.testConfigElementName) + "</testConfigElementName>\n"));
        appendable
                .append((("<testConfigElementId>" + this.testConfigElementId) + "</testConfigElementId>\n"));
        appendable.append((("<schemaElementId>" + this.schemaElementId) + "</schemaElementId>\n"));
        appendable.append((("<startTime>" + this.startTime) + "</startTime>\n"));
        appendable.append((("<endTime>" + this.endTime) + "</endTime>\n"));
        appendable.append((("<duration>" + this.duration) + "</duration>\n"));
        appendable.append((("<message>" + this.message) + "</message>\n"));
        appendable.append((("<errorMessage>" + this.errorMessage) + "</errorMessage>\n"));
        appendable.append((("<jiraExport>" + this.jiraExport) + "</jiraExport>\n"));
        appendable.append("</TestResult>\n");
        return appendable.toString();
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
            this.schemaElementId = new Identifier();
        }
        this.schemaElementId.setValue(schemaElementId);
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
     * Missing description at method getMessage.
     *
     * @return the Text.
     */
    public Text getMessage() {
        return this.message;
    }

    /**
     * Missing description at method setMessage.
     *
     * @param message the Text.
     */
    public void setMessage(Text message) {
        this.message = message;
    }

    /**
     * Missing description at method setMessage.
     *
     * @param message the String.
     */
    public void setMessage(String message) {
        if ((this.message == null)) {
            this.message = new Text();
        }
        this.message.setValue(message);
    }

    /**
     * Missing description at method getErrorMessage.
     *
     * @return the Text.
     */
    public Text getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Missing description at method setErrorMessage.
     *
     * @param errorMessage the Text.
     */
    public void setErrorMessage(Text errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Missing description at method setErrorMessage.
     *
     * @param errorMessage the String.
     */
    public void setErrorMessage(String errorMessage) {
        if ((this.errorMessage == null)) {
            this.errorMessage = new Text();
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
            this.jiraExport = new Flag();
        }
        this.jiraExport.setValue(jiraExport);
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
     * Missing description at method getTestScriptResultList.
     *
     * @return the List<TestScriptResult>.
     */
    public List<TestScriptResult> getTestScriptResultList() {
        if ((this.testScriptResultList == null)) {
            this.testScriptResultList = new NabuccoList<TestScriptResult>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.testScriptResultList;
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
