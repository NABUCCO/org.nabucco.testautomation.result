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
import org.nabucco.testautomation.result.facade.service.jira.JiraService;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceResult;
import org.nabucco.testautomation.result.facade.service.report.ReportResult;
import org.nabucco.testautomation.result.facade.service.resolve.ResolveResult;
import org.nabucco.testautomation.result.facade.service.search.SearchResult;

/**
 * ResultComponentLocal<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public interface ResultComponentLocal extends ResultComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainResultLocal.
     *
     * @return the MaintainResult.
     * @throws ServiceException
     */
    MaintainResult getMaintainResultLocal() throws ServiceException;

    /**
     * Getter for the SearchResultLocal.
     *
     * @return the SearchResult.
     * @throws ServiceException
     */
    SearchResult getSearchResultLocal() throws ServiceException;

    /**
     * Getter for the ResolveResultLocal.
     *
     * @return the ResolveResult.
     * @throws ServiceException
     */
    ResolveResult getResolveResultLocal() throws ServiceException;

    /**
     * Getter for the ReportResultLocal.
     *
     * @return the ReportResult.
     * @throws ServiceException
     */
    ReportResult getReportResultLocal() throws ServiceException;

    /**
     * Getter for the ProduceResultLocal.
     *
     * @return the ProduceResult.
     * @throws ServiceException
     */
    ProduceResult getProduceResultLocal() throws ServiceException;

    /**
     * Getter for the JiraServiceLocal.
     *
     * @return the JiraService.
     * @throws ServiceException
     */
    JiraService getJiraServiceLocal() throws ServiceException;
}
