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
import org.nabucco.testautomation.result.facade.message.TestResultMsg;
import org.nabucco.testautomation.result.facade.service.produce.ProduceTestResult;

/**
 * ProduceTestResultImpl<p/>TestResult produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class ProduceTestResultImpl extends ServiceSupport implements ProduceTestResult {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceTestResult";

    private ProduceTestResultServiceHandler produceTestResultServiceHandler;

    /** Constructs a new ProduceTestResultImpl instance. */
    public ProduceTestResultImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.produceTestResultServiceHandler = injector.inject(ProduceTestResultServiceHandler
                .getId());
        if ((this.produceTestResultServiceHandler != null)) {
            this.produceTestResultServiceHandler.setEntityManager(null);
            this.produceTestResultServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<TestResultMsg> produceTestResult(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceTestResultServiceHandler == null)) {
            super.getLogger()
                    .error("No service implementation configured for produceTestResult().");
            throw new InjectionException(
                    "No service implementation configured for produceTestResult().");
        }
        ServiceResponse<TestResultMsg> rs;
        this.produceTestResultServiceHandler.init();
        rs = this.produceTestResultServiceHandler.invoke(rq);
        this.produceTestResultServiceHandler.finish();
        return rs;
    }
}
