/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki*           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-05
 *
 *****************************************************/

package com.software.exceptions;

public class ReCaptchaValidException extends Exception {

    private static final long serialVersionUID = 5988703264604576448L;

    public ReCaptchaValidException(final String message) {
        super(message);
    }

    public ReCaptchaValidException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ReCaptchaValidException(final Throwable cause) {
        super(cause);
    }
}
