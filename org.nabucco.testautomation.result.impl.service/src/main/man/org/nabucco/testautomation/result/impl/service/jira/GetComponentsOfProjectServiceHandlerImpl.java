/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.impl.service.jira;

import java.util.List;

import org.nabucco.adapter.jira.JiraAdapterLocator;
import org.nabucco.adapter.jira.JiraFacade;
import org.nabucco.framework.base.facade.datatype.issuetracking.ProjectComponent;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.testautomation.result.facade.message.jira.ComponentListMsg;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;

/**
 * GetComponentsOfProjectServiceHandlerImpl<p/>Jira export service<p/>
 *
 * @version 1.0
 * @author Markus Jorroch, PRODYNA AG, 2011-01-05
 */
public class GetComponentsOfProjectServiceHandlerImpl extends GetComponentsOfProjectServiceHandler {

    private static final long serialVersionUID = 1L;

	@Override
	protected ComponentListMsg getComponentsOfProject(ProjectMsg msg) throws SearchException {
		try {
			JiraFacade jiraFacade = JiraAdapterLocator.getInstane().getAdapter();
			List<ProjectComponent> components = jiraFacade.getComponentsForProject(msg.getProject());
			ComponentListMsg rs = new ComponentListMsg();
			rs.getComponents().addAll(components);
			return rs;
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}

}
