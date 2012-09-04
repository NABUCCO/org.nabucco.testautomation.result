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
 * SaveTestConfigurationResultCommand<p/>This command should save a TestConfigurationResult<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-10-13
 */
public class SaveTestConfigurationResultCommand implements NabuccoCommand {

    private SaveTestConfigurationResultHandler saveTestConfigurationResultHandler = NabuccoInjector.getInstance(
            SaveTestConfigurationResultCommand.class).inject(SaveTestConfigurationResultHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.result.SaveTestConfigurationResultCommand";

    /** Constructs a new SaveTestConfigurationResultCommand instance. */
    public SaveTestConfigurationResultCommand() {
        super();
    }

    @Override
    public void run() {
        saveTestConfigurationResultHandler.saveTestConfigurationResult();
    }

    @Override
    public String getId() {
        return SaveTestConfigurationResultCommand.ID;
    }
}
