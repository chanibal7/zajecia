/************************************************
 *
 *  Copyright �2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 23-12-2023 *
 *****************************************************/
package com.software.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.software.annotation.PasswordComplexity;

public class UserResetPasswordDto implements Serializable {

    private static final long serialVersionUID = 8254876882533757747L;

    @NotNull
    private String token;

    @PasswordComplexity
    private String newPassword;

    @PasswordComplexity
    private String confirmedNewPassword;

    public UserResetPasswordDto() {
        super();
    }

    private UserResetPasswordDto(final String tokenArg) {
        super();
        this.token = tokenArg;
    }

    public String getToken() {
        return token;
    }

    public void setToken(final String tokenArg) {
        this.token = tokenArg;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(final String newPasswordArg) {
        this.newPassword = newPasswordArg;
    }

    public String getConfirmedNewPassword() {
        return confirmedNewPassword;
    }

    public void setConfirmedNewPassword(final String confirmedNewPasswordArg) {
        this.confirmedNewPassword = confirmedNewPasswordArg;
    }

    public static UserResetPasswordDto createEmptyWithToken(final String tokenArg) {
        return new UserResetPasswordDto(tokenArg);
    }
}