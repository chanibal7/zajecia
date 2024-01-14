/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki *           <br/>
 *           Andrzej.Piechocki@software.com
 *
 *  Created: 2023-12-10
 *
 *****************************************************/
package com.software.service.auth.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyMap;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.software.test.data.UserData;
import com.software.dao.user.UserDAO;
import com.software.domain.user.UserProfile;
import com.software.exceptions.ReCaptchaValidException;
import com.software.json.model.ReCaptchaAnswerVO;
import com.software.service.auth.ReCaptcha;
import com.software.service.auth.ReCaptchaImpl;
import com.software.service.auth.ReCaptchaImpl.ErrorCodes;

/**
 * Test class for service {@link com.software.service.auth.ReCaptchaImpl ReCaptchaImpl}
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReCaptchaImplTest {

    private static final String              TEST           = "test";

    @Mock
    UserDAO                                  userDao;

    @InjectMocks
    ReCaptcha                                captchaService = new ReCaptchaImpl();

    @Mock
    RestTemplate                             restTemplate;

    @Mock
    ReCaptchaAnswerVO                        reCaptchaAnswerVO;

    @Rule
    public org.junit.rules.ExpectedException exception      = org.junit.rules.ExpectedException.none();

    private void mockCaptchaForInvalidData() {
        final UserProfile userProfile = UserData.createUserProfileWithFailedAttempts(3);
        ReflectionTestUtils.setField(this.captchaService, "restTemplate", this.restTemplate);

        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(userProfile);
        Mockito.when(this.restTemplate.postForObject(anyString(), anyMap(), eq(ReCaptchaAnswerVO.class)))
        .thenReturn(this.reCaptchaAnswerVO);
        Mockito.when(this.reCaptchaAnswerVO.getSuccess()).thenReturn(Boolean.FALSE);
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldNotUseReCaptchaBecauseNoFailedAttempts() {

        // given
        final UserProfile userProfile = UserData.createUserProfileWithFailedAttempts(0);

        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(userProfile);

        // when
        final boolean shouldReCaptchaBeUsed = this.captchaService.shouldReCaptchaBeUsed(TEST);

        // then
        assertFalse(shouldReCaptchaBeUsed);
    }

    @Test
    public void shouldNotUseReCaptchaBecauseNoUserFound() {

        // given
        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(null);

        // when
        final boolean shouldReCaptchaBeUsed = this.captchaService.shouldReCaptchaBeUsed(TEST);

        // then
        assertFalse(shouldReCaptchaBeUsed);
    }

    @Test
    public void shouldNotUseReCaptchaBecauseTwoTimesFailedAttempts() {

        // given
        final UserProfile userProfile = UserData.createUserProfileWithFailedAttempts(2);

        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(userProfile);

        // when
        final boolean shouldReCaptchaBeUsed = this.captchaService.shouldReCaptchaBeUsed(TEST);

        // then
        assertFalse(shouldReCaptchaBeUsed);
    }

    @Test
    public void shouldPositiveVerifyCaptcha() {

        // given
        final UserProfile userProfile = UserData.createUserProfileWithFailedAttempts(3);
        ReflectionTestUtils.setField(this.captchaService, "restTemplate", this.restTemplate);

        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(userProfile);
        Mockito.when(this.restTemplate.postForObject(anyString(), anyMap(), eq(ReCaptchaAnswerVO.class)))
        .thenReturn(this.reCaptchaAnswerVO);
        Mockito.when(this.reCaptchaAnswerVO.getSuccess()).thenReturn(Boolean.TRUE);

        // when
        Exception catched = null;
        try {
            this.captchaService.verify(TEST, "response");
        } catch (final Exception ex) {
            catched = ex;
        }

        // then
        assertNull(catched);
    }

    @Test
    public void shouldPositiveVerifyWithoutCaptcha() {

        // given
        final UserProfile userProfile = UserData.createUserProfileWithFailedAttempts(1);
        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(userProfile);

        // when
        Exception catched = null;
        try {
            this.captchaService.verify(TEST, "response");
        } catch (final Exception ex) {
            catched = ex;
        }

        // then
        assertNull(catched);
    }

    @Test
    public void shouldThrowExceptionIfNotPositiveVerificationAppearFromCaptchaInvalidResponse()
            throws ReCaptchaValidException {

        // given
        this.exception.expect(ReCaptchaValidException.class);

        this.mockCaptchaForInvalidData();

        Mockito.when(this.reCaptchaAnswerVO.getErrorCodes()).thenReturn(new String[] { ErrorCodes.INVALID_INPUT_RESPONSE.getKey() });

        // when
        this.captchaService.verify(TEST, "response");
    }

    @Test
    public void shouldThrowExceptionIfNotPositiveVerificationAppearFromCaptchaInvalidSecret()
            throws ReCaptchaValidException {

        // given
        this.exception.expect(ReCaptchaValidException.class);

        this.mockCaptchaForInvalidData();

        Mockito.when(this.reCaptchaAnswerVO.getErrorCodes()).thenReturn(new String[] { ErrorCodes.INVALID_INPUT_SECRET.getKey() });

        // when
        this.captchaService.verify(TEST, "response");
    }

    @Test
    public void shouldThrowExceptionIfNotPositiveVerificationAppearFromCaptchaMissingResponse()
            throws ReCaptchaValidException {

        // given
        this.exception.expect(ReCaptchaValidException.class);

        this.mockCaptchaForInvalidData();

        Mockito.when(this.reCaptchaAnswerVO.getErrorCodes()).thenReturn(new String[] { ErrorCodes.MISSING_INPUT_RESPONSE.getKey() });

        // when
        this.captchaService.verify(TEST, "response");
    }

    @Test
    public void shouldThrowExceptionIfNotPositiveVerificationAppearFromCaptchaMissingSecret()
            throws ReCaptchaValidException {

        // given
        this.exception.expect(ReCaptchaValidException.class);

        this.mockCaptchaForInvalidData();

        Mockito.when(this.reCaptchaAnswerVO.getErrorCodes()).thenReturn(new String[] { ErrorCodes.MISSING_INPUT_SECRET.getKey() });

        // when
        this.captchaService.verify(TEST, "response");
    }

    @Test
    public void shouldThrowExceptionIfNotPositiveVerificationAppearFromCaptchUnknowCode()
            throws ReCaptchaValidException {

        // given
        this.exception.expect(ReCaptchaValidException.class);

        this.mockCaptchaForInvalidData();

        Mockito.when(this.reCaptchaAnswerVO.getErrorCodes()).thenReturn(new String[] { "" });

        // when
        this.captchaService.verify(TEST, "response");
    }

    @Test
    public void shouldUseReCaptchaBecauseThreeTimesFailedAttempts() {

        // given
        final UserProfile userProfile = UserData.createUserProfileWithFailedAttempts(3);

        Mockito.when(this.userDao.findByUsername(anyString())).thenReturn(userProfile);

        // when
        final boolean shouldReCaptchaBeUsed = this.captchaService.shouldReCaptchaBeUsed(TEST);

        // then
        assertTrue(shouldReCaptchaBeUsed);
    }
}