package org.nabucco.testautomation.result.ui.rcp.command.result;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.TestConfigurationResultMaintenanceMultiPageEditView;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.single.SingleJiraExportWizard;

public class JiraExportHandlerImpl implements JiraExportHandler {

	@Override
	public void jiraExport() {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				TestConfigurationResultMaintenanceMultiPageEditView view = (TestConfigurationResultMaintenanceMultiPageEditView) Activator.getDefault().getView(TestConfigurationResultMaintenanceMultiPageEditView.ID);
				TestResult testResult = (TestResult) ((MasterDetailTreeNode) ((IStructuredSelection) view.getMasterDetailsBlock().getTreeViewer().getSelection()).getFirstElement()).getDatatype();
				TestConfigurationResult testConfigurationResult = view.getModel().getTestConfigurationResult();
				
				SingleJiraExportWizard wizard = new SingleJiraExportWizard(testConfigurationResult, testResult);
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