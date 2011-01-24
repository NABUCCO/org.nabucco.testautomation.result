/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.result.facade.datatype.trace;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.image.ImageData;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * ScreenshotTrace<p/>The tracing information containing a screenshot<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-11-09
 */
public class ScreenshotTrace extends ActionTrace implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "screenshot", "imageId" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m0,1;", "l0,n;m0,1;" };

    private ImageData screenshot;

    private Identifier imageId;

    /** Constructs a new ScreenshotTrace instance. */
    public ScreenshotTrace() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ScreenshotTrace.
     */
    protected void cloneObject(ScreenshotTrace clone) {
        super.cloneObject(clone);
        if ((this.getScreenshot() != null)) {
            clone.setScreenshot(this.getScreenshot().cloneObject());
        }
        if ((this.getImageId() != null)) {
            clone.setImageId(this.getImageId().cloneObject());
        }
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<ImageData>(PROPERTY_NAMES[0], ImageData.class,
                PROPERTY_CONSTRAINTS[0], this.screenshot));
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[1], Identifier.class,
                PROPERTY_CONSTRAINTS[1], this.imageId));
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
        final ScreenshotTrace other = ((ScreenshotTrace) obj);
        if ((this.screenshot == null)) {
            if ((other.screenshot != null))
                return false;
        } else if ((!this.screenshot.equals(other.screenshot)))
            return false;
        if ((this.imageId == null)) {
            if ((other.imageId != null))
                return false;
        } else if ((!this.imageId.equals(other.imageId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.screenshot == null) ? 0 : this.screenshot.hashCode()));
        result = ((PRIME * result) + ((this.imageId == null) ? 0 : this.imageId.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<ScreenshotTrace>\n");
        appendable.append(super.toString());
        appendable.append((("<screenshot>" + this.screenshot) + "</screenshot>\n"));
        appendable.append((("<imageId>" + this.imageId) + "</imageId>\n"));
        appendable.append("</ScreenshotTrace>\n");
        return appendable.toString();
    }

    @Override
    public ScreenshotTrace cloneObject() {
        ScreenshotTrace clone = new ScreenshotTrace();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Missing description at method getScreenshot.
     *
     * @return the ImageData.
     */
    public ImageData getScreenshot() {
        return this.screenshot;
    }

    /**
     * Missing description at method setScreenshot.
     *
     * @param screenshot the ImageData.
     */
    public void setScreenshot(ImageData screenshot) {
        this.screenshot = screenshot;
    }

    /**
     * Missing description at method setScreenshot.
     *
     * @param screenshot the byte[].
     */
    public void setScreenshot(byte[] screenshot) {
        if ((this.screenshot == null)) {
            this.screenshot = new ImageData();
        }
        this.screenshot.setValue(screenshot);
    }

    /**
     * Missing description at method getImageId.
     *
     * @return the Identifier.
     */
    public Identifier getImageId() {
        return this.imageId;
    }

    /**
     * Missing description at method setImageId.
     *
     * @param imageId the Identifier.
     */
    public void setImageId(Identifier imageId) {
        this.imageId = imageId;
    }

    /**
     * Missing description at method setImageId.
     *
     * @param imageId the Long.
     */
    public void setImageId(Long imageId) {
        if ((this.imageId == null)) {
            this.imageId = new Identifier();
        }
        this.imageId.setValue(imageId);
    }
}
