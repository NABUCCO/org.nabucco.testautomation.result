/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
    void removeChild(final BrowserElement toBeRemoved,
            final TestConfigurationResultListViewBrowserElement element);
}
