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
 * RefreshResultTreeCommand<p/>This command should refresh the tree in the master details view of result.<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-10-14
 */
public class RefreshResultTreeCommand implements NabuccoCommand {

    private RefreshResultTreeHandler refreshResultTreeHandler = NabuccoInjector.getInstance(
            RefreshResultTreeCommand.class).inject(RefreshResultTreeHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.result.RefreshResultTreeCommand";

    /** Constructs a new RefreshResultTreeCommand instance. */
    public RefreshResultTreeCommand() {
        super();
    }

    @Override
    public void run() {
        refreshResultTreeHandler.refreshResultTree();
    }

    @Override
    public String getId() {
        return RefreshResultTreeCommand.ID;
    }
}
