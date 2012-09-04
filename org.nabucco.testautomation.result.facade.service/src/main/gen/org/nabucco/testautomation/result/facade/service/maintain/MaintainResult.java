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
package org.nabucco.testautomation.result.facade.service.maintain;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;

/**
 * MaintainResult<p/>Result maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public interface MaintainResult extends Service {

    /**
     * Missing description at method maintainTestConfigurationResult.
     *
     * @param rq the ServiceRequest<TestConfigurationResultMsg>.
     * @return the ServiceResponse<TestConfigurationResultMsg>.
     * @throws MaintainException
     */
    ServiceResponse<TestConfigurationResultMsg> maintainTestConfigurationResult(
            ServiceRequest<TestConfigurationResultMsg> rq) throws MaintainException;
}
