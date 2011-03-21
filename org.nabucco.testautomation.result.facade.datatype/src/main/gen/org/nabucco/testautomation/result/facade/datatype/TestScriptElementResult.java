/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.result.facade.datatype.status.TestScriptElementStatusType;

/**
 * TestScriptElementResult<p/>The result of a TestScriptElement<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public class TestScriptElementResult extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;m1,1;" };

    public static final String ELEMENTSTATUS = "elementStatus";

    public static final String ELEMENTID = "elementId";

    private TestScriptElementStatusType elementStatus;

    private Identifier elementId;

    /** Constructs a new TestScriptElementResult instance. */
    public TestScriptElementResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        elementStatus = TestScriptElementStatusType.NOT_EXECUTED;
    }

    /**
     * CloneObject.
     *
     * @param clone the TestScriptElementResult.
     */
    protected void cloneObject(TestScriptElementResult clone) {
        super.cloneObject(clone);
        clone.setElementStatus(this.getElementStatus());
        if ((this.getElementId() != null)) {
            clone.setElementId(this.getElementId().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class)
                .getPropertyMap());
        propertyMap.put(ELEMENTSTATUS, PropertyDescriptorSupport.createEnumeration(ELEMENTSTATUS,
                TestScriptElementStatusType.class, 2, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ELEMENTID, PropertyDescriptorSupport.createBasetype(ELEMENTID,
                Identifier.class, 3, PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                TestScriptElementResult.getPropertyDescriptor(ELEMENTSTATUS), this.elementStatus,
                null));
        properties.add(super.createProperty(
                TestScriptElementResult.getPropertyDescriptor(ELEMENTID), this.elementId, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(ELEMENTSTATUS) && (property.getType() == TestScriptElementStatusType.class))) {
            this.setElementStatus(((TestScriptElementStatusType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ELEMENTID) && (property.getType() == Identifier.class))) {
            this.setElementId(((Identifier) property.getInstance()));
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
        final TestScriptElementResult other = ((TestScriptElementResult) obj);
        if ((this.elementStatus == null)) {
            if ((other.elementStatus != null))
                return false;
        } else if ((!this.elementStatus.equals(other.elementStatus)))
            return false;
        if ((this.elementId == null)) {
            if ((other.elementId != null))
                return false;
        } else if ((!this.elementId.equals(other.elementId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.elementStatus == null) ? 0 : this.elementStatus
                .hashCode()));
        result = ((PRIME * result) + ((this.elementId == null) ? 0 : this.elementId.hashCode()));
        return result;
    }

    @Override
    public TestScriptElementResult cloneObject() {
        TestScriptElementResult clone = new TestScriptElementResult();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getElementStatus.
     *
     * @return the TestScriptElementStatusType.
     */
    public TestScriptElementStatusType getElementStatus() {
        return this.elementStatus;
    }

    /**
     * Missing description at method setElementStatus.
     *
     * @param elementStatus the TestScriptElementStatusType.
     */
    public void setElementStatus(TestScriptElementStatusType elementStatus) {
        this.elementStatus = elementStatus;
    }

    /**
     * Missing description at method setElementStatus.
     *
     * @param elementStatus the String.
     */
    public void setElementStatus(String elementStatus) {
        if ((elementStatus == null)) {
            this.elementStatus = null;
        } else {
            this.elementStatus = TestScriptElementStatusType.valueOf(elementStatus);
        }
    }

    /**
     * Missing description at method getElementId.
     *
     * @return the Identifier.
     */
    public Identifier getElementId() {
        return this.elementId;
    }

    /**
     * Missing description at method setElementId.
     *
     * @param elementId the Identifier.
     */
    public void setElementId(Identifier elementId) {
        this.elementId = elementId;
    }

    /**
     * Missing description at method setElementId.
     *
     * @param elementId the Long.
     */
    public void setElementId(Long elementId) {
        if ((this.elementId == null)) {
            if ((elementId == null)) {
                return;
            }
            this.elementId = new Identifier();
        }
        this.elementId.setValue(elementId);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestScriptElementResult.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestScriptElementResult.class)
                .getAllProperties();
    }
}
