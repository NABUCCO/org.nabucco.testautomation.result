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
package org.nabucco.testautomation.result.ui.rcp.communication.maintain;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.service.maintain.MaintainResult;

/**
 * MaintainResultDelegate<p/>Result maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class MaintainResultDelegate extends ServiceDelegateSupport {

    private MaintainResult service;

    /**
     * Constructs a new MaintainResultDelegate instance.
     *
     * @param service the MaintainResult.
     */
    public MaintainResultDelegate(MaintainResult service) {
        super();
        this.service = service;
    }

    /**
     * MaintainTestConfigurationResult.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the TestConfigurationResultMsg.
     * @return the TestConfigurationResultMsg.
     * @throws ClientException
     */
    public TestConfigurationResultMsg maintainTestConfigurationResult(TestConfigurationResultMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<TestConfigurationResultMsg> request = new ServiceRequest<TestConfigurationResultMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<TestConfigurationResultMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainTestConfigurationResult(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainResult.class, "maintainTestConfigurationResult", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainResult.maintainTestConfigurationResult");
    }
}
