/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-test-resources
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-12-10
 *
 *****************************************************/
package com.software.test.data;

import java.util.HashSet;
import java.util.Set;

import com.software.domain.user.Role;
import com.software.domain.user.UserProfile;

public final class UserData {

    private UserData() {
        super();
    }

    public static UserProfile createUserProfileWithFailedAttempts(final int failedAttempts) {
        final UserProfile userProfile = new UserProfile();
        userProfile.setFailedAttempts(failedAttempts);
        return userProfile;
    }

    public static UserProfile createUserProfileWithRoles(final Role role) {
        final UserProfile userProfile = new UserProfile();
        final Set<Role> roles = new HashSet<Role>();
        if (role != null) {
            roles.add(role);
        }
        userProfile.setRoles(roles);
        userProfile.setPassword("password");
        userProfile.setEmail("email");
        userProfile.setActive(true);
        return userProfile;
    }
}