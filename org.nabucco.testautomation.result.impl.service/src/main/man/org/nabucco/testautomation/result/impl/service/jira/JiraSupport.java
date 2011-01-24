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

public class JiraSupport {


	private static final String SCREENSHOT_NAME_PREFIX = "Screenshot ";
	private static final String FILE_NAME_PREFIX = "Attachment ";
	private static final String SCREENSHOT_NAME_SUFFIX = ".png";

	public static synchronized void buildSummary(Issue clonedIssue, TestResult testResult) {
		Description summary = clonedIssue.getSummary();
		if(summary == null || summary.getValue() == null || summary.getValue().length() == 0){
			clonedIssue.setSummary(testResult.getName().getValue());
		} else {
			clonedIssue.setSummary(summary.getValue() + " " + testResult.getName().getValue());
		}
	}

	public static synchronized void buildDescription(Issue clonedIssue, TestResult testResult, IssueMsg msg) {
		if(testResult.getStatus() == TestConfigElementStatusType.FAILED){


			if(testResult instanceof ManualTestResult){
				ManualTestResult manualTestResult = (ManualTestResult) testResult;

				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(" ").append(testResult.getTestConfigElementKey().getValue());
					builder.append("\n");
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(" ").append(testResult.getTestConfigElementName().getValue());
					builder.append("\n");
				}
				if(msg.getEnvironmentType() != null){
					builder.append("Environment:").append(" ").append(msg.getEnvironmentType().getName());
					builder.append("\n");
				}
				if(msg.getReleaseType() != null){
					builder.append("Release:").append(" ").append(msg.getReleaseType().getName());
					builder.append("\n");
				}
				if(testResult.getBrandType() != null){
					builder.append("Brand:").append(" ").append(testResult.getBrandType().getName());
					builder.append("\n");
				}
				if(testResult.getStartTime() != null){
					builder.append("StartTime:").append(" ").append(testResult.getStartTime().getValue().toString());
					builder.append("\n");
				}
				if(manualTestResult.getState() != null){
					builder.append("State:").append(" ").append(manualTestResult.getState().name());
					builder.append("\n\n");
				}
				if(manualTestResult.getUserErrorMessage() != null){
					builder.append("User Error Message:").append("\n").append(manualTestResult.getUserErrorMessage());
				}

				// Append erroneous TestScriptResults
				appendErroneousTestScriptResults(testResult, builder);

				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + "\n\n" + builder.toString());
				}
			} else {
				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(" ").append(testResult.getTestConfigElementKey().getValue());
					builder.append("\n");
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(" ").append(testResult.getTestConfigElementName().getValue());
					builder.append("\n");
				}
				if(msg.getEnvironmentType() != null){
					builder.append("EnvironmentType:").append(" ").append(msg.getEnvironmentType().getName());
					builder.append("\n");
				}
				if(msg.getReleaseType() != null){
					builder.append("ReleaseType:").append(" ").append(msg.getReleaseType().getName());
					builder.append("\n");
				}
				if(testResult.getBrandType() != null){
					builder.append("BrandType:").append(" ").append(testResult.getBrandType().getName());
					builder.append("\n");
				}
				if(testResult.getStartTime() != null){
					builder.append("StartTime:").append(" ").append(testResult.getStartTime().getValue().toString());
					builder.append("\n");
				}
				if(testResult.getStatus() != null){
					builder.append("Status:").append(" ").append(testResult.getStatus().name());
					builder.append("\n\n");
				}
				if(testResult.getErrorMessage() != null){
					builder.append("ErrorMessage:").append("\n").append(testResult.getErrorMessage());
				}

				// Append erroneous TestScriptResults
				appendErroneousTestScriptResults(testResult, builder);

				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + "\n\n" + builder.toString());
				}
			}



			// Successful
		} else {

			if(testResult instanceof ManualTestResult){
				ManualTestResult manualTestResult = (ManualTestResult) testResult;

				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(" ").append(testResult.getTestConfigElementKey().getValue());
					builder.append("\n");
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(" ").append(testResult.getTestConfigElementName().getValue());
					builder.append("\n");
				}
				if(msg.getEnvironmentType() != null){
					builder.append("Environment:").append(" ").append(msg.getEnvironmentType().getName());
					builder.append("\n");
				}
				if(msg.getReleaseType() != null){
					builder.append("Release:").append(" ").append(msg.getReleaseType().getName());
					builder.append("\n");
				}
				if(testResult.getBrandType() != null){
					builder.append("Brand:").append(" ").append(testResult.getBrandType().getName());
					builder.append("\n");
				}
				if(testResult.getStartTime() != null){
					builder.append("Start Time:").append(" ").append(testResult.getStartTime().getValue().toString());
					builder.append("\n");
				}
				if(manualTestResult.getState() != null){
					builder.append("State:").append(" ").append(manualTestResult.getState().name());
					builder.append("\n\n");
				}
				if(manualTestResult.getUserMessage() != null){
					builder.append("User Message:").append("\n").append(manualTestResult.getUserMessage());
				}

				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + "\n\n" + builder.toString());
				}
			} else {
				// Description
				StringBuilder builder = new StringBuilder();
				if(testResult.getTestConfigElementKey() != null){
					builder.append("Test Configuration Element Key:").append(" ").append(testResult.getTestConfigElementKey().getValue());
					builder.append("\n");
				}
				if(testResult.getTestConfigElementName() != null){
					builder.append("Test Configuration Element Name:").append(" ").append(testResult.getTestConfigElementName().getValue());
					builder.append("\n");
				}
				if(msg.getEnvironmentType() != null){
					builder.append("Environment:").append(" ").append(msg.getEnvironmentType().getName());
					builder.append("\n");
				}
				if(msg.getReleaseType() != null){
					builder.append("Release:").append(" ").append(msg.getReleaseType().getName());
					builder.append("\n");
				}
				if(testResult.getBrandType() != null){
					builder.append("Brand:").append(" ").append(testResult.getBrandType().getName());
					builder.append("\n");
				}
				if(testResult.getStartTime() != null){
					builder.append("Start Time:").append(" ").append(testResult.getStartTime().getValue().toString());
					builder.append("\n");
				}
				if(testResult.getStatus() != null){
					builder.append("Status:").append(" ").append(testResult.getStatus().name());
					builder.append("\n\n");
				}
				if(testResult.getMessage() != null){
					builder.append("Message:").append("\n").append(testResult.getMessage());
				}
				Documentation description = clonedIssue.getDescription();
				if(description == null || description.getValue() == null || description.getValue().length() == 0){
					clonedIssue.setDescription(builder.toString());
				} else {
					clonedIssue.setDescription(description.getValue() + "\n\n" + builder.toString());
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
					builder.append("Test Script Key:").append(" ").append(testScriptResult.getTestScriptKey().getValue());
					builder.append("\n");
				}
				if(testScriptResult.getTestScriptName() != null){
					builder.append("Test Script Name:").append(" ").append(testScriptResult.getTestScriptName().getValue());
					builder.append("\n");
				}
				if(testScriptResult.getStatus() != null){
					builder.append("Status:").append(" ").append(testScriptResult.getStatus().name());
					builder.append("\n");
				}
				if(testScriptResult.getStartTime() != null){
					builder.append("Start Time:").append(" ").append(testScriptResult.getStartTime().getValue());
					builder.append("\n");
				}				
				if(testScriptResult.getErrorMessage() != null){
					builder.append("Error Message:").append("\n").append(testScriptResult.getErrorMessage());
				}

				List<ActionTrace> actionTraceList = testScriptResult.getActionTraceList();
				for (ActionTrace actionTrace : actionTraceList) {
					if(actionTrace instanceof MessageTrace){
						builder.append("\n\n\t-----------------------------");
						builder.append("\n\t------ Message Trace --------");
						builder.append("\n\t-----------------------------\n\n");
						MessageTrace messageTrace = (MessageTrace) actionTrace;
						if(messageTrace.getName() != null){
							builder.append("Name:").append(" ").append(messageTrace.getName().getValue());
							builder.append("\n");
						}
						if(messageTrace.getRequest() != null){
							builder.append("Request:").append(" ").append(messageTrace.getRequest().getValue());
							builder.append("\n");
						}
						if(messageTrace.getResponse() != null){
							builder.append("Response:").append(" ").append(messageTrace.getResponse().getValue());
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
