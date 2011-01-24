/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message.jira;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.issuetracking.Priority;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * PriorityListMsg<p/>Message for transporting a list of Projects<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-01-05
 */
public class PriorityListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "priorities" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<Priority> priorities;

    /** Constructs a new PriorityListMsg instance. */
    public PriorityListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<Priority>(PROPERTY_NAMES[0], Priority.class,
                PROPERTY_CONSTRAINTS[0], this.priorities));
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
        final PriorityListMsg other = ((PriorityListMsg) obj);
        if ((this.priorities == null)) {
            if ((other.priorities != null))
                return false;
        } else if ((!this.priorities.equals(other.priorities)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.priorities == null) ? 0 : this.priorities.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<PriorityListMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<priorities>" + this.priorities) + "</priorities>\n"));
        appendable.append("</PriorityListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getPriorities.
     *
     * @return the List<Priority>.
     */
    public List<Priority> getPriorities() {
        if ((this.priorities == null)) {
            this.priorities = new ArrayList<Priority>();
        }
        return this.priorities;
    }
}
