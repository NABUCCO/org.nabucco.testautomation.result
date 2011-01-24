/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.DateTime;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "id", "name", "testConfigurationName",
            "testConfigurationId", "startTime" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;" };

    private Identifier id;

    private Name name;

    private Name testConfigurationName;

    private Identifier testConfigurationId;

    private DateTime startTime;

    /** Constructs a new TestConfigurationResultSearchMsg instance. */
    public TestConfigurationResultSearchMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[0], Identifier.class,
                PROPERTY_CONSTRAINTS[0], this.id));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[1], Name.class,
                PROPERTY_CONSTRAINTS[1], this.name));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[2], Name.class,
                PROPERTY_CONSTRAINTS[2], this.testConfigurationName));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[3], Identifier.class,
                PROPERTY_CONSTRAINTS[3], this.testConfigurationId));
        properties.add(new BasetypeProperty<DateTime>(PROPERTY_NAMES[4], DateTime.class,
                PROPERTY_CONSTRAINTS[4], this.startTime));
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
        final TestConfigurationResultSearchMsg other = ((TestConfigurationResultSearchMsg) obj);
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
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestConfigurationResultSearchMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<id>" + this.id) + "</id>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable
                .append((("<testConfigurationName>" + this.testConfigurationName) + "</testConfigurationName>\n"));
        appendable
                .append((("<testConfigurationId>" + this.testConfigurationId) + "</testConfigurationId>\n"));
        appendable.append((("<startTime>" + this.startTime) + "</startTime>\n"));
        appendable.append("</TestConfigurationResultSearchMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
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
}
