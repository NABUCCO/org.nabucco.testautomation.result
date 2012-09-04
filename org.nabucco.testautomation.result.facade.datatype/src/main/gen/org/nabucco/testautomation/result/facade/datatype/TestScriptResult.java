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
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.property.facade.datatype.base.LongText;
import org.nabucco.testautomation.property.facade.datatype.base.Text;
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

    private static final TestScriptStatusType STATUS_DEFAULT = TestScriptStatusType.PASSED;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,16;u0,n;m0,1;", "l0,255;u0,n;m1,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "m0,n;", "m0,n;", "l0,n;u0,n;m0,1;",
            "l0,100000;u0,n;m0,1;", "l0,100000;u0,n;m0,1;" };

    public static final String STATUS = "status";

    public static final String TESTSCRIPTKEY = "testScriptKey";

    public static final String TESTSCRIPTNAME = "testScriptName";

    public static final String STARTTIME = "startTime";

    public static final String ENDTIME = "endTime";

    public static final String DURATION = "duration";

    public static final String ELEMENTRESULTLIST = "elementResultList";

    public static final String ACTIONTRACELIST = "actionTraceList";

    public static final String MESSAGE = "message";

    public static final String ERRORMESSAGE = "errorMessage";

    public static final String LOGGING = "logging";

    private TestScriptStatusType status;

    private Key testScriptKey;

    private Name testScriptName;

    private Date startTime;

    private Date endTime;

    private Duration duration;

    private NabuccoList<TestScriptElementResult> elementResultList;

    private NabuccoList<ActionTrace> actionTraceList;

    private Text message;

    private LongText errorMessage;

    private LogTrace logging;

    /** Constructs a new TestScriptResult instance. */
    public TestScriptResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        status = STATUS_DEFAULT;
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
        if ((this.elementResultList != null)) {
            clone.elementResultList = this.elementResultList.cloneCollection();
        }
        if ((this.actionTraceList != null)) {
            clone.actionTraceList = this.actionTraceList.cloneCollection();
        }
        if ((this.getMessage() != null)) {
            clone.setMessage(this.getMessage().cloneObject());
        }
        if ((this.getErrorMessage() != null)) {
            clone.setErrorMessage(this.getErrorMessage().cloneObject());
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
        propertyMap.putAll(PropertyCache.getInstance().retrieve(TestScriptElementResult.class).getPropertyMap());
        propertyMap.put(STATUS, PropertyDescriptorSupport.createEnumeration(STATUS, TestScriptStatusType.class, 5,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(TESTSCRIPTKEY,
                PropertyDescriptorSupport.createBasetype(TESTSCRIPTKEY, Key.class, 6, PROPERTY_CONSTRAINTS[1], false));
        propertyMap
                .put(TESTSCRIPTNAME, PropertyDescriptorSupport.createBasetype(TESTSCRIPTNAME, Name.class, 7,
                        PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(STARTTIME,
                PropertyDescriptorSupport.createBasetype(STARTTIME, Date.class, 8, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(ENDTIME,
                PropertyDescriptorSupport.createBasetype(ENDTIME, Date.class, 9, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(DURATION,
                PropertyDescriptorSupport.createBasetype(DURATION, Duration.class, 10, PROPERTY_CONSTRAINTS[5], false));
        propertyMap
                .put(ELEMENTRESULTLIST, PropertyDescriptorSupport.createCollection(ELEMENTRESULTLIST,
                        TestScriptElementResult.class, 11, PROPERTY_CONSTRAINTS[6], false,
                        PropertyAssociationType.COMPOSITION));
        propertyMap.put(ACTIONTRACELIST, PropertyDescriptorSupport.createCollection(ACTIONTRACELIST, ActionTrace.class,
                12, PROPERTY_CONSTRAINTS[7], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(MESSAGE,
                PropertyDescriptorSupport.createBasetype(MESSAGE, Text.class, 13, PROPERTY_CONSTRAINTS[8], false));
        propertyMap.put(ERRORMESSAGE, PropertyDescriptorSupport.createBasetype(ERRORMESSAGE, LongText.class, 14,
                PROPERTY_CONSTRAINTS[9], false));
        propertyMap.put(LOGGING,
                PropertyDescriptorSupport.createBasetype(LOGGING, LogTrace.class, 15, PROPERTY_CONSTRAINTS[10], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(STATUS), this.getStatus(), null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(TESTSCRIPTKEY), this.testScriptKey,
                null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(TESTSCRIPTNAME),
                this.testScriptName, null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(STARTTIME), this.startTime, null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(ENDTIME), this.endTime, null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(DURATION), this.duration, null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(ELEMENTRESULTLIST),
                this.elementResultList, null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(ACTIONTRACELIST),
                this.actionTraceList, null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(MESSAGE), this.message, null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(ERRORMESSAGE), this.errorMessage,
                null));
        properties.add(super.createProperty(TestScriptResult.getPropertyDescriptor(LOGGING), this.logging, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(STATUS) && (property.getType() == TestScriptStatusType.class))) {
            this.setStatus(((TestScriptStatusType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTSCRIPTKEY) && (property.getType() == Key.class))) {
            this.setTestScriptKey(((Key) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTSCRIPTNAME) && (property.getType() == Name.class))) {
            this.setTestScriptName(((Name) property.getInstance()));
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
        } else if ((property.getName().equals(ELEMENTRESULTLIST) && (property.getType() == TestScriptElementResult.class))) {
            this.elementResultList = ((NabuccoList<TestScriptElementResult>) property.getInstance());
            return true;
        } else if ((property.getName().equals(ACTIONTRACELIST) && (property.getType() == ActionTrace.class))) {
            this.actionTraceList = ((NabuccoList<ActionTrace>) property.getInstance());
            return true;
        } else if ((property.getName().equals(MESSAGE) && (property.getType() == Text.class))) {
            this.setMessage(((Text) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ERRORMESSAGE) && (property.getType() == LongText.class))) {
            this.setErrorMessage(((LongText) property.getInstance()));
            return true;
        } else if ((property.getName().equals(LOGGING) && (property.getType() == LogTrace.class))) {
            this.setLogging(((LogTrace) property.getInstance()));
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
        result = ((PRIME * result) + ((this.testScriptKey == null) ? 0 : this.testScriptKey.hashCode()));
        result = ((PRIME * result) + ((this.testScriptName == null) ? 0 : this.testScriptName.hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        result = ((PRIME * result) + ((this.endTime == null) ? 0 : this.endTime.hashCode()));
        result = ((PRIME * result) + ((this.duration == null) ? 0 : this.duration.hashCode()));
        result = ((PRIME * result) + ((this.message == null) ? 0 : this.message.hashCode()));
        result = ((PRIME * result) + ((this.errorMessage == null) ? 0 : this.errorMessage.hashCode()));
        result = ((PRIME * result) + ((this.logging == null) ? 0 : this.logging.hashCode()));
        return result;
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
            if ((testScriptKey == null)) {
                return;
            }
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
            if ((testScriptName == null)) {
                return;
            }
            this.testScriptName = new Name();
        }
        this.testScriptName.setValue(testScriptName);
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
     * Missing description at method getElementResultList.
     *
     * @return the NabuccoList<TestScriptElementResult>.
     */
    public NabuccoList<TestScriptElementResult> getElementResultList() {
        if ((this.elementResultList == null)) {
            this.elementResultList = new NabuccoListImpl<TestScriptElementResult>(NabuccoCollectionState.INITIALIZED);
        }
        return this.elementResultList;
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
            if ((logging == null)) {
                return;
            }
            this.logging = new LogTrace();
        }
        this.logging.setValue(logging);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestScriptResult.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestScriptResult.class).getAllProperties();
    }
}
