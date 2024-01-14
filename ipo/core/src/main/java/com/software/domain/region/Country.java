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

package com.software.domain.region;

import com.software.domain.BaseEntity;
import com.software.domain.user.UserProfile;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "COUNTRY")
public class Country extends BaseEntity {

    @Column(name="NAME", nullable = false)
    private String name;

    @Column(name = "MESSAGE_KEY")
    private String messageKey;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<UserProfile> userProfiles;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private List<DutyStation> dutyStations;

    public Country() {
    }

    public Country(Long id, String name, String messageKey) {
        this.id = id;
        this.name = name;
        this.messageKey = messageKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserProfile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }

    public List<DutyStation> getDutyStations() {
        return dutyStations;
    }

    public void setDutyStations(List<DutyStation> dutyStations) {
        this.dutyStations = dutyStations;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

}
