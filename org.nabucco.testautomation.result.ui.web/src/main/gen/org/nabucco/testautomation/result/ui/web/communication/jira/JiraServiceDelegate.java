/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.web.communication.jira;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.result.facade.message.jira.ComponentListMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueTypeListMsg;
import org.nabucco.testautomation.result.facade.message.jira.PriorityListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;
import org.nabucco.testautomation.result.facade.message.jira.VersionListMsg;
import org.nabucco.testautomation.result.facade.service.jira.JiraService;

/**
 * JiraServiceDelegate<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public class JiraServiceDelegate extends ServiceDelegateSupport {

    private JiraService service;

    /**
     * Constructs a new JiraServiceDelegate instance.
     *
     * @param service the JiraService.
     */
    public JiraServiceDelegate(JiraService service) {
        super();
        this.service = service;
    }

    /**
     * Getter for the Projects.
     *
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the ProjectListMsg.
     * @throws SearchException
     */
    public ProjectListMsg getProjects(EmptyServiceMessage rq, NabuccoSession session)
            throws SearchException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<ProjectListMsg> rs;
        if ((service != null)) {
            rs = service.getProjects(request);
        } else {
            throw new SearchException("Cannot execute service operation: JiraService.getProjects");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the Priorities.
     *
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the PriorityListMsg.
     * @throws SearchException
     */
    public PriorityListMsg getPriorities(EmptyServiceMessage rq, NabuccoSession session)
            throws SearchException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<PriorityListMsg> rs;
        if ((service != null)) {
            rs = service.getPriorities(request);
        } else {
            throw new SearchException("Cannot execute service operation: JiraService.getPriorities");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the IssueTypesOfProject.
     *
     * @param session the NabuccoSession.
     * @param rq the ProjectMsg.
     * @return the IssueTypeListMsg.
     * @throws SearchException
     */
    public IssueTypeListMsg getIssueTypesOfProject(ProjectMsg rq, NabuccoSession session)
            throws SearchException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<IssueTypeListMsg> rs;
        if ((service != null)) {
            rs = service.getIssueTypesOfProject(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: JiraService.getIssueTypesOfProject");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the ComponentsOfProject.
     *
     * @param session the NabuccoSession.
     * @param rq the ProjectMsg.
     * @return the ComponentListMsg.
     * @throws SearchException
     */
    public ComponentListMsg getComponentsOfProject(ProjectMsg rq, NabuccoSession session)
            throws SearchException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<ComponentListMsg> rs;
        if ((service != null)) {
            rs = service.getComponentsOfProject(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: JiraService.getComponentsOfProject");
        }
        return rs.getResponseMessage();
    }

    /**
     * CreateIssue.
     *
     * @param session the NabuccoSession.
     * @param rq the IssueMsg.
     * @return the IssueMsg.
     * @throws MaintainException
     */
    public IssueMsg createIssue(IssueMsg rq, NabuccoSession session) throws MaintainException {
        ServiceRequest<IssueMsg> request = new ServiceRequest<IssueMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<IssueMsg> rs;
        if ((service != null)) {
            rs = service.createIssue(request);
        } else {
            throw new MaintainException("Cannot execute service operation: JiraService.createIssue");
        }
        return rs.getResponseMessage();
    }

    /**
     * CreateIssues.
     *
     * @param session the NabuccoSession.
     * @param rq the IssueMsg.
     * @return the IssueMsg.
     * @throws MaintainException
     */
    public IssueMsg createIssues(IssueMsg rq, NabuccoSession session) throws MaintainException {
        ServiceRequest<IssueMsg> request = new ServiceRequest<IssueMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<IssueMsg> rs;
        if ((service != null)) {
            rs = service.createIssues(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: JiraService.createIssues");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the VersionsOfProject.
     *
     * @param session the NabuccoSession.
     * @param rq the ProjectMsg.
     * @return the VersionListMsg.
     * @throws SearchException
     */
    public VersionListMsg getVersionsOfProject(ProjectMsg rq, NabuccoSession session)
            throws SearchException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<VersionListMsg> rs;
        if ((service != null)) {
            rs = service.getVersionsOfProject(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: JiraService.getVersionsOfProject");
        }
        return rs.getResponseMessage();
    }
}
