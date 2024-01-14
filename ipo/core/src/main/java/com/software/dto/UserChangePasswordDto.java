/************************************************
 *
 *  Copyright 2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 23-12-2023
 *
 *****************************************************/
package com.software.dto;

import com.software.annotation.PasswordComplexity;

public class UserChangePasswordDto extends UserResetPasswordDto {

    private static final long serialVersionUID = 8254876882533727747L;

    @PasswordComplexity
    private String currentPassword;

    public UserChangePasswordDto() {
        super();
    }

    public static UserChangePasswordDto createEmptyDto() {
        return new UserChangePasswordDto();
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(final String currentPasswordArg) {
        this.currentPassword = currentPasswordArg;
    }
}