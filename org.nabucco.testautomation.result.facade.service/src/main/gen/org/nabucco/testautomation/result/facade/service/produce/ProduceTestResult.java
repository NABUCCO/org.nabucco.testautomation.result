/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.result.facade.message.TestResultMsg;

/**
 * ProduceTestResult<p/>TestResult produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public interface ProduceTestResult extends Service {

    /**
     * Missing description at method produceTestResult.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TestResultMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TestResultMsg> produceTestResult(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;
}
