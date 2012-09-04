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

import java.io.Serializable;
import java.util.Map;

import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Form;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.view.ManagedFormViewPart;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.model.ReportingEditViewModel;


/**
 * ReportingEditView
 * <p/>
 * Edit view for reporting
 * <p/>
 * 
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-11-16
 */
public class ReportingEditView extends ManagedFormViewPart<ReportingEditViewModel> {

    public static final String ID = "org.nabucco.testautomation.ui.edit.reporting.ReportingEditView";

    private NabuccoFormToolkit ntk;

    public static final String TITLE = (ID + ".title");

    public static final String TAB_TITLE = (ID + ".tabTitle");

    /** Constructs a new ReportingEditView instance. */
    public ReportingEditView() {
        super();
    }

    @Override
    protected void createToolbarActions(IToolBarManager toolbarManager) {
    }

    @Override
    protected String getManagedFormTitle() {
        return I18N.i18n(TITLE);
    }

    @Override
    protected void createFormControl(Form form) {
        ntk = new NabuccoFormToolkit(form.getBody());
        Composite frame = ntk.createComposite(form.getBody(), new RowLayout(SWT.VERTICAL));
        model = new ReportingEditViewModel();
        this.getLayouter().layout(frame, this.getMessageManager(), model);
    }

    @Override
    protected void createHeadControl(Composite head) {
    }

    @Override
    public String getNewPartName() {
        return I18N.i18n(TAB_TITLE, this.getValues());
    }

    /**
     * Getter for the Values.
     * 
     * @return the Map<String, Serializable>.
     */
    public Map<String, Serializable> getValues() {
        return model.getValues();
    }

    @Override
    public String getId() {
        return ReportingEditView.ID;
    }
}
