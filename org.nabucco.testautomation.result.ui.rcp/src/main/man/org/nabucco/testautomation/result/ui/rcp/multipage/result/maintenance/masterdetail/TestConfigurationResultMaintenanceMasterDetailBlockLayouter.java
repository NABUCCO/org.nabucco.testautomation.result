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

import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlockLayouter;
import org.nabucco.framework.plugin.base.layout.I18NLabelProviderContributor;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultMaintenanceMultiPageEditViewModel;


/**
 * TestConfigurationMaintainanceMasterDetailBlockLayouter
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestConfigurationResultMaintenanceMasterDetailBlockLayouter extends
        MasterDetailBlockLayouter<TestConfigurationResultMaintenanceMultiPageEditViewModel> {

    private static final String TITLE = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetails.title";

    private static final String DESCRIPTION = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetails.description";

    /**
     * Default constructor.
     */
    public TestConfigurationResultMaintenanceMasterDetailBlockLayouter() {
        super(TITLE, DESCRIPTION);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public I18NLabelProviderContributor getMasterDetailLabelProvider() {
        return TestConfigurationResultMaintenanceMasterDetailLabelProvider.getInstance();
    }

}
