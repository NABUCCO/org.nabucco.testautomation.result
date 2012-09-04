/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * DeleteTestConfigurationResultCommand<p/>This command should delete a TestConfigurationResult<p/>
 *
 * @author Marco Sussek, PRODYNA AG, 2010-12-07
 */
public class DeleteTestConfigurationResultCommand implements NabuccoCommand {

    private DeleteTestConfigurationResultHandler deleteTestConfigurationResultHandler = NabuccoInjector.getInstance(
            DeleteTestConfigurationResultCommand.class).inject(DeleteTestConfigurationResultHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.result.DeleteTestConfigurationResultCommand";

    /** Constructs a new DeleteTestConfigurationResultCommand instance. */
    public DeleteTestConfigurationResultCommand() {
        super();
    }

    @Override
    public void run() {
        deleteTestConfigurationResultHandler.deleteTestConfigurationResult();
    }

    @Override
    public String getId() {
        return DeleteTestConfigurationResultCommand.ID;
    }
}
