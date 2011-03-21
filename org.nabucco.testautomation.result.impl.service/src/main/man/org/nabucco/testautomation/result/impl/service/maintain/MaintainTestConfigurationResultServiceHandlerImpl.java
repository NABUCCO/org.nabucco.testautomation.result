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
package org.nabucco.testautomation.result.impl.service.maintain;

import java.util.List;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceExceptionMapper;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.impl.service.DynamicCodeSupport;
import org.nabucco.testautomation.result.impl.service.maintain.visitor.TestConfigurationResultModificationVisitor;


/**
 * MaintainTestConfigurationResultServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class MaintainTestConfigurationResultServiceHandlerImpl extends
		MaintainTestConfigurationResultServiceHandler {

	private static final long serialVersionUID = 1L;
	
	private static final String PREFIX = "RESU-";
	
	private PersistenceHelper persistenceHelper;

	@Override
	protected TestConfigurationResultMsg maintainTestConfigurationResult(
			TestConfigurationResultMsg msg) throws MaintainException {
		
		TestConfigurationResult result = msg.getTestConfigurationResult();
		
		// Set owner
		if (result.getOwner() == null || result.getOwner().getValue() == null) {
			result.setOwner(NabuccoInstance.getInstance().getOwner());
		}
		
		try {
			// initialize PersistenceHelper
			this.persistenceHelper = new PersistenceHelper(super.getEntityManager());
			
			if (result.getDatatypeState() == DatatypeState.PERSISTENT) {
				DatatypeVisitor visitor = new TestConfigurationResultModificationVisitor(result);
				result.accept(visitor);
			}
			
            switch (result.getDatatypeState()) {

            case CONSTRUCTED:
                throw new MaintainException("TestConfigurationResult is not initialized.");
            case INITIALIZED:
            	result = this.create(result);
                break;
            case MODIFIED:
            	result = this.update(result);
                break;
            case DELETED:
            	this.delete(result);
            	result = null;
            	return msg;
            case TRANSIENT:
                break;
            case PERSISTENT:
                break;
            default:
                throw new MaintainException("Datatype state '"
                        + result.getDatatypeState()
                        + "' is not valid for TestConfigurationResult.");
            }
        } catch (Exception ex) {
			throw new MaintainException("Error maintaining TestConfigurationResult",
					PersistenceExceptionMapper.resolve(ex,
							TestConfigurationResult.class.getName(),
							result.getId()));

        }
        
        this.persistenceHelper.flush();
        this.persistenceHelper = null;
        
        if (result != null) {
        	load(result);
        }
        msg.setTestConfigurationResult(result);
		return msg;
	}
	
	private void load(TestConfigurationResult testConfigResult) {
		
		for (TestResultContainer container : testConfigResult.getTestResultList()) {
			load(container);
		}
		
		try {
			DynamicCodeSupport.getInstance().resolveDynamicCodes(testConfigResult, getContext());
		} catch (Exception ex) {
			super.getLogger().error(ex, "Could not resolve DynamicCodes for TestConfigurationResult");
		}
		testConfigResult.setDatatypeState(DatatypeState.PERSISTENT);
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
	
	private TestConfigurationResult create(TestConfigurationResult entity)
			throws PersistenceException {

		List<TestResultContainer> testResultList = entity.getTestResultList();

		for (int i = 0; i < testResultList.size(); i++) {
			TestResultContainer updatedTestResult = create(testResultList.get(i));
			testResultList.set(i, updatedTestResult);
		}

		entity.setOwner(NabuccoInstance.getInstance().getOwner());
		entity = this.persistenceHelper.persist(entity);
		entity.setIdentificationKey(PREFIX + entity.getId());
		entity.setDatatypeState(DatatypeState.MODIFIED);
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}

	private TestResultContainer create(TestResultContainer entity)
			throws PersistenceException {
		
		TestResult result = entity.getResult();
		
		if (result instanceof ManualTestResult) {
			result = create((ManualTestResult) result);
		} else {
			result = create((TestResult) result);
		}
		
		entity.setResult(result);
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private TestResult create(TestResult entity) throws PersistenceException {
		
		List<TestResultContainer> testResultList = entity.getTestResultList();

		for (int i = 0; i < testResultList.size(); i++) {
			TestResultContainer updatedTestResult = create(testResultList.get(i));
			testResultList.set(i, updatedTestResult);
		}
		
		List<TestScriptResult> scriptResultList = entity.getTestScriptResultList();
		
		for (int i = 0; i < scriptResultList.size(); i++) {
			TestScriptResult updatedScriptResult = create(scriptResultList.get(i));
			scriptResultList.set(i, updatedScriptResult);
		}
		
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private ManualTestResult create(ManualTestResult entity) throws PersistenceException {
		
		List<TestResultContainer> testResultList = entity.getTestResultList();

		for (int i = 0; i < testResultList.size(); i++) {
			TestResultContainer updatedTestResult = create(testResultList.get(i));
			testResultList.set(i, updatedTestResult);
		}
		
		List<ActionTrace> actionTraceList = entity.getActionTraceList();
		
		for (int i = 0; i < actionTraceList.size(); i++) {
			ActionTrace updatedActionTrace = create(actionTraceList.get(i));
			actionTraceList.set(i, updatedActionTrace);
		}

		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private TestScriptResult create(TestScriptResult testScriptResult) throws PersistenceException {
		
		List<ActionTrace> actionTraceList = testScriptResult.getActionTraceList();
		
		for (int i = 0; i < actionTraceList.size(); i++) {
			ActionTrace updatedActionTrace = create(actionTraceList.get(i));
			actionTraceList.set(i, updatedActionTrace);
		}

		testScriptResult = this.persistenceHelper.persist(testScriptResult);
		return testScriptResult;
	}

	private ActionTrace create(ActionTrace actionTrace) throws PersistenceException {
		actionTrace = this.persistenceHelper.persist(actionTrace);
		return actionTrace;
	}

	private TestConfigurationResult update(TestConfigurationResult entity)
			throws PersistenceException {

		List<TestResultContainer> testResultList = entity.getTestResultList();

		for (int i = 0; i < testResultList.size(); i++) {
			TestResultContainer updatedTestResult = update(testResultList.get(i));
			testResultList.set(i, updatedTestResult);
		}

		entity = this.persistenceHelper.persist(entity);
		return entity;
	}

	private TestResultContainer update(TestResultContainer entity)
			throws PersistenceException {

		TestResult result = entity.getResult();
		
		if (result instanceof ManualTestResult) {
			result = update((ManualTestResult) result);
		} else {
			result = update((TestResult) result);
		}
		
		entity.setResult(result);
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	public TestResult update(TestResult entity) throws PersistenceException {
		
		List<TestResultContainer> testResultList = entity.getTestResultList();

		for (int i = 0; i < testResultList.size(); i++) {
			TestResultContainer updatedTestResult = update(testResultList.get(i));
			testResultList.set(i, updatedTestResult);
		}

		entity = this.persistenceHelper.persist(entity);
		return entity;
	}

	public TestResult update(ManualTestResult entity) throws PersistenceException {
		
		List<ActionTrace> actionTraceList = entity.getActionTraceList();

		for (int i = 0; i < actionTraceList.size(); i++) {
			ActionTrace trace = update(actionTraceList.get(i));
			actionTraceList.set(i, trace);
		}

		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private ActionTrace update(ActionTrace actionTrace) throws PersistenceException {
		
		actionTrace = this.persistenceHelper.persist(actionTrace);
		return actionTrace;
	}

	private void delete(TestConfigurationResult entity)
			throws PersistenceException {

		if (entity.getId() == null) {
			return;
		}
		
		for (TestResultContainer testResult : entity.getTestResultList()) {
			delete(testResult);
		}
	
		this.persistenceHelper.persist(entity);
	}

	private void delete(TestResultContainer entity) throws PersistenceException {
		
		TestResult testResult = entity.getResult();
		List<TestResultContainer> subResultList = testResult.getTestResultList();
		
		for (TestResultContainer child : subResultList) {
			delete(child);
		}
		
		for (TestScriptResult scriptResult : testResult.getTestScriptResultList()) {
			delete(scriptResult);
		}
		
		if (testResult instanceof ManualTestResult) {
			ManualTestResult manualResult = (ManualTestResult) testResult;
			
			for (ActionTrace trace : manualResult.getActionTraceList()) {
				trace.setDatatypeState(DatatypeState.DELETED);
				this.persistenceHelper.persist(trace);
			}
		}
		
		// Delete TestResultContainer
		entity.setDatatypeState(DatatypeState.DELETED);
		this.persistenceHelper.persist(entity);

		// Delete TestResult
		testResult.setDatatypeState(DatatypeState.DELETED);
		this.persistenceHelper.persist(testResult);
	}
	
	private void delete(TestScriptResult entity) throws PersistenceException {

		for (ActionTrace trace : entity.getActionTraceList()) {
			trace.setDatatypeState(DatatypeState.DELETED);
			this.persistenceHelper.persist(trace);
		}
		
		entity.setDatatypeState(DatatypeState.DELETED);
		this.persistenceHelper.persist(entity);
	}

}
