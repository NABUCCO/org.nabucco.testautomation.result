/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.component;

import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for ResultComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class ResultComponentLocator extends ComponentLocatorSupport<ResultComponent> implements
        ComponentLocator<ResultComponent> {

    private static final String JNDI_NAME = ((((ComponentLocator.COMPONENTS + "/") + ResultComponent.COMPONENT_NAME) + "/") + "org.nabucco.testautomation.result.facade.component.ResultComponent");

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

    /**
     * Getter for the Instance.
     *
     * @return the ResultComponentLocator.
     */
    public static ResultComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new ResultComponentLocator(JNDI_NAME, ResultComponent.class);
        }
        return instance;
    }
}
