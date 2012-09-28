/** TODO...
 *
 *
 *
 *
 *
 * $Id: OpenDDRService.java,v 1.3 2012/06/06 14:18:20 ssantos Exp $
 *
 * Copyright (c) Present Technologies Lda., All Rights Reserved.
 * (www.present-technologies.com)
 *
 * This software is the proprietary information of Present Technologies Lda.
 * Use is subject to license terms.
 *
 * Last changed on $Date: 2012/06/06 14:18:20 $
 * Last changed by $Author: ssantos $
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
 * Singleton to access {@link Service} instance.
 *
 * @author Samuel Santos
 * @version $Revision: 1.3 $
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
        if (identificationService == null) {
            LOGGER.info("Starting Device Description Repository API service.");

            try {
                Properties initializationProperties = new Properties();
                initializationProperties.load(OpenDDRService.class.getResourceAsStream("/openddr/oddr.properties"));
                identificationService = ServiceFactory
                        .newService("org.openddr.simpleapi.oddr.ODDRService",
                                initializationProperties.getProperty(ODDRService.ODDR_VOCABULARY_IRI),
                                initializationProperties);
            } catch (IOException e) {
                LOGGER.error(e.getMessage(), e);
            } catch (InitializationException e) {
                LOGGER.error(e.getMessage(), e);
            } catch (NameException e) {
                LOGGER.error(e.getMessage(), e);
            }
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
