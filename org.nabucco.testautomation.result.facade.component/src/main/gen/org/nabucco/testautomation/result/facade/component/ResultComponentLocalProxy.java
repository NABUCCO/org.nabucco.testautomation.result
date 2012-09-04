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
package org.nabucco.testautomation.result.facade.component;

import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.testautomation.result.facade.component.ResultComponent;
import org.nabucco.testautomation.result.facade.service.jira.JiraService;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceResult;
import org.nabucco.testautomation.result.facade.service.report.ReportResult;
import org.nabucco.testautomation.result.facade.service.resolve.ResolveResult;
import org.nabucco.testautomation.result.facade.service.search.SearchResult;

/**
 * ResultComponentLocalProxy<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public class ResultComponentLocalProxy implements ResultComponent {

    private static final long serialVersionUID = 1L;

    private final ResultComponentLocal delegate;

    /**
     * Constructs a new ResultComponentLocalProxy instance.
     *
     * @param delegate the ResultComponentLocal.
     */
    public ResultComponentLocalProxy(ResultComponentLocal delegate) {
        super();
        if ((delegate == null)) {
            throw new IllegalArgumentException("Cannot create local proxy for component [null].");
        }
        this.delegate = delegate;
    }

    @Override
    public String getId() {
        return this.delegate.getId();
    }

    @Override
    public String getName() {
        return this.delegate.getName();
    }

    @Override
    public String getJndiName() {
        return this.delegate.getJndiName();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.delegate.getComponentRelationServiceLocal();
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return this.delegate.getQueryFilterServiceLocal();
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    public MaintainResult getMaintainResult() throws ServiceException {
        return this.delegate.getMaintainResultLocal();
    }

    @Override
    public SearchResult getSearchResult() throws ServiceException {
        return this.delegate.getSearchResultLocal();
    }

    @Override
    public ResolveResult getResolveResult() throws ServiceException {
        return this.delegate.getResolveResultLocal();
    }

    @Override
    public ReportResult getReportResult() throws ServiceException {
        return this.delegate.getReportResultLocal();
    }

    @Override
    public ProduceResult getProduceResult() throws ServiceException {
        return this.delegate.getProduceResultLocal();
    }

    @Override
    public JiraService getJiraService() throws ServiceException {
        return this.delegate.getJiraServiceLocal();
    }
}
