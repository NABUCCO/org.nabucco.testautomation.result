/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.list.result.view.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultListViewTestConfigurationResultNameLabelProvider
 *
 * @author Undefined
 */
public class TestConfigurationResultListViewTestConfigurationResultNameLabelProvider implements
        ILabelProvider {

    /** Constructs a new TestConfigurationResultListViewTestConfigurationResultNameLabelProvider instance. */
    public TestConfigurationResultListViewTestConfigurationResultNameLabelProvider() {
        super();
    }

    @Override
    public Image getImage(Object arg0) {
        return null;
    }

    @Override
    public String getText(Object arg0) {
        String result = "";
        if ((arg0 instanceof TestConfigurationResult)) {
            TestConfigurationResult testConfigurationResult = ((TestConfigurationResult) arg0);
            result = ((testConfigurationResult.getName() != null) ? testConfigurationResult
                    .getName().toString() : "");
        }
        return result;
    }

    @Override
    public void addListener(ILabelProviderListener arg0) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isLabelProperty(Object arg0, String arg1) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener arg0) {
    }
}
