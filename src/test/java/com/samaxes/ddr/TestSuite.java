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
package com.samaxes.ddr;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samaxes.ddr.openddr.OpenDDRServiceTest;
import com.samaxes.ddr.wurfl.WURFLServiceTest;

/**
 * Test suite.
 *
 * @author Samuel Santos
 */
@RunWith(Suite.class)
@SuiteClasses({ OpenDDRServiceTest.class, WURFLServiceTest.class })
public class TestSuite {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestSuite.class);

    private static Context context;

    public static Context getContext() {
        return context;
    }

    @BeforeClass
    public static void setUp() {
        LOGGER.info("Starting EJB container.");
        context = EJBContainer.createEJBContainer().getContext();
    }

    @AfterClass
    public static void tearDown() throws NamingException {
        LOGGER.info("Stoping EJB container.");
        context.close();
    }
}
