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
package org.nabucco.testautomation.result.ui.rcp.search.result.view;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.layout.NabuccoLayouter;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.result.ui.rcp.search.result.model.TestConfigurationResultSearchViewModel;

/**
 * Layouter for TestConfig Search View.
 * 
 * @author Markus Jorroch, PRODYNA AG
 * 
 */
public class TestConfigurationResultSearchViewLayouter implements
        NabuccoLayouter<TestConfigurationResultSearchViewModel> {

    private final static String SECTION_TITLE = TestConfigurationResultSearchView.ID + ".section";

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager,
            TestConfigurationResultSearchViewModel model, Layoutable<TestConfigurationResultSearchViewModel> view) {
        return layout(parent, messageManager, model);
    }

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager,
            TestConfigurationResultSearchViewModel model) {

        NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);
        TestConfigurationResultSearchViewWidgetFactory widgetFactory = new TestConfigurationResultSearchViewWidgetFactory(
                ntk, model);

        // build a section to host the other controls
        Section section = ntk.createSection(parent, SECTION_TITLE, new RowLayout());
        Composite child = ntk.createComposite(section, new GridLayout(2, false));
        section.setClient(child);

        // add label and input fields (pair-wise)

        layoutName(widgetFactory, child);

        return null;
    }

    /**
     * Layouts the name label and text field.
     * 
     * @param widgetFactory
     *            the widget factory.
     * @param parent
     *            the parent composite
     */
    private void layoutName(TestConfigurationResultSearchViewWidgetFactory widgetFactory, Composite parent) {
        Label label = widgetFactory.createLabelTestConfigurationResultName(parent);
        this.layout(label);

        Text text = widgetFactory.createInputFieldTestConfigurationResultName(parent);
        this.layout(text);
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
