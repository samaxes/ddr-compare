/*
 * DDR Compare
 * https://github.com/samaxes/ddr-compare
 *
 * Copyright 2012 samaxes.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
                LOGGER.debug("Display width is not available. A default value will be used instead.");
            }
            if (displayHeightProperty.exists()) {
                displayHeight = displayHeightProperty.getInteger();
            } else {
                LOGGER.debug("Display height is not available. A default value will be used instead.");
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
