/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-05
 *
 *****************************************************/

package com.software.exceptions;

import org.springframework.security.core.AuthenticationException;

public class ReCaptchaAuthenticationException extends AuthenticationException {

    private static final long serialVersionUID = 3979430740086079943L;

    public ReCaptchaAuthenticationException(final String msg) {
        super(msg);
    }

    public ReCaptchaAuthenticationException(final String msg, final Throwable t) {
        super(msg, t);
    }
}