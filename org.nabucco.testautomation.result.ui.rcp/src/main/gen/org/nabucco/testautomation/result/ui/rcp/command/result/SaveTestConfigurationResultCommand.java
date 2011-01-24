/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
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

    private SaveTestConfigurationResultHandler saveTestConfigurationResultHandler = NabuccoInjector
            .getInstance(SaveTestConfigurationResultCommand.class).inject(
                    SaveTestConfigurationResultHandler.class);

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
