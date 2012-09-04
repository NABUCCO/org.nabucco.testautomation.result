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
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * MessageTrace<p/>The tracing information containing request and response<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-10
 */
public class MessageTrace extends ActionTrace implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,1000000;u0,n;m0,1;", "l0,1000000;u0,n;m0,1;" };

    public static final String REQUEST = "request";

    public static final String RESPONSE = "response";

    private LogTrace request;

    private LogTrace response;

    /** Constructs a new MessageTrace instance. */
    public MessageTrace() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the MessageTrace.
     */
    protected void cloneObject(MessageTrace clone) {
        super.cloneObject(clone);
        if ((this.getRequest() != null)) {
            clone.setRequest(this.getRequest().cloneObject());
        }
        if ((this.getResponse() != null)) {
            clone.setResponse(this.getResponse().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ActionTrace.class).getPropertyMap());
        propertyMap.put(REQUEST,
                PropertyDescriptorSupport.createBasetype(REQUEST, LogTrace.class, 9, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(RESPONSE,
                PropertyDescriptorSupport.createBasetype(RESPONSE, LogTrace.class, 10, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(MessageTrace.getPropertyDescriptor(REQUEST), this.request, null));
        properties.add(super.createProperty(MessageTrace.getPropertyDescriptor(RESPONSE), this.response, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(REQUEST) && (property.getType() == LogTrace.class))) {
            this.setRequest(((LogTrace) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RESPONSE) && (property.getType() == LogTrace.class))) {
            this.setResponse(((LogTrace) property.getInstance()));
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
        final MessageTrace other = ((MessageTrace) obj);
        if ((this.request == null)) {
            if ((other.request != null))
                return false;
        } else if ((!this.request.equals(other.request)))
            return false;
        if ((this.response == null)) {
            if ((other.response != null))
                return false;
        } else if ((!this.response.equals(other.response)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.request == null) ? 0 : this.request.hashCode()));
        result = ((PRIME * result) + ((this.response == null) ? 0 : this.response.hashCode()));
        return result;
    }

    @Override
    public MessageTrace cloneObject() {
        MessageTrace clone = new MessageTrace();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getRequest.
     *
     * @return the LogTrace.
     */
    public LogTrace getRequest() {
        return this.request;
    }

    /**
     * Missing description at method setRequest.
     *
     * @param request the LogTrace.
     */
    public void setRequest(LogTrace request) {
        this.request = request;
    }

    /**
     * Missing description at method setRequest.
     *
     * @param request the String.
     */
    public void setRequest(String request) {
        if ((this.request == null)) {
            if ((request == null)) {
                return;
            }
            this.request = new LogTrace();
        }
        this.request.setValue(request);
    }

    /**
     * Missing description at method getResponse.
     *
     * @return the LogTrace.
     */
    public LogTrace getResponse() {
        return this.response;
    }

    /**
     * Missing description at method setResponse.
     *
     * @param response the LogTrace.
     */
    public void setResponse(LogTrace response) {
        this.response = response;
    }

    /**
     * Missing description at method setResponse.
     *
     * @param response the String.
     */
    public void setResponse(String response) {
        if ((this.response == null)) {
            if ((response == null)) {
                return;
            }
            this.response = new LogTrace();
        }
        this.response.setValue(response);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(MessageTrace.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(MessageTrace.class).getAllProperties();
    }
}
