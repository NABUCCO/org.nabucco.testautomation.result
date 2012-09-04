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
package org.nabucco.testautomation.result.ui.rcp.browser.reporting;

import java.io.Serializable;
import java.util.Map;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.model.browser.DatatypeBrowserElement;
import org.nabucco.testautomation.result.facade.datatype.ReportDefinition;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.model.ReportingEditViewModel;


/**
 * ReportDefinitionEditViewBrowserElement
 *
 * @author Undefined
 */
public class ReportDefinitionEditViewBrowserElement extends DatatypeBrowserElement implements
        NabuccoInjectionReciever {

    private ReportDefinitionEditViewBrowserElementHandler browserHandler;

    private ReportingEditViewModel viewModel;

    /**
     * Constructs a new ReportDefinitionEditViewBrowserElement instance.
     *
     * @param datatype the ReportDefinition.
     */
    public ReportDefinitionEditViewBrowserElement(final ReportDefinition datatype) {
        super();
        NabuccoInjector instance = NabuccoInjector
                .getInstance(ReportDefinitionEditViewBrowserElement.class);
        browserHandler = instance.inject(ReportDefinitionEditViewBrowserElementHandler.class);
        viewModel = new ReportingEditViewModel();
        viewModel.setReportDefinition(datatype);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        browserHandler.createChildren(viewModel, this);
    }

    @Override
    protected void fillDatatype() {
        viewModel = browserHandler.loadFull(viewModel);
    }

    /**
     * Getter for the ViewModel.
     *
     * @return the ReportingEditViewModel.
     */
    public ReportingEditViewModel getViewModel() {
        return this.viewModel;
    }

    @Override
    public Map<String, Serializable> getValues() {
        return this.viewModel.getValues();
    }

    /**
     * Setter for the ViewModel.
     *
     * @param viewModel the ReportingEditViewModel.
     */
    public void setViewModel(ReportingEditViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
