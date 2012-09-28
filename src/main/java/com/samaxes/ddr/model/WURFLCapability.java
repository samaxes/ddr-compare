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
