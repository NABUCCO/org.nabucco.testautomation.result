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

import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.result.facade.service.jira.JiraService;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainResult;
import org.nabucco.testautomation.result.facade.service.produce.ProduceResult;
import org.nabucco.testautomation.result.facade.service.report.ReportResult;
import org.nabucco.testautomation.result.facade.service.resolve.ResolveResult;
import org.nabucco.testautomation.result.facade.service.search.SearchResult;

/**
 * ResultComponent<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public interface ResultComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.testautomation.result";

    final String COMPONENT_PREFIX = "rslt";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.testautomation.result.facade.component.ResultComponent");

    /**
     * Getter for the MaintainResult.
     *
     * @return the MaintainResult.
     * @throws ServiceException
     */
    MaintainResult getMaintainResult() throws ServiceException;

    /**
     * Getter for the SearchResult.
     *
     * @return the SearchResult.
     * @throws ServiceException
     */
    SearchResult getSearchResult() throws ServiceException;

    /**
     * Getter for the ResolveResult.
     *
     * @return the ResolveResult.
     * @throws ServiceException
     */
    ResolveResult getResolveResult() throws ServiceException;

    /**
     * Getter for the ReportResult.
     *
     * @return the ReportResult.
     * @throws ServiceException
     */
    ReportResult getReportResult() throws ServiceException;

    /**
     * Getter for the ProduceResult.
     *
     * @return the ProduceResult.
     * @throws ServiceException
     */
    ProduceResult getProduceResult() throws ServiceException;

    /**
     * Getter for the JiraService.
     *
     * @return the JiraService.
     * @throws ServiceException
     */
    JiraService getJiraService() throws ServiceException;
}
