/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.impl.service.produce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.testautomation.result.facade.message.TestResultMsg;
import org.nabucco.testautomation.result.facade.message.TraceMsg;
import org.nabucco.testautomation.result.facade.service.produce.ProduceResult;

/**
 * ProduceResultImpl<p/>Result produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class ProduceResultImpl extends ServiceSupport implements ProduceResult {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceResult";

    private static Map<String, String[]> ASPECTS;

    private ProduceTestResultServiceHandler produceTestResultServiceHandler;

    private ProduceActionTraceServiceHandler produceActionTraceServiceHandler;

    private ProduceMessageTraceServiceHandler produceMessageTraceServiceHandler;

    private ProduceScreenshotTraceServiceHandler produceScreenshotTraceServiceHandler;

    private ProduceFileTraceServiceHandler produceFileTraceServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProduceResultImpl instance. */
    public ProduceResultImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceTestResultServiceHandler = injector.inject(ProduceTestResultServiceHandler.getId());
        if ((this.produceTestResultServiceHandler != null)) {
            this.produceTestResultServiceHandler.setPersistenceManager(persistenceManager);
            this.produceTestResultServiceHandler.setLogger(super.getLogger());
        }
        this.produceActionTraceServiceHandler = injector.inject(ProduceActionTraceServiceHandler.getId());
        if ((this.produceActionTraceServiceHandler != null)) {
            this.produceActionTraceServiceHandler.setPersistenceManager(persistenceManager);
            this.produceActionTraceServiceHandler.setLogger(super.getLogger());
        }
        this.produceMessageTraceServiceHandler = injector.inject(ProduceMessageTraceServiceHandler.getId());
        if ((this.produceMessageTraceServiceHandler != null)) {
            this.produceMessageTraceServiceHandler.setPersistenceManager(persistenceManager);
            this.produceMessageTraceServiceHandler.setLogger(super.getLogger());
        }
        this.produceScreenshotTraceServiceHandler = injector.inject(ProduceScreenshotTraceServiceHandler.getId());
        if ((this.produceScreenshotTraceServiceHandler != null)) {
            this.produceScreenshotTraceServiceHandler.setPersistenceManager(persistenceManager);
            this.produceScreenshotTraceServiceHandler.setLogger(super.getLogger());
        }
        this.produceFileTraceServiceHandler = injector.inject(ProduceFileTraceServiceHandler.getId());
        if ((this.produceFileTraceServiceHandler != null)) {
            this.produceFileTraceServiceHandler.setPersistenceManager(persistenceManager);
            this.produceFileTraceServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("produceTestResult", NO_ASPECTS);
            ASPECTS.put("produceActionTrace", NO_ASPECTS);
            ASPECTS.put("produceMessageTrace", NO_ASPECTS);
            ASPECTS.put("produceScreenshotTrace", NO_ASPECTS);
            ASPECTS.put("produceFileTrace", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<TestResultMsg> produceTestResult(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceTestResultServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceTestResult().");
            throw new InjectionException("No service implementation configured for produceTestResult().");
        }
        ServiceResponse<TestResultMsg> rs;
        this.produceTestResultServiceHandler.init();
        rs = this.produceTestResultServiceHandler.invoke(rq);
        this.produceTestResultServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TraceMsg> produceActionTrace(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceActionTraceServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceActionTrace().");
            throw new InjectionException("No service implementation configured for produceActionTrace().");
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
            super.getLogger().error("No service implementation configured for produceMessageTrace().");
            throw new InjectionException("No service implementation configured for produceMessageTrace().");
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
            super.getLogger().error("No service implementation configured for produceScreenshotTrace().");
            throw new InjectionException("No service implementation configured for produceScreenshotTrace().");
        }
        ServiceResponse<TraceMsg> rs;
        this.produceScreenshotTraceServiceHandler.init();
        rs = this.produceScreenshotTraceServiceHandler.invoke(rq);
        this.produceScreenshotTraceServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<TraceMsg> produceFileTrace(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceFileTraceServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceFileTrace().");
            throw new InjectionException("No service implementation configured for produceFileTrace().");
        }
        ServiceResponse<TraceMsg> rs;
        this.produceFileTraceServiceHandler.init();
        rs = this.produceFileTraceServiceHandler.invoke(rq);
        this.produceFileTraceServiceHandler.finish();
        return rs;
    }
}
