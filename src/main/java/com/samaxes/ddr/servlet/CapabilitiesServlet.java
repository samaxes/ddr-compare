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
package com.samaxes.ddr.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.samaxes.ddr.model.FiftyoneCapability;
import com.samaxes.ddr.model.OpenDDRCapability;
import com.samaxes.ddr.model.WURFLCapability;
import com.samaxes.ddr.openddr.OpenDDRService;
import com.samaxes.ddr.wurfl.WURFLService;

/**
 * Capabilities Servlet.
 */
@WebServlet("/")
public class CapabilitiesServlet extends HttpServlet {

    private static final long serialVersionUID = -4946904911604226714L;

    @Inject
    private OpenDDRService openDDRService;

    @Inject
    private WURFLService wurflService;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WURFLCapability wurflCapability = new WURFLCapability(wurflService, request);
        request.setAttribute("wurflCapability", wurflCapability);
        OpenDDRCapability openDDRCapability = new OpenDDRCapability(openDDRService, request);
        request.setAttribute("openDDRCapability", openDDRCapability);
        FiftyoneCapability fiftyoneCapability = new FiftyoneCapability(request);
        request.setAttribute("fiftyoneCapability", fiftyoneCapability);

        request.getRequestDispatcher("/WEB-INF/capabilities.jsp").forward(request, response);
    }
}
