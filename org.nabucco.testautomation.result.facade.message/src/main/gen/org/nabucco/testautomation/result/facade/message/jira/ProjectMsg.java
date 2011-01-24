/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message.jira;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.issuetracking.Project;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectMsg<p/>Message for transporting a Project<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-01-05
 */
public class ProjectMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "project" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private Project project;

    /** Constructs a new ProjectMsg instance. */
    public ProjectMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<Project>(PROPERTY_NAMES[0], Project.class,
                PROPERTY_CONSTRAINTS[0], this.project));
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
        final ProjectMsg other = ((ProjectMsg) obj);
        if ((this.project == null)) {
            if ((other.project != null))
                return false;
        } else if ((!this.project.equals(other.project)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.project == null) ? 0 : this.project.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ProjectMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<project>" + this.project) + "</project>\n"));
        appendable.append("</ProjectMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getProject.
     *
     * @return the Project.
     */
    public Project getProject() {
        return this.project;
    }

    /**
     * Missing description at method setProject.
     *
     * @param project the Project.
     */
    public void setProject(Project project) {
        this.project = project;
    }
}
