/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.service.maintain;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;

/**
 * MaintainTestConfigurationResult<p/>TestConfigurationResult maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public interface MaintainTestConfigurationResult extends Service {

    /**
     * Missing description at method maintainTestConfigurationResult.
     *
     * @param rq the ServiceRequest<TestConfigurationResultMsg>.
     * @return the ServiceResponse<TestConfigurationResultMsg>.
     * @throws MaintainException
     */
    ServiceResponse<TestConfigurationResultMsg> maintainTestConfigurationResult(
            ServiceRequest<TestConfigurationResultMsg> rq) throws MaintainException;
}
