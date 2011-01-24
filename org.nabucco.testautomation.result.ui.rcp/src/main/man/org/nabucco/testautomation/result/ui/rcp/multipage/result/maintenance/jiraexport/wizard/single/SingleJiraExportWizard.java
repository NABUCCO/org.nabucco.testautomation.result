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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.JiraAdapterConnector;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.page1.SingleJiraExportWizardPage1;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.page2.SingleJiraExportWizardPage2;



/**
 * SingleJiraExportWizard
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SingleJiraExportWizard extends Wizard implements INewWizard {

	private static final String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jira.wizard.CollectiveJiraExportWizard";
	
	private SingleJiraExportWizardPage1 page1;

	private SingleJiraExportWizardPage2 page2;
	
	private SingleJiraExportWizardModel singleJiraExportWizardModel;
	
	public SingleJiraExportWizard(TestConfigurationResult testConfigurationResult, TestResult testResult){
		this.singleJiraExportWizardModel = new SingleJiraExportWizardModel();
		this.singleJiraExportWizardModel.setSelectedTestResult(testResult);
		this.singleJiraExportWizardModel.setTestConfigurationResult(testConfigurationResult);
		this.singleJiraExportWizardModel.setJiraAdapterConnector(new JiraAdapterConnector());
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
		page1 = new SingleJiraExportWizardPage1(this.singleJiraExportWizardModel);
		page2 = new SingleJiraExportWizardPage2(this.singleJiraExportWizardModel);
		addPage(page1);
		addPage(page2);
	}

	@Override
	public boolean performFinish() {
		return this.singleJiraExportWizardModel.getJiraAdapterConnector().createIssue(this.singleJiraExportWizardModel);
	}
}
