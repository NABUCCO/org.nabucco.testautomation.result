/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.result.facade.datatype.TestResult;

/**
 * TestResultMsg<p/>Message for producing a TestResult<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class TestResultMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "testResult" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private TestResult testResult;

    /** Constructs a new TestResultMsg instance. */
    public TestResultMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<TestResult>(PROPERTY_NAMES[0], TestResult.class,
                PROPERTY_CONSTRAINTS[0], this.testResult));
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
        final TestResultMsg other = ((TestResultMsg) obj);
        if ((this.testResult == null)) {
            if ((other.testResult != null))
                return false;
        } else if ((!this.testResult.equals(other.testResult)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.testResult == null) ? 0 : this.testResult.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestResultMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<testResult>" + this.testResult) + "</testResult>\n"));
        appendable.append("</TestResultMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getTestResult.
     *
     * @return the TestResult.
     */
    public TestResult getTestResult() {
        return this.testResult;
    }

    /**
     * Missing description at method setTestResult.
     *
     * @param testResult the TestResult.
     */
    public void setTestResult(TestResult testResult) {
        this.testResult = testResult;
    }
}
