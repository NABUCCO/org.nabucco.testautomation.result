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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorForAllDatatypes;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorImpl;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;


/**
 * TestConfigurationMaintenanceMasterDetailTreeNodeCreator
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestConfigurationResultMaintenanceMasterDetailTreeNodeCreator extends
        MasterDetailTreeNodeCreatorImpl<Datatype> {

    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode createNodeTyped(final Datatype dataType,
            final MasterDetailTreeNode parent,
            final MasterDetailTreeNodeCreatorForAllDatatypes builder) {
        MasterDetailTreeNode result = new MasterDetailTreeNode(dataType, parent);

        if (dataType instanceof TestConfigurationResult) {
        	TestConfigurationResult testConfigurationResult = (TestConfigurationResult) dataType;

            for (TestResultContainer testResultContainer : testConfigurationResult.getTestResultList()){      
            	MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
                        .getInstance().create(testResultContainer.getResult(), result);
                result.getChildren().add(child);
            }
        } else if (dataType instanceof ManualTestResult) {
        	ManualTestResult manualTestResult = (ManualTestResult) dataType;

            for (ActionTrace actionTrace : manualTestResult.getActionTraceList()) {
                MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
                        .getInstance().create(actionTrace, result);
                result.getChildren().add(child);
            }
        } else if (dataType instanceof TestResult) {
        	TestResult testResult = (TestResult) dataType;

            for (TestResultContainer testResultContainer : testResult.getTestResultList()) {
                MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
                        .getInstance().create(testResultContainer.getResult(), result);
                result.getChildren().add(child);
            }
            
            for (TestScriptResult testScriptResult : testResult.getTestScriptResultList()) {
                MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
                        .getInstance().create(testScriptResult, result);
                result.getChildren().add(child);
            }
        } else if (dataType instanceof TestScriptResult) {
        	TestScriptResult testScriptResult = (TestScriptResult) dataType;

            for (ActionTrace actionTrace : testScriptResult.getActionTraceList()) {
                MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
                        .getInstance().create(actionTrace, result);
                result.getChildren().add(child);
            }
        }
        // Add Decorators
        TreeNodeDecorator.decorateNode(result, dataType);
        return result;
    }

}
