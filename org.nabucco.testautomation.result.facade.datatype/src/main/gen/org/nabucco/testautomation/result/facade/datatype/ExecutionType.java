/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * ExecutionType<p/>Enumeration to indicate the type of execution<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public enum ExecutionType implements Enumeration {
    AUTOMATED("A"),
    MANUAL("M"), ;

    private String id;

    /**
     * Constructs a new ExecutionType instance.
     *
     * @param id the String.
     */
    ExecutionType(String id) {
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
