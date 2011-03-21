/*
 * Copyright 2010 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco-source.org/nabucco-license.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableSorter;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailHelper;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorForAllDatatypes;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.addDialog.AddDialogLabelProvider;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.RemoveDatatypeMenuItem;
import org.nabucco.framework.plugin.base.component.multipage.xml.DatatypeXMLEditorTextPartCreator;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorTextPart;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerContentProvider;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerDefaultContentProvider;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.comparator.TestResultSorter;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.TreeNodeDecorator;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.listener.CreateJiraTaskListener;


/**
 * TestConfigurationResultResultMaintenanceMultiPageEditViewModelHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class TestConfigurationResultMaintenanceMultiPageEditViewModelHandlerImpl implements TestConfigurationResultMaintenanceMultiPageEditViewModelHandler {

	public static final String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultResultMaintenanceMultiPageEditViewModelHandlerImpl";

	private static final TestResultSorter resultSorter = new TestResultSorter();

	private static final String REMOVE = ".Remove";

	private static final String CREATE_JIRA_TASK = ".createJiraTask";

	public TestConfigurationResultMaintenanceMultiPageEditViewModelHandlerImpl() {
		super();
	}

	@Override
	public Menu getContextMenu(ISelection selection, TreeViewer treeViewer) {
		Menu result = new Menu(treeViewer.getTree());
		TreeSelection treeSelection = (TreeSelection) selection;
		Object firstElement = treeSelection.getFirstElement();
		if (firstElement instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) firstElement;
			Datatype datatype = treeNode.getDatatype();
			
			if(!MasterDetailHelper.isDatatypeEditable(datatype)){
				return null;
			}
			
			if(datatype instanceof TestResult) {
				TestResult testResult = (TestResult) datatype;
				if(testResult.getJiraExport() != null && testResult.getJiraExport().getValue() != null && testResult.getJiraExport().getValue()){

					// Execute
					MenuItem item = new MenuItem(result, SWT.CASCADE);
					Image image = ImageProvider.createImage(ResultImageRegistry.ICON_JIRA.getId());
					item.setImage(image);
					item.setText(I18N.i18n(ID + CREATE_JIRA_TASK));
					item.addSelectionListener(new CreateJiraTaskListener());

				}
			} 

			if(datatype instanceof ManualTestResult){
				// If not root case
				if (treeNode.getParent() != null) {
					// Remove
					Image image = ImageProvider.createImage("icons/delete.png");
					new RemoveDatatypeMenuItem(result, treeNode, this, treeViewer, ID + REMOVE, null, image);
				}
			}
		}
		return result;
	}


	/**
	 * Return whether possible children are available.
	 */
	@Override
	public boolean hasPossibleChildren(Datatype datatype) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Datatype[]> getPossibleChildren(Datatype datatype) {
		HashMap<String, Datatype[]> result = new HashMap<String, Datatype[]>();
		//		if(datatype instanceof TestConfigurationResult  || datatype instanceof TestResult){
		//			Datatype[] possibleChildrenInstances = new Datatype[]{ResultElementFactory.create(TestResult.class)};
		//			result.put("", possibleChildrenInstances);
		//		}
		return result;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public MasterDetailTreeNode addChild(final MasterDetailTreeNode parent, final Datatype newChild) {
		MasterDetailTreeNode result = null;
		Datatype parentDatatype = parent.getDatatype();

		if(newChild instanceof TestConfigurationResult){ // Root case
			result = addChildToTree(parent, (TestConfigurationResult) newChild);
		} else if (newChild instanceof TestResultContainer) {
			TestResultContainer testResultContainer = (TestResultContainer) newChild;

			if (parentDatatype instanceof TestConfigurationResult) {
				TestConfigurationResult parentTestConfigurationResult = (TestConfigurationResult) parentDatatype;
				// New Datatypes have to get an order
				testResultContainer.setOrderIndex(parentTestConfigurationResult
						.getTestResultList().size());
				result = addChildToTree(parent, testResultContainer.getResult());
				parentTestConfigurationResult.getTestResultList().add(testResultContainer);
			} else if (parentDatatype instanceof TestResult) {
				TestResult parentTestResult = (TestResult) parentDatatype;
				// New Datatypes have to get an order
				testResultContainer.setOrderIndex(parentTestResult
						.getTestResultList().size());
				result = addChildToTree(parent, testResultContainer.getResult());
				parentTestResult.getTestResultList().add(testResultContainer);
			}
		} else if(newChild instanceof TestScriptResult){
			TestScriptResult testScriptResult = (TestScriptResult) newChild;
			if (parentDatatype instanceof TestResult) {
				TestResult parentTestResult = (TestResult) parentDatatype;
				result = addChildToTree(parent, testScriptResult);
				parentTestResult.getTestScriptResultList().add(testScriptResult);
			} else if (parentDatatype instanceof TestScriptResult) {
				TestScriptResult parentTestScriptResult = (TestScriptResult) parentDatatype;
				result = addChildToTree(parent, testScriptResult);
				parentTestScriptResult.getElementResultList().add(testScriptResult);
			}
		} else if(newChild instanceof ActionTrace){
			ActionTrace actionTrace = (ActionTrace) newChild;
			if(parentDatatype instanceof TestScriptResult){
				TestScriptResult parentTestScriptResult = (TestScriptResult) parentDatatype;
				result = addChildToTree(parent, actionTrace);
				parentTestScriptResult.getActionTraceList().add(actionTrace);
			}
		}
		if(result == null){
			Activator.getDefault().logError(new NabuccoLogMessage(TestConfigurationResultMaintenanceMultiPageEditViewModelHandlerImpl.class, "FAILED to add new child!"));
		}
		// Add Decorators
		TreeNodeDecorator.decorateNode(result, newChild);
		return result;
	}

	private MasterDetailTreeNode addChildToTree(final MasterDetailTreeNode parent,
			final Datatype newChild) {
		MasterDetailTreeNode result = MasterDetailTreeNodeCreatorForAllDatatypes.getInstance()
		.create(newChild, parent);
		parent.getChildren().add(result);
		Datatype datatype = parent.getDatatype();
		if (datatype.getDatatypeState() == DatatypeState.PERSISTENT) {
			datatype.setDatatypeState(DatatypeState.MODIFIED);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(ISelection child) {
		StructuredSelection ssel = (StructuredSelection) child;
		MasterDetailTreeNode nodeToRemove = (MasterDetailTreeNode) ssel.getFirstElement();
		MasterDetailTreeNode parentNode = nodeToRemove.getParent();
		if(parentNode == null){
			return;
		}
		Datatype datatypeToRemove = nodeToRemove.getDatatype();
		if(datatypeToRemove instanceof ManualTestResult){
			Datatype parentDatatype = parentNode.getDatatype();
			boolean removedFromDataModel = false;
			int indexOfNodeToDelete = parentNode.getChildren().indexOf(nodeToRemove);
			if (parentDatatype instanceof TestConfigurationResult) {
				TestConfigurationResult parentConfigurationResult = (TestConfigurationResult) parentDatatype;
				List<TestResultContainer> testResultContainerList = parentConfigurationResult.getTestResultList();
				TestResultContainer containerToBeDeleted = testResultContainerList.get(indexOfNodeToDelete);
				// decrease Order Of AllElements With Order Index Higher Than Index Of Node To Delete
				updateOrdersAfterBeforeDeletion(indexOfNodeToDelete, testResultContainerList);
				testResultContainerList.remove(containerToBeDeleted);
				removedFromDataModel = true;
			} else if(parentDatatype instanceof TestResult){
				TestResult parentResult = (TestResult) parentDatatype;
				List<TestResultContainer> testResultContainerList = parentResult.getTestResultList();
				TestResultContainer containerToBeDeleted = testResultContainerList.get(indexOfNodeToDelete);
				// decrease Order Of AllElements With Order Index Higher Than Index Of Node To Delete
				updateOrdersAfterBeforeDeletion(indexOfNodeToDelete, testResultContainerList);
				testResultContainerList.remove(containerToBeDeleted);
				removedFromDataModel = true;
			}
			// set states if removing was successful
			if(removedFromDataModel){
				if (parentDatatype.getDatatypeState() == DatatypeState.PERSISTENT) {
					parentDatatype.setDatatypeState(DatatypeState.MODIFIED);
				}
				parentNode.getChildren().remove(nodeToRemove);
			}
		}
	}

	private void updateOrdersAfterBeforeDeletion(int indexOfNodeToDelete,
			List<TestResultContainer> testResultContainers) {
		for (TestResultContainer testResultContainer : testResultContainers) {
			Integer order = testResultContainer.getOrderIndex().getValue();
			if(order > indexOfNodeToDelete){
				testResultContainer.setOrderIndex(--order);
				testResultContainer.setDatatypeState(DatatypeState.MODIFIED);
			}
		}
	}



	/**
	 * {@inheritDoc}
	 */
	@Override
	public MasterDetailTreeNode createMasterDetailRepresentation(Datatype datatype) {
		return MasterDetailTreeNodeCreatorForAllDatatypes.getInstance().create(datatype, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public XMLEditorTextPart createXmlRepresentation(Datatype datatype) {
		return DatatypeXMLEditorTextPartCreator.getInstance().create(datatype, null);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public TestConfigurationResult createDefaultDatatype() {
		TestConfigurationResult testConfigurationResult = new TestConfigurationResult();
		testConfigurationResult.setName("");
		return testConfigurationResult;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AddDialogLabelProvider getAddDialogLabelProvider() {
		return new TestConfigurationResultMaintenanceMasterDetailAddDialogLabelProvider();
	}

	@Override
	public ElementPickerParameter getElementPickerParameter(Datatype parentDatatype) {
		NabuccoTableColumnInfo[] tableColumnInfo = createColumnInfo();
		NabuccoTableSorter tableSorter = null;
		ILabelProvider inputFieldLabelProvider = null;
		ElementPickerContentProvider contentProvider = new ElementPickerDefaultContentProvider(
				getPossibleChildren(parentDatatype));
		ElementPickerParameter result = new ElementPickerParameter(tableSorter,
				inputFieldLabelProvider, contentProvider, tableColumnInfo);
		return result;
	}

	private NabuccoTableColumnInfo[] createColumnInfo() {
		NabuccoTableColumnInfo[] result = new NabuccoTableColumnInfo[] { new NabuccoTableColumnInfo(
				"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.title",
				"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.tooltip",
				200, new TestConfigurationResultMaintenanceMasterDetailAddDialogLabelProvider()) };
		return result;
	}

	@Override
	public LabelForDialog getLabelForDialog() {
		LabelForDialog result = new LabelForDialog(
				"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.title",
				"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.message",
				"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.shellTitle",
				"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.messageTable",
				"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.messageCombo",
		"org.nabucco.testautomation.script.ui.rcp.multipage.maintainance.model.pathLabel");
		return result;
	}


	@Override
	public boolean up(ISelection selection) {
		TreeSelection treeSelection = (TreeSelection) selection;
		Object firstElement = treeSelection.getFirstElement();
		if (firstElement instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) firstElement;
			Datatype datatypeToMove = treeNode.getDatatype();
			if(datatypeToMove instanceof ManualTestResult){
				MasterDetailTreeNode parentTreeNode = treeNode.getParent();
				Datatype parentDatatype = parentTreeNode.getDatatype();
				int indexOfNodeToMove = parentTreeNode.getChildren().indexOf(treeNode);
				List<TestResultContainer> testResultList = null;
				if (parentDatatype instanceof TestConfigurationResult) {
					TestConfigurationResult parentTestConfigurationResult = (TestConfigurationResult) parentDatatype;
					testResultList = parentTestConfigurationResult.getTestResultList();
				} else if(parentDatatype instanceof TestResult){
					TestResult parentTestResult = (TestResult) parentDatatype;
					testResultList = parentTestResult.getTestResultList();
				}
				if(testResultList != null){
					TestResultContainer elementContainerToMove = testResultList.get(indexOfNodeToMove);
					Integer currentOrder = elementContainerToMove.getOrderIndex().getValue();
					setContainerOrder(testResultList, currentOrder - 1, currentOrder);
					elementContainerToMove.setOrderIndex(currentOrder - 1);
					elementContainerToMove.setDatatypeState(DatatypeState.MODIFIED);
					resultSorter.sort(testResultList); 
					return true;
				}
			}
		}
		return false;
	}


	@Override
	public boolean down(ISelection selection) {
		TreeSelection treeSelection = (TreeSelection) selection;
		Object firstElement = treeSelection.getFirstElement();
		if (firstElement instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) firstElement;
			Datatype datatypeToMove = treeNode.getDatatype();
			if(datatypeToMove instanceof ManualTestResult){
				MasterDetailTreeNode parentTreeNode = treeNode.getParent();
				Datatype parentDatatype = parentTreeNode.getDatatype();
				int indexOfNodeToMove = parentTreeNode.getChildren().indexOf(treeNode);
				List<TestResultContainer> testResultList = null;
				if (parentDatatype instanceof TestConfigurationResult) {
					TestConfigurationResult parentTestConfigurationResult = (TestConfigurationResult) parentDatatype;
					testResultList = parentTestConfigurationResult.getTestResultList();
				} else if(parentDatatype instanceof TestResult){
					TestResult parentTestResult = (TestResult) parentDatatype;
					testResultList = parentTestResult.getTestResultList();
				}
				if(testResultList != null){
					TestResultContainer elementContainerToMove = testResultList.get(indexOfNodeToMove);
					Integer currentOrder = elementContainerToMove.getOrderIndex().getValue();
					setContainerOrder(testResultList, currentOrder + 1, currentOrder);
					elementContainerToMove.setOrderIndex(currentOrder + 1);
					elementContainerToMove.setDatatypeState(DatatypeState.MODIFIED);
					resultSorter.sort(testResultList); 
					return true;
				}
			}
		}
		return false;
	}

	private void setContainerOrder(List<TestResultContainer> testResultList, int targetOrder,
			Integer orderToSet) {
		for (TestResultContainer testResultContainer : testResultList) {
			if (testResultContainer.getOrderIndex().getValue() == targetOrder) {
				testResultContainer.setOrderIndex(orderToSet);
				testResultContainer.setDatatypeState(DatatypeState.MODIFIED);
			}
		}
	}


}
