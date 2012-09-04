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
package org.nabucco.testautomation.result.impl.service.search;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.testautomation.property.facade.service.search.WildcardSupport;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultListMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;

/**
 * SearchTestConfigurationResultServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SearchTestConfigurationResultServiceHandlerImpl extends SearchTestConfigurationResultServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected TestConfigurationResultListMsg searchTestConfigurationResult(TestConfigurationResultSearchMsg msg)
            throws SearchException {

        StringBuilder queryString = new StringBuilder();
        queryString.append("FROM TestConfigurationResult r");

        List<String> filter = new ArrayList<String>();

        if (msg.getName() != null && msg.getName().getValue() != null) {
            filter.add("r.name LIKE '" + WildcardSupport.parse(msg.getName().getValue()) + "'");
        }

        if (msg.getTestConfigurationId() != null && msg.getTestConfigurationId().getValue() != null) {
            filter.add("r.testConfigurationId = :testConfigId");
        }

        if (msg.getTestConfigurationName() != null && msg.getTestConfigurationName().getValue() != null) {
            filter.add("r.testConfigurationName LIKE '"
                    + WildcardSupport.parse(msg.getTestConfigurationName().getValue()) + "'");
        }

        if (msg.getIdentificationKey() != null && msg.getIdentificationKey().getValue() != null) {
            filter.add("r.identificationKey LIKE '"
                    + WildcardSupport.parse(msg.getIdentificationKey().getValue()) + "'");
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
        queryString.append(" ORDER BY r.name");

        try {
            NabuccoQuery<TestConfigurationResult> query = super.getPersistenceManager().createQuery(
                    queryString.toString());

            if (msg.getTestConfigurationId() != null && msg.getTestConfigurationId().getValue() != null) {
                query.setParameter("testConfigId", msg.getTestConfigurationId());
            }

            List<TestConfigurationResult> resultList = query.getResultList();
            TestConfigurationResultListMsg rs = new TestConfigurationResultListMsg();
            rs.getTestConfigResultList().addAll(resultList);
            return rs;
        } catch (PersistenceException e) {
            throw new SearchException(e);
        }
    }

}
