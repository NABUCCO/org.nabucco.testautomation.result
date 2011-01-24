/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message.jira;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.issuetracking.ProjectComponent;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ComponentListMsg<p/>Message for transporting a list of ProjectComponents<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-01-05
 */
public class ComponentListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "components" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<ProjectComponent> components;

    /** Constructs a new ComponentListMsg instance. */
    public ComponentListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<ProjectComponent>(PROPERTY_NAMES[0],
                ProjectComponent.class, PROPERTY_CONSTRAINTS[0], this.components));
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
        final ComponentListMsg other = ((ComponentListMsg) obj);
        if ((this.components == null)) {
            if ((other.components != null))
                return false;
        } else if ((!this.components.equals(other.components)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.components == null) ? 0 : this.components.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ComponentListMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<components>" + this.components) + "</components>\n"));
        appendable.append("</ComponentListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getComponents.
     *
     * @return the List<ProjectComponent>.
     */
    public List<ProjectComponent> getComponents() {
        if ((this.components == null)) {
            this.components = new ArrayList<ProjectComponent>();
        }
        return this.components;
    }
}
