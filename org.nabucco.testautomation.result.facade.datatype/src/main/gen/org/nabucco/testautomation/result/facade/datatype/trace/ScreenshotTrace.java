/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.result.facade.datatype.trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.image.ImageData;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.result.facade.datatype.trace.ActionTrace;

/**
 * ScreenshotTrace<p/>The tracing information containing a screenshot<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-11-09
 */
public class ScreenshotTrace extends ActionTrace implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String SCREENSHOT = "screenshot";

    public static final String IMAGEID = "imageId";

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ActionTrace.class).getPropertyMap());
        propertyMap.put(SCREENSHOT, PropertyDescriptorSupport.createBasetype(SCREENSHOT, ImageData.class, 9,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap
                .put(IMAGEID, PropertyDescriptorSupport.createBasetype(IMAGEID, Identifier.class, 10,
                        PROPERTY_CONSTRAINTS[1], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ScreenshotTrace.getPropertyDescriptor(SCREENSHOT), this.screenshot, null));
        properties.add(super.createProperty(ScreenshotTrace.getPropertyDescriptor(IMAGEID), this.imageId, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SCREENSHOT) && (property.getType() == ImageData.class))) {
            this.setScreenshot(((ImageData) property.getInstance()));
            return true;
        } else if ((property.getName().equals(IMAGEID) && (property.getType() == Identifier.class))) {
            this.setImageId(((Identifier) property.getInstance()));
            return true;
        }
        return false;
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
            if ((screenshot == null)) {
                return;
            }
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
            if ((imageId == null)) {
                return;
            }
            this.imageId = new Identifier();
        }
        this.imageId.setValue(imageId);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ScreenshotTrace.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ScreenshotTrace.class).getAllProperties();
    }
}
