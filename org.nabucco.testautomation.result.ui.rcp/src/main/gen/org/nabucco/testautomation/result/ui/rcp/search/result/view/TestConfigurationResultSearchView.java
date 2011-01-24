/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.search.result.view;

import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.plugin.base.view.AbstractNabuccoSearchView;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.framework.plugin.base.view.NabuccoSearchView;
import org.nabucco.testautomation.result.ui.rcp.search.result.model.TestConfigurationResultSearchViewModel;

/**
 * TestConfigurationResultSearchView<p/>Search view for datatype TestConfigurationResult<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-10-12
 */
public class TestConfigurationResultSearchView extends
        AbstractNabuccoSearchView<TestConfigurationResultSearchViewModel> implements
        NabuccoSearchView {

    private TestConfigurationResultSearchViewModel model;

    public static final String ID = "org.nabucco.testautomation.result.ui.search.result.TestConfigurationResultSearchView";

    /** Constructs a new TestConfigurationResultSearchView instance. */
    public TestConfigurationResultSearchView() {
        super();
        model = new TestConfigurationResultSearchViewModel(this.getCorrespondingListView());
    }

    @Override
    public void createPartControl(final Composite parent,
            final NabuccoMessageManager aMessageManager) {
        this.getLayouter().layout(parent, aMessageManager, model);
    }

    @Override
    public TestConfigurationResultSearchViewModel getModel() {
        return model;
    }

    @Override
    public String getId() {
        return TestConfigurationResultSearchView.ID;
    }
}
