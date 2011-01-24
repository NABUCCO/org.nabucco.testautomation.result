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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.page1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.nabucco.framework.base.facade.datatype.issuetracking.IssueType;
import org.nabucco.framework.base.facade.datatype.issuetracking.Project;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.SingleJiraExportWizardModel;


/**
 * CollectiveJiraExportWizardPage1
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SingleJiraExportWizardPage1 extends WizardPage {

	public static final String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jira.wizard.SingleJiraExportWizardPage1";
	
	private Combo projectCombo;
	
	private SingleJiraExportWizardModel wizardModel;

	private Combo issueTypeCombo;
	
	private Map<String, Project> projectNameToProjectMap = new HashMap<String, Project>();
	
	private Map<String, IssueType> issueTypeNameToKeyMap = new HashMap<String, IssueType>();

	/**
	 * Constructs and initializes a new page instance.
	 */
	public SingleJiraExportWizardPage1(SingleJiraExportWizardModel singleJiraExportWizardModel) {
		super(I18N.i18n(ID + ".title"));
		this.setDescription(I18N.i18n(ID + ".description"));
		setImageDescriptor(ImageProvider.createImageDescriptor(ResultImageRegistry.ICON_JIRA_80X80.getId()));
		this.wizardModel = singleJiraExportWizardModel;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayout(new GridLayout(2, false));

		Label label = new Label(plate, SWT.NONE);
		label.setText(I18N.i18n(ID + ".project"));
		this.projectCombo = new Combo(plate, SWT.DROP_DOWN);
		label = new Label(plate, SWT.NONE);
		label.setText(I18N.i18n(ID + ".issueType"));
		this.issueTypeCombo = new Combo(plate, SWT.DROP_DOWN);
		
		List<Project> projects = this.wizardModel.getJiraAdapterConnector().getAvailableProjects();
		List<String> projectNames = new ArrayList<String>();
		for (Project project : projects) {
			projectNames.add(project.getName().getValue());
			projectNameToProjectMap.put(project.getName().getValue(), project);
		}
		this.projectCombo.setItems(projectNames.toArray(new String[projectNames.size()]));

		this.projectCombo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String selectedProject = projectCombo.getItem(projectCombo.getSelectionIndex());
				Project project = projectNameToProjectMap.get(selectedProject);
				wizardModel.setProject(project);
				List<IssueType> issueTypes = wizardModel.getJiraAdapterConnector().getIssueTypesForProject(project);
				List<String> issueTypeNames = new ArrayList<String>();
				for (IssueType issueType : issueTypes) {
					issueTypeNames.add(issueType.getName().getValue());
					issueTypeNameToKeyMap.put(issueType.getName().getValue(), issueType);
				}
				issueTypeCombo.setItems(issueTypeNames.toArray(new String[issueTypeNames.size()]));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		});
		
		this.issueTypeCombo.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String selectedIssueTypeName = issueTypeCombo.getItem(issueTypeCombo.getSelectionIndex());
				IssueType issueType = issueTypeNameToKeyMap.get(selectedIssueTypeName);
				wizardModel.setIssueType(issueType);
				setPageComplete(validatePage());
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		});
		setControl(plate);
		setPageComplete(validatePage());
	}


	

	private boolean validatePage() {
		if (this.projectCombo.getSelectionIndex() >= 0 && this.issueTypeCombo.getSelectionIndex() >= 0) {
			setErrorMessage(null);
			return true;
		}
		setErrorMessage(I18N.i18n(ID + ".noSelection"));
		return false;
	}
	
	

	
}


