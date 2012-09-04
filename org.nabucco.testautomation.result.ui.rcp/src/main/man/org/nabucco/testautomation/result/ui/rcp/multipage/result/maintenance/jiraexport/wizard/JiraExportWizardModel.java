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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard;

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
import org.nabucco.framework.base.facade.datatype.issuetracking.Version;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;


/**
 * JiraExportWizardModel
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class JiraExportWizardModel {

	private JiraAdapterConnector jiraAdapterConnector = new JiraAdapterConnector();
	
	private Project project;

	private IssueType issueType;
	
	private Priority priority;
	
	private String summary;
	
	private String description;
	
	private Date dueDate;

	private TestConfigurationResult testConfigurationResult;

	private List<ProjectComponent> selectedComponents = new ArrayList<ProjectComponent>();
	
	private List<ProjectComponent> possibleComponents = new ArrayList<ProjectComponent>();
	
	private List<Version> selectedVersions = new ArrayList<Version>();

	private List<Version> possibleVersions = new ArrayList<Version>();

	private List<TestResult> selectedTestResults = new ArrayList<TestResult>();

	private Set<PropertyChangeListener> listener = new HashSet<PropertyChangeListener>();
	
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
		this.possibleComponents.clear();
		this.possibleVersions.clear();
		
		if(project != null){
			this.possibleComponents.addAll(this.jiraAdapterConnector.getComponentsForProject(project));
			this.possibleVersions.addAll(this.jiraAdapterConnector.getVersionsForProject(project));
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
	public List<ProjectComponent> getSelectedComponents() {
		return selectedComponents;
	}

	/**
	 * @param component the component to set
	 */
	public void addSelectedComponent(ProjectComponent component) {
		this.selectedComponents.add(component);
	}
	
	/**
	 * @param version the version to add
	 */
	public void addSelectedVersion(Version version) {
		this.selectedVersions.add(version);
	}
	
	/**
	 * @return the selected versions
	 */
	public List<Version> getSelectedVersions() {
		return selectedVersions;
	}
	
	public List<Version> getPossibleVersions() {
		return this.possibleVersions;
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

	public List<ProjectComponent> getPossibleComponents() {
		return this.possibleComponents;
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
	public void setPossibleComponents(List<ProjectComponent> components) {
		this.possibleComponents = components;
	}

	/**
	 * @return the selectedTestResults
	 */
	public List<TestResult> getSelectedTestResults() {
		return selectedTestResults;
	}

	/**
	 * @param selectedTestResult the selectedTestResult to add
	 */
	public void addSelectedTestResult(TestResult selectedTestResult) {
		this.selectedTestResults.add(selectedTestResult);
	}
	
}
