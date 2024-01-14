/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-17
 *
 *****************************************************/
package com.software.service.auth;

import com.software.exceptions.RedirectException;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ZajeciaAuthority {
    boolean validate(final Authentication authentication, final HttpServletRequest request, final HttpServletResponse response) throws RedirectException;
    void acceptZajeciaAgreementAndReloadAuthorities();
}
