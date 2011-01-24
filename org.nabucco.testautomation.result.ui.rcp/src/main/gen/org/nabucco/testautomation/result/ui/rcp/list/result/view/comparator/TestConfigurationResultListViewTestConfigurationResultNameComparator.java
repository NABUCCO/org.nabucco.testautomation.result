/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.list.result.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultListViewTestConfigurationResultNameComparator
 *
 * @author Undefined
 */
public class TestConfigurationResultListViewTestConfigurationResultNameComparator extends
        NabuccoColumComparator<TestConfigurationResult> {

    /** Constructs a new TestConfigurationResultListViewTestConfigurationResultNameComparator instance. */
    public TestConfigurationResultListViewTestConfigurationResultNameComparator() {
        super();
    }

    @Override
    public int compareConcrete(TestConfigurationResult object1, TestConfigurationResult object2) {
        return this.compareBasetype(object1.getName(), object2.getName());
    }
}
