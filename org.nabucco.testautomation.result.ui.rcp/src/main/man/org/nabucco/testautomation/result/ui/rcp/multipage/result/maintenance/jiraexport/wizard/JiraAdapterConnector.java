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

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.base.facade.datatype.issuetracking.Issue;
import org.nabucco.framework.base.facade.datatype.issuetracking.IssueType;
import org.nabucco.framework.base.facade.datatype.issuetracking.Priority;
import org.nabucco.framework.base.facade.datatype.issuetracking.Project;
import org.nabucco.framework.base.facade.datatype.issuetracking.ProjectComponent;
import org.nabucco.framework.base.facade.datatype.issuetracking.Version;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.testautomation.result.facade.message.jira.ComponentListMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueTypeListMsg;
import org.nabucco.testautomation.result.facade.message.jira.PriorityListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;
import org.nabucco.testautomation.result.facade.message.jira.VersionListMsg;
import org.nabucco.testautomation.result.ui.rcp.communication.ResultComponentServiceDelegateFactory;
import org.nabucco.testautomation.result.ui.rcp.communication.jira.JiraServiceDelegate;


/**
 * JiraAdapterConnector
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class JiraAdapterConnector {

	private static ResultComponentServiceDelegateFactory resultComponentServiceDelegateFactory = ResultComponentServiceDelegateFactory.getInstance();
	
	public List<Project> getAvailableProjects() {

		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();

			ProjectListMsg rs = jiraService.getProjects(new EmptyServiceMessage());
			List<Project> projects = rs.getProjects();
			
			return projects;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return new ArrayList<Project>();
	}

	public List<IssueType> getIssueTypesForProject(Project project) {
		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();

			ProjectMsg rq = new ProjectMsg();
			rq.setProject(project);
			IssueTypeListMsg rs = jiraService.getIssueTypesOfProject(rq);
			List<IssueType> issueTypes = rs.getIssueTypes();
			
			return issueTypes;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return new ArrayList<IssueType>();
	}

	public List<ProjectComponent> getComponentsForProject(Project project) {
		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();

			ProjectMsg rq = new ProjectMsg();
			rq.setProject(project);
			ComponentListMsg rs = jiraService.getComponentsOfProject(rq);
			List<ProjectComponent> components = rs.getComponents();
			
			return components;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return new ArrayList<ProjectComponent>();
	}

	public List<Version> getVersionsForProject(Project project) {
		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();
			
			ProjectMsg rq = new ProjectMsg();
			rq.setProject(project);
			VersionListMsg rs = jiraService.getVersionsOfProject(rq);
			List<Version> versions = rs.getVersions();
			
			return versions;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return new ArrayList<Version>();
	}

	public List<Priority> getPriorities() {
		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();

			PriorityListMsg rs = jiraService.getPriorities(new EmptyServiceMessage());
			List<Priority> priorities = rs.getPriorities();
			
			return priorities;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return new ArrayList<Priority>();
	}

	public boolean createIssue(JiraExportWizardModel jiraExportWizardModel) {

		Issue issue = new Issue();
		issue.getComponents().addAll(jiraExportWizardModel.getSelectedComponents());
		issue.getAffectedVersions().addAll(jiraExportWizardModel.getSelectedVersions());
		issue.setDescription(jiraExportWizardModel.getDescription());
		issue.setPriority(jiraExportWizardModel.getPriority());
		issue.setProject(jiraExportWizardModel.getProject());
		issue.setSummary(jiraExportWizardModel.getSummary());
		issue.setIssueType(jiraExportWizardModel.getIssueType());
		
		if(jiraExportWizardModel.getDueDate() != null){
			issue.setDueDate(jiraExportWizardModel.getDueDate().getTime());
		}
		
		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();

			IssueMsg rq = new IssueMsg();
			rq.setIssue(issue);
			rq.setEnvironmentType(jiraExportWizardModel.getTestConfigurationResult().getEnvironmentType());
			rq.setReleaseType(jiraExportWizardModel.getTestConfigurationResult().getReleaseType());
			rq.getTestResults().addAll(jiraExportWizardModel.getSelectedTestResults());
			jiraService.createIssues(rq);
			
			return true;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return false;
		
	}
	
}
