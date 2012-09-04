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
package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.command.AbstractSaveCommandHandlerImpl;
import org.nabucco.testautomation.property.facade.service.history.HistoryEntry;
import org.nabucco.testautomation.property.facade.service.history.HistoryEntryType;
import org.nabucco.testautomation.property.facade.service.history.HistoryService;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultEditViewBusinessModel;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultMaintenanceMultiPageEditViewModel;

public class SaveTestConfigurationResultHandlerImpl
        extends
        AbstractSaveCommandHandlerImpl<TestConfigurationResultEditViewBusinessModel, TestConfigurationResultMaintenanceMultiPageEditViewModel>
        implements SaveTestConfigurationResultHandler {

    @Override
    public void saveTestConfigurationResult() {
        run();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBusinessModelId() {
        return TestConfigurationResultEditViewBusinessModel.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveModel(TestConfigurationResultMaintenanceMultiPageEditViewModel viewModel,
            TestConfigurationResultEditViewBusinessModel businessModel) throws ClientException {
        TestConfigurationResult response = businessModel.save(viewModel.getTestConfigurationResult());
        viewModel.setTestConfigurationResult(response);
        
        HistoryEntry entry = new HistoryEntry(HistoryEntryType.TEST_CONFIGURATION_RESULT, new Identifier(
                response.getId()), response.getIdentificationKey(), response.getName(), null);
        HistoryService.getInstance().addHistoryEntry(entry);
    }

}
