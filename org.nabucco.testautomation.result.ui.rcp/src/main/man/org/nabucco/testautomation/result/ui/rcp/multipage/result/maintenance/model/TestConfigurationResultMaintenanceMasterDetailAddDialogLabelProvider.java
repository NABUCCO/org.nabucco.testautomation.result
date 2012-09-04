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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model;

import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.addDialog.AddDialogLabelProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;


public class TestConfigurationResultMaintenanceMasterDetailAddDialogLabelProvider extends
		AddDialogLabelProvider {

	@Override
    public String getText(Object obj) {
        String result = null;
        if (obj instanceof TestConfigurationResult) {
        	TestConfigurationResult testConfigurationResult = ((TestConfigurationResult) obj);
			String name = testConfigurationResult.getClass().getCanonicalName();
            result = name;
        } else if(obj instanceof TestResultContainer){
    		String name = ((TestResultContainer) obj).getResult().getClass().getCanonicalName();
    		result = name;
    	}
        if (result == null) {
            return obj.getClass().getCanonicalName();
        }
        return I18N.i18n(result);
    }

	
	
}
