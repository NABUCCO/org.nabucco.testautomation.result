/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.message.TestResultMsg;
import org.nabucco.testautomation.result.ui.rcp.communication.ResultComponentServiceDelegateFactory;
import org.nabucco.testautomation.result.ui.rcp.communication.produce.ProduceResultDelegate;


/**
 * ResultElementFactory
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class ResultElementFactory {


	static Datatype create(Class<?> className){
		Datatype result = null;
		ResultComponentServiceDelegateFactory resultComponentServiceDelegateFactory = ResultComponentServiceDelegateFactory.getInstance();
		try {
			ProduceResultDelegate produceTestResultDelegate = resultComponentServiceDelegateFactory.getProduceResult();

			TestResultMsg response = produceTestResultDelegate.produceTestResult(new EmptyServiceMessage());
			TestResult testResult = response.getTestResult();
			result = testResult;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return result;
	}


}


