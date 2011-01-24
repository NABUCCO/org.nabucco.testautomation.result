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
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.masterdetail;

import java.util.Map;

import org.eclipse.jface.viewers.IDecoration;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.testautomation.result.facade.datatype.manual.ManualTestResult;


public class TreeNodeDecorator {



	private static String ICON_USER_8X8 = "icons/user_8x8.png";

	public static void decorateNode(MasterDetailTreeNode node, Datatype datatype){
		// Reused PropertyLists and ConfigElements should be decorated
		if (datatype instanceof ManualTestResult) {
			Map<Integer, String> decorations = node.getDecorations();
			decorations.put(IDecoration.BOTTOM_RIGHT, ICON_USER_8X8);
		} 
	}


}
