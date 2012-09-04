/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.result.ui.rcp.edit.reporting.model;

import java.io.Serializable;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.widgetcreators.code.CodeContentProvider;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.widgetcreators.code.CodeLabelProvider;
import org.nabucco.framework.plugin.base.logging.Loggable;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.testautomation.result.facade.datatype.ReportDefinition;


/**
 * ReportingEditViewModel
 * <p/>
 * Edit view for reporting
 * <p/>
 * 
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-11-16
 */
public class ReportingEditViewModel extends ViewModel implements Loggable {

    private ReportDefinition reportDefinition;

    private static final Code[] REPORT_TYPES = (Code[]) new CodeContentProvider(
            new ReportDefinition().getReportTypeCodePath()).getElements(null);

    private static final CodeLabelProvider LABEL_PROVIDER = new CodeLabelProvider();

    public static final String PROPERTY_REPORTDEFINITION_TYPE = "reportDefinitionType";

    /** Constructs a new ReportingEditViewModel instance. */
    public ReportingEditViewModel() {
        super();
    }

    /**
     * Getter for the ID.
     * 
     * @return the String.
     */
    @Override
    public String getID() {
        return "org.nabucco.testautomation.result.ui.rcp.edit.reporting.model.ReportingEditViewModel";
    }

    /**
     * Getter for the Values.
     * 
     * @return the Map<String, Serializable>.
     */
    @Override
    public Map<String, Serializable> getValues() {
        Map<String, Serializable> result = super.getValues();
        result.put(PROPERTY_REPORTDEFINITION_TYPE, this.getReportDefinitionType());
        return result;
    }

    /**
     * Setter for the ReportDefinition.
     * 
     * @param newValue
     *            the ReportDefinition.
     */
    public void setReportDefinition(ReportDefinition newValue) {
        ReportDefinition oldValue = this.reportDefinition;
        this.reportDefinition = newValue;
        this.updateProperty(PROPERTY_REPORTDEFINITION_TYPE,
                ((oldValue != null) ? oldValue.getReportType() : ""),
                ((newValue != null) ? newValue.getReportType() : ""));
    }

    /**
     * Getter for the ReportDefinition.
     * 
     * @return the ReportDefinition.
     */
    public ReportDefinition getReportDefinition() {
        return this.reportDefinition;
    }

    /**
     * Setter for the ReportDefinitionName.
     * 
     * @param newName
     *            the String.
     */
    public void setReportDefinitionType(String newName) {
        if (((reportDefinition != null) && (reportDefinition.getReportType() == null))) {
            reportDefinition.setReportType(null);
        }
        String oldVal = reportDefinition.getReportType() != null ? LABEL_PROVIDER
                .getText(reportDefinition.getReportType()) : "";
        for (Code current : REPORT_TYPES) {
            if (current.getName().getValue().compareTo(newName) == 0
                    && newName.compareTo(oldVal) != 0) {
                reportDefinition.setReportType(current);
                this.updateProperty(PROPERTY_REPORTDEFINITION_TYPE, oldVal, newName);
                if (((!oldVal.equals(newName)) && reportDefinition.getDatatypeState().equals(
                        DatatypeState.PERSISTENT))) {
                    reportDefinition.setDatatypeState(DatatypeState.MODIFIED);
                }
            }
        }
    }

    /**
     * Getter for the ReportDefinitionName.
     * 
     * @return the String.
     */
    public String getReportDefinitionType() {
        if ((reportDefinition == null) || (reportDefinition.getReportType() == null)) {
            return "";
        }
        return LABEL_PROVIDER.getText(reportDefinition.getReportType());
    }
}
