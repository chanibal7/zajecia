/************************************************
 *
 *  Copyright �2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki*           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-20
 *
 *****************************************************/

package com.software.domain.user;

import com.software.domain.UserPhonePK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name="USER_PHONE")
public class UserPhone implements Serializable{

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected UserPhonePK priUserKey;

    @Column(name = "PHONE_NUMBER", nullable = false, length = 16)
    private String phoneNumber;

    public UserPhone() {
    }

    public UserPhone(UserPhonePK priUserKey, String phoneNumber) {
        this.priUserKey = priUserKey;
        this.phoneNumber = phoneNumber;
    }

    public UserPhonePK getPriUserKey() {
        return priUserKey;
    }

    public void setUserKey(UserPhonePK priUserKey) {
        this.priUserKey = priUserKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
