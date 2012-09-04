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
package org.nabucco.testautomation.result.impl.service.jira;

import java.util.List;

import javax.naming.InitialContext;

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
				
				JiraFacade jiraFacade = JiraAdapterLocator.getInstane().getAdapter(new InitialContext());
				jiraFacade.createIssue(clonedIssue);
			}
			return msg;
		} catch (Exception e) {
			throw new MaintainException(e);
		}
	}

}
