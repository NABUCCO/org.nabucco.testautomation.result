/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.property.PropertyList;
import org.nabucco.testautomation.result.facade.datatype.TestScriptElementResult;
import org.nabucco.testautomation.result.facade.datatype.status.ActionStatusType;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * ActionResponse<p/>The result of a TestScriptElement<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public class ActionResponse extends TestScriptElementResult implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "actionStatus", "returnProperties",
            "actionTrace" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;", "m0,1;" };

    private ActionStatusType actionStatus;

    private PropertyList returnProperties;

    private Long returnPropertiesRefId;

    private ActionTrace actionTrace;

    /** Constructs a new ActionResponse instance. */
    public ActionResponse() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ActionResponse.
     */
    protected void cloneObject(ActionResponse clone) {
        super.cloneObject(clone);
        clone.setActionStatus(this.getActionStatus());
        if ((this.getReturnProperties() != null)) {
            clone.setReturnProperties(this.getReturnProperties().cloneObject());
        }
        if ((this.getReturnPropertiesRefId() != null)) {
            clone.setReturnPropertiesRefId(this.getReturnPropertiesRefId());
        }
        if ((this.getActionTrace() != null)) {
            clone.setActionTrace(this.getActionTrace().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<ActionStatusType>(PROPERTY_NAMES[0],
                ActionStatusType.class, PROPERTY_CONSTRAINTS[0], this.actionStatus));
        properties.add(new DatatypeProperty<PropertyList>(PROPERTY_NAMES[1], PropertyList.class,
                PROPERTY_CONSTRAINTS[1], this.returnProperties));
        properties.add(new DatatypeProperty<ActionTrace>(PROPERTY_NAMES[2], ActionTrace.class,
                PROPERTY_CONSTRAINTS[2], this.actionTrace));
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
        final ActionResponse other = ((ActionResponse) obj);
        if ((this.actionStatus == null)) {
            if ((other.actionStatus != null))
                return false;
        } else if ((!this.actionStatus.equals(other.actionStatus)))
            return false;
        if ((this.returnProperties == null)) {
            if ((other.returnProperties != null))
                return false;
        } else if ((!this.returnProperties.equals(other.returnProperties)))
            return false;
        if ((this.returnPropertiesRefId == null)) {
            if ((other.returnPropertiesRefId != null))
                return false;
        } else if ((!this.returnPropertiesRefId.equals(other.returnPropertiesRefId)))
            return false;
        if ((this.actionTrace == null)) {
            if ((other.actionTrace != null))
                return false;
        } else if ((!this.actionTrace.equals(other.actionTrace)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.actionStatus == null) ? 0 : this.actionStatus
                .hashCode()));
        result = ((PRIME * result) + ((this.returnProperties == null) ? 0 : this.returnProperties
                .hashCode()));
        result = ((PRIME * result) + ((this.returnPropertiesRefId == null) ? 0
                : this.returnPropertiesRefId.hashCode()));
        result = ((PRIME * result) + ((this.actionTrace == null) ? 0 : this.actionTrace.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ActionResponse>\n");
        appendable.append(super.toString());
        appendable.append((("<actionStatus>" + this.actionStatus) + "</actionStatus>\n"));
        appendable
                .append((("<returnProperties>" + this.returnProperties) + "</returnProperties>\n"));
        appendable
                .append((("<returnPropertiesRefId>" + this.returnPropertiesRefId) + "</returnPropertiesRefId>\n"));
        appendable.append((("<actionTrace>" + this.actionTrace) + "</actionTrace>\n"));
        appendable.append("</ActionResponse>\n");
        return appendable.toString();
    }

    @Override
    public ActionResponse cloneObject() {
        ActionResponse clone = new ActionResponse();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getActionStatus.
     *
     * @return the ActionStatusType.
     */
    public ActionStatusType getActionStatus() {
        return this.actionStatus;
    }

    /**
     * Missing description at method setActionStatus.
     *
     * @param actionStatus the ActionStatusType.
     */
    public void setActionStatus(ActionStatusType actionStatus) {
        this.actionStatus = actionStatus;
    }

    /**
     * Missing description at method setActionStatus.
     *
     * @param actionStatus the String.
     */
    public void setActionStatus(String actionStatus) {
        if ((actionStatus == null)) {
            this.actionStatus = null;
        } else {
            this.actionStatus = ActionStatusType.valueOf(actionStatus);
        }
    }

    /**
     * Missing description at method setReturnProperties.
     *
     * @param returnProperties the PropertyList.
     */
    public void setReturnProperties(PropertyList returnProperties) {
        this.returnProperties = returnProperties;
        if ((returnProperties != null)) {
            this.setReturnPropertiesRefId(returnProperties.getId());
        } else {
            this.setReturnPropertiesRefId(null);
        }
    }

    /**
     * Missing description at method getReturnProperties.
     *
     * @return the PropertyList.
     */
    public PropertyList getReturnProperties() {
        return this.returnProperties;
    }

    /**
     * Getter for the ReturnPropertiesRefId.
     *
     * @return the Long.
     */
    public Long getReturnPropertiesRefId() {
        return this.returnPropertiesRefId;
    }

    /**
     * Setter for the ReturnPropertiesRefId.
     *
     * @param returnPropertiesRefId the Long.
     */
    public void setReturnPropertiesRefId(Long returnPropertiesRefId) {
        this.returnPropertiesRefId = returnPropertiesRefId;
    }

    /**
     * Missing description at method setActionTrace.
     *
     * @param actionTrace the ActionTrace.
     */
    public void setActionTrace(ActionTrace actionTrace) {
        this.actionTrace = actionTrace;
    }

    /**
     * Missing description at method getActionTrace.
     *
     * @return the ActionTrace.
     */
    public ActionTrace getActionTrace() {
        return this.actionTrace;
    }
}
