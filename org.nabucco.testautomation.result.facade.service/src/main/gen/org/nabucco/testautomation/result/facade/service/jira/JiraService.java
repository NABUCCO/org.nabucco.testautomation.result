/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.service.jira;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.result.facade.message.jira.ComponentListMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueTypeListMsg;
import org.nabucco.testautomation.result.facade.message.jira.PriorityListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;

/**
 * JiraService<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public interface JiraService extends Service {

    /**
     * Missing description at method getProjects.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ProjectListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProjectListMsg> getProjects(ServiceRequest<EmptyServiceMessage> rq)
            throws SearchException;

    /**
     * Missing description at method getPriorities.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<PriorityListMsg>.
     * @throws SearchException
     */
    ServiceResponse<PriorityListMsg> getPriorities(ServiceRequest<EmptyServiceMessage> rq)
            throws SearchException;

    /**
     * Missing description at method getIssueTypesOfProject.
     *
     * @param rq the ServiceRequest<ProjectMsg>.
     * @return the ServiceResponse<IssueTypeListMsg>.
     * @throws SearchException
     */
    ServiceResponse<IssueTypeListMsg> getIssueTypesOfProject(ServiceRequest<ProjectMsg> rq)
            throws SearchException;

    /**
     * Missing description at method getComponentsOfProject.
     *
     * @param rq the ServiceRequest<ProjectMsg>.
     * @return the ServiceResponse<ComponentListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ComponentListMsg> getComponentsOfProject(ServiceRequest<ProjectMsg> rq)
            throws SearchException;

    /**
     * Missing description at method createIssue.
     *
     * @param rq the ServiceRequest<IssueMsg>.
     * @return the ServiceResponse<IssueMsg>.
     * @throws MaintainException
     */
    ServiceResponse<IssueMsg> createIssue(ServiceRequest<IssueMsg> rq) throws MaintainException;

    /**
     * Missing description at method createIssues.
     *
     * @param rq the ServiceRequest<IssueMsg>.
     * @return the ServiceResponse<IssueMsg>.
     * @throws MaintainException
     */
    ServiceResponse<IssueMsg> createIssues(ServiceRequest<IssueMsg> rq) throws MaintainException;
}
