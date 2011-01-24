/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.facade.datatype.base.Text;
import org.nabucco.testautomation.result.facade.datatype.status.TestScriptElementStatusType;

/**
 * TestScriptElementResult<p/>The result of a TestScriptElement<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-06-01
 */
public class TestScriptElementResult extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "elementStatus", "elementId", "message",
            "errorMessage" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,n;m1,1;", "l0,n;m0,1;",
            "l0,n;m0,1;" };

    private TestScriptElementStatusType elementStatus;

    private Identifier elementId;

    private Text message;

    private Text errorMessage;

    /** Constructs a new TestScriptElementResult instance. */
    public TestScriptElementResult() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        elementStatus = TestScriptElementStatusType.NOT_EXECUTED;
    }

    /**
     * CloneObject.
     *
     * @param clone the TestScriptElementResult.
     */
    protected void cloneObject(TestScriptElementResult clone) {
        super.cloneObject(clone);
        clone.setElementStatus(this.getElementStatus());
        if ((this.getElementId() != null)) {
            clone.setElementId(this.getElementId().cloneObject());
        }
        if ((this.getMessage() != null)) {
            clone.setMessage(this.getMessage().cloneObject());
        }
        if ((this.getErrorMessage() != null)) {
            clone.setErrorMessage(this.getErrorMessage().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<TestScriptElementStatusType>(PROPERTY_NAMES[0],
                TestScriptElementStatusType.class, PROPERTY_CONSTRAINTS[0], this.elementStatus));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[1], Identifier.class,
                PROPERTY_CONSTRAINTS[1], this.elementId));
        properties.add(new BasetypeProperty<Text>(PROPERTY_NAMES[2], Text.class,
                PROPERTY_CONSTRAINTS[2], this.message));
        properties.add(new BasetypeProperty<Text>(PROPERTY_NAMES[3], Text.class,
                PROPERTY_CONSTRAINTS[3], this.errorMessage));
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
        final TestScriptElementResult other = ((TestScriptElementResult) obj);
        if ((this.elementStatus == null)) {
            if ((other.elementStatus != null))
                return false;
        } else if ((!this.elementStatus.equals(other.elementStatus)))
            return false;
        if ((this.elementId == null)) {
            if ((other.elementId != null))
                return false;
        } else if ((!this.elementId.equals(other.elementId)))
            return false;
        if ((this.message == null)) {
            if ((other.message != null))
                return false;
        } else if ((!this.message.equals(other.message)))
            return false;
        if ((this.errorMessage == null)) {
            if ((other.errorMessage != null))
                return false;
        } else if ((!this.errorMessage.equals(other.errorMessage)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.elementStatus == null) ? 0 : this.elementStatus
                .hashCode()));
        result = ((PRIME * result) + ((this.elementId == null) ? 0 : this.elementId.hashCode()));
        result = ((PRIME * result) + ((this.message == null) ? 0 : this.message.hashCode()));
        result = ((PRIME * result) + ((this.errorMessage == null) ? 0 : this.errorMessage
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<TestScriptElementResult>\n");
        appendable.append(super.toString());
        appendable.append((("<elementStatus>" + this.elementStatus) + "</elementStatus>\n"));
        appendable.append((("<elementId>" + this.elementId) + "</elementId>\n"));
        appendable.append((("<message>" + this.message) + "</message>\n"));
        appendable.append((("<errorMessage>" + this.errorMessage) + "</errorMessage>\n"));
        appendable.append("</TestScriptElementResult>\n");
        return appendable.toString();
    }

    @Override
    public TestScriptElementResult cloneObject() {
        TestScriptElementResult clone = new TestScriptElementResult();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getElementStatus.
     *
     * @return the TestScriptElementStatusType.
     */
    public TestScriptElementStatusType getElementStatus() {
        return this.elementStatus;
    }

    /**
     * Missing description at method setElementStatus.
     *
     * @param elementStatus the TestScriptElementStatusType.
     */
    public void setElementStatus(TestScriptElementStatusType elementStatus) {
        this.elementStatus = elementStatus;
    }

    /**
     * Missing description at method setElementStatus.
     *
     * @param elementStatus the String.
     */
    public void setElementStatus(String elementStatus) {
        if ((elementStatus == null)) {
            this.elementStatus = null;
        } else {
            this.elementStatus = TestScriptElementStatusType.valueOf(elementStatus);
        }
    }

    /**
     * Missing description at method getElementId.
     *
     * @return the Identifier.
     */
    public Identifier getElementId() {
        return this.elementId;
    }

    /**
     * Missing description at method setElementId.
     *
     * @param elementId the Identifier.
     */
    public void setElementId(Identifier elementId) {
        this.elementId = elementId;
    }

    /**
     * Missing description at method setElementId.
     *
     * @param elementId the Long.
     */
    public void setElementId(Long elementId) {
        if ((this.elementId == null)) {
            this.elementId = new Identifier();
        }
        this.elementId.setValue(elementId);
    }

    /**
     * Missing description at method getMessage.
     *
     * @return the Text.
     */
    public Text getMessage() {
        return this.message;
    }

    /**
     * Missing description at method setMessage.
     *
     * @param message the Text.
     */
    public void setMessage(Text message) {
        this.message = message;
    }

    /**
     * Missing description at method setMessage.
     *
     * @param message the String.
     */
    public void setMessage(String message) {
        if ((this.message == null)) {
            this.message = new Text();
        }
        this.message.setValue(message);
    }

    /**
     * Missing description at method getErrorMessage.
     *
     * @return the Text.
     */
    public Text getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * Missing description at method setErrorMessage.
     *
     * @param errorMessage the Text.
     */
    public void setErrorMessage(Text errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Missing description at method setErrorMessage.
     *
     * @param errorMessage the String.
     */
    public void setErrorMessage(String errorMessage) {
        if ((this.errorMessage == null)) {
            this.errorMessage = new Text();
        }
        this.errorMessage.setValue(errorMessage);
    }
}
