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
 *  Created: 20-12-2023
 *
 *****************************************************/
package com.software.service;

import com.software.domain.user.UserProfile;
import com.software.dto.UserChangePasswordDto;

public interface UserService {

    public UserProfile findUniqueUserByEmailIgnoreCaseSensivity(final String userEmail);

    public void saveTokenIntoDB(String username, String token);

    public void sendResetPasswordEmail(String username, String serverUrl);

    public void setPasswordAndActiveAccount(final String token, final String password);

    public boolean checkAvailabilityOfToken(String token);

    boolean isCurrentPasswordExistsForLoggedUser(final UserChangePasswordDto dto);

    public void changePassword(final UserChangePasswordDto dto);
}
