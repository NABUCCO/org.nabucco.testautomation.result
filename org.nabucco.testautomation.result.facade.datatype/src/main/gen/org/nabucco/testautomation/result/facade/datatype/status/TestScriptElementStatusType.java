/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.status;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * TestScriptElementStatusType<p/>Enumeration to indicate the status of TestScriptElement<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public enum TestScriptElementStatusType implements Enumeration {
    EXECUTED("E"),
    NOT_EXECUTED("N"), ;

    private String id;

    /**
     * Constructs a new TestScriptElementStatusType instance.
     *
     * @param id the String.
     */
    TestScriptElementStatusType(String id) {
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
