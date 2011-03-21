/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.web.communication.search;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
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
     * @param session the NabuccoSession.
     * @param rq the TestConfigurationResultSearchMsg.
     * @return the TestConfigurationResultListMsg.
     * @throws SearchException
     */
    public TestConfigurationResultListMsg searchTestConfigurationResult(
            TestConfigurationResultSearchMsg rq, NabuccoSession session) throws SearchException {
        ServiceRequest<TestConfigurationResultSearchMsg> request = new ServiceRequest<TestConfigurationResultSearchMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestConfigurationResultListMsg> rs;
        if ((service != null)) {
            rs = service.searchTestConfigurationResult(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestConfigurationResult.searchTestConfigurationResult");
        }
        return rs.getResponseMessage();
    }

    /**
     * Getter for the TestConfigurationResult.
     *
     * @param session the NabuccoSession.
     * @param rq the TestConfigurationResultSearchMsg.
     * @return the TestConfigurationResultMsg.
     * @throws SearchException
     */
    public TestConfigurationResultMsg getTestConfigurationResult(
            TestConfigurationResultSearchMsg rq, NabuccoSession session) throws SearchException {
        ServiceRequest<TestConfigurationResultSearchMsg> request = new ServiceRequest<TestConfigurationResultSearchMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestConfigurationResultMsg> rs;
        if ((service != null)) {
            rs = service.getTestConfigurationResult(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchTestConfigurationResult.getTestConfigurationResult");
        }
        return rs.getResponseMessage();
    }
}
