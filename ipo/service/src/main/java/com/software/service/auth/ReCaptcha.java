/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-05
 *
 *****************************************************/

package com.software.service.auth;

import com.software.exceptions.ReCaptchaValidException;

public interface ReCaptcha {
    boolean shouldReCaptchaBeUsed(String username);

    void verify(String username, String response)
            throws ReCaptchaValidException;
}
