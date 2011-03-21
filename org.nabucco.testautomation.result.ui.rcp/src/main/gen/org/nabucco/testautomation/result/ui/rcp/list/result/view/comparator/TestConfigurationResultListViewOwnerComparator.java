/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.list.result.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultListViewOwnerComparator
 *
 * @author Undefined
 */
public class TestConfigurationResultListViewOwnerComparator extends
        NabuccoColumComparator<TestConfigurationResult> {

    /** Constructs a new TestConfigurationResultListViewOwnerComparator instance. */
    public TestConfigurationResultListViewOwnerComparator() {
        super();
    }

    @Override
    public int compareConcrete(TestConfigurationResult object1, TestConfigurationResult object2) {
        return this.compareBasetype(object1.getOwner(), object2.getOwner());
    }
}
