/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.trace;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Duration;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.base.DateValue;

/**
 * ActionTrace<p/>The tracing information for an external action call<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-10
 */
public class ActionTrace extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "name", "actionId", "startTime", "endTime",
            "duration", "stackTrace" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,100000;m0,1;" };

    private Name name;

    private Identifier actionId;

    private DateValue startTime;

    private DateValue endTime;

    private Duration duration;

    private LogTrace stackTrace;

    /** Constructs a new ActionTrace instance. */
    public ActionTrace() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ActionTrace.
     */
    protected void cloneObject(ActionTrace clone) {
        super.cloneObject(clone);
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getActionId() != null)) {
            clone.setActionId(this.getActionId().cloneObject());
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
        if ((this.getStackTrace() != null)) {
            clone.setStackTrace(this.getStackTrace().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[0], Name.class,
                PROPERTY_CONSTRAINTS[0], this.name));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[1], Identifier.class,
                PROPERTY_CONSTRAINTS[1], this.actionId));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[2], DateValue.class,
                PROPERTY_CONSTRAINTS[2], this.startTime));
        properties.add(new BasetypeProperty<DateValue>(PROPERTY_NAMES[3], DateValue.class,
                PROPERTY_CONSTRAINTS[3], this.endTime));
        properties.add(new BasetypeProperty<Duration>(PROPERTY_NAMES[4], Duration.class,
                PROPERTY_CONSTRAINTS[4], this.duration));
        properties.add(new BasetypeProperty<LogTrace>(PROPERTY_NAMES[5], LogTrace.class,
                PROPERTY_CONSTRAINTS[5], this.stackTrace));
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
        final ActionTrace other = ((ActionTrace) obj);
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.actionId == null)) {
            if ((other.actionId != null))
                return false;
        } else if ((!this.actionId.equals(other.actionId)))
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
        if ((this.stackTrace == null)) {
            if ((other.stackTrace != null))
                return false;
        } else if ((!this.stackTrace.equals(other.stackTrace)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.actionId == null) ? 0 : this.actionId.hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.endTime == null) ? 0 : this.endTime.hashCode()));
        result = ((PRIME * result) + ((this.duration == null) ? 0 : this.duration.hashCode()));
        result = ((PRIME * result) + ((this.stackTrace == null) ? 0 : this.stackTrace.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ActionTrace>\n");
        appendable.append(super.toString());
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<actionId>" + this.actionId) + "</actionId>\n"));
        appendable.append((("<startTime>" + this.startTime) + "</startTime>\n"));
        appendable.append((("<endTime>" + this.endTime) + "</endTime>\n"));
        appendable.append((("<duration>" + this.duration) + "</duration>\n"));
        appendable.append((("<stackTrace>" + this.stackTrace) + "</stackTrace>\n"));
        appendable.append("</ActionTrace>\n");
        return appendable.toString();
    }

    @Override
    public ActionTrace cloneObject() {
        ActionTrace clone = new ActionTrace();
        this.cloneObject(clone);
        return clone;
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
     * Missing description at method getActionId.
     *
     * @return the Identifier.
     */
    public Identifier getActionId() {
        return this.actionId;
    }

    /**
     * Missing description at method setActionId.
     *
     * @param actionId the Identifier.
     */
    public void setActionId(Identifier actionId) {
        this.actionId = actionId;
    }

    /**
     * Missing description at method setActionId.
     *
     * @param actionId the Long.
     */
    public void setActionId(Long actionId) {
        if ((this.actionId == null)) {
            this.actionId = new Identifier();
        }
        this.actionId.setValue(actionId);
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
     * Missing description at method getStackTrace.
     *
     * @return the LogTrace.
     */
    public LogTrace getStackTrace() {
        return this.stackTrace;
    }

    /**
     * Missing description at method setStackTrace.
     *
     * @param stackTrace the LogTrace.
     */
    public void setStackTrace(LogTrace stackTrace) {
        this.stackTrace = stackTrace;
    }

    /**
     * Missing description at method setStackTrace.
     *
     * @param stackTrace the String.
     */
    public void setStackTrace(String stackTrace) {
        if ((this.stackTrace == null)) {
            this.stackTrace = new LogTrace();
        }
        this.stackTrace.setValue(stackTrace);
    }
}
