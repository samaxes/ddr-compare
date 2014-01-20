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

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.ddr.simple.Service;

import com.samaxes.ddr.TestSuite;

/**
 * {@link OpenDDRService} test class.
 *
 * @author Samuel Santos
 */
public class OpenDDRServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenDDRServiceTest.class);

    private static OpenDDRService service;

    @BeforeClass
    public static void setUp() throws NamingException {
        service = (OpenDDRService) TestSuite.getContext().lookup("java:global/classes/OpenDDRService");
    }

    @AfterClass
    public static void tearDown() {
        service = null;
    }

    @Test
    public void getIdentificationService() {
        Service identificationService = service.getIdentificationService();

        LOGGER.info("OpenDDR API Version: {}", identificationService.getAPIVersion());
        LOGGER.info("OpenDDR Data Version: {}", identificationService.getDataVersion());

        assertNotNull(identificationService);
    }
}
