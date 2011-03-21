/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.list.result.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultListViewTestConfigurationResultKeyComparator
 *
 * @author Undefined
 */
public class TestConfigurationResultListViewTestConfigurationResultKeyComparator extends
        NabuccoColumComparator<TestConfigurationResult> {

    /** Constructs a new TestConfigurationResultListViewTestConfigurationResultKeyComparator instance. */
    public TestConfigurationResultListViewTestConfigurationResultKeyComparator() {
        super();
    }

    @Override
    public int compareConcrete(TestConfigurationResult object1, TestConfigurationResult object2) {
        return this.compareBasetype(object1.getIdentificationKey(), object2.getIdentificationKey());
    }
}
