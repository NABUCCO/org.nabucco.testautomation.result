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
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.property.facade.datatype.PropertyList;
import org.nabucco.testautomation.property.facade.datatype.base.LongText;
import org.nabucco.testautomation.property.facade.datatype.base.Text;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;", "m0,1;", "l0,n;u0,n;m0,1;",
            "l0,100000;u0,n;m0,1;" };

    public static final String ACTIONSTATUS = "actionStatus";

    public static final String RETURNPROPERTIES = "returnProperties";

    public static final String ACTIONTRACE = "actionTrace";

    public static final String MESSAGE = "message";

    public static final String ERRORMESSAGE = "errorMessage";

    private ActionStatusType actionStatus;

    private PropertyList returnProperties;

    private Long returnPropertiesRefId;

    private ActionTrace actionTrace;

    private Text message;

    private LongText errorMessage;

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
        if ((this.getMessage() != null)) {
            clone.setMessage(this.getMessage().cloneObject());
        }
        if ((this.getErrorMessage() != null)) {
            clone.setErrorMessage(this.getErrorMessage().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(TestScriptElementResult.class).getPropertyMap());
        propertyMap.put(ACTIONSTATUS, PropertyDescriptorSupport.createEnumeration(ACTIONSTATUS, ActionStatusType.class,
                5, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(RETURNPROPERTIES, PropertyDescriptorSupport.createDatatype(RETURNPROPERTIES,
                PropertyList.class, 6, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(ACTIONTRACE, PropertyDescriptorSupport.createDatatype(ACTIONTRACE, ActionTrace.class, 7,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(MESSAGE,
                PropertyDescriptorSupport.createBasetype(MESSAGE, Text.class, 8, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(ERRORMESSAGE, PropertyDescriptorSupport.createBasetype(ERRORMESSAGE, LongText.class, 9,
                PROPERTY_CONSTRAINTS[4], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ActionResponse.getPropertyDescriptor(ACTIONSTATUS), this.getActionStatus(),
                null));
        properties.add(super.createProperty(ActionResponse.getPropertyDescriptor(RETURNPROPERTIES),
                this.getReturnProperties(), this.returnPropertiesRefId));
        properties.add(super.createProperty(ActionResponse.getPropertyDescriptor(ACTIONTRACE), this.getActionTrace(),
                null));
        properties.add(super.createProperty(ActionResponse.getPropertyDescriptor(MESSAGE), this.message, null));
        properties
                .add(super.createProperty(ActionResponse.getPropertyDescriptor(ERRORMESSAGE), this.errorMessage, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ACTIONSTATUS) && (property.getType() == ActionStatusType.class))) {
            this.setActionStatus(((ActionStatusType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RETURNPROPERTIES) && (property.getType() == PropertyList.class))) {
            this.setReturnProperties(((PropertyList) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ACTIONTRACE) && (property.getType() == ActionTrace.class))) {
            this.setActionTrace(((ActionTrace) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MESSAGE) && (property.getType() == Text.class))) {
            this.setMessage(((Text) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ERRORMESSAGE) && (property.getType() == LongText.class))) {
            this.setErrorMessage(((LongText) property.getInstance()));
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
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.actionStatus == null) ? 0 : this.actionStatus.hashCode()));
        result = ((PRIME * result) + ((this.returnProperties == null) ? 0 : this.returnProperties.hashCode()));
        result = ((PRIME * result) + ((this.returnPropertiesRefId == null) ? 0 : this.returnPropertiesRefId.hashCode()));
        result = ((PRIME * result) + ((this.actionTrace == null) ? 0 : this.actionTrace.hashCode()));
        result = ((PRIME * result) + ((this.message == null) ? 0 : this.message.hashCode()));
        result = ((PRIME * result) + ((this.errorMessage == null) ? 0 : this.errorMessage.hashCode()));
        return result;
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
            if ((message == null)) {
                return;
            }
            this.message = new Text();
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
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ActionResponse.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ActionResponse.class).getAllProperties();
    }
}
