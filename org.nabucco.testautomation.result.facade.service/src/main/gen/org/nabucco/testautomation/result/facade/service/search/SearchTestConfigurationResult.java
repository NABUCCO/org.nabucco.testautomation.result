/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.service.search;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;

/**
 * SearchTestConfigurationResult<p/>TestConfiguration search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-15
 */
public interface SearchTestConfigurationResult extends Service {

    /**
     * Missing description at method searchTestConfigurationResult.
     *
     * @param rq the ServiceRequest<TestConfigurationResultSearchMsg>.
     * @return the ServiceResponse<TestConfigurationResultListMsg>.
     * @throws SearchException
     */
    ServiceResponse<TestConfigurationResultListMsg> searchTestConfigurationResult(
            ServiceRequest<TestConfigurationResultSearchMsg> rq) throws SearchException;

    /**
     * Missing description at method getTestConfigurationResult.
     *
     * @param rq the ServiceRequest<TestConfigurationResultSearchMsg>.
     * @return the ServiceResponse<TestConfigurationResultMsg>.
     * @throws SearchException
     */
    ServiceResponse<TestConfigurationResultMsg> getTestConfigurationResult(
            ServiceRequest<TestConfigurationResultSearchMsg> rq) throws SearchException;
}
