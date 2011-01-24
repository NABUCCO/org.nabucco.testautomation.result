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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.page1;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.TestConfigurationResultMaintenanceMasterDetailLabelProvider;

/**
 * TestResultTreeLabelProvider
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestResultTreeLabelProvider implements ILabelProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void addListener(ILabelProviderListener arg0) {
	}

	@Override
	public boolean isLabelProperty(Object arg0, String arg1) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener arg0) {
	}

	@Override
	public Image getImage(Object element) {
		return ImageProvider.createImage(TestConfigurationResultMaintenanceMasterDetailLabelProvider.getInstance().getImage(element));
	}

	@Override
	public String getText(Object element) {
		if (element instanceof TestConfigurationResult) {
			TestConfigurationResult testConfigurationResult = (TestConfigurationResult) element;
			return testConfigurationResult.getName().getValue();
		} else if (element instanceof TestResultContainer) {
			TestResult testResult = ((TestResultContainer) element).getResult();
			return testResult.getName().getValue();
		} 
		return null;
	}

}
