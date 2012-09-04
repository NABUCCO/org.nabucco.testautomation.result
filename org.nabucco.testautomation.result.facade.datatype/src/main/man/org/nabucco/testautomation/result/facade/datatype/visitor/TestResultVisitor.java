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
package org.nabucco.testautomation.result.facade.datatype.visitor;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;
import org.nabucco.testautomation.result.facade.datatype.TestResult;
import org.nabucco.testautomation.result.facade.datatype.TestScriptElementResult;
import org.nabucco.testautomation.result.facade.datatype.TestScriptResult;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.FileTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.MessageTrace;
import org.nabucco.testautomation.result.facade.datatype.trace.ScreenshotTrace;


/**
 * TestResultVisitor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class TestResultVisitor extends DatatypeVisitor {

	@Override
    public void visit(Datatype datatype) throws VisitorException {

        if (datatype instanceof TestConfigurationResult) {
            this.visit((TestConfigurationResult) datatype);
        } else if (datatype instanceof TestResult) {
            this.visit((TestResult) datatype);
        } else if (datatype instanceof TestScriptResult) {
            this.visit((TestScriptResult) datatype);
		} else if (datatype instanceof TestScriptElementResult) {
			this.visit((TestScriptElementResult) datatype);
		} else if (datatype instanceof MessageTrace) {
			this.visit((MessageTrace) datatype);
		} else if (datatype instanceof ScreenshotTrace) {
			this.visit((ScreenshotTrace) datatype);
		} else if (datatype instanceof FileTrace) {
			this.visit((FileTrace) datatype);
		} else if (datatype instanceof ActionTrace) {
			this.visit((ActionTrace) datatype);
		}
        super.visit(datatype);
    }
	
	protected void visit(TestConfigurationResult datatype) {
	}
	
	protected void visit(TestResult datatype) {
	}
	
	protected void visit(TestScriptResult datatype) {
	}
	
	protected void visit(TestScriptElementResult datatype) {
	}
	
	protected void visit(MessageTrace datatype) {
	}
	
	protected void visit(ScreenshotTrace datatype) {
	}

	protected void visit(FileTrace datatype) {
	}
	
	protected void visit(ActionTrace datatype) {
	}
	
}
