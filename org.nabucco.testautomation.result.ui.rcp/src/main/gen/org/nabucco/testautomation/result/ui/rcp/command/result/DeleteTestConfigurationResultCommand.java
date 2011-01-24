/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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

    private DeleteTestConfigurationResultHandler deleteTestConfigurationResultHandler = NabuccoInjector
            .getInstance(DeleteTestConfigurationResultCommand.class).inject(
                    DeleteTestConfigurationResultHandler.class);

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
