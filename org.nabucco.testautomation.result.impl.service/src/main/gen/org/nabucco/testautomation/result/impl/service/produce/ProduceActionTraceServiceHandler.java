/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.produce;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.result.facade.message.TraceMsg;

/**
 * ProduceActionTraceServiceHandler<p/>ActionTrace produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-12-06
 */
public abstract class ProduceActionTraceServiceHandler extends ServiceHandlerSupport implements
        ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.result.impl.service.produce.ProduceActionTraceServiceHandler";

    /** Constructs a new ProduceActionTraceServiceHandler instance. */
    public ProduceActionTraceServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<TraceMsg> invoke(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        ServiceResponse<TraceMsg> rs;
        TraceMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceActionTrace(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<TraceMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ProduceException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ProduceException wrappedException = new ProduceException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ProduceException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method produceActionTrace.
     *
     * @param msg the EmptyServiceMessage.
     * @return the TraceMsg.
     * @throws ProduceException
     */
    protected abstract TraceMsg produceActionTrace(EmptyServiceMessage msg) throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
