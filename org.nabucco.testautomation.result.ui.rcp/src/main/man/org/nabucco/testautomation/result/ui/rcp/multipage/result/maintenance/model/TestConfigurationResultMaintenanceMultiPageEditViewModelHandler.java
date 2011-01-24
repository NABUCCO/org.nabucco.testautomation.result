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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model;

import org.eclipse.jface.viewers.ISelection;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.framework.plugin.base.component.multipage.model.MasterDetailAble;
import org.nabucco.framework.plugin.base.component.multipage.model.XmlAble;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;


/**
 * TestConfigurationMaintainanceMultiplePageEditViewModelHandler
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public interface TestConfigurationResultMaintenanceMultiPageEditViewModelHandler extends
        CommandHandler, MasterDetailAble<Datatype>, XmlAble<Datatype> {

    /**
     * Create datatype during initializing the model.
     * 
     * @return root of all workflow conditions
     */
    public TestConfigurationResult createDefaultDatatype();

    public boolean up(ISelection selection);

    public boolean down(ISelection selection);

    /**
     * @param datatype
     * @return
     */
    boolean hasPossibleChildren(Datatype datatype);

}