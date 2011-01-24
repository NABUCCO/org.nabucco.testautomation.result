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

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.nabucco.framework.base.facade.datatype.issuetracking.IssueType;
import org.nabucco.framework.base.facade.datatype.issuetracking.Priority;
import org.nabucco.framework.base.facade.datatype.issuetracking.Project;
import org.nabucco.framework.base.facade.datatype.issuetracking.ProjectComponent;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.JiraAdapterConnector;



/**
 * SingleJiraExportWizardModel
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class CollectiveJiraExportWizardModel {

	private JiraAdapterConnector jiraAdapterConnector = new JiraAdapterConnector();
	
	private Project project;

	private IssueType issueType;
	
	private ProjectComponent component;
	
	private TestConfigurationResult testConfigurationResult;
	
	private Priority priority;
	
	private String summary;
	
	private String description;
	
	private Date dueDate;
	
	List<ProjectComponent> components = new ArrayList<ProjectComponent>();

	private Set<PropertyChangeListener> listener = new HashSet<PropertyChangeListener>();

	private List<TestResult> selectedTestResults;
	
	/**
	 * @return the jiraAdapterConnector
	 */
	public JiraAdapterConnector getJiraAdapterConnector() {
		return jiraAdapterConnector;
	}

	/**
	 * @param jiraAdapterConnector the jiraAdapterConnector to set
	 */
	public void setJiraAdapterConnector(JiraAdapterConnector jiraAdapterConnector) {
		this.jiraAdapterConnector = jiraAdapterConnector;
	}

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
		this.components.clear();
		if(project != null){
			this.components.addAll(this.jiraAdapterConnector.getComponentsForProject(project));
		}
		for (PropertyChangeListener propertyChangeListener : this.listener) {
			propertyChangeListener.propertyChange(new PropertyChangeEvent(this, "project", null, null));
		}
	}

	/**
	 * @return the issueType
	 */
	public IssueType getIssueType() {
		return issueType;
	}

	/**
	 * @param issueType the issueType to set
	 */
	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}

	/**
	 * @return the component
	 */
	public ProjectComponent getComponent() {
		return component;
	}

	/**
	 * @param component the component to set
	 */
	public void setComponent(ProjectComponent component) {
		this.component = component;
	}

	/**
	 * @return the testConfigurationResult
	 */
	public TestConfigurationResult getTestConfigurationResult() {
		return testConfigurationResult;
	}

	/**
	 * @param testConfigurationResult the testConfigurationResult to set
	 */
	public void setTestConfigurationResult(TestConfigurationResult testConfigurationResult) {
		this.testConfigurationResult = testConfigurationResult;
	}

	/**
	 * @return the priority
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(Priority priority) {
		this.priority = priority;
	}


	public void addListener(PropertyChangeListener propertyChangeListener){
		this.listener.add(propertyChangeListener);
	}

	public List<ProjectComponent> getComponents() {
		return this.components;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param descriptio the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @param components the components to set
	 */
	public void setComponents(List<ProjectComponent> components) {
		this.components = components;
	}

	/**
	 * @return the selectedTestResults
	 */
	public List<TestResult> getSelectedTestResults() {
		return selectedTestResults;
	}

	/**
	 * @param selectedTestResults the selectedTestResults to set
	 */
	public void setSelectedTestResults(List<TestResult> selectedTestResults) {
		this.selectedTestResults = selectedTestResults;
	}

	
	
	
}