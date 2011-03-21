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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model;

import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.logging.Loggable;
import org.nabucco.framework.plugin.base.model.BusinessModel;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.ui.rcp.communication.ResultComponentServiceDelegateFactory;
import org.nabucco.testautomation.result.ui.rcp.communication.maintain.MaintainTestConfigurationResultDelegate;
import org.nabucco.testautomation.result.ui.rcp.communication.search.SearchTestConfigurationResultDelegate;

/**
 * TestConfigurationResultEditViewBusinessModel
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestConfigurationResultEditViewBusinessModel implements BusinessModel, Loggable {

	public static String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultEditViewBusinessModel";

	@Override
	public String getID() {
		return ID;
	}

	public TestConfigurationResult readTestConfigurationResult(
			TestConfigurationResult testConfigurationResult) {
		ResultComponentServiceDelegateFactory resultComponentServiceDelegateFactory = ResultComponentServiceDelegateFactory
		.getInstance();
		try {
			SearchTestConfigurationResultDelegate searchTestConfigurationResult = resultComponentServiceDelegateFactory
			.getSearchTestConfigurationResult();

			TestConfigurationResultSearchMsg rq = new TestConfigurationResultSearchMsg();
			rq.setId(new Identifier(testConfigurationResult.getId()));

			TestConfigurationResultMsg response = searchTestConfigurationResult
			.getTestConfigurationResult(rq);
			return response.getTestConfigurationResult();
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return testConfigurationResult;
	}

	public TestConfigurationResult save(
			TestConfigurationResult testConfigurationResult)
			throws ClientException {

		ResultComponentServiceDelegateFactory resultComponentServiceDelegateFactory = ResultComponentServiceDelegateFactory
		.getInstance();
		MaintainTestConfigurationResultDelegate maintainTestConfigurationResult = resultComponentServiceDelegateFactory
		.getMaintainTestConfigurationResult();

		TestConfigurationResultMsg rq = new TestConfigurationResultMsg();
		rq.setTestConfigurationResult(testConfigurationResult);

		TestConfigurationResultMsg response = maintainTestConfigurationResult
		.maintainTestConfigurationResult(rq);
		return response.getTestConfigurationResult();
	}

	/**
	 * Deletes a TestConfigurationResult.
	 * 
	 * @param testConfigResult
	 *            the test configuration result to remove
	 * @throws ClientException
	 */
	public void delete(TestConfigurationResult testConfigResult)
			throws ClientException {
		ResultComponentServiceDelegateFactory resultComponent = ResultComponentServiceDelegateFactory
		.getInstance();

		MaintainTestConfigurationResultDelegate maintainDelegate = resultComponent
		.getMaintainTestConfigurationResult();

		TestConfigurationResultMsg rq = new TestConfigurationResultMsg();
		rq.setTestConfigurationResult(testConfigResult);

		maintainDelegate.maintainTestConfigurationResult(rq);
	}

}
