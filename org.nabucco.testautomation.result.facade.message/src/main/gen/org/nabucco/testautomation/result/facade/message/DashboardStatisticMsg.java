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
package org.nabucco.testautomation.result.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * DashboardStatisticMsg<p/>Message for transportation statistics<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-12-22
 */
public class DashboardStatisticMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "l0,n;u0,n;m1,1;" };

    public static final String NUMTESTCONFIGURATIONRESULTS = "numTestConfigurationResults";

    public static final String NUMSUCCESS = "numSuccess";

    public static final String NUMFAILED = "numFailed";

    private Number numTestConfigurationResults;

    private Number numSuccess;

    private Number numFailed;

    /** Constructs a new DashboardStatisticMsg instance. */
    public DashboardStatisticMsg() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(NUMTESTCONFIGURATIONRESULTS, PropertyDescriptorSupport.createBasetype(
                NUMTESTCONFIGURATIONRESULTS, Number.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(NUMSUCCESS,
                PropertyDescriptorSupport.createBasetype(NUMSUCCESS, Number.class, 1, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(NUMFAILED,
                PropertyDescriptorSupport.createBasetype(NUMFAILED, Number.class, 2, PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(DashboardStatisticMsg.getPropertyDescriptor(NUMTESTCONFIGURATIONRESULTS),
                this.numTestConfigurationResults));
        properties.add(super.createProperty(DashboardStatisticMsg.getPropertyDescriptor(NUMSUCCESS), this.numSuccess));
        properties.add(super.createProperty(DashboardStatisticMsg.getPropertyDescriptor(NUMFAILED), this.numFailed));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(NUMTESTCONFIGURATIONRESULTS) && (property.getType() == Number.class))) {
            this.setNumTestConfigurationResults(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NUMSUCCESS) && (property.getType() == Number.class))) {
            this.setNumSuccess(((Number) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NUMFAILED) && (property.getType() == Number.class))) {
            this.setNumFailed(((Number) property.getInstance()));
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
        final DashboardStatisticMsg other = ((DashboardStatisticMsg) obj);
        if ((this.numTestConfigurationResults == null)) {
            if ((other.numTestConfigurationResults != null))
                return false;
        } else if ((!this.numTestConfigurationResults.equals(other.numTestConfigurationResults)))
            return false;
        if ((this.numSuccess == null)) {
            if ((other.numSuccess != null))
                return false;
        } else if ((!this.numSuccess.equals(other.numSuccess)))
            return false;
        if ((this.numFailed == null)) {
            if ((other.numFailed != null))
                return false;
        } else if ((!this.numFailed.equals(other.numFailed)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.numTestConfigurationResults == null) ? 0 : this.numTestConfigurationResults
                .hashCode()));
        result = ((PRIME * result) + ((this.numSuccess == null) ? 0 : this.numSuccess.hashCode()));
        result = ((PRIME * result) + ((this.numFailed == null) ? 0 : this.numFailed.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getNumTestConfigurationResults.
     *
     * @return the Number.
     */
    public Number getNumTestConfigurationResults() {
        return this.numTestConfigurationResults;
    }

    /**
     * Missing description at method setNumTestConfigurationResults.
     *
     * @param numTestConfigurationResults the Number.
     */
    public void setNumTestConfigurationResults(Number numTestConfigurationResults) {
        this.numTestConfigurationResults = numTestConfigurationResults;
    }

    /**
     * Missing description at method getNumSuccess.
     *
     * @return the Number.
     */
    public Number getNumSuccess() {
        return this.numSuccess;
    }

    /**
     * Missing description at method setNumSuccess.
     *
     * @param numSuccess the Number.
     */
    public void setNumSuccess(Number numSuccess) {
        this.numSuccess = numSuccess;
    }

    /**
     * Missing description at method getNumFailed.
     *
     * @return the Number.
     */
    public Number getNumFailed() {
        return this.numFailed;
    }

    /**
     * Missing description at method setNumFailed.
     *
     * @param numFailed the Number.
     */
    public void setNumFailed(Number numFailed) {
        this.numFailed = numFailed;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(DashboardStatisticMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(DashboardStatisticMsg.class).getAllProperties();
    }
}
