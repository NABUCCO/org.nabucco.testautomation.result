package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.TestConfigurationResultMaintenanceMultiPageEditView;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.CollectiveJiraExportWizard;

public class CollectiveJiraExportHandlerImpl implements CollectiveJiraExportHandler {

	@Override
	public void collectiveJiraExport() {



		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				TestConfigurationResultMaintenanceMultiPageEditView view = (TestConfigurationResultMaintenanceMultiPageEditView) Activator.getDefault().getView(TestConfigurationResultMaintenanceMultiPageEditView.ID);
				TestConfigurationResult testConfigurationResult = view.getModel().getTestConfigurationResult();

				CollectiveJiraExportWizard wizard = new CollectiveJiraExportWizard(testConfigurationResult);
				wizard.init(Activator.getDefault().getWorkbench(), StructuredSelection.EMPTY);
				WizardDialog wizardDialog = new WizardDialog(null, wizard);
				wizardDialog.setBlockOnOpen(true);
				wizardDialog.setPageSize(600, 400);
				wizardDialog.setTitleImage(ImageProvider.createImage(ResultImageRegistry.ICON_JIRA.getId()));
				wizardDialog.open();
			}
		});


	}

}
