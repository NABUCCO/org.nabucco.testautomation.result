/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Order;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.result.facade.datatype.TestResult;

/**
 * TestResultContainer<p/>Container holding a TestResult and its order position<p/>
 *
 * @version 1.0
 * @author sschmidt, PRODYNA AG, 2010-10-05
 */
public class TestResultContainer extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;u0,n;m0,1;" };

    public static final String RESULT = "result";

    public static final String ORDERINDEX = "orderIndex";

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(RESULT, PropertyDescriptorSupport.createDatatype(RESULT, TestResult.class, 3,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.AGGREGATION));
        propertyMap.put(ORDERINDEX,
                PropertyDescriptorSupport.createBasetype(ORDERINDEX, Order.class, 4, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(TestResultContainer.getPropertyDescriptor(RESULT), this.getResult(), null));
        properties.add(super.createProperty(TestResultContainer.getPropertyDescriptor(ORDERINDEX), this.orderIndex,
                null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(RESULT) && (property.getType() == TestResult.class))) {
            this.setResult(((TestResult) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ORDERINDEX) && (property.getType() == Order.class))) {
            this.setOrderIndex(((Order) property.getInstance()));
            return true;
        }
        return false;
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
            if ((orderIndex == null)) {
                return;
            }
            this.orderIndex = new Order();
        }
        this.orderIndex.setValue(orderIndex);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestResultContainer.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestResultContainer.class).getAllProperties();
    }
}
