package com.software.domain;

import com.software.domain.lookup.PhoneTypeEnum;
import com.software.domain.lookup.converter.PhoneTypeEnumConverter;

import javax.persistence.*;

import java.io.Serializable;

@Embeddable
public class UserPhonePK implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name="PHONE_TYPE_ID")
    //@Embedded
    @Convert(converter = PhoneTypeEnumConverter.class)
    private PhoneTypeEnum phoneType;

    public UserPhonePK() {
    }

    public UserPhonePK(long userId, PhoneTypeEnum phoneType) {
        this.userId = userId;
        this.phoneType = phoneType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public PhoneTypeEnum getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneTypeEnum phoneType) {
        this.phoneType = phoneType;
    }
}
