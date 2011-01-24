/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingTestConfigurationResultListViewCommand<p/>open list view for TestConfigurationResult<p/>
 *
 * @author Markus Jorroch, PRODYNA AG, 2010-10-13
 */
public class OpenCorrespondingTestConfigurationResultListViewCommand implements NabuccoCommand {

    private OpenCorrespondingTestConfigurationResultListViewHandler openCorrespondingTestConfigurationResultListViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingTestConfigurationResultListViewCommand.class).inject(
                    OpenCorrespondingTestConfigurationResultListViewHandler.class);

    public static final String ID = "org.nabucco.testautomation.result.ui.command.result.OpenCorrespondingTestConfigurationResultListViewCommand";

    /** Constructs a new OpenCorrespondingTestConfigurationResultListViewCommand instance. */
    public OpenCorrespondingTestConfigurationResultListViewCommand() {
        super();
    }

    @Override
    public void run() {
        openCorrespondingTestConfigurationResultListViewHandler
                .openCorrespondingTestConfigurationResultListView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingTestConfigurationResultListViewCommand.ID;
    }
}
