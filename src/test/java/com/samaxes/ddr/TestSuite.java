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
 * @version $Revision$
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
    public static void setUp() throws NamingException {
        LOGGER.info("Starting EJB container.");
        context = EJBContainer.createEJBContainer().getContext();
    }

    @AfterClass
    public static void tearDown() throws NamingException {
        LOGGER.info("Stoping EJB container.");
        context.close();
    }
}
