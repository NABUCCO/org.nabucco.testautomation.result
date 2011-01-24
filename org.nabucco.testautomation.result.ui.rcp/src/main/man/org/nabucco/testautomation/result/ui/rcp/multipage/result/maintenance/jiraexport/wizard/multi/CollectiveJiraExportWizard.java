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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.JiraAdapterConnector;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.page1.CollectiveJiraExportWizardPage1;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.page2.CollectiveJiraExportWizardPage2;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.page3.CollectiveJiraExportWizardPage3;



/**
 * SingleJiraExportWizard
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class CollectiveJiraExportWizard extends Wizard implements INewWizard {

	private static final String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jira.wizard.CollectiveJiraExportWizard";
	
	private CollectiveJiraExportWizardPage1 page1;

	private CollectiveJiraExportWizardPage3 page3;

	private CollectiveJiraExportWizardPage2 page2;
	
	private CollectiveJiraExportWizardModel collectiveJiraExportWizardModel;
	
	public CollectiveJiraExportWizard(TestConfigurationResult testConfigurationResult){
		this.collectiveJiraExportWizardModel = new CollectiveJiraExportWizardModel();
		this.collectiveJiraExportWizardModel.setTestConfigurationResult(testConfigurationResult);
		this.collectiveJiraExportWizardModel.setJiraAdapterConnector(new JiraAdapterConnector());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		setWindowTitle(I18N.i18n(ID + ".WindowTitle"));
		setDefaultPageImageDescriptor(ImageProvider.createImageDescriptor(ResultImageRegistry.ICON_JIRA_80X80.getId()));
		setNeedsProgressMonitor(true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		page1 = new CollectiveJiraExportWizardPage1(this.collectiveJiraExportWizardModel);
		page2 = new CollectiveJiraExportWizardPage2(this.collectiveJiraExportWizardModel);
		page3 = new CollectiveJiraExportWizardPage3(this.collectiveJiraExportWizardModel);
		addPage(page1);
		addPage(page2);
		addPage(page3);
	}

	@Override
	public boolean performFinish() {
		return this.collectiveJiraExportWizardModel.getJiraAdapterConnector().createIssue(this.collectiveJiraExportWizardModel);
	}
}
