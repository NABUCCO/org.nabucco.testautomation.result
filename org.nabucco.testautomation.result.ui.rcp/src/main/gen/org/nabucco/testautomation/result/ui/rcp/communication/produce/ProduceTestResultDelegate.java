/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.communication.produce;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the EmptyServiceMessage.
     * @return the TestResultMsg.
     * @throws ClientException
     */
    public TestResultMsg produceTestResult(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TestResultMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceTestResult(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTestResultDelegate.class, "Service: ",
                                "ProduceTestResult.produceTestResult", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTestResult.produceTestResult");
    }
}
