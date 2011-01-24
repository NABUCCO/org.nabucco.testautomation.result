/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.result.ui.rcp.edit.reporting.model;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.model.BusinessModel;

import org.nabucco.testautomation.facade.datatype.engine.TestEngineConfiguration;
import org.nabucco.testautomation.facade.message.TestEngineConfigurationMsg;
import org.nabucco.testautomation.ui.rcp.communication.TestautomationComponentServiceDelegateFactory;
import org.nabucco.testautomation.ui.rcp.communication.maintain.MaintainTestEngineConfigurationDelegate;

/**
 * TestEngineConfigurationEditBusinessModel
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ReportingEditBusinessModel implements BusinessModel {

	public static String ID = "org.nabucco.testautomation.ui.rcp.edit.engine.model.TestEngineConfigurationEditBusinessModel";

	public TestEngineConfigurationMsg save(final TestEngineConfiguration config) throws ClientException {

		MaintainTestEngineConfigurationDelegate maintainDelegate;

		maintainDelegate = TestautomationComponentServiceDelegateFactory.getInstance()
		.getMaintainTestEngineConfiguration();

		TestEngineConfigurationMsg msg = new TestEngineConfigurationMsg();
		msg.setTestEngineConfiguration(config);
		return maintainDelegate.maintainTestEngineConfiguration(msg);
	}


}
