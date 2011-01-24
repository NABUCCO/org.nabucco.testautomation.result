/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.command.reporting;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenReportEditViewCommand<p/>This command should open the reporting view.<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-11-16
 */
public class OpenReportEditViewCommand implements NabuccoCommand {

    private OpenReportEditViewHandler openReportEditViewHandler = NabuccoInjector.getInstance(
            OpenReportEditViewCommand.class).inject(OpenReportEditViewHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.reporting.OpenReportEditViewCommand";

    /** Constructs a new OpenReportEditViewCommand instance. */
    public OpenReportEditViewCommand() {
        super();
    }

    @Override
    public void run() {
        openReportEditViewHandler.openReportEditView();
    }

    @Override
    public String getId() {
        return OpenReportEditViewCommand.ID;
    }
}
