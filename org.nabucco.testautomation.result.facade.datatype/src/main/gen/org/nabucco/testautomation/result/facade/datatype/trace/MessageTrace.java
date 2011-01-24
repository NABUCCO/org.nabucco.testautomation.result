/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.trace;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.log.LogTrace;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * MessageTrace<p/>The tracing information containing request and response<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-10
 */
public class MessageTrace extends ActionTrace implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "request", "response" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,100000;m0,1;", "l0,100000;m0,1;" };

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

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<LogTrace>(PROPERTY_NAMES[0], LogTrace.class,
                PROPERTY_CONSTRAINTS[0], this.request));
        properties.add(new BasetypeProperty<LogTrace>(PROPERTY_NAMES[1], LogTrace.class,
                PROPERTY_CONSTRAINTS[1], this.response));
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<MessageTrace>\n");
        appendable.append(super.toString());
        appendable.append((("<request>" + this.request) + "</request>\n"));
        appendable.append((("<response>" + this.response) + "</response>\n"));
        appendable.append("</MessageTrace>\n");
        return appendable.toString();
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
            this.response = new LogTrace();
        }
        this.response.setValue(response);
    }
}
