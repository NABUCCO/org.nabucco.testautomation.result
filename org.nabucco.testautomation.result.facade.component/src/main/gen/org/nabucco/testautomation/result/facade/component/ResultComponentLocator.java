/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.facade.component;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for ResultComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class ResultComponentLocator extends ComponentLocatorSupport<ResultComponent> implements
        ComponentLocator<ResultComponent> {

    private static ResultComponentLocator instance;

    /**
     * Constructs a new ResultComponentLocator instance.
     *
     * @param component the Class<ResultComponent>.
     * @param jndiName the String.
     */
    private ResultComponentLocator(String jndiName, Class<ResultComponent> component) {
        super(jndiName, component);
    }

    @Override
    public ResultComponent getComponent() throws ConnectionException {
        ResultComponent component = super.getComponent();
        if ((component instanceof ResultComponentLocal)) {
            return new ResultComponentLocalProxy(((ResultComponentLocal) component));
        }
        return component;
    }

    /**
     * Getter for the Instance.
     *
     * @return the ResultComponentLocator.
     */
    public static ResultComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new ResultComponentLocator(ResultComponent.JNDI_NAME, ResultComponent.class);
        }
        return instance;
    }
}
