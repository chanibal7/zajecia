/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-webapp
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 23-12-2023
 *
 *****************************************************/
package com.software.controller.helper;

import javax.servlet.http.HttpServletRequest;

public final class UrlHelper {

    private UrlHelper() {
        super();
    }

    /**
     * Full full path of serwer
     *
     * @param request
     * @return the full path of app eg: http://localhost:8080/zajecia/
     */
    public static String getServerUrl(final HttpServletRequest request) {
        final StringBuilder appUrl = new StringBuilder();
        appUrl.append(request.getScheme());
        appUrl.append("://");
        appUrl.append(request.getServerName());
        appUrl.append(":");
        appUrl.append(request.getServerPort());
        appUrl.append(request.getContextPath());
        return appUrl.toString();
    }
}
