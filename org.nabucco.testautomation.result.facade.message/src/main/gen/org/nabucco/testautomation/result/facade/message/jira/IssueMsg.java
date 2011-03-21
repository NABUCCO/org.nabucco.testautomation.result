/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message.jira;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.issuetracking.Issue;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,n;", "m0,1;", "m0,1;" };

    public static final String ISSUE = "issue";

    public static final String TESTRESULTS = "testResults";

    public static final String ENVIRONMENTTYPE = "environmentType";

    public static final String RELEASETYPE = "releaseType";

    private Issue issue;

    private NabuccoList<TestResult> testResults;

    private Code environmentType;

    private Code releaseType;

    /** Constructs a new IssueMsg instance. */
    public IssueMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(ISSUE, PropertyDescriptorSupport.createDatatype(ISSUE, Issue.class, 0,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(TESTRESULTS, PropertyDescriptorSupport.createCollection(TESTRESULTS,
                TestResult.class, 1, PROPERTY_CONSTRAINTS[1], false,
                PropertyAssociationType.COMPOSITION));
        propertyMap.put(ENVIRONMENTTYPE, PropertyDescriptorSupport.createDatatype(ENVIRONMENTTYPE,
                Code.class, 2, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT));
        propertyMap.put(RELEASETYPE, PropertyDescriptorSupport.createDatatype(RELEASETYPE,
                Code.class, 3, PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPONENT));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(IssueMsg.getPropertyDescriptor(ISSUE), this.issue));
        properties.add(super.createProperty(IssueMsg.getPropertyDescriptor(TESTRESULTS),
                this.testResults));
        properties.add(super.createProperty(IssueMsg.getPropertyDescriptor(ENVIRONMENTTYPE),
                this.environmentType));
        properties.add(super.createProperty(IssueMsg.getPropertyDescriptor(RELEASETYPE),
                this.releaseType));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ISSUE) && (property.getType() == Issue.class))) {
            this.setIssue(((Issue) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTRESULTS) && (property.getType() == TestResult.class))) {
            this.testResults = ((NabuccoList<TestResult>) property.getInstance());
            return true;
        } else if ((property.getName().equals(ENVIRONMENTTYPE) && (property.getType() == Code.class))) {
            this.setEnvironmentType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELEASETYPE) && (property.getType() == Code.class))) {
            this.setReleaseType(((Code) property.getInstance()));
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
     * @return the NabuccoList<TestResult>.
     */
    public NabuccoList<TestResult> getTestResults() {
        if ((this.testResults == null)) {
            this.testResults = new NabuccoListImpl<TestResult>(NabuccoCollectionState.INITIALIZED);
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(IssueMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(IssueMsg.class).getAllProperties();
    }
}
