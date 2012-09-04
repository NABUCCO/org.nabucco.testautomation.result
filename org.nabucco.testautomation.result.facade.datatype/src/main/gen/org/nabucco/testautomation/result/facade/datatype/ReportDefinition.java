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
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ReportDefinition<p/>A class defining a report<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-11-17
 */
public class ReportDefinition extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;" };

    public static final String REPORTTYPE = "reportType";

    private Code reportType;

    private Long reportTypeRefId;

    protected static final String REPORTTYPE_CODEPATH = "nabucco.testautomation.reports";

    /** Constructs a new ReportDefinition instance. */
    public ReportDefinition() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ReportDefinition.
     */
    protected void cloneObject(ReportDefinition clone) {
        super.cloneObject(clone);
        if ((this.getReportType() != null)) {
            clone.setReportType(this.getReportType().cloneObject());
        }
        if ((this.getReportTypeRefId() != null)) {
            clone.setReportTypeRefId(this.getReportTypeRefId());
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
        propertyMap.put(REPORTTYPE, PropertyDescriptorSupport.createDatatype(REPORTTYPE, Code.class, 3,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, REPORTTYPE_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ReportDefinition.getPropertyDescriptor(REPORTTYPE), this.getReportType(),
                this.reportTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(REPORTTYPE) && (property.getType() == Code.class))) {
            this.setReportType(((Code) property.getInstance()));
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
        final ReportDefinition other = ((ReportDefinition) obj);
        if ((this.reportType == null)) {
            if ((other.reportType != null))
                return false;
        } else if ((!this.reportType.equals(other.reportType)))
            return false;
        if ((this.reportTypeRefId == null)) {
            if ((other.reportTypeRefId != null))
                return false;
        } else if ((!this.reportTypeRefId.equals(other.reportTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.reportType == null) ? 0 : this.reportType.hashCode()));
        result = ((PRIME * result) + ((this.reportTypeRefId == null) ? 0 : this.reportTypeRefId.hashCode()));
        return result;
    }

    @Override
    public ReportDefinition cloneObject() {
        ReportDefinition clone = new ReportDefinition();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method setReportType.
     *
     * @param reportType the Code.
     */
    public void setReportType(Code reportType) {
        this.reportType = reportType;
        if ((reportType != null)) {
            this.setReportTypeRefId(reportType.getId());
        } else {
            this.setReportTypeRefId(null);
        }
    }

    /**
     * Missing description at method getReportType.
     *
     * @return the Code.
     */
    public Code getReportType() {
        return this.reportType;
    }

    /**
     * Getter for the ReportTypeRefId.
     *
     * @return the Long.
     */
    public Long getReportTypeRefId() {
        return this.reportTypeRefId;
    }

    /**
     * Setter for the ReportTypeRefId.
     *
     * @param reportTypeRefId the Long.
     */
    public void setReportTypeRefId(Long reportTypeRefId) {
        this.reportTypeRefId = reportTypeRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ReportDefinition.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ReportDefinition.class).getAllProperties();
    }

    /**
     * Getter for the ReportTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getReportTypeCodePath() {
        return new CodePath(REPORTTYPE_CODEPATH);
    }
}
