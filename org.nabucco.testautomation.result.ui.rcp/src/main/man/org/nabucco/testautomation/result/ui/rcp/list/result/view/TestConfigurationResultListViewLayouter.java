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
package org.nabucco.testautomation.result.ui.rcp.list.result.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoAbstractListLayouter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultListContentProvider;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultTableSorter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableParameter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableViewer;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.ui.rcp.list.result.model.TestConfigurationResultListViewModel;
import org.nabucco.testautomation.result.ui.rcp.list.result.view.comparator.TestConfigurationResultListViewOwnerComparator;
import org.nabucco.testautomation.result.ui.rcp.list.result.view.comparator.TestConfigurationResultListViewTestConfigurationResultNameComparator;
import org.nabucco.testautomation.result.ui.rcp.list.result.view.label.TestConfigurationResultListViewOwnerLabelProvider;
import org.nabucco.testautomation.result.ui.rcp.list.result.view.label.TestConfigurationResultListViewTestConfigurationResultKeyLabelProvider;
import org.nabucco.testautomation.result.ui.rcp.list.result.view.label.TestConfigurationResultListViewTestConfigurationResultNameLabelProvider;


public class TestConfigurationResultListViewLayouter extends NabuccoAbstractListLayouter<TestConfigurationResultListViewModel> {

	private static final String OWNER_COLUMN_KEY = "org.nabucco.testautomation.result.ui.rcp.list.result.view.owner";
	
	private static final String NAME_COLUMN_KEY = "org.nabucco.testautomation.result.ui.rcp.list.result.view.name";
	
	private static final String KEY_COLUMN_KEY = "org.nabucco.testautomation.result.ui.rcp.list.result.view.key";

	/**
	 * Layouts the table
	 **/
	@Override
	public NabuccoTableViewer layout(final Composite parent,
			final NabuccoMessageManager messageManager,
			final TestConfigurationResultListViewModel model, final Layoutable<TestConfigurationResultListViewModel> view) {

		NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);

		TestConfigurationResultListViewWidgetFactory widgetFactory = new TestConfigurationResultListViewWidgetFactory(
				ntk);

		NabuccoTableParameter parameter = new NabuccoTableParameter(
				new NabuccoDefaultTableSorter<TestConfigurationResult>(
						createComparators()),
				new TestConfigurationResultListViewTableFilter(),
				new NabuccoDefaultListContentProvider(model),
				createTableColumnInfo(), getDoubleClickCommand(view
						.getManagedFormViewPart()));

		return widgetFactory.createTable(parent, parameter, model);
	}

	private List<Comparator<TestConfigurationResult>> createComparators() {
		List<Comparator<TestConfigurationResult>> comparators = new ArrayList<Comparator<TestConfigurationResult>>();
		comparators.add(new TestConfigurationResultListViewTestConfigurationResultNameComparator());
		comparators.add(new  TestConfigurationResultListViewOwnerComparator());
		
		return comparators;
	}

	/**
	 * Creates needed tables.
	 * 
	 * @return table columns
	 */
	private NabuccoTableColumnInfo[] createTableColumnInfo() {
		NabuccoTableColumnInfo[] result = {
				new NabuccoTableColumnInfo(KEY_COLUMN_KEY,
						KEY_COLUMN_KEY, 200, SWT.LEFT,
						SWT.CENTER,
						new TestConfigurationResultListViewTestConfigurationResultKeyLabelProvider()),
				new NabuccoTableColumnInfo(NAME_COLUMN_KEY,
						NAME_COLUMN_KEY, 600, SWT.LEFT,
						SWT.CENTER,
						new TestConfigurationResultListViewTestConfigurationResultNameLabelProvider()),
                new NabuccoTableColumnInfo(OWNER_COLUMN_KEY,
                		OWNER_COLUMN_KEY, 200,
                        SWT.LEFT, SWT.LEFT,
                        new TestConfigurationResultListViewOwnerLabelProvider())};
		return result;
	}

}
