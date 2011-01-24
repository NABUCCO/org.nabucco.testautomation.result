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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.page2;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.base.facade.datatype.issuetracking.Priority;
import org.nabucco.framework.base.facade.datatype.issuetracking.ProjectComponent;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.SingleJiraExportWizardModel;


/**
 * SingleJiraExportWizardPage2
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SingleJiraExportWizardPage2 extends WizardPage implements PropertyChangeListener {

	public static final String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jira.wizard.SingleJiraExportWizardPage2";

	private SingleJiraExportWizardModel wizardModel;

	private Combo componentCombo;

	private Combo priorityCombo;

	private Text summaryText;

	private Text descriptionText;
	
	private DateTime dateTime;
	
	private Map<String, ProjectComponent> componentNameToComponentMap = new HashMap<String, ProjectComponent>();

	private Map<String, Priority> priorityNameToPriorityMap = new HashMap<String, Priority>();


	/**
	 * Constructs and initializes a new page instance.
	 */
	public SingleJiraExportWizardPage2(SingleJiraExportWizardModel collectiveJiraExportWizardModel) {
		super(I18N.i18n(ID + ".title"));
		this.setDescription(I18N.i18n(ID + ".description"));
		this.wizardModel = collectiveJiraExportWizardModel;
		this.wizardModel.addListener(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayout(new GridLayout(2, false));

		// Summary
		Label label = new Label(plate, SWT.NONE);
		label.setText(I18N.i18n(ID + ".summary"));
		this.summaryText = new Text(plate, SWT.BORDER);
		GridData layoutData = new GridData();
		layoutData.widthHint = 500;
		this.summaryText.setLayoutData(layoutData);
		this.summaryText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				wizardModel.setSummary(summaryText.getText());
				setPageComplete(validatePage());
			}
		});

		// Priority
		label = new Label(plate, SWT.NONE);
		label.setText(I18N.i18n(ID + ".priority"));
		this.priorityCombo = new Combo(plate, SWT.DROP_DOWN);

		List<Priority> priorities = this.wizardModel.getJiraAdapterConnector().getPriorities();
		List<String> priorityNames = new ArrayList<String>();
		for (Priority priority : priorities) {
			priorityNames.add(priority.getName().getValue());
			priorityNameToPriorityMap.put(priority.getName().getValue(), priority);
		}
		this.priorityCombo.setItems(priorityNames.toArray(new String[priorityNames.size()]));
		this.priorityCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String selectedPriority = priorityCombo.getItem(priorityCombo.getSelectionIndex());
				Priority priority = priorityNameToPriorityMap.get(selectedPriority);
				wizardModel.setPriority(priority);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		});


		// DueDate
		label = new Label(plate, SWT.NONE);
		label.setText(I18N.i18n(ID + ".dueDate"));
		this.dateTime = new DateTime (plate, SWT.DATE | SWT.DROP_DOWN | SWT.BORDER);
		this.dateTime.addSelectionListener (new SelectionAdapter () {

			@Override
			public void widgetSelected (SelectionEvent e) {
				Calendar calendar = Calendar.getInstance();
				calendar.clear();
		        calendar.set(Calendar.YEAR, dateTime.getYear());
		        calendar.set(Calendar.MONTH, dateTime.getMonth());
		        calendar.set(Calendar.DAY_OF_MONTH, dateTime.getDay());
		        Date date = calendar.getTime();
				wizardModel.setDueDate(date);
				setPageComplete(validatePage());
			}
		});

		// Component
		label = new Label(plate, SWT.NONE);
		label.setText(I18N.i18n(ID + ".component"));
		this.componentCombo = new Combo(plate, SWT.DROP_DOWN);

		List<ProjectComponent> components = this.wizardModel.getComponents();
		if(components.size() > 0){
			List<String> componentNames = new ArrayList<String>();
			for (ProjectComponent component : components) {
				componentNames.add(component.getName().getValue());
				componentNameToComponentMap.put(component.getName().getValue(), component);
			}
			this.componentCombo.setItems(componentNames.toArray(new String[componentNames.size()]));
		}
		this.componentCombo.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				String selectedComponent = componentCombo.getItem(componentCombo.getSelectionIndex());
				ProjectComponent component = componentNameToComponentMap.get(selectedComponent);
				wizardModel.setComponent(component);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		});
		
		// Description
		label = new Label(plate, SWT.NONE);
		label.setText(I18N.i18n(ID + ".fieldDescription"));
		this.descriptionText = new Text(plate, SWT.BORDER);
		layoutData = new GridData();
		layoutData.widthHint = 450;
		layoutData.heightHint = 500;
		this.descriptionText.setLayoutData(layoutData);
		this.descriptionText.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent arg0) {
				wizardModel.setDescription(descriptionText.getText());
				setPageComplete(validatePage());
			}
		});

		setControl(plate);
		setPageComplete(validatePage());
	}




	private boolean validatePage() {
		return true;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("project")){
			List<ProjectComponent> components = this.wizardModel.getComponents();
			List<String> componentNames = new ArrayList<String>();
			for (ProjectComponent component : components) {
				componentNames.add(component.getName().getValue());
				componentNameToComponentMap.put(component.getName().getValue(), component);
			}
			this.componentCombo.removeAll();
			this.componentCombo.setItems(componentNames.toArray(new String[componentNames.size()]));
			this.componentCombo.redraw();
			this.componentCombo.update();
		}
	}




}


