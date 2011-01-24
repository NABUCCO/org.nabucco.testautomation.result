/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * JiraExportCommand<p/>This command should create a JIRA Tasks for selected TestResult<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-29-12
 */
public class JiraExportCommand implements NabuccoCommand {

    private JiraExportHandler jiraExportHandler = NabuccoInjector.getInstance(
            JiraExportCommand.class).inject(JiraExportHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.result.JiraExportCommand";

    /** Constructs a new JiraExportCommand instance. */
    public JiraExportCommand() {
        super();
    }

    @Override
    public void run() {
        jiraExportHandler.jiraExport();
    }

    @Override
    public String getId() {
        return JiraExportCommand.ID;
    }
}
