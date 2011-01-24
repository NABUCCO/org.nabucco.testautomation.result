/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.status;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * ActionStatusType<p/>Enumeration to indicate the status of an Action<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public enum ActionStatusType implements Enumeration {
    EXECUTED("E"),
    FAILED("F"), ;

    private String id;

    /**
     * Constructs a new ActionStatusType instance.
     *
     * @param id the String.
     */
    ActionStatusType(String id) {
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
