/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message.jira;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.issuetracking.Issue;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.result.facade.datatype.TestResult;

/**
 * IssueMsg<p/>Message for transporting a Issue<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-01-05
 */
public class IssueMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "issue", "testResults", "environmentType",
            "releaseType" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,n;", "m0,1;", "m0,1;" };

    private Issue issue;

    private List<TestResult> testResults;

    private Code environmentType;

    private Code releaseType;

    /** Constructs a new IssueMsg instance. */
    public IssueMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<Issue>(PROPERTY_NAMES[0], Issue.class,
                PROPERTY_CONSTRAINTS[0], this.issue));
        properties.add(new ListProperty<TestResult>(PROPERTY_NAMES[1], TestResult.class,
                PROPERTY_CONSTRAINTS[1], this.testResults));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[2], Code.class,
                PROPERTY_CONSTRAINTS[2], this.environmentType));
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[3], Code.class,
                PROPERTY_CONSTRAINTS[3], this.releaseType));
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
        final IssueMsg other = ((IssueMsg) obj);
        if ((this.issue == null)) {
            if ((other.issue != null))
                return false;
        } else if ((!this.issue.equals(other.issue)))
            return false;
        if ((this.testResults == null)) {
            if ((other.testResults != null))
                return false;
        } else if ((!this.testResults.equals(other.testResults)))
            return false;
        if ((this.environmentType == null)) {
            if ((other.environmentType != null))
                return false;
        } else if ((!this.environmentType.equals(other.environmentType)))
            return false;
        if ((this.releaseType == null)) {
            if ((other.releaseType != null))
                return false;
        } else if ((!this.releaseType.equals(other.releaseType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.issue == null) ? 0 : this.issue.hashCode()));
        result = ((PRIME * result) + ((this.testResults == null) ? 0 : this.testResults.hashCode()));
        result = ((PRIME * result) + ((this.environmentType == null) ? 0 : this.environmentType
                .hashCode()));
        result = ((PRIME * result) + ((this.releaseType == null) ? 0 : this.releaseType.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<IssueMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<issue>" + this.issue) + "</issue>\n"));
        appendable.append((("<testResults>" + this.testResults) + "</testResults>\n"));
        appendable.append((("<environmentType>" + this.environmentType) + "</environmentType>\n"));
        appendable.append((("<releaseType>" + this.releaseType) + "</releaseType>\n"));
        appendable.append("</IssueMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getIssue.
     *
     * @return the Issue.
     */
    public Issue getIssue() {
        return this.issue;
    }

    /**
     * Missing description at method setIssue.
     *
     * @param issue the Issue.
     */
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    /**
     * Missing description at method getTestResults.
     *
     * @return the List<TestResult>.
     */
    public List<TestResult> getTestResults() {
        if ((this.testResults == null)) {
            this.testResults = new ArrayList<TestResult>();
        }
        return this.testResults;
    }

    /**
     * Missing description at method getEnvironmentType.
     *
     * @return the Code.
     */
    public Code getEnvironmentType() {
        return this.environmentType;
    }

    /**
     * Missing description at method setEnvironmentType.
     *
     * @param environmentType the Code.
     */
    public void setEnvironmentType(Code environmentType) {
        this.environmentType = environmentType;
    }

    /**
     * Missing description at method getReleaseType.
     *
     * @return the Code.
     */
    public Code getReleaseType() {
        return this.releaseType;
    }

    /**
     * Missing description at method setReleaseType.
     *
     * @param releaseType the Code.
     */
    public void setReleaseType(Code releaseType) {
        this.releaseType = releaseType;
    }
}
