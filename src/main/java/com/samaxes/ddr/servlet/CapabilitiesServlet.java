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
