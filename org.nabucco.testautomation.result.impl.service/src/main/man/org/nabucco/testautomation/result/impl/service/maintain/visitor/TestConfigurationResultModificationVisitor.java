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
package org.nabucco.testautomation.result.impl.service.maintain.visitor;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.result.facade.datatype.TestConfigurationResult;


/**
 * TestConfigurationResultModificationVisitor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public final class TestConfigurationResultModificationVisitor extends DatatypeVisitor {

    private final TestConfigurationResult result;

    /**
     * Creates a new {@link TestConfigurationResultModificationVisitor} instance.
     * 
     * @param resul
     *            the TestConfigurationResult
     */
    public TestConfigurationResultModificationVisitor(TestConfigurationResult result) {
        this.result = result;
    }

    @Override
    public void visit(Datatype datatype) throws VisitorException {

        if (datatype.getDatatypeState() == DatatypeState.INITIALIZED
                || datatype.getDatatypeState() == DatatypeState.MODIFIED
                || datatype.getDatatypeState() == DatatypeState.DELETED) {
        	result.setDatatypeState(DatatypeState.MODIFIED);
        } else {
            super.visit(datatype);
        }
    }
}
