/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.browser.result;

import java.util.List;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.framework.plugin.base.model.browser.BrowserListElement;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.list.result.model.TestConfigurationResultListViewModel;

/**
 * TestConfigurationResultListViewBrowserElement
 *
 * @author Undefined
 */
public class TestConfigurationResultListViewBrowserElement extends
        BrowserListElement<TestConfigurationResultListViewModel> implements
        NabuccoInjectionReciever {

    private TestConfigurationResultListViewBrowserElementHandler listViewBrowserElementHandler;

    /**
     * Constructs a new TestConfigurationResultListViewBrowserElement instance.
     *
     * @param datatypeList the List<TestConfigurationResult>.
     */
    public TestConfigurationResultListViewBrowserElement(
            final List<TestConfigurationResult> datatypeList) {
        this(datatypeList.toArray(new TestConfigurationResult[datatypeList.size()]));
    }

    /**
     * Constructs a new TestConfigurationResultListViewBrowserElement instance.
     *
     * @param datatypeArray the TestConfigurationResult[].
     */
    public TestConfigurationResultListViewBrowserElement(
            final TestConfigurationResult[] datatypeArray) {
        super();
        NabuccoInjector instance = NabuccoInjector
                .getInstance(TestConfigurationResultListViewBrowserElement.class);
        listViewBrowserElementHandler = instance
                .inject(TestConfigurationResultListViewBrowserElementHandler.class);
        viewModel = new TestConfigurationResultListViewModel();
        viewModel.setElements(datatypeArray);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        listViewBrowserElementHandler.createChildren(viewModel, this);
    }

    @Override
    public void removeBrowserElement(final BrowserElement element) {
        super.removeBrowserElement(element);
        listViewBrowserElementHandler.removeChild(element, this);
    }
}
