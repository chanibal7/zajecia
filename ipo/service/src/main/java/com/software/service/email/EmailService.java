/************************************************
 *
 *  Copyright �2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 18-12-2023 *
 *****************************************************/
package com.software.service.email;


public interface EmailService {

    public void sendResetPasswordEmail(String resetLink, String to);
}
