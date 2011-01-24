package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.base.facade.datatype.issuetracking.Issue;
import org.nabucco.framework.base.facade.datatype.issuetracking.IssueType;
import org.nabucco.framework.base.facade.datatype.issuetracking.Priority;
import org.nabucco.framework.base.facade.datatype.issuetracking.Project;
import org.nabucco.framework.base.facade.datatype.issuetracking.ProjectComponent;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.message.jira.ComponentListMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;
import org.nabucco.testautomation.result.facade.message.jira.IssueTypeListMsg;
import org.nabucco.testautomation.result.facade.message.jira.PriorityListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;
import org.nabucco.testautomation.result.ui.rcp.communication.ResultComponentServiceDelegateFactory;
import org.nabucco.testautomation.result.ui.rcp.communication.jira.JiraServiceDelegate;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.CollectiveJiraExportWizardModel;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.SingleJiraExportWizardModel;

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


	public boolean createIssue(CollectiveJiraExportWizardModel collectiveJiraExportWizardModel) {
		Issue issue = new Issue();
		issue.setComponent(collectiveJiraExportWizardModel.getComponent());
		issue.setDescription(collectiveJiraExportWizardModel.getDescription());
		if(collectiveJiraExportWizardModel.getDueDate() != null){
			issue.setDueDate(collectiveJiraExportWizardModel.getDueDate().getTime());
		}
		issue.setPriority(collectiveJiraExportWizardModel.getPriority());
		issue.setProject(collectiveJiraExportWizardModel.getProject());
		issue.setSummary(collectiveJiraExportWizardModel.getSummary());
		issue.setIssueType(collectiveJiraExportWizardModel.getIssueType());
		
		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();

			IssueMsg rq = new IssueMsg();
			rq.setIssue(issue);
			rq.setEnvironmentType(collectiveJiraExportWizardModel.getTestConfigurationResult().getEnvironmentType());
			rq.setReleaseType(collectiveJiraExportWizardModel.getTestConfigurationResult().getReleaseType());
			rq.getTestResults().addAll(collectiveJiraExportWizardModel.getSelectedTestResults());
			jiraService.createIssues(rq);
			
			return true;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return false;
		
	}
	
	public boolean createIssue(SingleJiraExportWizardModel singleJiraExportWizardModel) {
		Issue issue = new Issue();
		issue.setComponent(singleJiraExportWizardModel.getComponent());
		issue.setDescription(singleJiraExportWizardModel.getDescription());
		if(singleJiraExportWizardModel.getDueDate() != null){
			issue.setDueDate(singleJiraExportWizardModel.getDueDate().getTime());
		}
		issue.setPriority(singleJiraExportWizardModel.getPriority());
		issue.setProject(singleJiraExportWizardModel.getProject());
		issue.setSummary(singleJiraExportWizardModel.getSummary());
		issue.setIssueType(singleJiraExportWizardModel.getIssueType());
		
		ArrayList<TestResult> testResults = new ArrayList<TestResult>();
		testResults.add(singleJiraExportWizardModel.getSelectedTestResult());
		
		try {
			JiraServiceDelegate jiraService = resultComponentServiceDelegateFactory.getJiraService();

			IssueMsg rq = new IssueMsg();
			rq.setIssue(issue);
			rq.setEnvironmentType(singleJiraExportWizardModel.getTestConfigurationResult().getEnvironmentType());
			rq.setReleaseType(singleJiraExportWizardModel.getTestConfigurationResult().getReleaseType());
			rq.getTestResults().addAll(testResults);
			jiraService.createIssue(rq);
			
			return true;
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return false;
		
	}

}
