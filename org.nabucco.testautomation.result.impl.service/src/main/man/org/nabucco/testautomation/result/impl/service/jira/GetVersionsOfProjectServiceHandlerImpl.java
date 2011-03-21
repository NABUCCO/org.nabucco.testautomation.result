/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
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
import org.nabucco.framework.base.facade.datatype.issuetracking.Version;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.testautomation.result.facade.message.jira.ProjectMsg;
import org.nabucco.testautomation.result.facade.message.jira.VersionListMsg;


/**
 * GetComponentsOfProjectServiceHandlerImpl.java
 *
 * @author Steffen Schmidt, PRODYNA AG
 */
public class GetVersionsOfProjectServiceHandlerImpl extends GetVersionsOfProjectServiceHandler {

    private static final long serialVersionUID = 1L;

	@Override
	protected VersionListMsg getVersionsOfProject(ProjectMsg msg) throws SearchException {
		try {
			JiraFacade jiraFacade = JiraAdapterLocator.getInstane().getAdapter(new InitialContext());
			List<Version> versions = jiraFacade.getVersionsForProject(msg.getProject());
			VersionListMsg rs = new VersionListMsg();
			rs.getVersions().addAll(versions);
			return rs;
		} catch (Exception e) {
			throw new SearchException(e);
		}
	}

}
