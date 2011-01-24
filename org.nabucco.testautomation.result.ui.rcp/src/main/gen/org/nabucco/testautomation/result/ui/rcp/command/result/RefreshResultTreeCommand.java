/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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
