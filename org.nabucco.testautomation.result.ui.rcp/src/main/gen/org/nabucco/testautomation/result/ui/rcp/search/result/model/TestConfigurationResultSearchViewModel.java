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
package org.nabucco.testautomation.result.ui.rcp.search.result.model;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchViewModel;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultSearchViewModel<p/>Search view for datatype TestConfigurationResult<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-10-12
 */
public class TestConfigurationResultSearchViewModel extends NabuccoComponentSearchViewModel<TestConfigurationResult>
        implements NabuccoComponentSearchParameter {

    public static final String ID = "org.nabucco.testautomation.result.ui.search.result.TestConfigurationResultSearchViewModel";

    private TestConfigurationResult testConfigurationResult;

    public static final String PROPERTY_TESTCONFIGURATIONRESULT_NAME = "testConfigurationResultName";

    public static String TITLE = (ID + "Title");

    /**
     * Constructs a new TestConfigurationResultSearchViewModel instance.
     *
     * @param viewId the String.
     */
    public TestConfigurationResultSearchViewModel(String viewId) {
        super();
        correspondingListView = viewId;
        this.testConfigurationResult = new TestConfigurationResult();
    }

    @Override
    public String getSearchModelId() {
        return searchModelId;
    }

    @Override
    public NabuccoComponentSearchParameter getSearchParameter() {
        return this;
    }

    /**
     * Getter for the TestConfigurationResult.
     *
     * @return the TestConfigurationResult.
     */
    public TestConfigurationResult getTestConfigurationResult() {
        return this.testConfigurationResult;
    }

    /**
     * Setter for the TestConfigurationResultName.
     *
     * @param newName the String.
     */
    public void setTestConfigurationResultName(String newName) {
        if (((testConfigurationResult != null) && (testConfigurationResult.getName() == null))) {
            Name name = new Name();
            testConfigurationResult.setName(name);
        }
        String oldVal = testConfigurationResult.getName().getValue();
        testConfigurationResult.getName().setValue(newName);
        this.updateProperty(PROPERTY_TESTCONFIGURATIONRESULT_NAME, oldVal, newName);
        if (((!oldVal.equals(newName)) && testConfigurationResult.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            testConfigurationResult.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the TestConfigurationResultName.
     *
     * @return the String.
     */
    public String getTestConfigurationResultName() {
        if ((((testConfigurationResult == null) || (testConfigurationResult.getName() == null)) || (testConfigurationResult
                .getName().getValue() == null))) {
            return "";
        }
        return testConfigurationResult.getName().getValue();
    }

    @Override
    public String getId() {
        return TestConfigurationResultSearchViewModel.ID;
    }
}
