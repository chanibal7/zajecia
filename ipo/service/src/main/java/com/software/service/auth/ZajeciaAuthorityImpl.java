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
 *  Created: 2023-12-17
 *
 *****************************************************/
package com.software.service.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.AppConstant;
import com.software.dao.user.UserDAO;
import com.software.domain.user.Role;
import com.software.domain.user.UserProfile;
import com.software.exceptions.RedirectException;

@Service
public class ZajeciaAuthorityImpl implements ZajeciaAuthority {

    @Autowired
    private UserDAO userDao;

    private Authentication allowOnlyForAgreementProviding(final Authentication authentication) {

        // Remove all granted authorities and add only one to enable user to provide agreement for application usage
        final List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(AppConstant.Roles.ROLE_USAGE_AGREEMENT_PROVIDER.toString()));
        return new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
    }

    @Override
    @Transactional
    public void acceptZajeciaAgreementAndReloadAuthorities() {

        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final String userName = authentication.getName();
        final UserProfile userProfile = userDao.findByUsername(userName);
        userProfile.setUsageAgreementDate(new Date());
        userDao.update(userProfile);
        final Set<Role> roles = userProfile.getRoles();
        final List<GrantedAuthority> authorities = ZajeciaUserDetailsService.buildUserAuthority(roles);
        final Authentication newAuthentication = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), authentication.getCredentials(), authorities);
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);
    }

    @Override
    public boolean validate(final Authentication authentication, final HttpServletRequest request, final HttpServletResponse response) throws RedirectException {

        final UserWithSalt user = (UserWithSalt) authentication.getPrincipal();
        if ((user != null) && !user.iszajeciaUsageAgreement()) {
            try {
                // Save manually information about authentication in security context
                SecurityContextHolder.getContext().setAuthentication(allowOnlyForAgreementProviding(authentication));
                response.sendRedirect("usage-agreement.htm");
                return false;
            } catch (final IOException e) {
                throw new RedirectException(e);
            }
        }
        return true;
    }
}
