/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.facade.service.search.SearchTestConfigurationResult;

/**
 * SearchTestConfigurationResultDelegate<p/>TestConfiguration search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-15
 */
public class SearchTestConfigurationResultDelegate extends ServiceDelegateSupport {

    private SearchTestConfigurationResult service;

    /**
     * Constructs a new SearchTestConfigurationResultDelegate instance.
     *
     * @param service the SearchTestConfigurationResult.
     */
    public SearchTestConfigurationResultDelegate(SearchTestConfigurationResult service) {
        super();
        this.service = service;
    }

    /**
     * SearchTestConfigurationResult.
     *
     * @param rq the TestConfigurationResultSearchMsg.
     * @return the TestConfigurationResultListMsg.
     * @throws ClientException
     */
    public TestConfigurationResultListMsg searchTestConfigurationResult(
            TestConfigurationResultSearchMsg rq) throws ClientException {
        ServiceRequest<TestConfigurationResultSearchMsg> request = new ServiceRequest<TestConfigurationResultSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestConfigurationResultListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchTestConfigurationResult(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchTestConfigurationResultDelegate.class,
                                "Service: ",
                                "SearchTestConfigurationResult.searchTestConfigurationResult",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchTestConfigurationResult.searchTestConfigurationResult");
    }

    /**
     * Getter for the TestConfigurationResult.
     *
     * @param rq the TestConfigurationResultSearchMsg.
     * @return the TestConfigurationResultMsg.
     * @throws ClientException
     */
    public TestConfigurationResultMsg getTestConfigurationResult(TestConfigurationResultSearchMsg rq)
            throws ClientException {
        ServiceRequest<TestConfigurationResultSearchMsg> request = new ServiceRequest<TestConfigurationResultSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestConfigurationResultMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.getTestConfigurationResult(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchTestConfigurationResultDelegate.class,
                                "Service: ",
                                "SearchTestConfigurationResult.getTestConfigurationResult",
                                " Time: ", String.valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchTestConfigurationResult.getTestConfigurationResult");
    }
}
