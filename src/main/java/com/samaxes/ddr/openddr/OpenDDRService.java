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
package com.samaxes.ddr.openddr;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.openddr.simpleapi.oddr.ODDRService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.ddr.simple.Service;
import org.w3c.ddr.simple.ServiceFactory;
import org.w3c.ddr.simple.exception.InitializationException;
import org.w3c.ddr.simple.exception.NameException;

/**
 * Singleton that loads repository file on startup and gives access to {@link Service} instance.
 *
 * @author Samuel Santos
 */
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class OpenDDRService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenDDRService.class);

    private Service identificationService;

    /**
     * Starts the Device Description Repository API service.
     */
    @PostConstruct
    private void start() {
        LOGGER.info("Starting OpenDDR service.");

        try {
            Properties initializationProperties = new Properties();
            initializationProperties.load(OpenDDRService.class.getResourceAsStream("/openddr/oddr.properties"));
            identificationService = ServiceFactory.newService("org.openddr.simpleapi.oddr.ODDRService",
                    initializationProperties.getProperty(ODDRService.ODDR_VOCABULARY_IRI), initializationProperties);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (InitializationException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (NameException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * Gets {@link Service} instance.
     *
     * @return the {@link Service} instance
     */
    public Service getIdentificationService() {
        return identificationService;
    }
}
