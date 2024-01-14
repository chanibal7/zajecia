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
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-12-06
 *
 *****************************************************/
package com.software.service;

import com.software.domain.user.UserProfile;

public interface WelcomeService {

    public UserProfile getUserProfile(String userName);
}
