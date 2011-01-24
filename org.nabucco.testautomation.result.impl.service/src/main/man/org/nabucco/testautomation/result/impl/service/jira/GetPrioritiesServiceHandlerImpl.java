/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.jira;

import java.util.List;

import org.nabucco.adapter.jira.JiraAdapterLocator;
import org.nabucco.adapter.jira.JiraFacade;
import org.nabucco.framework.base.facade.datatype.issuetracking.Priority;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.testautomation.result.facade.message.jira.PriorityListMsg;


/**
 * GetProjectsServiceHandlerImpl<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public class GetPrioritiesServiceHandlerImpl extends GetPrioritiesServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected PriorityListMsg getPriorities(EmptyServiceMessage msg) throws SearchException {
		try {
			JiraFacade jiraFacade = JiraAdapterLocator.getInstane().getAdapter();
			List<Priority> priorities = jiraFacade.getPriorities();
			PriorityListMsg rs = new PriorityListMsg();
			rs.getPriorities().addAll(priorities);
			return rs;
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
}