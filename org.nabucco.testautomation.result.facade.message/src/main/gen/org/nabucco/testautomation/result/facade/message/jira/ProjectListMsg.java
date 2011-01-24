/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message.jira;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.issuetracking.Project;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectListMsg<p/>Message for transporting a list of Projects<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-01-05
 */
public class ProjectListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "projects" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<Project> projects;

    /** Constructs a new ProjectListMsg instance. */
    public ProjectListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<Project>(PROPERTY_NAMES[0], Project.class,
                PROPERTY_CONSTRAINTS[0], this.projects));
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
        final ProjectListMsg other = ((ProjectListMsg) obj);
        if ((this.projects == null)) {
            if ((other.projects != null))
                return false;
        } else if ((!this.projects.equals(other.projects)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.projects == null) ? 0 : this.projects.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ProjectListMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<projects>" + this.projects) + "</projects>\n"));
        appendable.append("</ProjectListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getProjects.
     *
     * @return the List<Project>.
     */
    public List<Project> getProjects() {
        if ((this.projects == null)) {
            this.projects = new ArrayList<Project>();
        }
        return this.projects;
    }
}
