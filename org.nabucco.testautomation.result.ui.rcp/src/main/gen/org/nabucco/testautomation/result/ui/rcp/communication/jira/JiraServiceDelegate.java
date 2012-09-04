/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.ui.rcp.communication.jira;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
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
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the ProjectListMsg.
     * @throws ClientException
     */
    public ProjectListMsg getProjects(EmptyServiceMessage message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.getProjects(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(JiraService.class, "getProjects", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.getProjects");
    }

    /**
     * Getter for the Priorities.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the PriorityListMsg.
     * @throws ClientException
     */
    public PriorityListMsg getPriorities(EmptyServiceMessage message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<PriorityListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.getPriorities(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(JiraService.class, "getPriorities", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.getPriorities");
    }

    /**
     * Getter for the IssueTypesOfProject.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectMsg.
     * @return the IssueTypeListMsg.
     * @throws ClientException
     */
    public IssueTypeListMsg getIssueTypesOfProject(ProjectMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IssueTypeListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.getIssueTypesOfProject(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(JiraService.class, "getIssueTypesOfProject", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.getIssueTypesOfProject");
    }

    /**
     * Getter for the ComponentsOfProject.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectMsg.
     * @return the ComponentListMsg.
     * @throws ClientException
     */
    public ComponentListMsg getComponentsOfProject(ProjectMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ComponentListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.getComponentsOfProject(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(JiraService.class, "getComponentsOfProject", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.getComponentsOfProject");
    }

    /**
     * CreateIssue.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the IssueMsg.
     * @return the IssueMsg.
     * @throws ClientException
     */
    public IssueMsg createIssue(IssueMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<IssueMsg> request = new ServiceRequest<IssueMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IssueMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.createIssue(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(JiraService.class, "createIssue", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.createIssue");
    }

    /**
     * CreateIssues.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the IssueMsg.
     * @return the IssueMsg.
     * @throws ClientException
     */
    public IssueMsg createIssues(IssueMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<IssueMsg> request = new ServiceRequest<IssueMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<IssueMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.createIssues(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(JiraService.class, "createIssues", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.createIssues");
    }

    /**
     * Getter for the VersionsOfProject.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectMsg.
     * @return the VersionListMsg.
     * @throws ClientException
     */
    public VersionListMsg getVersionsOfProject(ProjectMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ProjectMsg> request = new ServiceRequest<ProjectMsg>(super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<VersionListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.getVersionsOfProject(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(JiraService.class, "getVersionsOfProject", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: JiraService.getVersionsOfProject");
    }
}
