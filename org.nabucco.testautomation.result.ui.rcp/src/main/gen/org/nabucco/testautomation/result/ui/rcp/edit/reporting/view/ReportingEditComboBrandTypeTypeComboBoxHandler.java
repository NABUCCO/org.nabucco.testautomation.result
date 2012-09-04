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
package org.nabucco.testautomation.result.ui.rcp.edit.reporting.view;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.model.ReportingEditViewModel;


/**
 * AuthorizationUserEditViewUserTypeComboBoxHandler
 * <p/>
 * Edit view for datatype AuthorizationUser
 * <p/>
 * 
 * @version 1.0
 * @author Frank Ratschinski, PRODYNA AG, 2010-01-18
 */
public class ReportingEditComboBrandTypeTypeComboBoxHandler implements SelectionListener {

    private ReportingEditViewModel model;

    /**
     * Constructs a new AuthorizationUserEditViewUserTypeComboBoxHandler instance.
     * 
     * @param model
     *            the AuthorizationUserEditViewModel.
     */
    public ReportingEditComboBrandTypeTypeComboBoxHandler(final ReportingEditViewModel model) {
        super();
        this.model = model;
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent selectionEvent) {
        if ((selectionEvent.widget instanceof Combo)) {
            Combo combo = ((Combo) selectionEvent.widget);
            model.setReportDefinitionType(combo.getText());
        }
    }

    @Override
    public void widgetSelected(SelectionEvent selectionEvent) {
        if ((selectionEvent.widget instanceof Combo)) {
            Combo combo = ((Combo) selectionEvent.widget);
            model.setReportDefinitionType(combo.getText());
        }
    }
}
