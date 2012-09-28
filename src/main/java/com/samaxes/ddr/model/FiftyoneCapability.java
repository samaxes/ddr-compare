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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fiftyone.mobile.detection.BaseDeviceInfo;
import fiftyone.mobile.detection.Provider;
import fiftyone.mobile.detection.binary.BinaryException;
import fiftyone.mobile.detection.binary.Reader;

/**
 * 51Degrees.mobi capabilities.
 */
public class FiftyoneCapability {

    private static final Logger LOGGER = LoggerFactory.getLogger(FiftyoneCapability.class);

    private Integer screenPixelsWidth = 320; // Default value

    private Integer screenPixelsHeight = 480; // Default value

    public FiftyoneCapability(HttpServletRequest request) {
        // Create a Provider object
        Provider provider;
        try {
            provider = Reader.create();
        } catch (BinaryException e) {
            throw new RuntimeException(e);
        }

        // Read in a HttpServletRequest or User Agent String
        BaseDeviceInfo deviceInfo = provider.getDeviceInfo(request.getHeader("User-Agent"));

        // Get the value of a property
        try {
            screenPixelsWidth = Integer.valueOf(deviceInfo.getFirstPropertyValue("ScreenPixelsWidth"));
        } catch (NumberFormatException e) {
            LOGGER.info(e.getMessage());
        }
        try {
            screenPixelsHeight = Integer.valueOf(deviceInfo.getFirstPropertyValue("ScreenPixelsHeight"));
        } catch (NumberFormatException e) {
            LOGGER.info(e.getMessage());
        }

        // Before exiting your application, ensure you dispose of the Provide to
        // release it's resources such as it's thread pool
        provider.destroy();
    }

    public Integer getScreenPixelsWidth() {
        return screenPixelsWidth;
    }

    public Integer getScreenPixelsHeight() {
        return screenPixelsHeight;
    }
}
