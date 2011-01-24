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

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.layout.NabuccoLayouter;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.model.ReportingEditViewModel;
import org.nabucco.testautomation.result.ui.rcp.edit.reporting.view.ReportingEditViewWidgetFactory;


public class ReportingEditViewLayouter implements NabuccoLayouter {

    private ReportingEditViewWidgetFactory reportingEditViewWidgetFactory;

    private static final String CONFIG_TEXT = "TestEngineConfiguration";

    private NabuccoFormToolkit ntk;

    /**
     * {@inheritDoc}
     */
    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager, ViewModel model) {
        if (model instanceof ReportingEditViewModel) {
            return layout(parent, messageManager, (ReportingEditViewModel) model);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager,
            ViewModel model, Layoutable view) {
        return layout(parent, messageManager, model);
    }

    /**
     * {@inheritDoc}
     */
    public Composite layout(final Composite aComposite, final NabuccoMessageManager messageManager,
            final ReportingEditViewModel model) {
        layout(aComposite, model);
        return null;
    }

    /**
     * layout.
     * 
     * @param parent
     * @param aModel
     */
    private void layout(final Composite parent, final ReportingEditViewModel aModel) {

        ntk = new NabuccoFormToolkit(parent);
        reportingEditViewWidgetFactory = new ReportingEditViewWidgetFactory(ntk, aModel);

        layoutSectionAddUser(parent);
    }

    private void layoutSectionAddUser(Composite parent) {
        Section addUserSection = ntk.createSection(parent, CONFIG_TEXT, new GridLayout());

        Composite child = ntk.createComposite(addUserSection, new GridLayout(2, false));
        addUserSection.setClient(child);

        layoutConfigName(child);
    }

    private void layoutConfigName(Composite parent) {
        reportingEditViewWidgetFactory.createLabelType(parent);
        reportingEditViewWidgetFactory.createElementComboUserType(parent, null);
    }

    /**
     * Layout the text field.
     * 
     * @param text
     *            the text field
     */
    private void layout(Text text) {
        GridData data = new GridData();
        data.widthHint = 180;
        text.setLayoutData(data);
    }

    /**
     * Layout the label.
     * 
     * @param label
     *            the label
     */
    private void layout(Label label) {
        GridData data = new GridData();
        data.widthHint = 100;
        label.setLayoutData(data);
    }

}
