/** TODO...
 *
 *
 *
 *
 *
 * $Id: WURFLServiceTest.java,v 1.1 2012/05/31 12:03:09 ssantos Exp $
 *
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 *
 * Last changed on $Date: 2012/05/31 12:03:09 $
 * Last changed by $Author: ssantos $
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
 * @version $Revision: 1.1 $
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
