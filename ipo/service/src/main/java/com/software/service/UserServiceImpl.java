/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 20-12-2023 *
 *****************************************************/
package com.software.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.software.dao.user.UserDAO;
import com.software.domain.user.UserProfile;
import com.software.dto.UserChangePasswordDto;
import com.software.service.email.EmailService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ShaPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void setPasswordAndActiveAccount(final String token, final String password) {
        final UserProfile userProfile = userDAO.findAvailableUniqueProfileByToken(token);
        if (userProfile == null) {
            throw new IllegalStateException("User not found for given token");
        }
        userProfile.setPassword(passwordEncoder.encodePassword(password, userProfile.getSalt()));
        userProfile.setActive(true);
        userProfile.setToken(null); // clear token - should not be available
                                    // once again by the same link
        userDAO.update(userProfile);
    }

    @Override
    public void saveTokenIntoDB(final String username, final String token) {
        final UserProfile userProfile = this.findUniqueUserByEmailIgnoreCaseSensivity(username);
        if (userProfile == null) {
            throw new IllegalStateException("User not found for given username");
        }
        userProfile.setToken(token);
        userProfile.setResetPasswordValidDate(new Date());
        userDAO.updateWithFlush(userProfile);
    }

    @Override
    public boolean isCurrentPasswordExistsForLoggedUser(final UserChangePasswordDto dto) {
        final UserProfile userProfile = findLoggedUser();
        return userProfile.getPassword().equals(passwordEncoder.encodePassword(dto.getCurrentPassword(), userProfile.getSalt()));
    }

    private UserProfile findLoggedUser() {
        final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return this.findUniqueUserByEmailIgnoreCaseSensivity(auth.getName());
    }

    @Override
    @Transactional
    public void sendResetPasswordEmail(final String email, final String serverUrl) {
        final String token = UUID.randomUUID().toString();
        final String appUrl = String.format("%s/new-password.htm?token=%s", serverUrl, token);
        emailService.sendResetPasswordEmail(appUrl, email);
        this.saveTokenIntoDB(email, token);
    }

    @Override
    public boolean checkAvailabilityOfToken(final String token) {
        return userDAO.isProfileTokenValid(token);
    }

    @Override
    public UserProfile findUniqueUserByEmailIgnoreCaseSensivity(final String userEmail) {
        return userDAO.findByUsername(userEmail);
    }

    @Override
    @Transactional
    public void changePassword(final UserChangePasswordDto dto) {
        final UserProfile userProfile = findLoggedUser();
        userProfile.setPassword(passwordEncoder.encodePassword(dto.getNewPassword(), userProfile.getSalt()));
        userProfile.setUpdateDate(new Date()); //TODO should be added automatically by interceptors
        userDAO.updateWithFlush(userProfile);
    }
}
