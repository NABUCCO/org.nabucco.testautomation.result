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
package org.nabucco.testautomation.result.impl.service.jira;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.testautomation.result.facade.message.jira.ComponentListMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueTypeListMsg;
import org.nabucco.testautomation.result.facade.message.jira.PriorityListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;
import org.nabucco.testautomation.result.facade.message.jira.VersionListMsg;
import org.nabucco.testautomation.result.facade.service.jira.JiraService;

/**
 * JiraServiceImpl<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public class JiraServiceImpl extends ServiceSupport implements JiraService {

    private static final long serialVersionUID = 1L;

    private static final String ID = "JiraService";

    private static Map<String, String[]> ASPECTS;

    private GetProjectsServiceHandler getProjectsServiceHandler;

    private GetPrioritiesServiceHandler getPrioritiesServiceHandler;

    private GetIssueTypesOfProjectServiceHandler getIssueTypesOfProjectServiceHandler;

    private GetComponentsOfProjectServiceHandler getComponentsOfProjectServiceHandler;

    private CreateIssueServiceHandler createIssueServiceHandler;

    private CreateIssuesServiceHandler createIssuesServiceHandler;

    private GetVersionsOfProjectServiceHandler getVersionsOfProjectServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new JiraServiceImpl instance. */
    public JiraServiceImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.getProjectsServiceHandler = injector.inject(GetProjectsServiceHandler.getId());
        if ((this.getProjectsServiceHandler != null)) {
            this.getProjectsServiceHandler.setPersistenceManager(persistenceManager);
            this.getProjectsServiceHandler.setLogger(super.getLogger());
        }
        this.getPrioritiesServiceHandler = injector.inject(GetPrioritiesServiceHandler.getId());
        if ((this.getPrioritiesServiceHandler != null)) {
            this.getPrioritiesServiceHandler.setPersistenceManager(persistenceManager);
            this.getPrioritiesServiceHandler.setLogger(super.getLogger());
        }
        this.getIssueTypesOfProjectServiceHandler = injector.inject(GetIssueTypesOfProjectServiceHandler.getId());
        if ((this.getIssueTypesOfProjectServiceHandler != null)) {
            this.getIssueTypesOfProjectServiceHandler.setPersistenceManager(persistenceManager);
            this.getIssueTypesOfProjectServiceHandler.setLogger(super.getLogger());
        }
        this.getComponentsOfProjectServiceHandler = injector.inject(GetComponentsOfProjectServiceHandler.getId());
        if ((this.getComponentsOfProjectServiceHandler != null)) {
            this.getComponentsOfProjectServiceHandler.setPersistenceManager(persistenceManager);
            this.getComponentsOfProjectServiceHandler.setLogger(super.getLogger());
        }
        this.createIssueServiceHandler = injector.inject(CreateIssueServiceHandler.getId());
        if ((this.createIssueServiceHandler != null)) {
            this.createIssueServiceHandler.setPersistenceManager(persistenceManager);
            this.createIssueServiceHandler.setLogger(super.getLogger());
        }
        this.createIssuesServiceHandler = injector.inject(CreateIssuesServiceHandler.getId());
        if ((this.createIssuesServiceHandler != null)) {
            this.createIssuesServiceHandler.setPersistenceManager(persistenceManager);
            this.createIssuesServiceHandler.setLogger(super.getLogger());
        }
        this.getVersionsOfProjectServiceHandler = injector.inject(GetVersionsOfProjectServiceHandler.getId());
        if ((this.getVersionsOfProjectServiceHandler != null)) {
            this.getVersionsOfProjectServiceHandler.setPersistenceManager(persistenceManager);
            this.getVersionsOfProjectServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("getProjects", NO_ASPECTS);
            ASPECTS.put("getPriorities", NO_ASPECTS);
            ASPECTS.put("getIssueTypesOfProject", NO_ASPECTS);
            ASPECTS.put("getComponentsOfProject", NO_ASPECTS);
            ASPECTS.put("createIssue", NO_ASPECTS);
            ASPECTS.put("createIssues", NO_ASPECTS);
            ASPECTS.put("getVersionsOfProject", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ProjectListMsg> getProjects(ServiceRequest<EmptyServiceMessage> rq) throws SearchException {
        if ((this.getProjectsServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for getProjects().");
            throw new InjectionException("No service implementation configured for getProjects().");
        }
        ServiceResponse<ProjectListMsg> rs;
        this.getProjectsServiceHandler.init();
        rs = this.getProjectsServiceHandler.invoke(rq);
        this.getProjectsServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<PriorityListMsg> getPriorities(ServiceRequest<EmptyServiceMessage> rq)
            throws SearchException {
        if ((this.getPrioritiesServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for getPriorities().");
            throw new InjectionException("No service implementation configured for getPriorities().");
        }
        ServiceResponse<PriorityListMsg> rs;
        this.getPrioritiesServiceHandler.init();
        rs = this.getPrioritiesServiceHandler.invoke(rq);
        this.getPrioritiesServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<IssueTypeListMsg> getIssueTypesOfProject(ServiceRequest<ProjectMsg> rq)
            throws SearchException {
        if ((this.getIssueTypesOfProjectServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for getIssueTypesOfProject().");
            throw new InjectionException("No service implementation configured for getIssueTypesOfProject().");
        }
        ServiceResponse<IssueTypeListMsg> rs;
        this.getIssueTypesOfProjectServiceHandler.init();
        rs = this.getIssueTypesOfProjectServiceHandler.invoke(rq);
        this.getIssueTypesOfProjectServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ComponentListMsg> getComponentsOfProject(ServiceRequest<ProjectMsg> rq)
            throws SearchException {
        if ((this.getComponentsOfProjectServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for getComponentsOfProject().");
            throw new InjectionException("No service implementation configured for getComponentsOfProject().");
        }
        ServiceResponse<ComponentListMsg> rs;
        this.getComponentsOfProjectServiceHandler.init();
        rs = this.getComponentsOfProjectServiceHandler.invoke(rq);
        this.getComponentsOfProjectServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<IssueMsg> createIssue(ServiceRequest<IssueMsg> rq) throws MaintainException {
        if ((this.createIssueServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for createIssue().");
            throw new InjectionException("No service implementation configured for createIssue().");
        }
        ServiceResponse<IssueMsg> rs;
        this.createIssueServiceHandler.init();
        rs = this.createIssueServiceHandler.invoke(rq);
        this.createIssueServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<IssueMsg> createIssues(ServiceRequest<IssueMsg> rq) throws MaintainException {
        if ((this.createIssuesServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for createIssues().");
            throw new InjectionException("No service implementation configured for createIssues().");
        }
        ServiceResponse<IssueMsg> rs;
        this.createIssuesServiceHandler.init();
        rs = this.createIssuesServiceHandler.invoke(rq);
        this.createIssuesServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<VersionListMsg> getVersionsOfProject(ServiceRequest<ProjectMsg> rq) throws SearchException {
        if ((this.getVersionsOfProjectServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for getVersionsOfProject().");
            throw new InjectionException("No service implementation configured for getVersionsOfProject().");
        }
        ServiceResponse<VersionListMsg> rs;
        this.getVersionsOfProjectServiceHandler.init();
        rs = this.getVersionsOfProjectServiceHandler.invoke(rq);
        this.getVersionsOfProjectServiceHandler.finish();
        return rs;
    }
}
