/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CollectiveJiraExportCommand<p/>This command should create JIRA Tasks for a collection of TestResults<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-29-12
 */
public class CollectiveJiraExportCommand implements NabuccoCommand {

    private CollectiveJiraExportHandler collectiveJiraExportHandler = NabuccoInjector.getInstance(
            CollectiveJiraExportCommand.class).inject(CollectiveJiraExportHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.result.CollectiveJiraExportCommand";

    /** Constructs a new CollectiveJiraExportCommand instance. */
    public CollectiveJiraExportCommand() {
        super();
    }

    @Override
    public void run() {
        collectiveJiraExportHandler.collectiveJiraExport();
    }

    @Override
    public String getId() {
        return CollectiveJiraExportCommand.ID;
    }
}
