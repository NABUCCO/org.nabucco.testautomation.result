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

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.TestConfigurationResultMaintenanceMultiPageEditView;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.JiraExportWizard;

public class JiraExportHandlerImpl implements JiraExportHandler {

	@Override
	public void jiraExport() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				TestConfigurationResultMaintenanceMultiPageEditView view = (TestConfigurationResultMaintenanceMultiPageEditView) Activator.getDefault().getView(TestConfigurationResultMaintenanceMultiPageEditView.ID);
				TestResult testResult = (TestResult) ((MasterDetailTreeNode) ((IStructuredSelection) view.getMasterDetailsBlock().getTreeViewer().getSelection()).getFirstElement()).getDatatype();
				TestConfigurationResult testConfigurationResult = view.getModel().getTestConfigurationResult();
				
				JiraExportWizard wizard = new JiraExportWizard(testConfigurationResult, testResult);
				wizard.init(Activator.getDefault().getWorkbench(), StructuredSelection.EMPTY);
				WizardDialog wizardDialog = new WizardDialog(null, wizard);
				wizardDialog.setBlockOnOpen(true);
				wizardDialog.setPageSize(600, 400);
				wizardDialog.setTitleImage(ImageProvider.createImage(ResultImageRegistry.ICON_JIRA.getId()));
				wizardDialog.open();
			}
		});

	}

}
