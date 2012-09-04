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
package org.nabucco.testautomation.result.facade.datatype.trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Duration;
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ActionTrace<p/>The tracing information for an external action call<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-10
 */
public class ActionTrace extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m1,1;", "l0,16;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,1000000;u0,n;m0,1;" };

    public static final String NAME = "name";

    public static final String ACTIONID = "actionId";

    public static final String STARTTIME = "startTime";

    public static final String ENDTIME = "endTime";

    public static final String DURATION = "duration";

    public static final String STACKTRACE = "stackTrace";

    private Name name;

    private Key actionId;

    private Date startTime;

    private Date endTime;

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(NAME,
                PropertyDescriptorSupport.createBasetype(NAME, Name.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ACTIONID,
                PropertyDescriptorSupport.createBasetype(ACTIONID, Key.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(STARTTIME,
                PropertyDescriptorSupport.createBasetype(STARTTIME, Date.class, 5, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(ENDTIME,
                PropertyDescriptorSupport.createBasetype(ENDTIME, Date.class, 6, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(DURATION,
                PropertyDescriptorSupport.createBasetype(DURATION, Duration.class, 7, PROPERTY_CONSTRAINTS[4], false));
        propertyMap
                .put(STACKTRACE, PropertyDescriptorSupport.createBasetype(STACKTRACE, LogTrace.class, 8,
                        PROPERTY_CONSTRAINTS[5], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ActionTrace.getPropertyDescriptor(NAME), this.name, null));
        properties.add(super.createProperty(ActionTrace.getPropertyDescriptor(ACTIONID), this.actionId, null));
        properties.add(super.createProperty(ActionTrace.getPropertyDescriptor(STARTTIME), this.startTime, null));
        properties.add(super.createProperty(ActionTrace.getPropertyDescriptor(ENDTIME), this.endTime, null));
        properties.add(super.createProperty(ActionTrace.getPropertyDescriptor(DURATION), this.duration, null));
        properties.add(super.createProperty(ActionTrace.getPropertyDescriptor(STACKTRACE), this.stackTrace, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ACTIONID) && (property.getType() == Key.class))) {
            this.setActionId(((Key) property.getInstance()));
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
        } else if ((property.getName().equals(STACKTRACE) && (property.getType() == LogTrace.class))) {
            this.setStackTrace(((LogTrace) property.getInstance()));
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
            if ((name == null)) {
                return;
            }
            this.name = new Name();
        }
        this.name.setValue(name);
    }

    /**
     * Missing description at method getActionId.
     *
     * @return the Key.
     */
    public Key getActionId() {
        return this.actionId;
    }

    /**
     * Missing description at method setActionId.
     *
     * @param actionId the Key.
     */
    public void setActionId(Key actionId) {
        this.actionId = actionId;
    }

    /**
     * Missing description at method setActionId.
     *
     * @param actionId the String.
     */
    public void setActionId(String actionId) {
        if ((this.actionId == null)) {
            if ((actionId == null)) {
                return;
            }
            this.actionId = new Key();
        }
        this.actionId.setValue(actionId);
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
            if ((stackTrace == null)) {
                return;
            }
            this.stackTrace = new LogTrace();
        }
        this.stackTrace.setValue(stackTrace);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ActionTrace.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ActionTrace.class).getAllProperties();
    }
}
