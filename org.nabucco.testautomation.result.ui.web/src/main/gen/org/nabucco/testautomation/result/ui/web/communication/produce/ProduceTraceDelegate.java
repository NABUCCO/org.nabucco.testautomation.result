/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
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
     * @throws ProduceException
     */
    public TraceMsg produceActionTrace(EmptyServiceMessage rq) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceActionTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceActionTrace");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceActionTrace.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    public TraceMsg produceActionTrace(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceActionTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceActionTrace");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceMessageTrace.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    public TraceMsg produceMessageTrace(EmptyServiceMessage rq) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceMessageTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceMessageTrace");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceMessageTrace.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    public TraceMsg produceMessageTrace(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceMessageTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceMessageTrace");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceScreenshotTrace.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    public TraceMsg produceScreenshotTrace(EmptyServiceMessage rq) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceScreenshotTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceScreenshotTrace");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceScreenshotTrace.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    public TraceMsg produceScreenshotTrace(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceScreenshotTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceScreenshotTrace");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceFileTrace.
     *
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    public TraceMsg produceFileTrace(EmptyServiceMessage rq) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceFileTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceFileTrace");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceFileTrace.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    public TraceMsg produceFileTrace(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<TraceMsg> rs;
        if ((service != null)) {
            rs = service.produceFileTrace(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceTrace.produceFileTrace");
        }
        return rs.getResponseMessage();
    }
}
