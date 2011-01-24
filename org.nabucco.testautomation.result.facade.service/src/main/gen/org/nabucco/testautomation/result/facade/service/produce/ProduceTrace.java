/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.result.facade.message.TraceMsg;

/**
 * ProduceTrace<p/>ActionTrace produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-12-06
 */
public interface ProduceTrace extends Service {

    /**
     * Missing description at method produceActionTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceActionTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Missing description at method produceMessageTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceMessageTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Missing description at method produceScreenshotTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceScreenshotTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Missing description at method produceFileTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceFileTrace(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;
}