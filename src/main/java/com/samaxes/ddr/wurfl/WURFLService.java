/** TODO...
 *
 *
 *
 *
 *
 * $Id: WURFLService.java,v 1.1 2012/05/31 12:03:09 ssantos Exp $
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
 * Singleton to access {@link WURFLManager} and {@link WURFLUtils} instances.
 *
 * @author Samuel Santos
 * @version $Revision: 1.1 $
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
    public void start() {
        if (wurflHolder == null) {
            LOGGER.info("Starting Device Description Repository API service.");

            wurflHolder = new CustomWURFLHolder(WURFLService.class.getResource("/wurfl/wurfl-2.1.1.xml.gz").toString());
        }
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
