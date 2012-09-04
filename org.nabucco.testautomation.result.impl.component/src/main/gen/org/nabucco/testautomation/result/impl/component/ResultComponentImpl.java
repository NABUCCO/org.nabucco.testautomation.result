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
package org.nabucco.testautomation.result.impl.component;

import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;
import org.nabucco.testautomation.result.facade.component.ResultComponentLocal;
import org.nabucco.testautomation.result.facade.component.ResultComponentRemote;
import org.nabucco.testautomation.result.facade.service.jira.JiraService;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceResult;
import org.nabucco.testautomation.result.facade.service.report.ReportResult;
import org.nabucco.testautomation.result.facade.service.resolve.ResolveResult;
import org.nabucco.testautomation.result.facade.service.search.SearchResult;

/**
 * ResultComponentImpl<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public class ResultComponentImpl extends ComponentSupport implements ResultComponentLocal, ResultComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResultComponent";

    /** Constructs a new ResultComponentImpl instance. */
    public ResultComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE, ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL, ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainResult getMaintainResultLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.MAINTAIN_RESULT_LOCAL, MaintainResult.class);
    }

    @Override
    public MaintainResult getMaintainResult() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.MAINTAIN_RESULT_REMOTE, MaintainResult.class);
    }

    @Override
    public SearchResult getSearchResultLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.SEARCH_RESULT_LOCAL, SearchResult.class);
    }

    @Override
    public SearchResult getSearchResult() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.SEARCH_RESULT_REMOTE, SearchResult.class);
    }

    @Override
    public ResolveResult getResolveResultLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.RESOLVE_RESULT_LOCAL, ResolveResult.class);
    }

    @Override
    public ResolveResult getResolveResult() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.RESOLVE_RESULT_REMOTE, ResolveResult.class);
    }

    @Override
    public ReportResult getReportResultLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.REPORT_RESULT_LOCAL, ReportResult.class);
    }

    @Override
    public ReportResult getReportResult() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.REPORT_RESULT_REMOTE, ReportResult.class);
    }

    @Override
    public ProduceResult getProduceResultLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.PRODUCE_RESULT_LOCAL, ProduceResult.class);
    }

    @Override
    public ProduceResult getProduceResult() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.PRODUCE_RESULT_REMOTE, ProduceResult.class);
    }

    @Override
    public JiraService getJiraServiceLocal() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.JIRA_SERVICE_LOCAL, JiraService.class);
    }

    @Override
    public JiraService getJiraService() throws ServiceException {
        return super.lookup(ResultComponentJndiNames.JIRA_SERVICE_REMOTE, JiraService.class);
    }
}
