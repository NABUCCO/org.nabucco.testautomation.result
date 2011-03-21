/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.list.result.view;

import org.eclipse.jface.viewers.Viewer;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableFilter;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultListViewTableFilter<p/>ListView for Test Configuration Result<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-10-12
 */
public class TestConfigurationResultListViewTableFilter extends NabuccoTableFilter {

    /** Constructs a new TestConfigurationResultListViewTableFilter instance. */
    public TestConfigurationResultListViewTableFilter() {
        super();
    }

    @Override
    public boolean select(final Viewer viewer, final Object parentElement, final Object element) {
        boolean result = false;
        if (((null == searchFilter.getFilter()) || (0 == searchFilter.getFilter().length()))) {
            result = true;
        } else if ((element instanceof TestConfigurationResult)) {
            TestConfigurationResult datatype = ((TestConfigurationResult) element);
            result = (result || this.contains(datatype.getIdentificationKey(),
                    searchFilter.getFilter()));
            result = (result || this.contains(datatype.getName(), searchFilter.getFilter()));
            result = (result || this.contains(datatype.getOwner(), searchFilter.getFilter()));
        }
        return result;
    }
}
