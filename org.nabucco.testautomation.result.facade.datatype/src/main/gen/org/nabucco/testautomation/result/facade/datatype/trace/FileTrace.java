/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.trace;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Data;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * FileTrace<p/>The tracing information containing a binary file<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-12-06
 */
public class FileTrace extends ActionTrace implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "fileContent", "fileId" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m0,1;", "l0,n;m0,1;" };

    private Data fileContent;

    private Identifier fileId;

    /** Constructs a new FileTrace instance. */
    public FileTrace() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the FileTrace.
     */
    protected void cloneObject(FileTrace clone) {
        super.cloneObject(clone);
        if ((this.getFileContent() != null)) {
            clone.setFileContent(this.getFileContent().cloneObject());
        }
        if ((this.getFileId() != null)) {
            clone.setFileId(this.getFileId().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Data>(PROPERTY_NAMES[0], Data.class,
                PROPERTY_CONSTRAINTS[0], this.fileContent));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[1], Identifier.class,
                PROPERTY_CONSTRAINTS[1], this.fileId));
        return properties;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final FileTrace other = ((FileTrace) obj);
        if ((this.fileContent == null)) {
            if ((other.fileContent != null))
                return false;
        } else if ((!this.fileContent.equals(other.fileContent)))
            return false;
        if ((this.fileId == null)) {
            if ((other.fileId != null))
                return false;
        } else if ((!this.fileId.equals(other.fileId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.fileContent == null) ? 0 : this.fileContent.hashCode()));
        result = ((PRIME * result) + ((this.fileId == null) ? 0 : this.fileId.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<FileTrace>\n");
        appendable.append(super.toString());
        appendable.append((("<fileContent>" + this.fileContent) + "</fileContent>\n"));
        appendable.append((("<fileId>" + this.fileId) + "</fileId>\n"));
        appendable.append("</FileTrace>\n");
        return appendable.toString();
    }

    @Override
    public FileTrace cloneObject() {
        FileTrace clone = new FileTrace();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getFileContent.
     *
     * @return the Data.
     */
    public Data getFileContent() {
        return this.fileContent;
    }

    /**
     * Missing description at method setFileContent.
     *
     * @param fileContent the Data.
     */
    public void setFileContent(Data fileContent) {
        this.fileContent = fileContent;
    }

    /**
     * Missing description at method setFileContent.
     *
     * @param fileContent the byte[].
     */
    public void setFileContent(byte[] fileContent) {
        if ((this.fileContent == null)) {
            this.fileContent = new Data();
        }
        this.fileContent.setValue(fileContent);
    }

    /**
     * Missing description at method getFileId.
     *
     * @return the Identifier.
     */
    public Identifier getFileId() {
        return this.fileId;
    }

    /**
     * Missing description at method setFileId.
     *
     * @param fileId the Identifier.
     */
    public void setFileId(Identifier fileId) {
        this.fileId = fileId;
    }

    /**
     * Missing description at method setFileId.
     *
     * @param fileId the Long.
     */
    public void setFileId(Long fileId) {
        if ((this.fileId == null)) {
            this.fileId = new Identifier();
        }
        this.fileId.setValue(fileId);
    }
}
