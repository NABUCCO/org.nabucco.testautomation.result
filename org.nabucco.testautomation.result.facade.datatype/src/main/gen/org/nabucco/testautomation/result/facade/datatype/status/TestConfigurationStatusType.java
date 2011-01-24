/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.status;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * TestConfigurationStatusType<p/>Enumeration to indicate the status of the execution of a TestConfiguration<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public enum TestConfigurationStatusType implements Enumeration {
    INITIALIZED("I"),
    RUNNING("R"),
    FINISHED("F"),
    CANCELLED("C"),
    WAITING("W"), ;

    private String id;

    /**
     * Constructs a new TestConfigurationStatusType instance.
     *
     * @param id the String.
     */
    TestConfigurationStatusType(String id) {
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
