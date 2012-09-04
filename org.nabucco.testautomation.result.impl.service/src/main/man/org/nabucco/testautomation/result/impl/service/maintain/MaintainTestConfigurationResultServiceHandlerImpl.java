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
package org.nabucco.testautomation.result.impl.service.maintain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceExceptionMapper;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.message.TestConfigurationResultMsg;
import org.nabucco.testautomation.result.impl.service.maintain.support.ResultMaintainSupport;
import org.nabucco.testautomation.result.impl.service.maintain.visitor.TestConfigurationResultModificationVisitor;

/**
 * MaintainTestConfigurationResultServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class MaintainTestConfigurationResultServiceHandlerImpl extends MaintainTestConfigurationResultServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String PREFIX = "RESU-";

    private ResultMaintainSupport support;

    private Map<Long, Code> codeMap;

    @Override
    protected TestConfigurationResultMsg maintainTestConfigurationResult(TestConfigurationResultMsg msg)
            throws MaintainException {

        TestConfigurationResult result = msg.getTestConfigurationResult();
        this.codeMap = new HashMap<Long, Code>();

        try {
            // initialize PersistenceHelper
            this.support = new ResultMaintainSupport(super.getPersistenceManager());

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
                getLogger().info("TestConfigurationResult '" + result.getName() + "' [" + result.getId() + "] deleted");

                result = null;
                return msg;
            case TRANSIENT:
                break;
            case PERSISTENT:
                break;
            default:
                throw new MaintainException("Datatype state '"
                        + result.getDatatypeState() + "' is not valid for TestConfigurationResult.");
            }

            this.getPersistenceManager().flush();
            this.support = null;

        } catch (Exception ex) {
            throw new MaintainException("Error maintaining TestConfigurationResult",
                    PersistenceExceptionMapper.resolve(ex, TestConfigurationResult.class.getName(), result.getId()));

        }

        // Resolve
        if (result != null) {
            resolve(result);
            getLogger().info(
                    "TestConfigurationResult '"
                            + result.getName() + "' [" + result.getId() + "] successfully maintained");
        }

        msg.setTestConfigurationResult(result);
        return msg;
    }

    private void resolve(TestConfigurationResult testConfigResult) {

        for (TestResultContainer container : testConfigResult.getTestResultList()) {
            resolve(container);
        }

        if (testConfigResult.getEnvironmentTypeRefId() != null) {
            testConfigResult.setEnvironmentType(this.codeMap.get(testConfigResult.getEnvironmentTypeRefId()));
        }

        if (testConfigResult.getReleaseTypeRefId() != null) {
            testConfigResult.setReleaseType(this.codeMap.get(testConfigResult.getReleaseTypeRefId()));
        }
    }

    private void resolve(TestResultContainer container) {

        TestResult result = container.getResult();

        for (TestResultContainer child : result.getTestResultList()) {
            resolve(child);
        }

        result.getTestScriptResultList().size();

        // Resolve DynamicCodes
        if (result.getBrandTypeRefId() != null) {
            result.setBrandType(this.codeMap.get(result.getBrandTypeRefId()));
        }
    }

    private TestConfigurationResult create(TestConfigurationResult entity) throws MaintainException {

        List<TestResultContainer> testResultList = entity.getTestResultList();

        for (int i = 0; i < testResultList.size(); i++) {
            TestResultContainer updatedTestResult = create(testResultList.get(i));
            testResultList.set(i, updatedTestResult);
        }

        if (!this.codeMap.containsKey(entity.getEnvironmentTypeRefId())) {
            this.codeMap.put(entity.getEnvironmentTypeRefId(), entity.getEnvironmentType());
        }

        if (!this.codeMap.containsKey(entity.getReleaseTypeRefId())) {
            this.codeMap.put(entity.getReleaseTypeRefId(), entity.getReleaseType());
        }

        entity = this.support.maintain(entity);
        entity.setIdentificationKey(PREFIX + entity.getId());
        entity.setDatatypeState(DatatypeState.MODIFIED);
        entity = this.support.maintain(entity);
        return entity;
    }

    private TestResultContainer create(TestResultContainer entity) throws MaintainException {

        TestResult result = entity.getResult();

        if (result instanceof ManualTestResult) {
            result = create((ManualTestResult) result);
        } else {
            result = create((TestResult) result);
        }

        entity.setResult(result);
        entity = this.support.maintain(entity);
        return entity;
    }

    private TestResult create(TestResult entity) throws MaintainException {

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

        if (!this.codeMap.containsKey(entity.getBrandTypeRefId())) {
            this.codeMap.put(entity.getBrandTypeRefId(), entity.getBrandType());
        }

        entity = this.support.maintain(entity);
        return entity;
    }

    private ManualTestResult create(ManualTestResult entity) throws MaintainException {

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

        entity = this.support.maintain(entity);
        return entity;
    }

    private TestScriptResult create(TestScriptResult testScriptResult) throws MaintainException {

        List<ActionTrace> actionTraceList = testScriptResult.getActionTraceList();

        for (int i = 0; i < actionTraceList.size(); i++) {
            ActionTrace updatedActionTrace = create(actionTraceList.get(i));
            actionTraceList.set(i, updatedActionTrace);
        }

        testScriptResult = this.support.maintain(testScriptResult);
        return testScriptResult;
    }

    private ActionTrace create(ActionTrace actionTrace) throws MaintainException {
        actionTrace = this.support.maintain(actionTrace);
        return actionTrace;
    }

    private TestConfigurationResult update(TestConfigurationResult entity) throws MaintainException {

        List<TestResultContainer> testResultList = entity.getTestResultList();

        for (int i = 0; i < testResultList.size(); i++) {
            TestResultContainer updatedTestResult = update(testResultList.get(i));
            testResultList.set(i, updatedTestResult);
        }

        if (!this.codeMap.containsKey(entity.getEnvironmentTypeRefId())) {
            this.codeMap.put(entity.getEnvironmentTypeRefId(), entity.getEnvironmentType());
        }

        if (!this.codeMap.containsKey(entity.getReleaseTypeRefId())) {
            this.codeMap.put(entity.getReleaseTypeRefId(), entity.getReleaseType());
        }

        entity = this.support.maintain(entity);
        return entity;
    }

    private TestResultContainer update(TestResultContainer entity) throws MaintainException {

        TestResult result = entity.getResult();

        if (result instanceof ManualTestResult) {
            result = update((ManualTestResult) result);
        } else {
            result = update((TestResult) result);
        }

        entity.setResult(result);
        entity = this.support.maintain(entity);
        return entity;
    }

    public TestResult update(TestResult entity) throws MaintainException {

        List<TestResultContainer> testResultList = entity.getTestResultList();

        for (int i = 0; i < testResultList.size(); i++) {
            TestResultContainer updatedTestResult = update(testResultList.get(i));
            testResultList.set(i, updatedTestResult);
        }

        if (!this.codeMap.containsKey(entity.getBrandTypeRefId())) {
            this.codeMap.put(entity.getBrandTypeRefId(), entity.getBrandType());
        }

        entity = this.support.maintain(entity);
        return entity;
    }

    public TestResult update(ManualTestResult entity) throws MaintainException {

        List<ActionTrace> actionTraceList = entity.getActionTraceList();

        for (int i = 0; i < actionTraceList.size(); i++) {
            ActionTrace trace = update(actionTraceList.get(i));
            actionTraceList.set(i, trace);
        }

        if (!this.codeMap.containsKey(entity.getBrandTypeRefId())) {
            this.codeMap.put(entity.getBrandTypeRefId(), entity.getBrandType());
        }

        entity = this.support.maintain(entity);
        return entity;
    }

    private ActionTrace update(ActionTrace actionTrace) throws MaintainException {

        actionTrace = this.support.maintain(actionTrace);
        return actionTrace;
    }

    private void delete(TestConfigurationResult entity) throws MaintainException {

        if (entity.getId() == null) {
            return;
        }

        for (TestResultContainer testResult : entity.getTestResultList()) {
            delete(testResult);
        }

        this.support.maintain(entity);
    }

    private void delete(TestResultContainer entity) throws MaintainException {

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
                this.support.maintain(trace);
            }
        }

        // Delete TestResultContainer
        entity.setDatatypeState(DatatypeState.DELETED);
        this.support.maintain(entity);

        // Delete TestResult
        testResult.setDatatypeState(DatatypeState.DELETED);
        this.support.maintain(testResult);
    }

    private void delete(TestScriptResult entity) throws MaintainException {

        for (ActionTrace trace : entity.getActionTraceList()) {
            trace.setDatatypeState(DatatypeState.DELETED);
            this.support.maintain(trace);
        }

        entity.setDatatypeState(DatatypeState.DELETED);
        this.support.maintain(entity);
    }

}
