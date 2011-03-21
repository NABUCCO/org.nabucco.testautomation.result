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
package org.nabucco.testautomation.result.impl.service.search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.impl.service.search.SearchTestConfigurationResultServiceHandler;


/**
 * SearchTestConfigurationResultServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SearchTestConfigurationResultServiceHandlerImpl extends
		SearchTestConfigurationResultServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected TestConfigurationResultListMsg searchTestConfigurationResult(
			TestConfigurationResultSearchMsg msg) throws SearchException {
		
		StringBuilder queryString = new StringBuilder();
		queryString.append("select r from TestConfigurationResult r");

		List<String> filter = new ArrayList<String>();

		if (msg.getOwner() != null && msg.getOwner().getValue() != null) {
			filter.add("r.owner = :owner");
		}
		
		if (msg.getName() != null && msg.getName().getValue() != null) {
			filter.add("r.name LIKE '" + msg.getName().getValue() + "%'");
		}
		
		if (msg.getTestConfigurationName() != null && msg.getTestConfigurationName().getValue() != null) {
			filter.add("r.description LIKE '" + msg.getTestConfigurationName().getValue() + "%'");
		}
		
		if (msg.getTestConfigurationId() != null && msg.getTestConfigurationId().getValue() != null) {
			filter.add("r.testConfigurationId = :testConfigId");
		}
		
		if (msg.getStartTime() != null && msg.getStartTime().getValue() != null) {
			// filter.add("r.startTime ");
		}

		// append filter criteria
		int filterSize = filter.size();

		if (filterSize > 0) {
			queryString.append(" WHERE ");
			int c = 1;
			for (String str : filter) {
				queryString.append(str);

				if (c++ < filterSize) {
					queryString.append(" AND ");
				}
			}
		}
		queryString.append(" order by r.name");

		Query query = super.getEntityManager().createQuery(
				queryString.toString());
		
		if (msg.getOwner() != null && msg.getOwner().getValue() != null) {
			query.setParameter("owner", msg.getOwner());
		}
		
		if (msg.getTestConfigurationId() != null && msg.getTestConfigurationId().getValue() != null) {
			query.setParameter("testConfigId", msg.getTestConfigurationId());
		}

		@SuppressWarnings("unchecked")
		List<TestConfigurationResult> resultList = query.getResultList();
		TestConfigurationResultListMsg rs = new TestConfigurationResultListMsg();

		for (TestConfigurationResult testConfigurationResult : resultList) {
			testConfigurationResult.setDatatypeState(DatatypeState.PERSISTENT);
			rs.getTestConfigResultList().add(testConfigurationResult);
		}
		
		return rs;
	}

}
