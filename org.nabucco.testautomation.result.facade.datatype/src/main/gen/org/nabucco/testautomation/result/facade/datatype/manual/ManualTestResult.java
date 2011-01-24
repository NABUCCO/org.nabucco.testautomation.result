/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.manual;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualState;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * ManualTestResult<p/>The result of a manual test step<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-11-30
 */
public class ManualTestResult extends TestResult implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "state", "userMessage", "userErrorMessage",
            "actionTraceList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,10000;m0,1;",
            "l0,10000;m0,1;", "m0,n;" };

    private ManualState state;

    private LogTrace userMessage;

    private LogTrace userErrorMessage;

    private List<ActionTrace> actionTraceList;

    /** Constructs a new ManualTestResult instance. */
    public ManualTestResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        state = ManualState.INITIALIZED;
    }

    /**
     * CloneObject.
     *
     * @param clone the ManualTestResult.
     */
    protected void cloneObject(ManualTestResult clone) {
        super.cloneObject(clone);
        clone.setState(this.getState());
        if ((this.getUserMessage() != null)) {
            clone.setUserMessage(this.getUserMessage().cloneObject());
        }
        if ((this.getUserErrorMessage() != null)) {
            clone.setUserErrorMessage(this.getUserErrorMessage().cloneObject());
        }
        if ((this.actionTraceList instanceof NabuccoList<?>)) {
            clone.actionTraceList = ((NabuccoList<ActionTrace>) this.actionTraceList)
                    .cloneCollection();
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
        properties.add(new EnumProperty<ManualState>(PROPERTY_NAMES[0], ManualState.class,
                PROPERTY_CONSTRAINTS[0], this.state));
        properties.add(new BasetypeProperty<LogTrace>(PROPERTY_NAMES[1], LogTrace.class,
                PROPERTY_CONSTRAINTS[1], this.userMessage));
        properties.add(new BasetypeProperty<LogTrace>(PROPERTY_NAMES[2], LogTrace.class,
                PROPERTY_CONSTRAINTS[2], this.userErrorMessage));
        properties.add(new ListProperty<ActionTrace>(PROPERTY_NAMES[3], ActionTrace.class,
                PROPERTY_CONSTRAINTS[3], this.actionTraceList));
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
        final ManualTestResult other = ((ManualTestResult) obj);
        if ((this.state == null)) {
            if ((other.state != null))
                return false;
        } else if ((!this.state.equals(other.state)))
            return false;
        if ((this.userMessage == null)) {
            if ((other.userMessage != null))
                return false;
        } else if ((!this.userMessage.equals(other.userMessage)))
            return false;
        if ((this.userErrorMessage == null)) {
            if ((other.userErrorMessage != null))
                return false;
        } else if ((!this.userErrorMessage.equals(other.userErrorMessage)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.state == null) ? 0 : this.state.hashCode()));
        result = ((PRIME * result) + ((this.userMessage == null) ? 0 : this.userMessage.hashCode()));
        result = ((PRIME * result) + ((this.userErrorMessage == null) ? 0 : this.userErrorMessage
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ManualTestResult>\n");
        appendable.append(super.toString());
        appendable.append((("<state>" + this.state) + "</state>\n"));
        appendable.append((("<userMessage>" + this.userMessage) + "</userMessage>\n"));
        appendable
                .append((("<userErrorMessage>" + this.userErrorMessage) + "</userErrorMessage>\n"));
        appendable.append("</ManualTestResult>\n");
        return appendable.toString();
    }

    @Override
    public ManualTestResult cloneObject() {
        ManualTestResult clone = new ManualTestResult();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getState.
     *
     * @return the ManualState.
     */
    public ManualState getState() {
        return this.state;
    }

    /**
     * Missing description at method setState.
     *
     * @param state the ManualState.
     */
    public void setState(ManualState state) {
        this.state = state;
    }

    /**
     * Missing description at method setState.
     *
     * @param state the String.
     */
    public void setState(String state) {
        if ((state == null)) {
            this.state = null;
        } else {
            this.state = ManualState.valueOf(state);
        }
    }

    /**
     * Missing description at method getUserMessage.
     *
     * @return the LogTrace.
     */
    public LogTrace getUserMessage() {
        return this.userMessage;
    }

    /**
     * Missing description at method setUserMessage.
     *
     * @param userMessage the LogTrace.
     */
    public void setUserMessage(LogTrace userMessage) {
        this.userMessage = userMessage;
    }

    /**
     * Missing description at method setUserMessage.
     *
     * @param userMessage the String.
     */
    public void setUserMessage(String userMessage) {
        if ((this.userMessage == null)) {
            this.userMessage = new LogTrace();
        }
        this.userMessage.setValue(userMessage);
    }

    /**
     * Missing description at method getUserErrorMessage.
     *
     * @return the LogTrace.
     */
    public LogTrace getUserErrorMessage() {
        return this.userErrorMessage;
    }

    /**
     * Missing description at method setUserErrorMessage.
     *
     * @param userErrorMessage the LogTrace.
     */
    public void setUserErrorMessage(LogTrace userErrorMessage) {
        this.userErrorMessage = userErrorMessage;
    }

    /**
     * Missing description at method setUserErrorMessage.
     *
     * @param userErrorMessage the String.
     */
    public void setUserErrorMessage(String userErrorMessage) {
        if ((this.userErrorMessage == null)) {
            this.userErrorMessage = new LogTrace();
        }
        this.userErrorMessage.setValue(userErrorMessage);
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
}
