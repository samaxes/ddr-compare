/** TODO...
 *
 *
 *
 *
 *
 * $Id: OpenDDRServiceTest.java,v 1.2 2012/06/01 15:33:07 ssantos Exp $
 *
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 *
 * Last changed on $Date: 2012/06/01 15:33:07 $
 * Last changed by $Author: ssantos $
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
 * @version $Revision: 1.2 $
 */
public class OpenDDRServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenDDRServiceTest.class);

    private static OpenDDRService service;

    @BeforeClass
    public static void setUp() throws NamingException {
        service = (OpenDDRService) TestSuite.getContext().lookup("java:global/classes/OpenDDRService");
    }

    @AfterClass
    public static void tearDown() throws NamingException {
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
