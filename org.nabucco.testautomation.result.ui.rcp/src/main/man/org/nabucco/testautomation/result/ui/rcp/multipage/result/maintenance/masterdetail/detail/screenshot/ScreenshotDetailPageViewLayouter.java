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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.detail.screenshot;

import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.BaseTypeWidgetFactory;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.property.ui.rcp.multipage.detail.PropertyDetailPageViewLayouter;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;

/**
 * ScreenshotDetailPageViewLayouter
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public class ScreenshotDetailPageViewLayouter extends
PropertyDetailPageViewLayouter {

	private static final String PROPERTY_SCREENSHOT = "screenshot";

	private static final String BUTTON = PROPERTY_SCREENSHOT + ".button";

	/**
	 * Creates a new {@link MetadataDetailPageViewLayouter} instance.
	 * 
	 * @param title
	 *            the detail view title
	 */
	public ScreenshotDetailPageViewLayouter(String title) {
		super(title);
	}

	@Override
	public Composite layout(Composite parent, Datatype datatype,
			String masterBlockId, Set<String> invisibleProperties,
			Set<String> readOnlyProperties, ViewModel externalViewModel,
			NabuccoMessageManager messageManager) {
		return super.layout(parent, datatype, masterBlockId,
				invisibleProperties, readOnlyProperties, externalViewModel,
				messageManager);
	}

	@Override
	protected Control layoutElement(Composite parent,
			BaseTypeWidgetFactory widgetFactory, Datatype datatype,
			String masterBlockId, NabuccoProperty property,
			GridData data, boolean readOnly, ViewModel externalViewModel,
			NabuccoMessageManager messageManager) {

		// Validate property screenshot
		String propertyName = property.getName();
		
		if (propertyName.equalsIgnoreCase(PROPERTY_SCREENSHOT)) {
			// Create Label
			Label label = widgetFactory.createLabel(parent, masterBlockId + "."
					+ PROPERTY_SCREENSHOT);
			label.setToolTipText(label.getText());
			label.setLayoutData(data);

			// Create Button
			NabuccoFormToolkit nft = widgetFactory.getNabuccoFormToolKit();
			Button button = nft.createFlatButton(parent, ImageProvider
					.createImage(ResultImageRegistry.ICON_SCREENSHOT.getId()));
			button.setToolTipText(I18N.i18n(masterBlockId + "." + BUTTON));
			button.addSelectionListener(new OpenScreenshotListener(
					(ScreenshotTrace) datatype, true));

			// Format button right
			data = new GridData();
			data.horizontalAlignment = SWT.LEFT;
			button.setLayoutData(data);

			return button;
		} else {
			return super.layoutElement(parent, widgetFactory, datatype,
					masterBlockId, property, data, readOnly,
					externalViewModel, messageManager);
		}
	}
}
