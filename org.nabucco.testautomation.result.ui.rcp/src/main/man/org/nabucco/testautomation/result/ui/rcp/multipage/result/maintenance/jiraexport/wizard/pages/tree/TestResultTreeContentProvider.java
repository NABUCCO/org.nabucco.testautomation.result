/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.result.ui.rcp.multipage.result.maintenance.jiraexport.wizard.pages.tree;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResultContainer;

public class TestResultTreeContentProvider implements ITreeContentProvider {

	private TestConfigurationResult testConfigurationResult;

	public TestResultTreeContentProvider(TestConfigurationResult testConfigurationResult) {
		this.testConfigurationResult = testConfigurationResult;
	}

	@Override
	public Object[] getChildren(Object arg0) {
		if(arg0 instanceof TestConfigurationResult){
			return ((TestConfigurationResult) arg0).getTestResultList().toArray();
		} else if(arg0 instanceof TestResultContainer){
			return ((TestResultContainer) arg0).getResult().getTestResultList().toArray();
		}
		return null;
	}

	@Override
	public Object getParent(Object arg0) {
		if(arg0 instanceof TestResultContainer){
			List<TestResultContainer> testResultList = this.testConfigurationResult.getTestResultList();
			if(testResultList.contains(arg0)){
				return this.testConfigurationResult;
			} else {
				for (TestResultContainer testResultContainer : testResultList) {
					Object parent = getParent(testResultContainer, (TestResultContainer) arg0);
					if(parent != null){
						return parent;
					}
				}
			}
		}
		return null;
	}

	private Object getParent(TestResultContainer testResultContainer, TestResultContainer child) {
		List<TestResultContainer> testResultList = testResultContainer.getResult().getTestResultList();
		if(testResultList.contains(child)){
			return testResultContainer;
		} else {
			for (TestResultContainer childTestResultContainer : testResultList) {
				Object parent = getParent(childTestResultContainer, child);
				if(parent != null){
					return parent;
				}
			}
		}
		return null;
	}

	@Override
	public boolean hasChildren(Object arg0) {
		if(arg0 instanceof TestConfigurationResult){
			return ((TestConfigurationResult) arg0).getTestResultList().size() > 0;
		} else if(arg0 instanceof TestResultContainer){
			return ((TestResultContainer) arg0).getResult().getTestResultList().size() > 0;
		}
		return false;
	}

	@Override
	public void dispose() {
		// do nothing
	}

	@Override
	public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		// do nothing
		
	}

	@Override
	public Object[] getElements(Object arg0) {
		if(arg0 instanceof Object[]){
			return ((Object[]) arg0);
		} else {
			return this.getChildren(arg0);
		}
	}

	

}
