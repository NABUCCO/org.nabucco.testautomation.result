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

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.layout.I18NLabelProviderContributor;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigElementStatusType;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigurationStatusType;
import org.nabucco.testautomation.result.facade.datatype.status.TestScriptStatusType;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.FileTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;


/**
 * TestConfigurationMaintainanceMasterDetailLabelProvider
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestConfigurationResultMaintenanceMasterDetailLabelProvider implements I18NLabelProviderContributor {

	private static final String ICON_RESULT = "icons/case.png";

	private static final String ICON_CLOCK = "icons/clock.png";

	private static final String ICON_FOLDER = "icons/folder.png";

	private static final String MASTER_DETAIL_TREE = "MasterDetailTree.";

	private static TestConfigurationResultMaintenanceMasterDetailLabelProvider instance = new TestConfigurationResultMaintenanceMasterDetailLabelProvider();

	private TestConfigurationResultMaintenanceMasterDetailLabelProvider() {
	}

	public static TestConfigurationResultMaintenanceMasterDetailLabelProvider getInstance() {
		return instance;
	}

	@Override
	public Map.Entry<String, Map<String, ? extends Serializable>> getText(final Object element) {
		Map.Entry<String, Map<String, ? extends Serializable>> result = null;
		if (element instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) element;
			result = getText(treeNode.getDatatype());
		}
		return result;
	}

	/**
	 * String representing a special datatype.
	 * 
	 * @param datatype
	 * @return
	 */
	private Map.Entry<String, Map<String, ? extends Serializable>> getText(final Datatype datatype) {
		Map.Entry<String, Map<String, ? extends Serializable>> result = new AbstractMap.SimpleEntry<String, Map<String, ? extends Serializable>>(
				datatype.toString(), null);

		if (datatype instanceof TestConfigurationResult) {
			TestConfigurationResult testConfigurationResult = (TestConfigurationResult) datatype;
			result = createEntry(MASTER_DETAIL_TREE + "TestConfigurationResult", "name", testConfigurationResult.getName().getValue());
		} else if (datatype instanceof TestResult) {
			TestResult testResult = (TestResult) datatype;
			result = createEntry(MASTER_DETAIL_TREE + "TestResult", "name", testResult.getName().getValue());
		} else if (datatype instanceof TestScriptResult) {
			TestScriptResult testScriptResult = (TestScriptResult) datatype;
			result = createEntry(MASTER_DETAIL_TREE + "TestScriptResult", "name", testScriptResult.getTestScriptName().getValue());
		} else if (datatype instanceof ActionTrace) {
			ActionTrace actionTrace = (ActionTrace) datatype;
			result = createEntry(MASTER_DETAIL_TREE + "ActionTrace", "name", actionTrace.getName().getValue().toString());
		}
		return result;
	}

	private SimpleEntry<String, Map<String, ? extends Serializable>> createEntry(final String i18n, String key, String value) {
		return new AbstractMap.SimpleEntry<String, Map<String, ? extends Serializable>>(i18n, createMap(key, value));
	}

	private Map<String, ? extends Serializable> createMap(final String key, final String value) {
		Map<String, String> result = new HashMap<String, String>();
		result.put(key, value);
		return result;
	}

	@Override
	public String getImage(Object element) {

		if (element instanceof MasterDetailTreeNode) {

			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) element;
			Datatype datatype = treeNode.getDatatype();
			return getImage(datatype);
		} else if (element instanceof Datatype) {
			return getImage((Datatype) element);
		}
		return ICON_FOLDER;
	}

	private String getImage(Datatype datatype) {

		if (datatype instanceof TestResultContainer) {
			datatype = ((TestResultContainer) datatype).getResult();
		}

		if (datatype instanceof TestConfigurationResult) {

			TestConfigurationResult result = (TestConfigurationResult) datatype;
			TestConfigurationStatusType status = result.getStatus();

			if (status == null) {
				return ResultImageRegistry.ICON_RUN.getId();
			}

			switch (status) {
			case INITIALIZED:
				return ResultImageRegistry.ICON_RUN.getId();
			case RUNNING:
				return ResultImageRegistry.ICON_RUN.getId();
			case CANCELLED:
			case FINISHED:
				return ICON_RESULT;
			default:
				break;
			}

		} else if (datatype instanceof TestResult) {

			TestResult testResult = (TestResult) datatype;
			TestConfigElementStatusType status = testResult.getStatus();

			if (status == null) {
				return ResultImageRegistry.ICON_RUN.getId();
			}

			switch (status) {
			case FAILED:
				return ResultImageRegistry.ICON_FAIL.getId();
			case PASSED:
				return ResultImageRegistry.ICON_SUCCESS.getId();
			case SKIPPED:
				return ResultImageRegistry.ICON_SKIP.getId();
			}

		} else if (datatype instanceof TestScriptResult) {

			TestScriptResult testScriptResult = (TestScriptResult) datatype;
			TestScriptStatusType status = testScriptResult.getStatus();

			if (status == null) {
				return ResultImageRegistry.ICON_RUN.getId();
			}

			switch (status) {
			case ABORTED:
				return ResultImageRegistry.ICON_ABORT.getId();
			case FAILED:
				return ResultImageRegistry.ICON_FAIL.getId();
			case PASSED:
				return ResultImageRegistry.ICON_SUCCESS.getId();
			case SKIPPED:
				return ResultImageRegistry.ICON_SKIP.getId();
			}

		} else if (datatype instanceof ScreenshotTrace) {
			return ResultImageRegistry.ICON_SCREENSHOT.getId();
		} else if (datatype instanceof FileTrace) {
			return ResultImageRegistry.ICON_FILE.getId();
		} else if (datatype instanceof ActionTrace) {
			return ICON_CLOCK;
		}
		return ICON_FOLDER;
	}
}
