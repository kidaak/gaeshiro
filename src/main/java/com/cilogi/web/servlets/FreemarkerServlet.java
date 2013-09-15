// Copyright (c) 2012 Tim Niblett. All Rights Reserved.
//
// File:        FreemarkerServlet.java  (07-Oct-2012)
// Author:      tim
//
// Copyright in the whole and every part of this source file belongs to
// Tim Niblett (the Author) and may not be used, sold, licenced, 
// transferred, copied or reproduced in whole or in part in 
// any manner or form or in or on any media to any person other than 
// in accordance with the terms of The Author's agreement
// or otherwise without the prior written consent of The Author.  All
// information contained in this source file is confidential information
// belonging to The Author and as such may not be disclosed other
// than in accordance with the terms of The Author's agreement, or
// otherwise, without the prior written consent of The Author.  As
// confidential information this source file must be kept fully and
// effectively secure at all times.
//


package com.cilogi.web.servlets;

import com.cilogi.shiro.gaeuser.IGaeUserDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

//
//  I originally used FreemarkerServlet, but it didn't work with HTTPS for some reason.
//
@Singleton
public class FreemarkerServlet extends BaseServlet {
    static final Logger LOG = Logger.getLogger(FreemarkerServlet.class.getName());

    @Inject
    public FreemarkerServlet(IGaeUserDAO gaeUserDAO) {
        super(gaeUserDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        showView(response, uri, mapping(request));
    }
}