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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.page1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ICheckStateProvider;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;
import org.nabucco.testautomation.result.facade.datatype.status.TestConfigElementStatusType;
import org.nabucco.testautomation.result.ui.rcp.images.ResultImageRegistry;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.multi.CollectiveJiraExportWizardModel;


/**
 * CollectiveJiraExportWizardPage1
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class CollectiveJiraExportWizardPage1 extends WizardPage {

	public static final String ID = "org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jira.wizard.CollectiveJiraExportWizardPage1";

	private CollectiveJiraExportWizardModel collectiveJiraExportWizardModel;

	private CheckboxTreeViewer treeViewer;

	/**
	 * Constructs and initializes a new page instance.
	 */
	public CollectiveJiraExportWizardPage1(CollectiveJiraExportWizardModel collectiveJiraExportWizardModel) {
		super(I18N.i18n(ID + ".title"));
		this.setDescription(I18N.i18n(ID + ".description"));
		setImageDescriptor(ImageProvider.createImageDescriptor(ResultImageRegistry.ICON_JIRA_80X80.getId()));
		this.collectiveJiraExportWizardModel = collectiveJiraExportWizardModel;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createControl(Composite parent) {
		Composite plate = new Composite(parent, SWT.NONE);
		plate.setLayout(new GridLayout(1, false));

		final Tree tree = new Tree(plate, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.CHECK);
		// Attach a listener directly after the creation
		tree.addListener(SWT.Selection,new Listener() {
			public void handleEvent(Event event) {
				if( event.detail == SWT.CHECK ) {
					if( !(event.item.getData() instanceof TestResultContainer) || isExportAllowed((TestResultContainer) event.item.getData()) == false) {
						event.detail = SWT.NONE;
						event.type   = SWT.None;
						event.doit   = false;
						try {
							tree.setRedraw(false);
							TreeItem item = (TreeItem)event.item;
							item.setChecked(! item.getChecked() );
						} finally {
							tree.setRedraw(true);
						}
					}
				}
			}
		});


		this.treeViewer = new CheckboxTreeViewer(tree);
		this.treeViewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		this.treeViewer.setContentProvider(new TestResultTreeContentProvider(this.collectiveJiraExportWizardModel.getTestConfigurationResult()));
		this.treeViewer.setLabelProvider(new TestResultTreeLabelProvider());

		this.treeViewer.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent arg0) {
				Object[] checkedElements = treeViewer.getCheckedElements();
				List<TestResult> checkedTestResults = new ArrayList<TestResult>();
				for (Object object : checkedElements) {
					if(object instanceof TestResultContainer && isExportAllowed((TestResultContainer) object)){
						checkedTestResults.add(((TestResultContainer) object).getResult());
					}
				}
				collectiveJiraExportWizardModel.setSelectedTestResults(checkedTestResults);
				setPageComplete(validatePage());
			}
		});

		this.treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent arg0) {
				Object firstElement = ((IStructuredSelection) treeViewer.getSelection()).getFirstElement();
				treeViewer.expandToLevel(firstElement, -1);
			}
		});

		this.treeViewer.setCheckStateProvider(new ICheckStateProvider() {
			
			@Override
			public boolean isGrayed(Object arg0) {
				if(arg0 instanceof TestConfigurationResult){
					return true;
				} else if(arg0 instanceof TestResultContainer){
					return !isExportAllowed((TestResultContainer) arg0);
				}
				return false;
			}
			
			@Override
			public boolean isChecked(Object arg0) {
				if(arg0 instanceof TestConfigurationResult){
					return true;
				} else if(arg0 instanceof TestResultContainer){
					return !isExportAllowed((TestResultContainer) arg0);
				}
				return false;
			}
		});
		
		this.treeViewer.setInput(new Object[]{this.collectiveJiraExportWizardModel.getTestConfigurationResult()});
		
		// Preset failed TestResults
		List<TestResultContainer> erroneousTestResults = getErroneousTestResults();
		for (TestResultContainer testResultContainer : erroneousTestResults) {
			if(isExportAllowed(testResultContainer)){
				treeViewer.setChecked(testResultContainer, true);
				treeViewer.expandToLevel(testResultContainer, 0);
			}
		}
		
		this.treeViewer.refresh();

		createButtons(plate);

		setControl(plate);
		setPageComplete(validatePage());
	}

	private void createButtons(Composite plate) {
		Composite parent = new Composite(plate, SWT.NONE);
		parent.setLayout(new GridLayout(3, false));

		Button selectAll = new Button(parent, SWT.NONE);
		selectAll.setText(I18N.i18n(ID + ".selectAll"));
		selectAll.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				List<TestResultContainer> testResultContainers = getAllRestults();
				for (TestResultContainer testResultContainer : testResultContainers) {
					if(isExportAllowed(testResultContainer)){
						ITreeContentProvider contentProvider = (ITreeContentProvider) treeViewer.getContentProvider();
						Object parent = contentProvider.getParent(testResultContainer);
						while(parent != null){
							treeViewer.expandToLevel(parent, 1);
							parent = contentProvider.getParent(parent);
						}
						treeViewer.setChecked(testResultContainer, true);
					}
				}
				setPageComplete(validatePage());
			}


			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		});

		Button deselectAll = new Button(parent, SWT.NONE);
		deselectAll.setText(I18N.i18n(ID + ".deselectAll"));
		deselectAll.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				List<TestResultContainer> testResultContainers = getAllRestults();
				for (TestResultContainer testResultContainer : testResultContainers) {
					if(isExportAllowed(testResultContainer)){
						treeViewer.setChecked(testResultContainer, false);
					}
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		});

		Button selectErroneous = new Button(parent, SWT.NONE);
		selectErroneous.setText(I18N.i18n(ID + ".selectErroneous"));
		selectErroneous.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				List<TestResultContainer> erroneousTestResults = getErroneousTestResults();
				for (TestResultContainer testResultContainer : erroneousTestResults) {
					if(isExportAllowed(testResultContainer)){
						ITreeContentProvider contentProvider = (ITreeContentProvider) treeViewer.getContentProvider();
						Object parent = contentProvider.getParent(testResultContainer);
						while(parent != null){
							treeViewer.expandToLevel(parent, 1);
							parent = contentProvider.getParent(parent);
						}
						treeViewer.setChecked(testResultContainer, true);
					}
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		});

	}

	private boolean validatePage() {
		Object[] checkedElements = this.treeViewer.getCheckedElements();
		for (Object object : checkedElements) {
			if(object instanceof TestResultContainer){
				if(isExportAllowed((TestResultContainer) object)){
					setErrorMessage(null);
					return true;
				}
			}
		}
		setErrorMessage(I18N.i18n(ID + ".noSelection"));
		return false;
	}


	private List<TestResultContainer> getErroneousTestResults() {
		List<TestResultContainer> testResultList = this.collectiveJiraExportWizardModel.getTestConfigurationResult().getTestResultList();
		List<TestResultContainer> resultList = new ArrayList<TestResultContainer>();
		for (TestResultContainer testResultContainer : testResultList) {
			TestResult result = testResultContainer.getResult();
			if(result.getStatus() == TestConfigElementStatusType.FAILED){
				resultList.add(testResultContainer);
				resultList.addAll(getErroneousTestResults(result));
			}
		}
		return resultList;
	}

	private Collection<? extends TestResultContainer> getErroneousTestResults(TestResult parentResult) {
		List<TestResultContainer> testResultList = parentResult.getTestResultList();
		List<TestResultContainer> resultList = new ArrayList<TestResultContainer>();
		for (TestResultContainer testResultContainer : testResultList) {
			TestResult result = testResultContainer.getResult();
			if(result.getStatus() == TestConfigElementStatusType.FAILED){
				resultList.add(testResultContainer);
				resultList.addAll(getErroneousTestResults(result));
			}
		}
		return resultList;
	}


	private boolean isExportAllowed(TestResultContainer testResultContainer){
		return isExportAllowed(testResultContainer.getResult());
	}

	private boolean isExportAllowed(TestResult testResult){
		return (testResult.getJiraExport() != null && testResult.getJiraExport().getValue() != null && testResult.getJiraExport().getValue());
	}

	

	private List<TestResultContainer> getAllRestults() {
		List<TestResultContainer> resultsList = new ArrayList<TestResultContainer>();
		List<TestResultContainer> testResultList = this.collectiveJiraExportWizardModel.getTestConfigurationResult().getTestResultList();
		resultsList.addAll(testResultList);
		for (TestResultContainer testResultContainer : testResultList) {
			resultsList.addAll(getAllChildren(testResultContainer));
		}
		return resultsList;
	}

	private List<TestResultContainer> getAllChildren(TestResultContainer testResultContainer) {
		List<TestResultContainer> resultsList = new ArrayList<TestResultContainer>();
		List<TestResultContainer> testResultList = testResultContainer.getResult().getTestResultList();
		resultsList.addAll(testResultList);
		for (TestResultContainer childTestResultContainer : testResultList) {
			resultsList.addAll(getAllChildren(childTestResultContainer));
		}
		return resultsList;
	}
	
}


