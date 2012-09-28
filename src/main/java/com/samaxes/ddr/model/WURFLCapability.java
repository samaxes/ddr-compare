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

import net.sourceforge.wurfl.core.Device;

import com.samaxes.ddr.wurfl.WURFLService;

/**
 * WURFL capabilities.
 */
public class WURFLCapability {

    private Integer resolutionWidth;

    private Integer resolutionHeight;

    private Integer maxImageWidth;

    private Integer maxImageHeight;

    public WURFLCapability(WURFLService wurflService, HttpServletRequest request) {
        Device device = wurflService.getWurflHolder().getWURFLManager().getDeviceForRequest(request);
        resolutionWidth = Integer.valueOf(device.getCapability("resolution_width"));
        resolutionHeight = Integer.valueOf(device.getCapability("resolution_height"));
        maxImageWidth = Integer.valueOf(device.getCapability("max_image_width"));
        maxImageHeight = Integer.valueOf(device.getCapability("max_image_height"));
    }

    public Integer getResolutionWidth() {
        return resolutionWidth;
    }

    public Integer getResolutionHeight() {
        return resolutionHeight;
    }

    public Integer getMaxImageWidth() {
        return maxImageWidth;
    }

    public Integer getMaxImageHeight() {
        return maxImageHeight;
    }
}
