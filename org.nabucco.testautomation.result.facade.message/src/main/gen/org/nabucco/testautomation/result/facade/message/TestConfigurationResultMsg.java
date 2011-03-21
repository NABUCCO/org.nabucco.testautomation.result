/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
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

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    public static final String TESTCONFIGURATIONRESULT = "testConfigurationResult";

    private TestConfigurationResult testConfigurationResult;

    /** Constructs a new TestConfigurationResultMsg instance. */
    public TestConfigurationResultMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(TESTCONFIGURATIONRESULT, PropertyDescriptorSupport.createDatatype(
                TESTCONFIGURATIONRESULT, TestConfigurationResult.class, 0, PROPERTY_CONSTRAINTS[0],
                false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                TestConfigurationResultMsg.getPropertyDescriptor(TESTCONFIGURATIONRESULT),
                this.testConfigurationResult));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(TESTCONFIGURATIONRESULT) && (property.getType() == TestConfigurationResult.class))) {
            this.setTestConfigurationResult(((TestConfigurationResult) property.getInstance()));
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestConfigurationResultMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestConfigurationResultMsg.class)
                .getAllProperties();
    }
}
