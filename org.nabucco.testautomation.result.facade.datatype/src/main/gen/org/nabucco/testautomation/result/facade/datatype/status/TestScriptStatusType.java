/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.status;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * TestScriptStatusType<p/>Enumeration to indicate the status of a TestScript<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public enum TestScriptStatusType implements Enumeration {
    PASSED("P"),
    FAILED("F"),
    SKIPPED("S"),
    ABORTED("A"), ;

    private String id;

    /**
     * Constructs a new TestScriptStatusType instance.
     *
     * @param id the String.
     */
    TestScriptStatusType(String id) {
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
