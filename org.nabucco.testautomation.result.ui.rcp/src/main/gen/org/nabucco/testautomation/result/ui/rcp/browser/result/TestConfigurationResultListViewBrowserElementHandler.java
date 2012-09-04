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
package org.nabucco.testautomation.result.ui.rcp.browser.result;

import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.testautomation.result.ui.rcp.list.result.model.TestConfigurationResultListViewModel;

/**
 * TestConfigurationResultListViewBrowserElementHandler
 *
 * @author Undefined
 */
public interface TestConfigurationResultListViewBrowserElementHandler extends CommandHandler {

    /**
     * CreateChildren.
     *
     * @param element the TestConfigurationResultListViewBrowserElement.
     * @param viewModel the TestConfigurationResultListViewModel.
     */
    void createChildren(final TestConfigurationResultListViewModel viewModel,
            final TestConfigurationResultListViewBrowserElement element);

    /**
     * RemoveChild.
     *
     * @param element the TestConfigurationResultListViewBrowserElement.
     * @param toBeRemoved the BrowserElement.
     */
    void removeChild(final BrowserElement toBeRemoved, final TestConfigurationResultListViewBrowserElement element);
}
