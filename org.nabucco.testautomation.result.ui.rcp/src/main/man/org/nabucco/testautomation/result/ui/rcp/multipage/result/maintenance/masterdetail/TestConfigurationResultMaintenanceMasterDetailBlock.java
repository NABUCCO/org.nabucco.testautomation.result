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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.ui.forms.DetailsPart;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlockLayouter;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.FileTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.MessageTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.TestConfigurationResultMaintenanceMultiPageEditView;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.detail.filetrace.FileTraceDetailPageView;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.detail.screenshot.ScreenshotDetailPageView;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultMaintenanceMultiPageEditViewModel;

import org.nabucco.testautomation.ui.rcp.multipage.detail.TestautomationDetailPageView;

/**
 * TestConfigurationMaintainanceMasterDetailBlock
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestConfigurationResultMaintenanceMasterDetailBlock extends
        MasterDetailBlock<TestConfigurationResultMaintenanceMultiPageEditViewModel> implements
        Layoutable<TestConfigurationResultMaintenanceMultiPageEditViewModel> {

    public static String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.TestConfigurationResultMaintenanceMasterDetailBlock";

    /**
     * @param model
     * @param messageManager
     * @param workflowConditionMultiplePageEditView
     */
    public TestConfigurationResultMaintenanceMasterDetailBlock(
            TestConfigurationResultMaintenanceMultiPageEditViewModel model,
            NabuccoMessageManager messageManager,
            TestConfigurationResultMaintenanceMultiPageEditView workflowConditionMultiplePageEditView) {
        super(messageManager, workflowConditionMultiplePageEditView, model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void registerPages(DetailsPart arg0) {
    	Map<Class<? extends Datatype>, Set<String>> typeToInvisiblePropertiesMap = this.getTypeToInvisiblePropertiesMap();
    	Set<String> readOnlyProperties = new HashSet<String>();
    	Set<String> invisibleProperties = new HashSet<String>();
    	
    	invisibleProperties.add("testConfigurationId");
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
    	readOnlyProperties.add("owner");
    	readOnlyProperties.add("identificationKey");
    	readOnlyProperties.add("status");
    	readOnlyProperties.add("testConfigurationName");
    	readOnlyProperties.add("testConfigurationId");
    	readOnlyProperties.add("startTime");
    	readOnlyProperties.add("endTime");
    	readOnlyProperties.add("environmentType");
    	readOnlyProperties.add("releaseType");
    	readOnlyProperties.add("duration");
        detailsPart.registerPage(TestConfigurationResult.class, new TestautomationDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "TestConfigurationResult", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(TestConfigurationResult.class, invisibleProperties);
        
        invisibleProperties = new HashSet<String>();
        readOnlyProperties = new HashSet<String>();
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
        invisibleProperties.add("testConfigElementId");
        invisibleProperties.add("schemaElementId");
        readOnlyProperties.add("level");
    	readOnlyProperties.add("status");
    	readOnlyProperties.add("name");
    	readOnlyProperties.add("testConfigElementName");
    	readOnlyProperties.add("testConfigElementKey");
    	readOnlyProperties.add("testConfigElementId");
    	readOnlyProperties.add("schemaElementId");
    	readOnlyProperties.add("message");
    	readOnlyProperties.add("errorMessage");
    	readOnlyProperties.add("startTime");
    	readOnlyProperties.add("endTime");
    	readOnlyProperties.add("brandType");
    	readOnlyProperties.add("duration");
        invisibleProperties.add("jiraExport");
        detailsPart.registerPage(TestResult.class, new TestautomationDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "TestResult", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(TestResult.class, invisibleProperties);
        
        invisibleProperties = new HashSet<String>();
        readOnlyProperties = new HashSet<String>();
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
        invisibleProperties.add("testConfigElementId");
        invisibleProperties.add("schemaElementId");
        invisibleProperties.add("message");
        invisibleProperties.add("errorMessage");
        invisibleProperties.add("jiraExport");
        readOnlyProperties.add("level");
    	readOnlyProperties.add("status");
    	readOnlyProperties.add("name");
    	readOnlyProperties.add("testConfigElementName");
    	readOnlyProperties.add("testConfigElementKey");
    	readOnlyProperties.add("testConfigElementId");
    	readOnlyProperties.add("schemaElementId");
    	readOnlyProperties.add("message");
    	readOnlyProperties.add("errorMessage");
    	readOnlyProperties.add("startTime");
    	readOnlyProperties.add("endTime");
    	readOnlyProperties.add("brandType");
    	readOnlyProperties.add("duration");
    	readOnlyProperties.add("userMessage");
    	readOnlyProperties.add("userErrorMessage");
    	readOnlyProperties.add("state");
        detailsPart.registerPage(ManualTestResult.class, new TestautomationDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "ManualTestResult", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(ManualTestResult.class, invisibleProperties);
        
        invisibleProperties = new HashSet<String>();
        readOnlyProperties = new HashSet<String>();
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
        invisibleProperties.add("elementId");
        invisibleProperties.add("imageId");
    	readOnlyProperties.add("status");
    	readOnlyProperties.add("testScriptName");
    	readOnlyProperties.add("testScriptKey");
    	readOnlyProperties.add("startTime");
    	readOnlyProperties.add("endTime");
    	readOnlyProperties.add("elementStatus");
    	readOnlyProperties.add("elementId");
    	readOnlyProperties.add("message");
    	readOnlyProperties.add("errorMessage");
    	readOnlyProperties.add("logging");
    	readOnlyProperties.add("duration");
        detailsPart.registerPage(TestScriptResult.class, new TestautomationDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "TestScriptResult", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(TestScriptResult.class, invisibleProperties);
        
        readOnlyProperties = new HashSet<String>();
        readOnlyProperties.add("name");
    	readOnlyProperties.add("actionId");
    	readOnlyProperties.add("startTime");
    	readOnlyProperties.add("endTime");
    	readOnlyProperties.add("duration");
    	readOnlyProperties.add("stackTrace");
        detailsPart.registerPage(ActionTrace.class, new TestautomationDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "ActionTrace", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(ActionTrace.class, invisibleProperties);
        
        readOnlyProperties = new HashSet<String>();
        readOnlyProperties.add("name");
    	readOnlyProperties.add("actionId");
    	readOnlyProperties.add("startTime");
    	readOnlyProperties.add("endTime");
    	readOnlyProperties.add("duration");
    	readOnlyProperties.add("stackTrace");
    	readOnlyProperties.add("request");
    	readOnlyProperties.add("response");
        detailsPart.registerPage(MessageTrace.class, new TestautomationDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "MessageTrace", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(MessageTrace.class, invisibleProperties);
        
        readOnlyProperties = new HashSet<String>();
        readOnlyProperties.add("name");
        readOnlyProperties.add("actionId");
        invisibleProperties = new HashSet<String>();
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
    	invisibleProperties.add("startTime");
    	invisibleProperties.add("endTime");
    	invisibleProperties.add("duration");
    	invisibleProperties.add("stackTrace");
    	invisibleProperties.add("imageId");
        detailsPart.registerPage(ScreenshotTrace.class, new ScreenshotDetailPageView(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "ScreenshotTrace", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(ScreenshotTrace.class, invisibleProperties);
        
        readOnlyProperties = new HashSet<String>();
        readOnlyProperties.add("name");
        readOnlyProperties.add("actionId");
        invisibleProperties = new HashSet<String>();
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
        invisibleProperties.add("startTime");
        invisibleProperties.add("endTime");
        invisibleProperties.add("duration");
    	invisibleProperties.add("stackTrace");
    	invisibleProperties.add("fileId");
        detailsPart.registerPage(FileTrace.class, new FileTraceDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "FileTrace", invisibleProperties, readOnlyProperties));
        typeToInvisiblePropertiesMap.put(FileTrace.class, invisibleProperties);
    }

    /**
     * {@inheritDoc}
     * 
     * @return
     */
    protected MasterDetailBlockLayouter<TestConfigurationResultMaintenanceMultiPageEditViewModel> getLayouter() {
        return new TestConfigurationResultMaintenanceMasterDetailBlockLayouter();
    }

}
