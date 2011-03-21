/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.DateTime;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * TestConfigurationResultSearchMsg<p/>Message for searching TestConfigurationResults<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-10-05
 */
public class TestConfigurationResultSearchMsg extends ServiceMessageSupport implements
        ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l3,12;m0,1;", "l0,n;m0,1;",
            "l0,255;m0,1;", "l0,255;m0,1;", "l0,n;m0,1;", "l0,n;m0,1;" };

    public static final String OWNER = "owner";

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String TESTCONFIGURATIONNAME = "testConfigurationName";

    public static final String TESTCONFIGURATIONID = "testConfigurationId";

    public static final String STARTTIME = "startTime";

    private Owner owner;

    private Identifier id;

    private Name name;

    private Name testConfigurationName;

    private Identifier testConfigurationId;

    private DateTime startTime;

    /** Constructs a new TestConfigurationResultSearchMsg instance. */
    public TestConfigurationResultSearchMsg() {
        super();
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(OWNER, PropertyDescriptorSupport.createBasetype(OWNER, Owner.class, 0,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ID, PropertyDescriptorSupport.createBasetype(ID, Identifier.class, 1,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 2,
                PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(TESTCONFIGURATIONNAME, PropertyDescriptorSupport.createBasetype(
                TESTCONFIGURATIONNAME, Name.class, 3, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(TESTCONFIGURATIONID, PropertyDescriptorSupport.createBasetype(
                TESTCONFIGURATIONID, Identifier.class, 4, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(STARTTIME, PropertyDescriptorSupport.createBasetype(STARTTIME,
                DateTime.class, 5, PROPERTY_CONSTRAINTS[5], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(
                TestConfigurationResultSearchMsg.getPropertyDescriptor(OWNER), this.owner));
        properties.add(super.createProperty(
                TestConfigurationResultSearchMsg.getPropertyDescriptor(ID), this.id));
        properties.add(super.createProperty(
                TestConfigurationResultSearchMsg.getPropertyDescriptor(NAME), this.name));
        properties.add(super.createProperty(
                TestConfigurationResultSearchMsg.getPropertyDescriptor(TESTCONFIGURATIONNAME),
                this.testConfigurationName));
        properties.add(super.createProperty(
                TestConfigurationResultSearchMsg.getPropertyDescriptor(TESTCONFIGURATIONID),
                this.testConfigurationId));
        properties.add(super.createProperty(
                TestConfigurationResultSearchMsg.getPropertyDescriptor(STARTTIME), this.startTime));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(OWNER) && (property.getType() == Owner.class))) {
            this.setOwner(((Owner) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ID) && (property.getType() == Identifier.class))) {
            this.setId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTCONFIGURATIONNAME) && (property.getType() == Name.class))) {
            this.setTestConfigurationName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TESTCONFIGURATIONID) && (property.getType() == Identifier.class))) {
            this.setTestConfigurationId(((Identifier) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STARTTIME) && (property.getType() == DateTime.class))) {
            this.setStartTime(((DateTime) property.getInstance()));
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
        final TestConfigurationResultSearchMsg other = ((TestConfigurationResultSearchMsg) obj);
        if ((this.owner == null)) {
            if ((other.owner != null))
                return false;
        } else if ((!this.owner.equals(other.owner)))
            return false;
        if ((this.id == null)) {
            if ((other.id != null))
                return false;
        } else if ((!this.id.equals(other.id)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.testConfigurationName == null)) {
            if ((other.testConfigurationName != null))
                return false;
        } else if ((!this.testConfigurationName.equals(other.testConfigurationName)))
            return false;
        if ((this.testConfigurationId == null)) {
            if ((other.testConfigurationId != null))
                return false;
        } else if ((!this.testConfigurationId.equals(other.testConfigurationId)))
            return false;
        if ((this.startTime == null)) {
            if ((other.startTime != null))
                return false;
        } else if ((!this.startTime.equals(other.startTime)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.owner == null) ? 0 : this.owner.hashCode()));
        result = ((PRIME * result) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.testConfigurationName == null) ? 0
                : this.testConfigurationName.hashCode()));
        result = ((PRIME * result) + ((this.testConfigurationId == null) ? 0
                : this.testConfigurationId.hashCode()));
        result = ((PRIME * result) + ((this.startTime == null) ? 0 : this.startTime.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getOwner.
     *
     * @return the Owner.
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * Missing description at method setOwner.
     *
     * @param owner the Owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Missing description at method getId.
     *
     * @return the Identifier.
     */
    public Identifier getId() {
        return this.id;
    }

    /**
     * Missing description at method setId.
     *
     * @param id the Identifier.
     */
    public void setId(Identifier id) {
        this.id = id;
    }

    /**
     * Missing description at method getName.
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Missing description at method setName.
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Missing description at method getTestConfigurationName.
     *
     * @return the Name.
     */
    public Name getTestConfigurationName() {
        return this.testConfigurationName;
    }

    /**
     * Missing description at method setTestConfigurationName.
     *
     * @param testConfigurationName the Name.
     */
    public void setTestConfigurationName(Name testConfigurationName) {
        this.testConfigurationName = testConfigurationName;
    }

    /**
     * Missing description at method getTestConfigurationId.
     *
     * @return the Identifier.
     */
    public Identifier getTestConfigurationId() {
        return this.testConfigurationId;
    }

    /**
     * Missing description at method setTestConfigurationId.
     *
     * @param testConfigurationId the Identifier.
     */
    public void setTestConfigurationId(Identifier testConfigurationId) {
        this.testConfigurationId = testConfigurationId;
    }

    /**
     * Missing description at method getStartTime.
     *
     * @return the DateTime.
     */
    public DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Missing description at method setStartTime.
     *
     * @param startTime the DateTime.
     */
    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(TestConfigurationResultSearchMsg.class)
                .getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(TestConfigurationResultSearchMsg.class)
                .getAllProperties();
    }
}
