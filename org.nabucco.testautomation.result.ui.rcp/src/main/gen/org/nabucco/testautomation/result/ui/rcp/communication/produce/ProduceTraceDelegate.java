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
import org.nabucco.testautomation.result.facade.message.TraceMsg;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTrace;

/**
 * ProduceTraceDelegate<p/>ActionTrace produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-12-06
 */
public class ProduceTraceDelegate extends ServiceDelegateSupport {

    private ProduceTrace service;

    /**
     * Constructs a new ProduceTraceDelegate instance.
     *
     * @param service the ProduceTrace.
     */
    public ProduceTraceDelegate(ProduceTrace service) {
        super();
        this.service = service;
    }

    /**
     * ProduceActionTrace.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ClientException
     */
    public TraceMsg produceActionTrace(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceActionTrace(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTraceDelegate.class, "Service: ",
                                "ProduceTrace.produceActionTrace", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTrace.produceActionTrace");
    }

    /**
     * ProduceMessageTrace.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ClientException
     */
    public TraceMsg produceMessageTrace(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceMessageTrace(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTraceDelegate.class, "Service: ",
                                "ProduceTrace.produceMessageTrace", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTrace.produceMessageTrace");
    }

    /**
     * ProduceScreenshotTrace.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ClientException
     */
    public TraceMsg produceScreenshotTrace(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceScreenshotTrace(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTraceDelegate.class, "Service: ",
                                "ProduceTrace.produceScreenshotTrace", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceTrace.produceScreenshotTrace");
    }

    /**
     * ProduceFileTrace.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ClientException
     */
    public TraceMsg produceFileTrace(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceFileTrace(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceTraceDelegate.class, "Service: ",
                                "ProduceTrace.produceFileTrace", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceTrace.produceFileTrace");
    }
}
