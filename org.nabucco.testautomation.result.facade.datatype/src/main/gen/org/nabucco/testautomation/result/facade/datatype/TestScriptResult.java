/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Duration;
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.base.DateValue;
import org.nabucco.testautomation.result.facade.datatype.TestScriptElementResult;
import org.nabucco.testautomation.result.facade.datatype.status.TestScriptStatusType;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * TestScriptResult<p/>The result of a TestScript<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public class TestScriptResult extends TestScriptElementResult implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "status", "testScriptKey", "testScriptName",
            "startTime", "endTime", "duration", "elementResultList", "actionTraceList", "logging" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,16;m0,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "m0,n;", "m0,n;", "l0,100000;m0,1;" };

    private TestScriptStatusType status;

    private Key testScriptKey;

    private Name testScriptName;

    private DateValue startTime;

    private DateValue endTime;

    private Duration duration;

    private List<TestScriptElementResult> elementResultList;

    private List<ActionTrace> actionTraceList;

    private LogTrace logging;

    /** Constructs a new TestScriptResult instance. */
    public TestScriptResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        status = TestScriptStatusType.PASSED;
    }

    /**
     * CloneObject.
     *
     * @param clone the TestScriptResult.
     */
    protected void cloneObject(TestScriptResult clone) {
        super.cloneObject(clone);
        clone.setStatus(this.getStatus());
        if ((this.getTestScriptKey() != null)) {
            clone.setTestScriptKey(this.getTestScriptKey().cloneObject());
        }
        if ((this.getTestScriptName() != null)) {
            clone.setTestScriptName(this.getTestScriptName().cloneObject());
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
        if ((this.elementResultList instanceof NabuccoList<?>)) {
            clone.elementResultList = ((NabuccoList<TestScriptElementResult>) this.elementResultList)
                    .cloneCollection();
        }
        if ((this.actionTraceList instanceof NabuccoList<?>)) {
            clone.actionTraceList = ((NabuccoList<ActionTrace>) this.actionTraceList)
                    .cloneCollection();
        }
        if ((this.getLogging() != null)) {
            clone.setLogging(this.getLogging().cloneObject());
        }
    }

    /**
     * Getter for the ActionTraceListJPA.
     *
     * @return the List<ActionTrace>.
     */
    List<ActionTrace> getActionTraceListJPA() {
        if ((this.actionTraceList == null)) {
            this.actionTraceList = new NabuccoList<ActionTrace>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<ActionTrace>) this.actionTraceList).getDelegate();
    }

    /**
     * Setter for the ActionTraceListJPA.
     *
     * @param actionTraceList the List<ActionTrace>.
     */
    void setActionTraceListJPA(List<ActionTrace> actionTraceList) {
        if ((this.actionTraceList == null)) {
            this.actionTraceList = new NabuccoList<ActionTrace>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<ActionTrace>) this.actionTraceList).setDelegate(actionTraceList);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<TestScriptStatusType>(PROPERTY_NAMES[0],
                TestScriptStatusType.class, PROPERTY_CONSTRAINTS[0], this.status));
        properties.add(new BasetypeProperty<Key>(PROPERTY_NAMES[1], Key.class,
                PROPERTY_CONSTRAINTS[1], this.testScriptKey));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[2], Name.class,
                PROPERTY_CONSTRAINTS[2], this.testScriptName));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[3], DateValue.class,
                PROPERTY_CONSTRAINTS[3], this.startTime));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[4], DateValue.class,
                PROPERTY_CONSTRAINTS[4], this.endTime));
        properties.add(new BasetypeProperty<Duration>(PROPERTY_NAMES[5], Duration.class,
                PROPERTY_CONSTRAINTS[5], this.duration));
        properties.add(new ListProperty<TestScriptElementResult>(PROPERTY_NAMES[6],
                TestScriptElementResult.class, PROPERTY_CONSTRAINTS[6], this.elementResultList));
        properties.add(new ListProperty<ActionTrace>(PROPERTY_NAMES[7], ActionTrace.class,
                PROPERTY_CONSTRAINTS[7], this.actionTraceList));
        properties.add(new BasetypeProperty<LogTrace>(PROPERTY_NAMES[8], LogTrace.class,
                PROPERTY_CONSTRAINTS[8], this.logging));
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
        final TestScriptResult other = ((TestScriptResult) obj);
        if ((this.status == null)) {
            if ((other.status != null))
                return false;
        } else if ((!this.status.equals(other.status)))
            return false;
        if ((this.testScriptKey == null)) {
            if ((other.testScriptKey != null))
                return false;
        } else if ((!this.testScriptKey.equals(other.testScriptKey)))
            return false;
        if ((this.testScriptName == null)) {
            if ((other.testScriptName != null))
                return false;
        } else if ((!this.testScriptName.equals(other.testScriptName)))
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
        if ((this.logging == null)) {
            if ((other.logging != null))
                return false;
        } else if ((!this.logging.equals(other.logging)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.status == null) ? 0 : this.status.hashCode()));
        result = ((PRIME * result) + ((this.testScriptKey == null) ? 0 : this.testScriptKey
                .hashCode()));
        result = ((PRIME * result) + ((this.testScriptName == null) ? 0 : this.testScriptName
                .hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.endTime == null) ? 0 : this.endTime.hashCode()));
        result = ((PRIME * result) + ((this.duration == null) ? 0 : this.duration.hashCode()));
        result = ((PRIME * result) + ((this.logging == null) ? 0 : this.logging.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestScriptResult>\n");
        appendable.append(super.toString());
        appendable.append((("<status>" + this.status) + "</status>\n"));
        appendable.append((("<testScriptKey>" + this.testScriptKey) + "</testScriptKey>\n"));
        appendable.append((("<testScriptName>" + this.testScriptName) + "</testScriptName>\n"));
        appendable.append((("<startTime>" + this.startTime) + "</startTime>\n"));
        appendable.append((("<endTime>" + this.endTime) + "</endTime>\n"));
        appendable.append((("<duration>" + this.duration) + "</duration>\n"));
        appendable.append((("<logging>" + this.logging) + "</logging>\n"));
        appendable.append("</TestScriptResult>\n");
        return appendable.toString();
    }

    @Override
    public TestScriptResult cloneObject() {
        TestScriptResult clone = new TestScriptResult();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getStatus.
     *
     * @return the TestScriptStatusType.
     */
    public TestScriptStatusType getStatus() {
        return this.status;
    }

    /**
     * Missing description at method setStatus.
     *
     * @param status the TestScriptStatusType.
     */
    public void setStatus(TestScriptStatusType status) {
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
            this.status = TestScriptStatusType.valueOf(status);
        }
    }

    /**
     * Missing description at method getTestScriptKey.
     *
     * @return the Key.
     */
    public Key getTestScriptKey() {
        return this.testScriptKey;
    }

    /**
     * Missing description at method setTestScriptKey.
     *
     * @param testScriptKey the Key.
     */
    public void setTestScriptKey(Key testScriptKey) {
        this.testScriptKey = testScriptKey;
    }

    /**
     * Missing description at method setTestScriptKey.
     *
     * @param testScriptKey the String.
     */
    public void setTestScriptKey(String testScriptKey) {
        if ((this.testScriptKey == null)) {
            this.testScriptKey = new Key();
        }
        this.testScriptKey.setValue(testScriptKey);
    }

    /**
     * Missing description at method getTestScriptName.
     *
     * @return the Name.
     */
    public Name getTestScriptName() {
        return this.testScriptName;
    }

    /**
     * Missing description at method setTestScriptName.
     *
     * @param testScriptName the Name.
     */
    public void setTestScriptName(Name testScriptName) {
        this.testScriptName = testScriptName;
    }

    /**
     * Missing description at method setTestScriptName.
     *
     * @param testScriptName the String.
     */
    public void setTestScriptName(String testScriptName) {
        if ((this.testScriptName == null)) {
            this.testScriptName = new Name();
        }
        this.testScriptName.setValue(testScriptName);
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
     * Missing description at method getElementResultList.
     *
     * @return the List<TestScriptElementResult>.
     */
    public List<TestScriptElementResult> getElementResultList() {
        if ((this.elementResultList == null)) {
            this.elementResultList = new NabuccoList<TestScriptElementResult>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.elementResultList;
    }

    /**
     * Missing description at method getActionTraceList.
     *
     * @return the List<ActionTrace>.
     */
    public List<ActionTrace> getActionTraceList() {
        if ((this.actionTraceList == null)) {
            this.actionTraceList = new NabuccoList<ActionTrace>(NabuccoCollectionState.INITIALIZED);
        }
        return this.actionTraceList;
    }

    /**
     * Missing description at method getLogging.
     *
     * @return the LogTrace.
     */
    public LogTrace getLogging() {
        return this.logging;
    }

    /**
     * Missing description at method setLogging.
     *
     * @param logging the LogTrace.
     */
    public void setLogging(LogTrace logging) {
        this.logging = logging;
    }

    /**
     * Missing description at method setLogging.
     *
     * @param logging the String.
     */
    public void setLogging(String logging) {
        if ((this.logging == null)) {
            this.logging = new LogTrace();
        }
        this.logging.setValue(logging);
    }
}
