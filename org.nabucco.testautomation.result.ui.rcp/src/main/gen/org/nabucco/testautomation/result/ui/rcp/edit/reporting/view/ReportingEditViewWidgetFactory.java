/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.result.ui.rcp.edit.reporting.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.widgetcreators.code.CodeContentProvider;
import org.nabucco.framework.common.dynamiccode.ui.rcp.component.multipage.masterdetail.widgetcreators.code.CodeLabelProvider;
import org.nabucco.framework.plugin.base.component.picker.combo.ElementPickerCombo;
import org.nabucco.framework.plugin.base.component.picker.combo.ElementPickerComboParameter;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.testautomation.result.facade.datatype.ReportDefinition;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.model.ReportingEditViewModel;


/**
 * ReportingEditViewWidgetFactory
 * <p/>
 * Edit view for reporting
 * <p/>
 * 
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-11-16
 */
public class ReportingEditViewWidgetFactory extends WidgetFactory {

    private ReportingEditViewModel model;

    private ReportDefinition dummy = new ReportDefinition();

    public static final String SECTION = "SectionName";

    public static final String LABEL_TYPE = "report.type";

    public static final String OBSERVE_VALUE_TYPE = ReportingEditViewModel.PROPERTY_REPORTDEFINITION_TYPE;

    /**
     * Constructs a new ReportingEditViewWidgetFactory instance.
     * 
     * @param model
     *            the ReportingEditViewModel.
     * @param nabuccoFormToolKit
     *            the NabuccoFormToolkit.
     */
    public ReportingEditViewWidgetFactory(NabuccoFormToolkit nabuccoFormToolKit,
            ReportingEditViewModel model) {
        super(nabuccoFormToolKit);
        this.model = model;
    }

    /**
     * CreateSectionHeading.
     * 
     * @param parent
     *            the Composite.
     * @return the Section.
     */
    public Section createSectionHeading(Composite parent) {
        return nabuccoFormToolKit.createSection(parent, SECTION, new GridLayout());
    }

    /**
     * CreateLabelType.
     * 
     * @param parent
     *            the Composite.
     * @return the Label.
     */
    public Label createLabelType(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_TYPE);
    }

    /**
     * CreateElementComboUserType.
     * 
     * @param params
     *            the ElementPickerComboParameter.
     * @param parent
     *            the Composite.
     */
    public void createElementComboUserType(Composite parent, ElementPickerComboParameter params) {
        ElementPickerCombo elementCombo = new ElementPickerCombo(parent, SWT.NONE,
                new CodeContentProvider(dummy.getReportTypeCodePath()), new CodeLabelProvider(),
                "", false);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement;
        IObservableValue modelElement;
        uiElement = SWTObservables.observeSelection(elementCombo.getCombo());
        modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_TYPE);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        elementCombo
                .addSelectionListener(new ReportingEditComboBrandTypeTypeComboBoxHandler(model));
    }
}
