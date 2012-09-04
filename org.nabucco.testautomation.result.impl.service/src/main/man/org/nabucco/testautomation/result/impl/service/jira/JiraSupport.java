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

import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.documentation.Documentation;
import org.nabucco.framework.base.facade.datatype.issuetracking.FileAttachment;
import org.nabucco.framework.base.facade.datatype.issuetracking.Issue;
import org.nabucco.framework.base.facade.datatype.issuetracking.ScreenshotAttachment;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigElementStatusType;
import org.nabucco.testautomation.result.facade.datatype.status.TestScriptStatusType;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.FileTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.MessageTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;
import org.nabucco.testautomation.result.facade.message.jira.IssueMsg;

/**
 * JiraSupport
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class JiraSupport {

	private static final String NEW_LINE = "\n";

	private static final String SPACE = " ";

	private static final String SCREENSHOT_NAME_PREFIX = "Screenshot ";
	
	private static final String FILE_NAME_PREFIX = "Attachment ";
	
	private static final String SCREENSHOT_NAME_SUFFIX = ".png";

	public static synchronized void buildSummary(Issue clonedIssue, TestResult testResult) {
		Description summary = clonedIssue.getSummary();
		if(summary == null || summary.getValue() == null || summary.getValue().length() == 0){
			clonedIssue.setSummary(testResult.getName().getValue());
		} else {
			clonedIssue.setSummary(summary.getValue() + SPACE + testResult.getName().getValue());
		}
	}

	public static synchronized void buildDescription(Issue clonedIssue, TestResult testResult, IssueMsg msg) {
		if(testResult.getStatus() == TestConfigElementStatusType.FAILED){


			if(testResult instanceof ManualTestResult){
				ManualTestResult manualTestResult = (ManualTestResult) testResult;

				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(SPACE).append(testResult.getTestConfigElementKey().getValue());
					builder.append(NEW_LINE);
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(SPACE).append(testResult.getTestConfigElementName().getValue());
					builder.append(NEW_LINE);
				}
				if(msg.getEnvironmentType() != null){
					builder.append("Environment:").append(SPACE).append(msg.getEnvironmentType().getName());
					builder.append(NEW_LINE);
				}
				if(msg.getReleaseType() != null){
					builder.append("Release:").append(SPACE).append(msg.getReleaseType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getBrandType() != null){
					builder.append("Brand:").append(SPACE).append(testResult.getBrandType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getStartTime() != null){
					builder.append("StartTime:").append(SPACE).append(testResult.getStartTime().getValue().toString());
					builder.append(NEW_LINE);
				}
				if(manualTestResult.getState() != null){
					builder.append("State:").append(SPACE).append(manualTestResult.getState().name());
					builder.append(NEW_LINE);
					builder.append(NEW_LINE);
				}
				if(manualTestResult.getUserErrorMessage() != null){
					builder.append("User Error Message:").append(NEW_LINE).append(manualTestResult.getUserErrorMessage());
				}

				// Append erroneous TestScriptResults
				appendErroneousTestScriptResults(testResult, builder);

				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + NEW_LINE + NEW_LINE + builder.toString());
				}
			} else {
				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(SPACE).append(testResult.getTestConfigElementKey().getValue());
					builder.append(NEW_LINE);
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(SPACE).append(testResult.getTestConfigElementName().getValue());
					builder.append(NEW_LINE);
				}
				if(msg.getEnvironmentType() != null){
					builder.append("EnvironmentType:").append(SPACE).append(msg.getEnvironmentType().getName());
					builder.append(NEW_LINE);
				}
				if(msg.getReleaseType() != null){
					builder.append("ReleaseType:").append(SPACE).append(msg.getReleaseType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getBrandType() != null){
					builder.append("BrandType:").append(SPACE).append(testResult.getBrandType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getStartTime() != null){
					builder.append("StartTime:").append(SPACE).append(testResult.getStartTime().getValue().toString());
					builder.append(NEW_LINE);
				}
				if(testResult.getStatus() != null){
					builder.append("Status:").append(SPACE).append(testResult.getStatus().name());
					builder.append(NEW_LINE);
					builder.append(NEW_LINE);
				}
				if(testResult.getErrorMessage() != null){
					builder.append("ErrorMessage:").append(NEW_LINE).append(testResult.getErrorMessage());
				}

				// Append erroneous TestScriptResults
				appendErroneousTestScriptResults(testResult, builder);

				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + NEW_LINE + NEW_LINE + builder.toString());
				}
			}



			// Successful
		} else {

			if(testResult instanceof ManualTestResult){
				ManualTestResult manualTestResult = (ManualTestResult) testResult;

				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(SPACE).append(testResult.getTestConfigElementKey().getValue());
					builder.append(NEW_LINE);
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(SPACE).append(testResult.getTestConfigElementName().getValue());
					builder.append(NEW_LINE);
				}
				if(msg.getEnvironmentType() != null){
					builder.append("Environment:").append(SPACE).append(msg.getEnvironmentType().getName());
					builder.append(NEW_LINE);
				}
				if(msg.getReleaseType() != null){
					builder.append("Release:").append(SPACE).append(msg.getReleaseType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getBrandType() != null){
					builder.append("Brand:").append(SPACE).append(testResult.getBrandType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getStartTime() != null){
					builder.append("Start Time:").append(SPACE).append(testResult.getStartTime().getValue().toString());
					builder.append(NEW_LINE);
				}
				if(manualTestResult.getState() != null){
					builder.append("State:").append(SPACE).append(manualTestResult.getState().name());
					builder.append(NEW_LINE);
					builder.append(NEW_LINE);
				}
				if(manualTestResult.getUserMessage() != null){
					builder.append("User Message:").append(NEW_LINE).append(manualTestResult.getUserMessage());
				}

				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + NEW_LINE + NEW_LINE + builder.toString());
				}
			} else {
				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(SPACE).append(testResult.getTestConfigElementKey().getValue());
					builder.append(NEW_LINE);
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(SPACE).append(testResult.getTestConfigElementName().getValue());
					builder.append(NEW_LINE);
				}
				if(msg.getEnvironmentType() != null){
					builder.append("Environment:").append(SPACE).append(msg.getEnvironmentType().getName());
					builder.append(NEW_LINE);
				}
				if(msg.getReleaseType() != null){
					builder.append("Release:").append(SPACE).append(msg.getReleaseType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getBrandType() != null){
					builder.append("Brand:").append(SPACE).append(testResult.getBrandType().getName());
					builder.append(NEW_LINE);
				}
				if(testResult.getStartTime() != null){
					builder.append("Start Time:").append(SPACE).append(testResult.getStartTime().getValue().toString());
					builder.append(NEW_LINE);
				}
				if(testResult.getStatus() != null){
					builder.append("Status:").append(SPACE).append(testResult.getStatus().name());
					builder.append(NEW_LINE);
					builder.append(NEW_LINE);
				}
				if(testResult.getMessage() != null){
					builder.append("Message:").append(NEW_LINE).append(testResult.getMessage());
				}
				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + NEW_LINE + NEW_LINE + builder.toString());
				}
			}
		}

	}

	private static synchronized void appendErroneousTestScriptResults(TestResult testResult, StringBuilder builder) {
		List<TestScriptResult> testScriptResultList = testResult.getTestScriptResultList();
		for (TestScriptResult testScriptResult : testScriptResultList) {
			if(testScriptResult.getStatus() == TestScriptStatusType.FAILED){
				builder.append("\n\n\n-----------------------------");
				builder.append("\n- Failed Test Script -");
				builder.append("\n-----------------------------\n\n");

				if(testScriptResult.getTestScriptKey() != null){
					builder.append("Test Script Key:").append(SPACE).append(testScriptResult.getTestScriptKey().getValue());
					builder.append(NEW_LINE);
				}
				if(testScriptResult.getTestScriptName() != null){
					builder.append("Test Script Name:").append(SPACE).append(testScriptResult.getTestScriptName().getValue());
					builder.append(NEW_LINE);
				}
				if(testScriptResult.getStatus() != null){
					builder.append("Status:").append(SPACE).append(testScriptResult.getStatus().name());
					builder.append(NEW_LINE);
				}
				if(testScriptResult.getStartTime() != null){
					builder.append("Start Time:").append(SPACE).append(testScriptResult.getStartTime().getValue());
					builder.append(NEW_LINE);
				}				
				if(testScriptResult.getErrorMessage() != null){
					builder.append("Error Message:").append(NEW_LINE).append(testScriptResult.getErrorMessage());
				}

				List<ActionTrace> actionTraceList = testScriptResult.getActionTraceList();
				for (ActionTrace actionTrace : actionTraceList) {
					if(actionTrace instanceof MessageTrace){
						builder.append("\n\n\t-----------------------------");
						builder.append("\n\t------ Message Trace --------");
						builder.append("\n\t-----------------------------\n\n");
						MessageTrace messageTrace = (MessageTrace) actionTrace;
						if(messageTrace.getName() != null){
							builder.append("Name:").append(SPACE).append(messageTrace.getName().getValue());
							builder.append(NEW_LINE);
						}
						if(messageTrace.getRequest() != null){
							builder.append("Request:").append(SPACE).append(messageTrace.getRequest().getValue());
							builder.append(NEW_LINE);
						}
						if(messageTrace.getResponse() != null){
							builder.append("Response:").append(SPACE).append(messageTrace.getResponse().getValue());
						}
					}
				}
			}
		}
	}

	public static void addAttachments(Issue clonedIssue, TestResult testResult, boolean onlyFailedScripts) {
		if(testResult instanceof ManualTestResult){
			ManualTestResult manualTestResult = (ManualTestResult) testResult;
			List<ActionTrace> actionTraceList = manualTestResult.getActionTraceList();
			for (ActionTrace actionTrace : actionTraceList) {
				if(actionTrace instanceof ScreenshotTrace){
					ScreenshotAttachment screenshotAttachment = new ScreenshotAttachment();
					screenshotAttachment.setImage(((ScreenshotTrace) actionTrace).getScreenshot());
					screenshotAttachment.setName(SCREENSHOT_NAME_PREFIX + (actionTraceList.indexOf(actionTrace) + 1) + SCREENSHOT_NAME_SUFFIX);
					clonedIssue.getScreenshotAttachments().add(screenshotAttachment);
				} else if(actionTrace instanceof ActionTrace){
					FileAttachment fileAttachment = new FileAttachment();
					fileAttachment.setData(((FileTrace) actionTrace).getFileContent());
					fileAttachment.setName(actionTrace.getName());
					clonedIssue.getFileAttachments().add(fileAttachment);
				}
			}
		} else {
			List<TestScriptResult> testScriptResultList = testResult.getTestScriptResultList();
			for (TestScriptResult testScriptResult : testScriptResultList) {
				if(!onlyFailedScripts || testScriptResult.getStatus() == TestScriptStatusType.FAILED){
					List<ActionTrace> actionTraceList = testScriptResult.getActionTraceList();
					for (ActionTrace actionTrace : actionTraceList) {
						if(actionTrace instanceof ScreenshotTrace){
							ScreenshotAttachment screenshotAttachment = new ScreenshotAttachment();
							screenshotAttachment.setImage(((ScreenshotTrace) actionTrace).getScreenshot());
							screenshotAttachment.setName(SCREENSHOT_NAME_PREFIX + (actionTraceList.indexOf(actionTrace) + 1) + SCREENSHOT_NAME_SUFFIX);
							clonedIssue.getScreenshotAttachments().add(screenshotAttachment);
						} else if(actionTrace instanceof FileTrace){
							FileAttachment fileAttachment = new FileAttachment();
							fileAttachment.setData(((FileTrace) actionTrace).getFileContent());
							fileAttachment.setName(FILE_NAME_PREFIX + (actionTraceList.indexOf(actionTrace) + 1));
							clonedIssue.getFileAttachments().add(fileAttachment);
						}
					}
				}
			}
		}
	}

}
