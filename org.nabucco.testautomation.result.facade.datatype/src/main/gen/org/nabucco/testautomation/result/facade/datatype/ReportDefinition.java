/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;

/**
 * ReportDefinition<p/>A class defining a report<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-11-17
 */
public class ReportDefinition extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "reportType" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;" };

    private Code reportType;

    private Long reportTypeRefId;

    private static final String REPORTTYPE_CODEPATH = "nabucco.testautomation.reports";

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

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<Code>(PROPERTY_NAMES[0], Code.class,
                PROPERTY_CONSTRAINTS[0], this.reportType));
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
        result = ((PRIME * result) + ((this.reportTypeRefId == null) ? 0 : this.reportTypeRefId
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ReportDefinition>\n");
        appendable.append(super.toString());
        appendable.append((("<reportType>" + this.reportType) + "</reportType>\n"));
        appendable.append((("<reportTypeRefId>" + this.reportTypeRefId) + "</reportTypeRefId>\n"));
        appendable.append("</ReportDefinition>\n");
        return appendable.toString();
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
     * Getter for the ReportTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getReportTypeCodePath() {
        return new CodePath(REPORTTYPE_CODEPATH);
    }
}
