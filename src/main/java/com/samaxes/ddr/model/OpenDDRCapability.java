/** TODO...
 *
 *
 *
 *
 *
 * $Id$
 *
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 *
 * Last changed on $Date$
 * Last changed by $Author$
 */
package com.samaxes.ddr.model;

import javax.servlet.http.HttpServletRequest;

import org.openddr.simpleapi.oddr.model.ODDRHTTPEvidence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.ddr.simple.Evidence;
import org.w3c.ddr.simple.PropertyRef;
import org.w3c.ddr.simple.PropertyValue;
import org.w3c.ddr.simple.PropertyValues;
import org.w3c.ddr.simple.exception.NameException;
import org.w3c.ddr.simple.exception.ValueException;

import com.samaxes.ddr.openddr.OpenDDRService;

/**
 * OpenDDR capabilities.
 */
public class OpenDDRCapability {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenDDRCapability.class);

    private Integer displayWidth = 320; // Default value

    private Integer displayHeight = 480; // Default value

    public OpenDDRCapability(OpenDDRService openDDRService, HttpServletRequest request) {
        PropertyRef displayWidthRef;
        PropertyRef displayHeightRef;

        try {
            displayWidthRef = openDDRService.getIdentificationService().newPropertyRef("displayWidth");
            displayHeightRef = openDDRService.getIdentificationService().newPropertyRef("displayHeight");
        } catch (NameException e) {
            throw new RuntimeException(e);
        }

        PropertyRef[] propertyRefs = new PropertyRef[] { displayWidthRef, displayHeightRef };
        Evidence evidence = new ODDRHTTPEvidence();
        evidence.put("User-Agent", request.getHeader("User-Agent"));

        try {
            PropertyValues propertyValues = openDDRService.getIdentificationService().getPropertyValues(evidence,
                    propertyRefs);
            PropertyValue displayWidthProperty = propertyValues.getValue(displayWidthRef);
            PropertyValue displayHeightProperty = propertyValues.getValue(displayHeightRef);

            if (displayWidthProperty.exists()) {
                displayWidth = displayWidthProperty.getInteger();
            } else {
                LOGGER.info("Property displayWidth is not available. A default value will be used.");
            }
            if (displayHeightProperty.exists()) {
                displayHeight = displayHeightProperty.getInteger();
            } else {
                LOGGER.info("Property displayHeight is not available. A default value will be used.");
            }
        } catch (NameException e) {
            throw new RuntimeException(e);
        } catch (ValueException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getDisplayWidth() {
        return displayWidth;
    }

    public Integer getDisplayHeight() {
        return displayHeight;
    }
}
