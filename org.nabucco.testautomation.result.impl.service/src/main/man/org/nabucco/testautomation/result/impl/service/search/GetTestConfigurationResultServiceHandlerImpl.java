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

import javax.persistence.Query;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.validation.constraint.element.ConstraintFactory;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultSearchMsg;
import org.nabucco.testautomation.result.impl.service.DynamicCodeSupport;
import org.nabucco.testautomation.result.impl.service.search.GetTestConfigurationResultServiceHandler;


/**
 * GetTestConfigurationResultServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class GetTestConfigurationResultServiceHandlerImpl extends
		GetTestConfigurationResultServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected TestConfigurationResultMsg getTestConfigurationResult(
			TestConfigurationResultSearchMsg msg) throws SearchException {
		
		if (msg.getId() == null || msg.getId().getValue() == null) {
			throw new SearchException("Mandatory Identifier is null");
		}
		
		String queryString = "select r from TestConfigurationResult r where r.id = :id";
		Query query = super.getEntityManager().createQuery(
				queryString.toString());
		query.setParameter("id", msg.getId().getValue());
		TestConfigurationResult result = (TestConfigurationResult) query.getSingleResult();

		if (result == null) {
			throw new SearchException("TestConfigurationResult with id '" + msg.getId().getValue() + "' not found");
		}
		
		load(result);
		
		// Check owner and set Editable-Constraint
		if (!result.getOwner().equals(NabuccoInstance.getInstance().getOwner())) {
			try {
				result.addConstraint(ConstraintFactory.getInstance()
						.createEditableConstraint(false), true);
			} catch (VisitorException ex) {
				throw new SearchException(ex);
			}
		}
		
		TestConfigurationResultMsg rs = new TestConfigurationResultMsg();
		rs.setTestConfigurationResult(result);
		return rs;
	}
	
	private void load(TestConfigurationResult result) {
		
		for (TestResultContainer container : result.getTestResultList()) {
			load(container);
		}
		
		try {
			DynamicCodeSupport.getInstance().resolveDynamicCodes(result, getContext());
		} catch (Exception ex) {
			super.getLogger().error(ex, "Could not resolve DynamicCodes for TestConfigurationResult");
		}
		
		result.setDatatypeState(DatatypeState.PERSISTENT);
	}

	private void load(TestResultContainer container) {
		
		TestResult result = container.getResult();
		
		for (TestResultContainer child : result.getTestResultList()) {
			load(child);
		}
		
		for (TestScriptResult scriptResult : result.getTestScriptResultList()) {
			load(scriptResult);
		}
		
		if (result instanceof ManualTestResult) {
			
			for (ActionTrace trace : ((ManualTestResult) result).getActionTraceList()) {
				trace.setDatatypeState(DatatypeState.PERSISTENT);
			}
		}
		
		try {
			DynamicCodeSupport.getInstance().resolveDynamicCodes(result, getContext());
		} catch (Exception ex) {
			super.getLogger().error(ex, "Could not resolve DynamicCodes for TestConfigurationResult");
		}
		
		container.setDatatypeState(DatatypeState.PERSISTENT);
		result.setDatatypeState(DatatypeState.PERSISTENT);
	}

	private void load(TestScriptResult result) {
		
		for (ActionTrace trace : result.getActionTraceList()) {
			trace.setDatatypeState(DatatypeState.PERSISTENT);
		}
		result.setDatatypeState(DatatypeState.PERSISTENT);
	}

}
