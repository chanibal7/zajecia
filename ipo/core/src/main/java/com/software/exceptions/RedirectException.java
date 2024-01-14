/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki *           <br/>
 * \*           andrzej.piechocki@software.com*
 *  Created: 2023-12-11
 *
 *****************************************************/
package com.software.exceptions;

import java.io.IOException;

public class RedirectException extends IOException {
    public RedirectException(String message) {
        super(message);
    }

    public RedirectException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedirectException(Throwable cause) {
        super(cause);
    }
}
