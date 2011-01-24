/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.jira;

import java.util.List;

import org.nabucco.adapter.jira.JiraAdapterLocator;
import org.nabucco.adapter.jira.JiraFacade;
import org.nabucco.framework.base.facade.datatype.issuetracking.Project;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.testautomation.result.facade.message.jira.ProjectListMsg;


/**
 * GetProjectsServiceHandlerImpl<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public class GetProjectsServiceHandlerImpl extends GetProjectsServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected ProjectListMsg getProjects(EmptyServiceMessage msg) throws SearchException {
		try {
			JiraFacade jiraFacade = JiraAdapterLocator.getInstane().getAdapter();
			List<Project> projects = jiraFacade.getProjects();
			ProjectListMsg rs = new ProjectListMsg();
			rs.getProjects().addAll(projects);
			return rs;
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}