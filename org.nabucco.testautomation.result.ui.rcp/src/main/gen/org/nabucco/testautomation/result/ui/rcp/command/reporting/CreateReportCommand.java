/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.command.reporting;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CreateReportCommand<p/>This command should create the selected report.<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-11-16
 */
public class CreateReportCommand implements NabuccoCommand {

    private CreateReportHandler createReportHandler = NabuccoInjector.getInstance(
            CreateReportCommand.class).inject(CreateReportHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.reporting.CreateReportCommand";

    /** Constructs a new CreateReportCommand instance. */
    public CreateReportCommand() {
        super();
    }

    @Override
    public void run() {
        createReportHandler.createReport();
    }

    @Override
    public String getId() {
        return CreateReportCommand.ID;
    }
}
