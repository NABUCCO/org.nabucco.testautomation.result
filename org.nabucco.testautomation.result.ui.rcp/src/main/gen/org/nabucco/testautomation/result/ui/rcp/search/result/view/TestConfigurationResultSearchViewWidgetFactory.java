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
package org.nabucco.testautomation.result.ui.rcp.search.result.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.testautomation.result.ui.rcp.search.result.model.TestConfigurationResultSearchViewModel;

/**
 * TestConfigurationResultSearchViewWidgetFactory<p/>Search view for datatype TestConfigurationResult<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2010-10-12
 */
public class TestConfigurationResultSearchViewWidgetFactory extends WidgetFactory {

    private TestConfigurationResultSearchViewModel model;

    public static final String LABEL_TESTCONFIGURATIONRESULTNAME = "testConfigurationResult.name";

    public static final String OBSERVE_VALUE_TESTCONFIGURATIONRESULTNAME = TestConfigurationResultSearchViewModel.PROPERTY_TESTCONFIGURATIONRESULT_NAME;

    /**
     * Constructs a new TestConfigurationResultSearchViewWidgetFactory instance.
     *
     * @param aModel the TestConfigurationResultSearchViewModel.
     * @param nabuccoFormToolKit the NabuccoFormToolkit.
     */
    public TestConfigurationResultSearchViewWidgetFactory(final NabuccoFormToolkit nabuccoFormToolKit,
            final TestConfigurationResultSearchViewModel aModel) {
        super(nabuccoFormToolKit);
        model = aModel;
    }

    /**
     * CreateLabelTestConfigurationResultName.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelTestConfigurationResultName(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_TESTCONFIGURATIONRESULTNAME);
    }

    /**
     * CreateInputFieldTestConfigurationResultName.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldTestConfigurationResultName(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model, OBSERVE_VALUE_TESTCONFIGURATIONRESULTNAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }
}
