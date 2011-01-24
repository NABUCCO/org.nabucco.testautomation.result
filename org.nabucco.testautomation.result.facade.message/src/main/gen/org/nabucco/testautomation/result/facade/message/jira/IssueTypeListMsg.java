/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message.jira;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.issuetracking.IssueType;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * IssueTypeListMsg<p/>Message for transporting a list of IssueType<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-01-05
 */
public class IssueTypeListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "issueTypes" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<IssueType> issueTypes;

    /** Constructs a new IssueTypeListMsg instance. */
    public IssueTypeListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<IssueType>(PROPERTY_NAMES[0], IssueType.class,
                PROPERTY_CONSTRAINTS[0], this.issueTypes));
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
        final IssueTypeListMsg other = ((IssueTypeListMsg) obj);
        if ((this.issueTypes == null)) {
            if ((other.issueTypes != null))
                return false;
        } else if ((!this.issueTypes.equals(other.issueTypes)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.issueTypes == null) ? 0 : this.issueTypes.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<IssueTypeListMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<issueTypes>" + this.issueTypes) + "</issueTypes>\n"));
        appendable.append("</IssueTypeListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getIssueTypes.
     *
     * @return the List<IssueType>.
     */
    public List<IssueType> getIssueTypes() {
        if ((this.issueTypes == null)) {
            this.issueTypes = new ArrayList<IssueType>();
        }
        return this.issueTypes;
    }
}
