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
package org.nabucco.testautomation.result.ui.rcp.browser.result;

import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.browser.result.TestConfigurationResultEditViewBrowserElement;
import org.nabucco.testautomation.result.ui.rcp.browser.result.TestConfigurationResultListViewBrowserElement;
import org.nabucco.testautomation.result.ui.rcp.browser.result.TestConfigurationResultListViewBrowserElementHandler;
import org.nabucco.testautomation.result.ui.rcp.list.result.model.TestConfigurationResultListViewModel;


public class TestConfigurationResultListViewBrowserElementHandlerImpl implements
TestConfigurationResultListViewBrowserElementHandler {

	@Override
	public void createChildren(TestConfigurationResultListViewModel viewModel,
			TestConfigurationResultListViewBrowserElement element) {
		TestConfigurationResult[] elements = viewModel.getElements();
		for (TestConfigurationResult testConfigurationResult : elements) {
			element.addBrowserElement(new TestConfigurationResultEditViewBrowserElement(testConfigurationResult));
		}
	}

	@Override
	public void removeChild(BrowserElement toBeRemoved,
			TestConfigurationResultListViewBrowserElement element) {
		// do nothing
	}

	
}
