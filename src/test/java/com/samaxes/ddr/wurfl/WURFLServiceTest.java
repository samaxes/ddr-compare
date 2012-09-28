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

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import net.sourceforge.wurfl.core.WURFLHolder;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samaxes.ddr.TestSuite;

/**
 * {@link WURFLService} test class.
 *
 * @author Samuel Santos
 */
public class WURFLServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(WURFLServiceTest.class);

    private static WURFLService service;

    @BeforeClass
    public static void setUp() throws NamingException {
        service = (WURFLService) TestSuite.getContext().lookup("java:global/classes/WURFLService");
    }

    @AfterClass
    public static void tearDown() throws NamingException {
        service = null;
    }

    @Test
    public void getShortCache() {
        WURFLHolder wurflHolder = service.getWurflHolder();

        LOGGER.info("WURFL Version: {}", wurflHolder.getWURFLUtils().getVersion());

        assertNotNull(wurflHolder);
    }
}
