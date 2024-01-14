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

package com.software.conf;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.LocaleResolver;

import com.software.AppConstant;
import com.software.dao.user.UserDAO;
import com.software.exceptions.ReCaptchaAuthenticationException;
import com.software.exceptions.ReCaptchaValidException;
import com.software.exceptions.RedirectException;
import com.software.service.auth.ReCaptcha;
import com.software.service.auth.ZajeciaAuthority;

public class ZajeciaUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Logger LOGGER = Logger.getLogger(ZajeciaUsernamePasswordAuthenticationFilter.class);

    @Autowired
    private UserDAO userDao;

    @Autowired
    private ReCaptcha reCaptcha;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @Autowired
    private ZajeciaAuthority usageAgreement;

    @Override
    public Authentication attemptAuthentication(final HttpServletRequest request, final HttpServletResponse response) throws AuthenticationException {
        final String captchaResponse = request.getParameter("g-recaptcha-response");
        Authentication authentication = null;
        try {
            reCaptcha.verify(this.obtainUsername(request), captchaResponse);
            authentication = super.attemptAuthentication(request, response);
            return returnAuthenticationBasedOnUsageAgreement(request, response, authentication);

        } catch (final ReCaptchaValidException e) {
            if (Boolean.TRUE.equals(request.getSession().getAttribute(AppConstant.SessionAttribute.SHOW_RECAPTCHA))) {
                request.getSession().setAttribute(AppConstant.SessionAttribute.ADDITIONAL_LOGIN_ATTEMPT_ERROR_MESSAGE,
                        this.messageSource.getMessage("login.invalid.rechaptcha", null, this.localeResolver.resolveLocale(request)));
            } else {
                request.getSession().setAttribute(AppConstant.SessionAttribute.ADDITIONAL_LOGIN_ATTEMPT_ERROR_MESSAGE,
                        this.messageSource.getMessage("login.missing.recaptcha", null, this.localeResolver.resolveLocale(request)));
            }
            throw new ReCaptchaAuthenticationException(e.getMessage(), e);
        }
    }

    private Authentication returnAuthenticationBasedOnUsageAgreement(final HttpServletRequest request, final HttpServletResponse response,
            final Authentication authentication) {
        try {
            if (!usageAgreement.validate(authentication, request, response)) {
                // Below, by returning null I want to interrupt security
                // chain processing. I have to log success login attempt
                // manually
                logSuccessLogIn(request);
                // Returning null will cause interruption of further
                // security chain processing. It's necessary to execute page
                // redirect
                return null;
            }
        } catch (final RedirectException e) {
            LOGGER.error("Cannot execute page redirection", e);
        }

        return authentication;
    }

    private void logSuccessLogIn(final HttpServletRequest request) {
        this.userDao.logSuccessLogInAttempt(this.obtainUsername(request));
        request.getSession().setAttribute(AppConstant.SessionAttribute.SHOW_RECAPTCHA, false);
    }

    @Override
    protected void successfulAuthentication(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain,
            final Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, filterChain, authResult);
        logSuccessLogIn(request);
        LOGGER.debug("user has been successful authentificated");
    }

    @Override
    protected void unsuccessfulAuthentication(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
        final int failedAttemptCounter = this.userDao.logFailedLogInAttempt(this.obtainUsername(request));
        request.getSession().setAttribute(AppConstant.SessionAttribute.SHOW_RECAPTCHA, failedAttemptCounter >= 3);
        LOGGER.debug("user has not been authentificated");
    }
}