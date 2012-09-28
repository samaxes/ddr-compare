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
package com.samaxes.ddr.wurfl;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import net.sourceforge.wurfl.core.CustomWURFLHolder;
import net.sourceforge.wurfl.core.WURFLHolder;
import net.sourceforge.wurfl.core.WURFLManager;
import net.sourceforge.wurfl.core.WURFLUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton that loads repository file on startup and gives access to {@link WURFLManager} and {@link WURFLUtils}
 * instances.
 *
 * @author Samuel Santos
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class WURFLService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WURFLService.class);

    private WURFLHolder wurflHolder;

    /**
     * Starts the Device Description Repository API service.
     */
    @PostConstruct
    private void start() {
        LOGGER.info("Starting WURFL service.");

        wurflHolder = new CustomWURFLHolder(WURFLService.class.getResource("/wurfl/wurfl-2.1.1.xml.gz").toString());
    }

    /**
     * Gets {@link CustomWURFLHolder} instance.
     *
     * @return the {@link CustomWURFLHolder} instance
     */
    public WURFLHolder getWurflHolder() {
        return wurflHolder;
    }
}
