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
package org.nabucco.testautomation.result.impl.service.report;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.Number;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigElementStatusType;
import org.nabucco.testautomation.result.facade.message.DashboardStatisticMsg;

/**
 * GetDashboardStatisticServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class GetDashboardStatisticServiceHandlerImpl extends GetDashboardStatisticServiceHandler {

    private static final long serialVersionUID = -1L;

    @Override
    protected DashboardStatisticMsg getDashboardStatistic(EmptyServiceMessage msg) throws SearchException {
        try {
            DashboardStatisticMsg rs = new DashboardStatisticMsg();

            NabuccoQuery<Long> query1 = super.getPersistenceManager().createQuery(
                    "SELECT count(r) FROM TestConfigurationResult r");
            Long result = query1.getSingleResult();
            rs.setNumTestConfigurationResults(new Number(result.intValue()));

            NabuccoQuery<Object[]> query2 = super.getPersistenceManager().createQuery(
                    "SELECT r.status, count(r) FROM TestResult r WHERE r.level = 'ONE' GROUP BY r.status");
            List<Object[]> resultSet = query2.getResultList();

            for (Object[] objects : resultSet) {

                switch ((TestConfigElementStatusType) objects[0]) {
                case PASSED:
                    rs.setNumSuccess(new Number(((Long) objects[1]).intValue()));
                    break;
                case FAILED:
                    rs.setNumFailed(new Number(((Long) objects[1]).intValue()));
                    break;
                }
            }

            return rs;
        } catch (PersistenceException e) {
            throw new SearchException(e);
        }
    }

}
