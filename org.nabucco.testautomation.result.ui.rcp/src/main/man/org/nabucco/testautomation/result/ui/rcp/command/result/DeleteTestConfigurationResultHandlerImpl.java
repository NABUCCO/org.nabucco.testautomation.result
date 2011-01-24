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
package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.close.AbstractDeleteDatatypeHandler;
import org.nabucco.framework.plugin.base.model.BusinessModel;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.command.result.DeleteTestConfigurationResultHandler;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.TestConfigurationResultMaintenanceMultiPageEditView;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultEditViewBusinessModel;


public class DeleteTestConfigurationResultHandlerImpl
		extends
		AbstractDeleteDatatypeHandler<TestConfigurationResultMaintenanceMultiPageEditView>
		implements DeleteTestConfigurationResultHandler {

	@Override
	public void deleteTestConfigurationResult() {
		run();
	}

	@Override
	public String getId() {
		return TestConfigurationResultMaintenanceMultiPageEditView.ID;
	}

	@Override
	protected boolean preClose(
			TestConfigurationResultMaintenanceMultiPageEditView view) {

		TestConfigurationResult testConfigResult = view.getModel()
				.getTestConfigurationResult();

		testConfigResult.setDatatypeState(DatatypeState.DELETED);

		BusinessModel businessModel = Activator
				.getDefault()
				.getModel()
				.getBusinessModel(
						TestConfigurationResultEditViewBusinessModel.ID);

		try {
			if (businessModel instanceof TestConfigurationResultEditViewBusinessModel) {
				((TestConfigurationResultEditViewBusinessModel) businessModel)
						.delete(testConfigResult);
			}
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
			return true;
		}

		return super.preClose(view);
	}
}
