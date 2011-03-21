/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.communication.jira;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the EmptyServiceMessage.
     * @return the ProjectListMsg.
     * @throws ClientException
     */
    public ProjectListMsg getProjects(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ProjectListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getProjects(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(JiraServiceDelegate.class, "Service: ",
                                "JiraService.getProjects", " Time: ",
                                String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.getProjects");
    }

    /**
     * Getter for the Priorities.
     *
     * @param rq the EmptyServiceMessage.
     * @return the PriorityListMsg.
     * @throws ClientException
     */
    public PriorityListMsg getPriorities(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<PriorityListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getPriorities(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(JiraServiceDelegate.class, "Service: ",
                                "JiraService.getPriorities", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.getPriorities");
    }

    /**
     * Getter for the IssueTypesOfProject.
     *
     * @param rq the ProjectMsg.
     * @return the IssueTypeListMsg.
     * @throws ClientException
     */
    public IssueTypeListMsg getIssueTypesOfProject(ProjectMsg rq) throws ClientException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<IssueTypeListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getIssueTypesOfProject(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(JiraServiceDelegate.class, "Service: ",
                                "JiraService.getIssueTypesOfProject", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: JiraService.getIssueTypesOfProject");
    }

    /**
     * Getter for the ComponentsOfProject.
     *
     * @param rq the ProjectMsg.
     * @return the ComponentListMsg.
     * @throws ClientException
     */
    public ComponentListMsg getComponentsOfProject(ProjectMsg rq) throws ClientException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<ComponentListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getComponentsOfProject(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(JiraServiceDelegate.class, "Service: ",
                                "JiraService.getComponentsOfProject", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: JiraService.getComponentsOfProject");
    }

    /**
     * CreateIssue.
     *
     * @param rq the IssueMsg.
     * @return the IssueMsg.
     * @throws ClientException
     */
    public IssueMsg createIssue(IssueMsg rq) throws ClientException {
        ServiceRequest<IssueMsg> request = new ServiceRequest<IssueMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<IssueMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.createIssue(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(JiraServiceDelegate.class, "Service: ",
                                "JiraService.createIssue", " Time: ",
                                String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.createIssue");
    }

    /**
     * CreateIssues.
     *
     * @param rq the IssueMsg.
     * @return the IssueMsg.
     * @throws ClientException
     */
    public IssueMsg createIssues(IssueMsg rq) throws ClientException {
        ServiceRequest<IssueMsg> request = new ServiceRequest<IssueMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<IssueMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.createIssues(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(JiraServiceDelegate.class, "Service: ",
                                "JiraService.createIssues", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.createIssues");
    }

    /**
     * Getter for the VersionsOfProject.
     *
     * @param rq the ProjectMsg.
     * @return the VersionListMsg.
     * @throws ClientException
     */
    public VersionListMsg getVersionsOfProject(ProjectMsg rq) throws ClientException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<VersionListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getVersionsOfProject(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(JiraServiceDelegate.class, "Service: ",
                                "JiraService.getVersionsOfProject", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: JiraService.getVersionsOfProject");
    }
}
