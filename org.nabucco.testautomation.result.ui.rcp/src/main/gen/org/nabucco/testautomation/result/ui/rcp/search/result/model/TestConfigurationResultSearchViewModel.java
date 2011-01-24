/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
public class TestConfigurationResultSearchViewModel extends
        NabuccoComponentSearchViewModel<TestConfigurationResult> implements
        NabuccoComponentSearchParameter {

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
        if (((!oldVal.equals(newName)) && testConfigurationResult.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
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
