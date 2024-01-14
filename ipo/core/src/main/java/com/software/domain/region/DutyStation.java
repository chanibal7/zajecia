/************************************************
 *
 *  Copyright �2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-03-20
 *
 *****************************************************/

package com.software.domain.region;

import com.software.domain.BaseEntity;
import com.software.domain.user.UserProfile;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "DUTY_STATION")
public class DutyStation extends BaseEntity{

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToMany(mappedBy = "dutyStation")
    private List<UserProfile> userProfiles;

    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
