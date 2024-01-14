/************************************************
 *
 *  Copyright �2023
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-20
 *
 *****************************************************/
package com.software.domain.user;


import com.software.domain.BaseEntity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="USER_IMAGE")
public class UserImage extends BaseEntity {

    @Lob
    @Column(name = "raw_data")
    private byte[] rawData;

    @Column(name = "mime_type", nullable = false)
    private String mimeType;

    @OneToMany(mappedBy = "userImage")
    private List<UserProfile> userProfiles;

    public UserImage() {
    }

    public byte[] getRawData() {
        return rawData;
    }

    public void setRawData(byte[] rawData) {
        this.rawData = rawData;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }
}
