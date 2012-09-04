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
			JiraFacade jiraFacade = JiraAdapterLocator.getInstane().getAdapter(new InitialContext());
			List<Priority> priorities = jiraFacade.getPriorities();
			PriorityListMsg rs = new PriorityListMsg();
			rs.getPriorities().addAll(priorities);
			return rs;
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}
	
}
