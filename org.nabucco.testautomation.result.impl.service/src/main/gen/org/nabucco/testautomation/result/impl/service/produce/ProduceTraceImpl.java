/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.result.facade.message.TraceMsg;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTrace;

/**
 * ProduceTraceImpl<p/>ActionTrace produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-12-06
 */
public class ProduceTraceImpl extends ServiceSupport implements ProduceTrace {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceTrace";

    private ProduceActionTraceServiceHandler produceActionTraceServiceHandler;

    private ProduceMessageTraceServiceHandler produceMessageTraceServiceHandler;

    private ProduceScreenshotTraceServiceHandler produceScreenshotTraceServiceHandler;

    private ProduceFileTraceServiceHandler produceFileTraceServiceHandler;

    /** Constructs a new ProduceTraceImpl instance. */
    public ProduceTraceImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.produceActionTraceServiceHandler = injector.inject(ProduceActionTraceServiceHandler
                .getId());
        if ((this.produceActionTraceServiceHandler != null)) {
            this.produceActionTraceServiceHandler.setEntityManager(null);
            this.produceActionTraceServiceHandler.setLogger(super.getLogger());
        }
        this.produceMessageTraceServiceHandler = injector.inject(ProduceMessageTraceServiceHandler
                .getId());
        if ((this.produceMessageTraceServiceHandler != null)) {
            this.produceMessageTraceServiceHandler.setEntityManager(null);
            this.produceMessageTraceServiceHandler.setLogger(super.getLogger());
        }
        this.produceScreenshotTraceServiceHandler = injector
                .inject(ProduceScreenshotTraceServiceHandler.getId());
        if ((this.produceScreenshotTraceServiceHandler != null)) {
            this.produceScreenshotTraceServiceHandler.setEntityManager(null);
            this.produceScreenshotTraceServiceHandler.setLogger(super.getLogger());
        }
        this.produceFileTraceServiceHandler = injector.inject(ProduceFileTraceServiceHandler
                .getId());
        if ((this.produceFileTraceServiceHandler != null)) {
            this.produceFileTraceServiceHandler.setEntityManager(null);
            this.produceFileTraceServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<TraceMsg> produceActionTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceActionTraceServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceActionTrace().");
            throw new InjectionException(
                    "No service implementation configured for produceActionTrace().");
        }
        ServiceResponse<TraceMsg> rs;
        this.produceActionTraceServiceHandler.init();
        rs = this.produceActionTraceServiceHandler.invoke(rq);
        this.produceActionTraceServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TraceMsg> produceMessageTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceMessageTraceServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceMessageTrace().");
            throw new InjectionException(
                    "No service implementation configured for produceMessageTrace().");
        }
        ServiceResponse<TraceMsg> rs;
        this.produceMessageTraceServiceHandler.init();
        rs = this.produceMessageTraceServiceHandler.invoke(rq);
        this.produceMessageTraceServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TraceMsg> produceScreenshotTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceScreenshotTraceServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceScreenshotTrace().");
            throw new InjectionException(
                    "No service implementation configured for produceScreenshotTrace().");
        }
        ServiceResponse<TraceMsg> rs;
        this.produceScreenshotTraceServiceHandler.init();
        rs = this.produceScreenshotTraceServiceHandler.invoke(rq);
        this.produceScreenshotTraceServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TraceMsg> produceFileTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceFileTraceServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceFileTrace().");
            throw new InjectionException(
                    "No service implementation configured for produceFileTrace().");
        }
        ServiceResponse<TraceMsg> rs;
        this.produceFileTraceServiceHandler.init();
        rs = this.produceFileTraceServiceHandler.invoke(rq);
        this.produceFileTraceServiceHandler.finish();
        return rs;
    }
}
