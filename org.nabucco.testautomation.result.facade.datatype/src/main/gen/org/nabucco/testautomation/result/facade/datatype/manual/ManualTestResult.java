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
package org.nabucco.testautomation.result.facade.datatype.manual;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualState;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.FileTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.MessageTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;
import org.nabucco.testautomation.settings.facade.datatype.engine.ContextSnapshot;

/**
 * ManualTestResult<p/>The result of a manual test step<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-11-30
 */
public class ManualTestResult extends TestResult implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final ManualState STATE_DEFAULT = ManualState.INITIALIZED;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,10000;u0,n;m0,1;", "l0,10000;u0,n;m0,1;",
            "m0,n;", "m0,n;", "m0,n;", "m0,n;", "m0,1;", "m0,1;" };

    public static final String STATE = "state";

    public static final String USERMESSAGE = "userMessage";

    public static final String USERERRORMESSAGE = "userErrorMessage";

    public static final String ACTIONTRACELIST = "actionTraceList";

    public static final String SCREENSHOTS = "screenshots";

    public static final String FILES = "files";

    public static final String MESSAGES = "messages";

    public static final String CONTEXTSNAPSHOT = "contextSnapshot";

    public static final String PROPERTYLIST = "propertyList";

    private ManualState state;

    private LogTrace userMessage;

    private LogTrace userErrorMessage;

    private NabuccoList<ActionTrace> actionTraceList;

    private NabuccoList<ScreenshotTrace> screenshots;

    private NabuccoList<FileTrace> files;

    private NabuccoList<MessageTrace> messages;

    private ContextSnapshot contextSnapshot;

    private ContextSnapshot propertyList;

    /** Constructs a new ManualTestResult instance. */
    public ManualTestResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        state = STATE_DEFAULT;
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
        if ((this.actionTraceList != null)) {
            clone.actionTraceList = this.actionTraceList.cloneCollection();
        }
        if ((this.screenshots != null)) {
            clone.screenshots = this.screenshots.cloneCollection();
        }
        if ((this.files != null)) {
            clone.files = this.files.cloneCollection();
        }
        if ((this.messages != null)) {
            clone.messages = this.messages.cloneCollection();
        }
        if ((this.getContextSnapshot() != null)) {
            clone.setContextSnapshot(this.getContextSnapshot().cloneObject());
        }
        if ((this.getPropertyList() != null)) {
            clone.setPropertyList(this.getPropertyList().cloneObject());
        }
    }

    /**
     * Getter for the ActionTraceListJPA.
     *
     * @return the List<ActionTrace>.
     */
    List<ActionTrace> getActionTraceListJPA() {
        if ((this.actionTraceList == null)) {
            this.actionTraceList = new NabuccoListImpl<ActionTrace>(NabuccoCollectionState.EAGER);
        }
        return ((NabuccoListImpl<ActionTrace>) this.actionTraceList).getDelegate();
    }

    /**
     * Setter for the ActionTraceListJPA.
     *
     * @param actionTraceList the List<ActionTrace>.
     */
    void setActionTraceListJPA(List<ActionTrace> actionTraceList) {
        if ((this.actionTraceList == null)) {
            this.actionTraceList = new NabuccoListImpl<ActionTrace>(NabuccoCollectionState.EAGER);
        }
        ((NabuccoListImpl<ActionTrace>) this.actionTraceList).setDelegate(actionTraceList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(TestResult.class).getPropertyMap());
        propertyMap.put(STATE, PropertyDescriptorSupport.createEnumeration(STATE, ManualState.class, 19,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(USERMESSAGE, PropertyDescriptorSupport.createBasetype(USERMESSAGE, LogTrace.class, 20,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(USERERRORMESSAGE, PropertyDescriptorSupport.createBasetype(USERERRORMESSAGE, LogTrace.class,
                21, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(ACTIONTRACELIST, PropertyDescriptorSupport.createCollection(ACTIONTRACELIST, ActionTrace.class,
                22, PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(SCREENSHOTS, PropertyDescriptorSupport.createCollection(SCREENSHOTS, ScreenshotTrace.class, 23,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(FILES, PropertyDescriptorSupport.createCollection(FILES, FileTrace.class, 24,
                PROPERTY_CONSTRAINTS[5], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(MESSAGES, PropertyDescriptorSupport.createCollection(MESSAGES, MessageTrace.class, 25,
                PROPERTY_CONSTRAINTS[6], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(CONTEXTSNAPSHOT, PropertyDescriptorSupport.createDatatype(CONTEXTSNAPSHOT,
                ContextSnapshot.class, 26, PROPERTY_CONSTRAINTS[7], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(PROPERTYLIST, PropertyDescriptorSupport.createDatatype(PROPERTYLIST, ContextSnapshot.class, 27,
                PROPERTY_CONSTRAINTS[8], false, PropertyAssociationType.COMPONENT));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ManualTestResult.getPropertyDescriptor(STATE), this.getState(), null));
        properties
                .add(super.createProperty(ManualTestResult.getPropertyDescriptor(USERMESSAGE), this.userMessage, null));
        properties.add(super.createProperty(ManualTestResult.getPropertyDescriptor(USERERRORMESSAGE),
                this.userErrorMessage, null));
        properties.add(super.createProperty(ManualTestResult.getPropertyDescriptor(ACTIONTRACELIST),
                this.actionTraceList, null));
        properties
                .add(super.createProperty(ManualTestResult.getPropertyDescriptor(SCREENSHOTS), this.screenshots, null));
        properties.add(super.createProperty(ManualTestResult.getPropertyDescriptor(FILES), this.files, null));
        properties.add(super.createProperty(ManualTestResult.getPropertyDescriptor(MESSAGES), this.messages, null));
        properties.add(super.createProperty(ManualTestResult.getPropertyDescriptor(CONTEXTSNAPSHOT),
                this.getContextSnapshot(), null));
        properties.add(super.createProperty(ManualTestResult.getPropertyDescriptor(PROPERTYLIST),
                this.getPropertyList(), null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(STATE) && (property.getType() == ManualState.class))) {
            this.setState(((ManualState) property.getInstance()));
            return true;
        } else if ((property.getName().equals(USERMESSAGE) && (property.getType() == LogTrace.class))) {
            this.setUserMessage(((LogTrace) property.getInstance()));
            return true;
        } else if ((property.getName().equals(USERERRORMESSAGE) && (property.getType() == LogTrace.class))) {
            this.setUserErrorMessage(((LogTrace) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ACTIONTRACELIST) && (property.getType() == ActionTrace.class))) {
            this.actionTraceList = ((NabuccoList<ActionTrace>) property.getInstance());
            return true;
        } else if ((property.getName().equals(SCREENSHOTS) && (property.getType() == ScreenshotTrace.class))) {
            this.screenshots = ((NabuccoList<ScreenshotTrace>) property.getInstance());
            return true;
        } else if ((property.getName().equals(FILES) && (property.getType() == FileTrace.class))) {
            this.files = ((NabuccoList<FileTrace>) property.getInstance());
            return true;
        } else if ((property.getName().equals(MESSAGES) && (property.getType() == MessageTrace.class))) {
            this.messages = ((NabuccoList<MessageTrace>) property.getInstance());
            return true;
        } else if ((property.getName().equals(CONTEXTSNAPSHOT) && (property.getType() == ContextSnapshot.class))) {
            this.setContextSnapshot(((ContextSnapshot) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROPERTYLIST) && (property.getType() == ContextSnapshot.class))) {
            this.setPropertyList(((ContextSnapshot) property.getInstance()));
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
        if ((this.contextSnapshot == null)) {
            if ((other.contextSnapshot != null))
                return false;
        } else if ((!this.contextSnapshot.equals(other.contextSnapshot)))
            return false;
        if ((this.propertyList == null)) {
            if ((other.propertyList != null))
                return false;
        } else if ((!this.propertyList.equals(other.propertyList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.state == null) ? 0 : this.state.hashCode()));
        result = ((PRIME * result) + ((this.userMessage == null) ? 0 : this.userMessage.hashCode()));
        result = ((PRIME * result) + ((this.userErrorMessage == null) ? 0 : this.userErrorMessage.hashCode()));
        result = ((PRIME * result) + ((this.contextSnapshot == null) ? 0 : this.contextSnapshot.hashCode()));
        result = ((PRIME * result) + ((this.propertyList == null) ? 0 : this.propertyList.hashCode()));
        return result;
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
            if ((userMessage == null)) {
                return;
            }
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
            if ((userErrorMessage == null)) {
                return;
            }
            this.userErrorMessage = new LogTrace();
        }
        this.userErrorMessage.setValue(userErrorMessage);
    }

    /**
     * Missing description at method getActionTraceList.
     *
     * @return the NabuccoList<ActionTrace>.
     */
    public NabuccoList<ActionTrace> getActionTraceList() {
        if ((this.actionTraceList == null)) {
            this.actionTraceList = new NabuccoListImpl<ActionTrace>(NabuccoCollectionState.INITIALIZED);
        }
        return this.actionTraceList;
    }

    /**
     * Missing description at method getScreenshots.
     *
     * @return the NabuccoList<ScreenshotTrace>.
     */
    public NabuccoList<ScreenshotTrace> getScreenshots() {
        if ((this.screenshots == null)) {
            this.screenshots = new NabuccoListImpl<ScreenshotTrace>(NabuccoCollectionState.INITIALIZED);
        }
        return this.screenshots;
    }

    /**
     * Missing description at method getFiles.
     *
     * @return the NabuccoList<FileTrace>.
     */
    public NabuccoList<FileTrace> getFiles() {
        if ((this.files == null)) {
            this.files = new NabuccoListImpl<FileTrace>(NabuccoCollectionState.INITIALIZED);
        }
        return this.files;
    }

    /**
     * Missing description at method getMessages.
     *
     * @return the NabuccoList<MessageTrace>.
     */
    public NabuccoList<MessageTrace> getMessages() {
        if ((this.messages == null)) {
            this.messages = new NabuccoListImpl<MessageTrace>(NabuccoCollectionState.INITIALIZED);
        }
        return this.messages;
    }

    /**
     * Missing description at method setContextSnapshot.
     *
     * @param contextSnapshot the ContextSnapshot.
     */
    public void setContextSnapshot(ContextSnapshot contextSnapshot) {
        this.contextSnapshot = contextSnapshot;
    }

    /**
     * Missing description at method getContextSnapshot.
     *
     * @return the ContextSnapshot.
     */
    public ContextSnapshot getContextSnapshot() {
        return this.contextSnapshot;
    }

    /**
     * Missing description at method setPropertyList.
     *
     * @param propertyList the ContextSnapshot.
     */
    public void setPropertyList(ContextSnapshot propertyList) {
        this.propertyList = propertyList;
    }

    /**
     * Missing description at method getPropertyList.
     *
     * @return the ContextSnapshot.
     */
    public ContextSnapshot getPropertyList() {
        return this.propertyList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ManualTestResult.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ManualTestResult.class).getAllProperties();
    }
}
