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
package org.nabucco.testautomation.result.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.result.facade.message.TestResultMsg;
import org.nabucco.testautomation.result.facade.message.TraceMsg;

/**
 * ProduceResult<p/>Result produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public interface ProduceResult extends Service {

    /**
     * Missing description at method produceTestResult.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TestResultMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TestResultMsg> produceTestResult(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceActionTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceActionTrace(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceMessageTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceMessageTrace(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceScreenshotTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceScreenshotTrace(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceFileTrace.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<TraceMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TraceMsg> produceFileTrace(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;
}
