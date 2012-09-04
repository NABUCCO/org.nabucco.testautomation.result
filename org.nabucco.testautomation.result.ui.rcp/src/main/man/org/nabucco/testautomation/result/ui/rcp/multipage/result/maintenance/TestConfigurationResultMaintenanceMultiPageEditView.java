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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Map;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailHelper;
import org.nabucco.framework.plugin.base.component.multipage.view.MultiPageEditView;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorPage;
import org.nabucco.framework.plugin.base.component.multipage.xml.example.XmlDefaultPage;
import org.nabucco.testautomation.property.facade.service.history.HistoryEntry;
import org.nabucco.testautomation.property.facade.service.history.HistoryEntryType;
import org.nabucco.testautomation.property.facade.service.history.HistoryService;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.TestConfigurationResultMaintenanceMasterDetailBlock;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultMaintenanceMultiPageEditViewModel;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestResultCopyPasteHandler;

/**
 * TestConfigurationResultMaintenanceMultiPageEditView
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestConfigurationResultMaintenanceMultiPageEditView extends
        MultiPageEditView<TestConfigurationResultMaintenanceMultiPageEditViewModel> {

    private static final String TOOLTIP_EXECUTE = "Execute";

    private static final String TOOLTIP_DELETE = "Delete";

    private static final String TOOLTIP_SAVE = "Save";

    private static final String TOOLTIP_IMPORT = "Import";

    private static final String TOOLTIP_RELOAD = "Reload";

    public static final String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.TestConfigurationResultMaintenanceMultiPageEditView";

    public static final String TITLE = ID + ".title";

    public static final String TAB_TITLE = ID + ".tabTitle";

    private TestConfigurationResultMaintenanceMasterDetailBlock testConfigurationResultMaintenanceMasterDetailBlock;

    /**
     * Creates a new {@link TestConfigurationResultResultMaintenanceMultiplePageEditView} instance.
     */
    public TestConfigurationResultMaintenanceMultiPageEditView() throws ClientException {
        model = new TestConfigurationResultMaintenanceMultiPageEditViewModel();
        TestConfigurationResult testConfigurationResult = new TestConfigurationResult();
        testConfigurationResult.setName("");
        testConfigurationResult.setIdentificationKey("");
        model.setTestConfigurationResult(testConfigurationResult);
        model.setCopyPasteHandler(new TestResultCopyPasteHandler());
    }

    @Override
    protected String getManagedFormTitle() {
        return I18N.i18n(TITLE, getValues());
    }

    @Override
    public MasterDetailBlock<TestConfigurationResultMaintenanceMultiPageEditViewModel> getMasterDetailsBlock() {
        if (testConfigurationResultMaintenanceMasterDetailBlock == null) {
            testConfigurationResultMaintenanceMasterDetailBlock = new TestConfigurationResultMaintenanceMasterDetailBlock(
                    model, getMessageManager(), this);
        }
        return testConfigurationResultMaintenanceMasterDetailBlock;
    }

    @Override
    public void postOpen() {
        // Activate or deactivate Reload Button
        refreshReloadButtonState();
        super.model.addPropertyChangeListener("datatype", new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                refreshReloadButtonState();
            }
        });

        // Add HistoryEntry
        TestConfigurationResult result = super.model.getTestConfigurationResult();

        if (result.getDatatypeState() != DatatypeState.INITIALIZED
                && result.getDatatypeState() != DatatypeState.CONSTRUCTED) {
            HistoryEntry entry = new HistoryEntry(HistoryEntryType.TEST_CONFIGURATION_RESULT, new Identifier(
                    result.getId()), result.getIdentificationKey(), result.getName(), null);
            HistoryService.getInstance().addHistoryEntry(entry);
        }
    }

    private void refreshReloadButtonState() {
        // TODO Develop general concept in plugin.base
        final ToolBar toolBar = ((ToolBarManager) getToolBarManager()).getControl();
        ToolItem reloadItem = null;
        ToolItem importItem = null;
        ToolItem saveItem = null;
        ToolItem deleteItem = null;
        ToolItem executeItem = null;

        for (ToolItem item : toolBar.getItems()) {
            if (item.getToolTipText() != null) {
                if (item.getToolTipText().equals(TOOLTIP_RELOAD)) {
                    reloadItem = item;
                } else if (item.getToolTipText().equals(TOOLTIP_IMPORT)) {
                    importItem = item;
                } else if (item.getToolTipText().equals(TOOLTIP_SAVE)) {
                    saveItem = item;
                } else if (item.getToolTipText().equals(TOOLTIP_DELETE)) {
                    deleteItem = item;
                } else if (item.getToolTipText().equals(TOOLTIP_EXECUTE)) {
                    executeItem = item;
                }
            }
        }

        if (reloadItem != null) {
            if (super.getModel().getTestConfigurationResult().getDatatypeState() == DatatypeState.INITIALIZED) {
                reloadItem.setEnabled(false);
            } else {
                reloadItem.setEnabled(true);
            }
        }
        if (importItem != null) {
            if (MasterDetailHelper.isImportPossible(super.getModel().getTestConfigurationResult())) {
                importItem.setEnabled(true);
            } else {
                importItem.setEnabled(false);
            }
        }
        if (saveItem != null) {
            if (MasterDetailHelper.isDatatypeEditable(super.getModel().getTestConfigurationResult())) {
                saveItem.setEnabled(true);
            } else {
                saveItem.setEnabled(false);
            }
        }
        if (deleteItem != null) {
            if (MasterDetailHelper.isDatatypeEditable(super.getModel().getTestConfigurationResult())) {
                deleteItem.setEnabled(true);
            } else {
                deleteItem.setEnabled(false);
            }
        }
        if (executeItem != null) {
            if (MasterDetailHelper.isDatatypeEditable(super.getModel().getTestConfigurationResult())) {
                executeItem.setEnabled(true);
            } else {
                executeItem.setEnabled(false);
            }
        }
    }

    @Override
    public XMLEditorPage getXMLPage() {
        return new XmlDefaultPage();
    }

    public Map<String, Serializable> getValues() {
        return model.getValues();
    }

    @Override
    public String getNewPartName() {
        return I18N.i18n(TAB_TITLE, getValues());
    }

    @Override
    public String getId() {
        return ID;
    }

}
