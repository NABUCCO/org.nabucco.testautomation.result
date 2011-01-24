/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Order;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.result.facade.datatype.TestResult;

/**
 * TestResultContainer<p/>Container holding a TestResult and its order position<p/>
 *
 * @version 1.0
 * @author sschmidt, PRODYNA AG, 2010-10-05
 */
public class TestResultContainer extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "result", "orderIndex" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;m0,1;" };

    private TestResult result;

    private Order orderIndex;

    /** Constructs a new TestResultContainer instance. */
    public TestResultContainer() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the TestResultContainer.
     */
    protected void cloneObject(TestResultContainer clone) {
        super.cloneObject(clone);
        if ((this.getResult() != null)) {
            clone.setResult(this.getResult().cloneObject());
        }
        if ((this.getOrderIndex() != null)) {
            clone.setOrderIndex(this.getOrderIndex().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<TestResult>(PROPERTY_NAMES[0], TestResult.class,
                PROPERTY_CONSTRAINTS[0], this.result));
        properties.add(new BasetypeProperty<Order>(PROPERTY_NAMES[1], Order.class,
                PROPERTY_CONSTRAINTS[1], this.orderIndex));
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
        final TestResultContainer other = ((TestResultContainer) obj);
        if ((this.result == null)) {
            if ((other.result != null))
                return false;
        } else if ((!this.result.equals(other.result)))
            return false;
        if ((this.orderIndex == null)) {
            if ((other.orderIndex != null))
                return false;
        } else if ((!this.orderIndex.equals(other.orderIndex)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.result == null) ? 0 : this.result.hashCode()));
        result = ((PRIME * result) + ((this.orderIndex == null) ? 0 : this.orderIndex.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestResultContainer>\n");
        appendable.append(super.toString());
        appendable.append((("<result>" + this.result) + "</result>\n"));
        appendable.append((("<orderIndex>" + this.orderIndex) + "</orderIndex>\n"));
        appendable.append("</TestResultContainer>\n");
        return appendable.toString();
    }

    @Override
    public TestResultContainer cloneObject() {
        TestResultContainer clone = new TestResultContainer();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setResult.
     *
     * @param result the TestResult.
     */
    public void setResult(TestResult result) {
        this.result = result;
    }

    /**
     * Missing description at method getResult.
     *
     * @return the TestResult.
     */
    public TestResult getResult() {
        return this.result;
    }

    /**
     * Missing description at method getOrderIndex.
     *
     * @return the Order.
     */
    public Order getOrderIndex() {
        return this.orderIndex;
    }

    /**
     * Missing description at method setOrderIndex.
     *
     * @param orderIndex the Order.
     */
    public void setOrderIndex(Order orderIndex) {
        this.orderIndex = orderIndex;
    }

    /**
     * Missing description at method setOrderIndex.
     *
     * @param orderIndex the Integer.
     */
    public void setOrderIndex(Integer orderIndex) {
        if ((this.orderIndex == null)) {
            this.orderIndex = new Order();
        }
        this.orderIndex.setValue(orderIndex);
    }
}
