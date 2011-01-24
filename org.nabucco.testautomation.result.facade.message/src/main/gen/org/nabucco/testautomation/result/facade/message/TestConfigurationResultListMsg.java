/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultListMsg<p/>Message containing a list of TestConfigurationResults<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class TestConfigurationResultListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "testConfigResultList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<TestConfigurationResult> testConfigResultList;

    /** Constructs a new TestConfigurationResultListMsg instance. */
    public TestConfigurationResultListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<TestConfigurationResult>(PROPERTY_NAMES[0],
                TestConfigurationResult.class, PROPERTY_CONSTRAINTS[0], this.testConfigResultList));
        return properties;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final TestConfigurationResultListMsg other = ((TestConfigurationResultListMsg) obj);
        if ((this.testConfigResultList == null)) {
            if ((other.testConfigResultList != null))
                return false;
        } else if ((!this.testConfigResultList.equals(other.testConfigResultList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.testConfigResultList == null) ? 0
                : this.testConfigResultList.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestConfigurationResultListMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<testConfigResultList>" + this.testConfigResultList) + "</testConfigResultList>\n"));
        appendable.append("</TestConfigurationResultListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getTestConfigResultList.
     *
     * @return the List<TestConfigurationResult>.
     */
    public List<TestConfigurationResult> getTestConfigResultList() {
        if ((this.testConfigResultList == null)) {
            this.testConfigResultList = new ArrayList<TestConfigurationResult>();
        }
        return this.testConfigResultList;
    }
}
