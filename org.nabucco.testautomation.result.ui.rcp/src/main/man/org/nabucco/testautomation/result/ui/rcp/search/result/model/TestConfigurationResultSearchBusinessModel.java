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
package org.nabucco.testautomation.result.ui.rcp.search.result.model;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchModel;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.ui.rcp.browser.result.TestConfigurationResultListViewBrowserElement;
import org.nabucco.testautomation.result.ui.rcp.communication.ResultComponentServiceDelegateFactory;
import org.nabucco.testautomation.result.ui.rcp.communication.search.SearchResultDelegate;

/**
 * Does the search for TestConfigurationResult.
 * 
 * @author Markus Jorroch, PRODYNA AG
 * 
 */
public class TestConfigurationResultSearchBusinessModel implements NabuccoComponentSearchModel {

    public static final String ID = "org.nabucco.testautomation.result.ui.rcp.search.result.model.TestConfigurationResultSearchBusinessModel";

    /**
     * {@inheritDoc}
     */
    @Override
    public TestConfigurationResultListViewBrowserElement search(NabuccoComponentSearchParameter searchViewModel) {
        TestConfigurationResultListViewBrowserElement result = null;
        if (searchViewModel instanceof TestConfigurationResultSearchViewModel) {
            TestConfigurationResultSearchViewModel testConfigurationResultSearchViewModel = (TestConfigurationResultSearchViewModel) searchViewModel;
            TestConfigurationResultSearchMsg rq = createTestConfigurationResultSearchMsg(testConfigurationResultSearchViewModel);
            List<TestConfigurationResult> searchResult = search(rq);
            if (searchResult != null) {
                result = new TestConfigurationResultListViewBrowserElement(
                        searchResult.toArray(new TestConfigurationResult[0]));
            }
        }
        return result;
    }

    private List<TestConfigurationResult> search(final TestConfigurationResultSearchMsg rq) {
        List<TestConfigurationResult> result = null;
        try {
            SearchResultDelegate searchDelegate = ResultComponentServiceDelegateFactory.getInstance().getSearchResult();
            TestConfigurationResultListMsg response = searchDelegate.searchTestConfigurationResult(rq);
            result = response.getTestConfigResultList();
        } catch (ClientException e) {
            Activator.getDefault().logError(e);
        }
        return result;
    }

    private TestConfigurationResultSearchMsg createTestConfigurationResultSearchMsg(
            TestConfigurationResultSearchViewModel searchViewModel) {
        TestConfigurationResultSearchMsg result = new TestConfigurationResultSearchMsg();
        result.setName(getNameFromModel(searchViewModel));
        return result;
    }

    private Name getNameFromModel(TestConfigurationResultSearchViewModel searchViewModel) {
        Name result = new Name();
        String name = searchViewModel.getTestConfigurationResultName();

        result.setValue((name == null || name.length() == 0) ? null : name);
        return result;
    }

}
