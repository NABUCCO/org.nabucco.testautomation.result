/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.result.facade.message.TestResultMsg;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTestResult;

/**
 * ProduceTestResultDelegate<p/>TestResult produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class ProduceTestResultDelegate extends ServiceDelegateSupport {

    private ProduceTestResult service;

    /**
     * Constructs a new ProduceTestResultDelegate instance.
     *
     * @param service the ProduceTestResult.
     */
    public ProduceTestResultDelegate(ProduceTestResult service) {
        super();
        this.service = service;
    }

    /**
     * ProduceTestResult.
     *
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the TestResultMsg.
     * @throws ProduceException
     */
    public TestResultMsg produceTestResult(EmptyServiceMessage rq, NabuccoSession session)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<TestResultMsg> rs;
        if ((service != null)) {
            rs = service.produceTestResult(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTestResult.produceTestResult");
        }
        return rs.getResponseMessage();
    }
}
