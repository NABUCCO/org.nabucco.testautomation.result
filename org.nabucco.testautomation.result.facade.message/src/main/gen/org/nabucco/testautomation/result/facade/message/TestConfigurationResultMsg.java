/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;

/**
 * TestConfigurationResultMsg<p/>Message for persisting a TestConfigurationResult<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class TestConfigurationResultMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "testConfigurationResult" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private TestConfigurationResult testConfigurationResult;

    /** Constructs a new TestConfigurationResultMsg instance. */
    public TestConfigurationResultMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<TestConfigurationResult>(PROPERTY_NAMES[0],
                TestConfigurationResult.class, PROPERTY_CONSTRAINTS[0],
                this.testConfigurationResult));
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
        final TestConfigurationResultMsg other = ((TestConfigurationResultMsg) obj);
        if ((this.testConfigurationResult == null)) {
            if ((other.testConfigurationResult != null))
                return false;
        } else if ((!this.testConfigurationResult.equals(other.testConfigurationResult)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.testConfigurationResult == null) ? 0
                : this.testConfigurationResult.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestConfigurationResultMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<testConfigurationResult>" + this.testConfigurationResult) + "</testConfigurationResult>\n"));
        appendable.append("</TestConfigurationResultMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getTestConfigurationResult.
     *
     * @return the TestConfigurationResult.
     */
    public TestConfigurationResult getTestConfigurationResult() {
        return this.testConfigurationResult;
    }

    /**
     * Missing description at method setTestConfigurationResult.
     *
     * @param testConfigurationResult the TestConfigurationResult.
     */
    public void setTestConfigurationResult(TestConfigurationResult testConfigurationResult) {
        this.testConfigurationResult = testConfigurationResult;
    }
}
