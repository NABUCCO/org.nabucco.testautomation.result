/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.jira;

import java.util.List;

import org.nabucco.adapter.jira.JiraAdapterLocator;
import org.nabucco.adapter.jira.JiraFacade;
import org.nabucco.framework.base.facade.datatype.issuetracking.Issue;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigElementStatusType;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;

/**
 * CreateIssueServiceHandlerImpl<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public class CreateIssuesServiceHandlerImpl extends CreateIssuesServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected IssueMsg createIssues(IssueMsg msg) throws MaintainException {
		try {
			Issue issue = msg.getIssue();
			List<TestResult> testResults = msg.getTestResults();
			for (TestResult testResult : testResults) {
				Issue clonedIssue = issue.cloneObject();
				// Summary
				JiraSupport.buildSummary(clonedIssue, testResult);
				// Description
				JiraSupport.buildDescription(clonedIssue, testResult, msg);
				// Attachments
				JiraSupport.addAttachments(clonedIssue, testResult, (testResult.getStatus() == TestConfigElementStatusType.FAILED));
				
				JiraFacade jiraFacade = JiraAdapterLocator.getInstane().getAdapter();
				jiraFacade.createIssue(clonedIssue);
			}
			return msg;
		} catch (Exception e) {
			throw new MaintainException(e);
		}
	}


}
