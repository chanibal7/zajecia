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
 \*           andrzej.piechocki@software.com
 *
 *  Created: 2023-12-05
 *
 *****************************************************/

package com.software.service.auth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.dao.user.UserDAO;
import com.software.domain.user.Role;
import com.software.domain.user.UserProfile;

@Service("userDetailsService")
public class ZajeciaUserDetailsService
        implements UserDetailsService {

    private static final Logger LOGGER = Logger.getLogger(UserDetailsService.class);

    @Autowired private UserDAO userDAO;

    @Transactional(readOnly = true)
    public static List<GrantedAuthority> buildUserAuthority(final Set<Role> roles) {
        final Set<GrantedAuthority> setAuths = new HashSet<>();

        for (final Role role : roles) {
            setAuths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new ArrayList<>(setAuths);
    }

    private UserWithSalt buildUserForAuthentication(final UserProfile user, final List<GrantedAuthority> authorities) {
        final UserWithSalt userWithSalt =
            new UserWithSalt(user.getEmail(), user.getPassword(), user.isActive(), true, true, true, authorities);
        userWithSalt.setSalt(user.getSalt());
        userWithSalt.setzajeciaUsageAgreement( user.getUsageAgreementDate() != null );
        return userWithSalt;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String userName)
        throws UsernameNotFoundException {

        final UserProfile userProfile = this.userDAO.findByUsername(userName);

        if (userProfile == null) {
            LOGGER.info("User: '" + userName + "' doesn't exist in the database");
            throw new UsernameNotFoundException("Incorrect username or password");
        }
        final Set<Role> roles = userProfile.getRoles();
        final List<GrantedAuthority> authorities = buildUserAuthority(roles);
        return this.buildUserForAuthentication(userProfile, authorities);
    }
}