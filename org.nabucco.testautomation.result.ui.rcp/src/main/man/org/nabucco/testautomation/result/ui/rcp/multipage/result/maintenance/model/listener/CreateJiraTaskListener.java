package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.listener;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.nabucco.testautomation.result.ui.rcp.command.result.JiraExportHandlerImpl;

public class CreateJiraTaskListener implements SelectionListener {

	@Override
	public void widgetDefaultSelected(SelectionEvent arg0) {
		// do nothing
	}

	@Override
	public void widgetSelected(SelectionEvent arg0) {
		new JiraExportHandlerImpl().jiraExport();
	}

}
