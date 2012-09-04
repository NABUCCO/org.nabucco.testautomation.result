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
package org.nabucco.testautomation.result.ui.rcp.communication;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateFactorySupport;
import org.nabucco.testautomation.result.facade.component.ResultComponent;
import org.nabucco.testautomation.result.facade.component.ResultComponentLocator;
import org.nabucco.testautomation.result.ui.rcp.communication.jira.JiraServiceDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.maintain.MaintainResultDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.produce.ProduceResultDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.report.ReportResultDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.resolve.ResolveResultDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.search.SearchResultDelegate;

/**
 * ServiceDelegateFactoryTemplate<p/>Component for testautomation result<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-01-28
 */
public class ResultComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<ResultComponent> {

    private static ResultComponentServiceDelegateFactory instance = new ResultComponentServiceDelegateFactory();

    private MaintainResultDelegate maintainResultDelegate;

    private SearchResultDelegate searchResultDelegate;

    private ResolveResultDelegate resolveResultDelegate;

    private ReportResultDelegate reportResultDelegate;

    private ProduceResultDelegate produceResultDelegate;

    private JiraServiceDelegate jiraServiceDelegate;

    /** Constructs a new ResultComponentServiceDelegateFactory instance. */
    private ResultComponentServiceDelegateFactory() {
        super(ResultComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainResult.
     *
     * @return the MaintainResultDelegate.
     * @throws ClientException
     */
    public MaintainResultDelegate getMaintainResult() throws ClientException {
        try {
            if ((this.maintainResultDelegate == null)) {
                this.maintainResultDelegate = new MaintainResultDelegate(this.getComponent().getMaintainResult());
            }
            return this.maintainResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainResult", e);
        }
    }

    /**
     * Getter for the SearchResult.
     *
     * @return the SearchResultDelegate.
     * @throws ClientException
     */
    public SearchResultDelegate getSearchResult() throws ClientException {
        try {
            if ((this.searchResultDelegate == null)) {
                this.searchResultDelegate = new SearchResultDelegate(this.getComponent().getSearchResult());
            }
            return this.searchResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchResult", e);
        }
    }

    /**
     * Getter for the ResolveResult.
     *
     * @return the ResolveResultDelegate.
     * @throws ClientException
     */
    public ResolveResultDelegate getResolveResult() throws ClientException {
        try {
            if ((this.resolveResultDelegate == null)) {
                this.resolveResultDelegate = new ResolveResultDelegate(this.getComponent().getResolveResult());
            }
            return this.resolveResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ResolveResult", e);
        }
    }

    /**
     * Getter for the ReportResult.
     *
     * @return the ReportResultDelegate.
     * @throws ClientException
     */
    public ReportResultDelegate getReportResult() throws ClientException {
        try {
            if ((this.reportResultDelegate == null)) {
                this.reportResultDelegate = new ReportResultDelegate(this.getComponent().getReportResult());
            }
            return this.reportResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ReportResult", e);
        }
    }

    /**
     * Getter for the ProduceResult.
     *
     * @return the ProduceResultDelegate.
     * @throws ClientException
     */
    public ProduceResultDelegate getProduceResult() throws ClientException {
        try {
            if ((this.produceResultDelegate == null)) {
                this.produceResultDelegate = new ProduceResultDelegate(this.getComponent().getProduceResult());
            }
            return this.produceResultDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceResult", e);
        }
    }

    /**
     * Getter for the JiraService.
     *
     * @return the JiraServiceDelegate.
     * @throws ClientException
     */
    public JiraServiceDelegate getJiraService() throws ClientException {
        try {
            if ((this.jiraServiceDelegate == null)) {
                this.jiraServiceDelegate = new JiraServiceDelegate(this.getComponent().getJiraService());
            }
            return this.jiraServiceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: ResultComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: JiraService", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the ResultComponentServiceDelegateFactory.
     */
    public static ResultComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
