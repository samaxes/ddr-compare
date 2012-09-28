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
            LOGGER.debug("Display width is not available. A default value will be used instead.");
        }
        try {
            screenPixelsHeight = Integer.valueOf(deviceInfo.getFirstPropertyValue("ScreenPixelsHeight"));
        } catch (NumberFormatException e) {
            LOGGER.debug("Display height is not available. A default value will be used instead.");
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
