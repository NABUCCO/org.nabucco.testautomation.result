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
package org.nabucco.testautomation.result.impl.service.resolve;

import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;

/**
 * ResolveTestConfigurationResultServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ResolveTestConfigurationResultServiceHandlerImpl extends ResolveTestConfigurationResultServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected TestConfigurationResultMsg resolveTestConfigurationResult(TestConfigurationResultSearchMsg msg)
            throws ResolveException {

        if (msg.getId() == null || msg.getId().getValue() == null) {
            throw new ResolveException("Mandatory Identifier is null");
        }

        try {
            String queryString = "FROM TestConfigurationResult r WHERE r.id = :id";
            NabuccoQuery<TestConfigurationResult> query = super.getPersistenceManager().createQuery(
                    queryString.toString());
            query.setParameter("id", msg.getId().getValue());
            TestConfigurationResult result = (TestConfigurationResult) query.getSingleResult();

            if (result == null) {
                throw new ResolveException("TestConfigurationResult with id '" + msg.getId().getValue() + "' not found");
            }

            load(result);

            TestConfigurationResultMsg rs = new TestConfigurationResultMsg();
            rs.setTestConfigurationResult(result);
            return rs;
        } catch (PersistenceException e) {
            throw new ResolveException(e);
        }
    }

    private void load(TestConfigurationResult result) {

        for (TestResultContainer container : result.getTestResultList()) {
            load(container);
        }
    }

    private void load(TestResultContainer container) {

        TestResult result = container.getResult();

        for (TestResultContainer child : result.getTestResultList()) {
            load(child);
        }

        result.getTestScriptResultList().size();
    }

}
