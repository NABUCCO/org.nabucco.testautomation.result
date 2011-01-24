/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
    public TestConfigurationResultSearchViewWidgetFactory(
            final NabuccoFormToolkit nabuccoFormToolKit,
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
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_TESTCONFIGURATIONRESULTNAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }
}
