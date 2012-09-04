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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.detail.filetrace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.nabucco.framework.base.facade.datatype.Data;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.widget.BaseTypeWidgetFactory;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.property.ui.rcp.multipage.detail.PropertyDetailPageViewLayouter;
import org.nabucco.testautomation.result.facade.datatype.trace.FileTrace;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;

/**
 * FileTraceDetailPageViewLayouter
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class FileTraceDetailPageViewLayouter extends PropertyDetailPageViewLayouter {

    private static final String PROPERTY_FILE_CONTENT = "fileContent";

    private static final String BUTTON = PROPERTY_FILE_CONTENT + ".button";

    /**
     * Creates a new {@link MetadataDetailPageViewLayouter} instance.
     * 
     * @param title
     *            the detail view title
     */
    public FileTraceDetailPageViewLayouter(String title) {
        super(title);
    }

    @Override
    public Composite layout(Composite parent, Datatype datatype, String masterBlockId, Set<String> invisibleProperties,
            Set<String> readOnlyProperties, ViewModel externalViewModel, NabuccoMessageManager messageManager) {

        return super.layout(parent, datatype, masterBlockId, invisibleProperties, readOnlyProperties,
                externalViewModel, messageManager);
    }

    @Override
    protected Control layoutElement(Composite parent, BaseTypeWidgetFactory widgetFactory, Datatype datatype,
            String masterBlockId, NabuccoProperty property, GridData data, boolean readOnly,
            ViewModel externalViewModel, NabuccoMessageManager messageManager) {

        // Validate property fileContent
        String propertyName = property.getName();

        if (propertyName.equalsIgnoreCase(PROPERTY_FILE_CONTENT)) {

            final FileTrace fileTrace = (FileTrace) datatype;

            // Create Label
            Label label = widgetFactory.createLabel(parent, masterBlockId + "." + PROPERTY_FILE_CONTENT);
            label.setToolTipText(label.getText());
            label.setLayoutData(data);

            // Create Button
            NabuccoFormToolkit nft = widgetFactory.getNabuccoFormToolKit();
            Button button = nft.createFlatButton(parent,
                    ImageProvider.createImage(ResultImageRegistry.ICON_FILE.getId()));
            button.setToolTipText(I18N.i18n(masterBlockId + "." + BUTTON));
            button.addSelectionListener(new SelectionListener() {

                @Override
                public void widgetSelected(SelectionEvent arg0) {

                    try {
                        Data fileContent = fileTrace.getFileContent();
                        String fileName = null;
                        String userHome = System.getProperty("java.io.tmpdir");
                        File folder = new File(userHome);

                        String extension = null;
                        String fileNameWithExtension = fileTrace.getName().getValue();
                        for (int i = fileNameWithExtension.length() - 1; i > 0; i--) {
                            if (fileNameWithExtension.charAt(i) == '.') {
                                extension = fileNameWithExtension.substring(i);
                                fileName = fileNameWithExtension.substring(0, i);
                                break;
                            }
                        }
                        File tempFile = File.createTempFile(fileName, extension, folder);

                        FileOutputStream fos = new FileOutputStream(tempFile);
                        fos.write(fileContent.getValue());
                        fos.close();

                        Program p = Program.findProgram(extension);
                        if (p != null) {
                            p.execute(tempFile.getAbsolutePath());
                        } else {
                            Activator.getDefault().logError("No system editor for type '" + extension + "' found");
                        }

                    } catch (IOException e) {
                        Activator.getDefault().logError(e);
                    }
                }

                @Override
                public void widgetDefaultSelected(SelectionEvent arg0) {
                    // do nothing
                }
            });

            // Format button right
            data = new GridData();
            data.horizontalAlignment = SWT.LEFT;
            button.setLayoutData(data);

            return button;
        } else {
            return super.layoutElement(parent, widgetFactory, datatype, masterBlockId, property, data, readOnly,
                    externalViewModel, messageManager);
        }
    }
}
