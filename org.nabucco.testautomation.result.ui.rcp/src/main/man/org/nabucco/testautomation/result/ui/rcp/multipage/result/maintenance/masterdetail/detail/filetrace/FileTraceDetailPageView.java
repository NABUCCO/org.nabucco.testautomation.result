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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.detail.filetrace;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.ui.forms.IManagedForm;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.detail.GeneralDetailPageViewLayouter;
import org.nabucco.framework.plugin.base.component.multipage.model.MultiPageEditViewModel;
import org.nabucco.framework.plugin.base.view.ManagedFormViewPart;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail.TestConfigurationResultMaintenanceMasterDetailBlock;
import org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.model.TestConfigurationResultMaintenanceMultiPageEditViewModel;

import org.nabucco.testautomation.ui.rcp.multipage.detail.TestautomationDetailPageView;

/**
 * ScreenshotDetailPageView
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public class FileTraceDetailPageView<M extends MultiPageEditViewModel> extends TestautomationDetailPageView<TestConfigurationResultMaintenanceMultiPageEditViewModel> {

	/**
	 * Creates a new {@link FileTraceDetailPageView} instance.
	 * 
	 * @param block
	 *            the master-detail block
	 * @param managedForm
	 *            the managed form
	 * @param parentView
	 *            the parent view
	 * @param nabuccoMessageManager
	 *            the message manager
	 * @param masterBlockId
	 *            the master-block id
	 * @param detailTitle
	 *            i18n representation of title for details
	 */
	public FileTraceDetailPageView(MasterDetailBlock<TestConfigurationResultMaintenanceMultiPageEditViewModel> block,
			IManagedForm managedForm, ManagedFormViewPart<TestConfigurationResultMaintenanceMultiPageEditViewModel> parentView,
			NabuccoMessageManager nabuccoMessageManager, String masterBlockId,
			String detailTitle) {
		super(block, managedForm, parentView, nabuccoMessageManager,
				masterBlockId, detailTitle, new HashSet<String>(),
				new HashSet<String>());
	}

	/**
	 * Creates a new {@link FileTraceDetailPageView} instance.
	 * 
	 * @param block
	 *            the master-detail block
	 * @param managedForm
	 *            the managed form
	 * @param parentView
	 *            the parent view
	 * @param nabuccoMessageManager
	 *            the message manager
	 * @param masterBlockId
	 *            the master-block id
	 * @param detailTitle
	 *            i18n representation of title for details
	 * @param readOnlyProperties
	 *            properties that are not editable
	 * @param invisibleProperties
	 *            properties that are not painted
	 */
	public FileTraceDetailPageView(
			TestConfigurationResultMaintenanceMasterDetailBlock block,
			IManagedForm managedForm,
			ManagedFormViewPart<TestConfigurationResultMaintenanceMultiPageEditViewModel> managedFormViewPart,
			NabuccoMessageManager nabuccoMessageManager, String iD,
			String detailTitle, Set<String> invisibleProperties,
			Set<String> readOnlyProperties) {
		super(block, managedForm, managedFormViewPart, nabuccoMessageManager,
				iD, detailTitle, invisibleProperties, readOnlyProperties);
	}

	/**
	 * Getter for the view layouter.
	 * 
	 * @param title
	 *            title of the detail page
	 * 
	 * @return the layouter
	 */
	@Override
	protected GeneralDetailPageViewLayouter getLayouter(String title) {
		return new FileTraceDetailPageViewLayouter(title);
	}

}
