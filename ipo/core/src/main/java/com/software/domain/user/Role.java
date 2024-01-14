/************************************************
 *
 
 *  AP Software Services
 *
 *  @project: zajecia
 *  @subproject: zajecia-core
 *
 *  @author: Andrzej Piechocki
 *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-12-06
 *
 *****************************************************/
package com.software.domain.user;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.software.domain.BaseEntity;

@Entity
@Table(name = "ROLE")
public class Role extends BaseEntity {

    @Column(name = "NAME", nullable = false, length = 64)
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @JoinTable(name = "USER_ROLE", joinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<UserProfile> userProfiles;

    @Column(name = "MESSAGE_KEY", nullable = false)
    private String messageKey;

    public Role() {
    }

    public Role(final String descriptionA, final String nameA, final List<UserProfile> userProfilesA) {
        this.description = descriptionA;
        this.name = nameA;
        this.userProfiles = userProfilesA;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public List<UserProfile> getUserProfiles() {
        return this.userProfiles;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public void setDescription(final String descriptionA) {
        this.description = descriptionA;
    }

    public void setName(final String nameA) {
        this.name = nameA;
    }

    public void setUserProfiles(final List<UserProfile> userProfilesA) {
        this.userProfiles = userProfilesA;
    }
}