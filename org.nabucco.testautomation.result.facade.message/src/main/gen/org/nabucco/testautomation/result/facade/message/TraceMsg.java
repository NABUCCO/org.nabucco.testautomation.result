/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * TraceMsg<p/>Message for transporting an ActionTrace<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class TraceMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "trace" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private ActionTrace trace;

    /** Constructs a new TraceMsg instance. */
    public TraceMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<ActionTrace>(PROPERTY_NAMES[0], ActionTrace.class,
                PROPERTY_CONSTRAINTS[0], this.trace));
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
        final TraceMsg other = ((TraceMsg) obj);
        if ((this.trace == null)) {
            if ((other.trace != null))
                return false;
        } else if ((!this.trace.equals(other.trace)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.trace == null) ? 0 : this.trace.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TraceMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<trace>" + this.trace) + "</trace>\n"));
        appendable.append("</TraceMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getTrace.
     *
     * @return the ActionTrace.
     */
    public ActionTrace getTrace() {
        return this.trace;
    }

    /**
     * Missing description at method setTrace.
     *
     * @param trace the ActionTrace.
     */
    public void setTrace(ActionTrace trace) {
        this.trace = trace;
    }
}
