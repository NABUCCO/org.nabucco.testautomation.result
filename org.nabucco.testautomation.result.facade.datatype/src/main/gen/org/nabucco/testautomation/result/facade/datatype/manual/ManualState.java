/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.manual;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * ManualState<p/>Enumeration to indicate the state of a manual result<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-11-30
 */
public enum ManualState implements Enumeration {
    INITIALIZED("I"),
    FINISHED("F"),
    ABORTED("A"), ;

    private String id;

    /**
     * Constructs a new ManualState instance.
     *
     * @param id the String.
     */
    ManualState(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getOrdinal() {
        return this.ordinal();
    }

    @Override
    public Enumeration cloneObject() {
        return this;
    }
}
