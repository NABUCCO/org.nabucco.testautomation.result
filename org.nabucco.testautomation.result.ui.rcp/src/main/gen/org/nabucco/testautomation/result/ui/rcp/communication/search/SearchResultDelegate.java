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
package org.nabucco.testautomation.result.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.property.facade.message.QuickSearchMsg;
import org.nabucco.testautomation.property.facade.message.QuickSearchRs;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.facade.service.search.SearchResult;

/**
 * SearchResultDelegate<p/>Result search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-15
 */
public class SearchResultDelegate extends ServiceDelegateSupport {

    private SearchResult service;

    /**
     * Constructs a new SearchResultDelegate instance.
     *
     * @param service the SearchResult.
     */
    public SearchResultDelegate(SearchResult service) {
        super();
        this.service = service;
    }

    /**
     * SearchTestConfigurationResult.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the TestConfigurationResultSearchMsg.
     * @return the TestConfigurationResultListMsg.
     * @throws ClientException
     */
    public TestConfigurationResultListMsg searchTestConfigurationResult(TestConfigurationResultSearchMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<TestConfigurationResultSearchMsg> request = new ServiceRequest<TestConfigurationResultSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<TestConfigurationResultListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchTestConfigurationResult(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchResult.class, "searchTestConfigurationResult", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchResult.searchTestConfigurationResult");
    }

    /**
     * QuickSearch.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the QuickSearchMsg.
     * @return the QuickSearchRs.
     * @throws ClientException
     */
    public QuickSearchRs quickSearch(QuickSearchMsg message, ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<QuickSearchMsg> request = new ServiceRequest<QuickSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<QuickSearchRs> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.quickSearch(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchResult.class, "quickSearch", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchResult.quickSearch");
    }
}
