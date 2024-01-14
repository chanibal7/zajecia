/************************************************
 *
 *  Copyright ©2023  *  AP Software Services *
 *  @project: zajecia
 *  @subproject: zajecia-service
 *
 *  @author: Andrzej Piechocki           <br/>
 *\*           andrzej.piechocki@software.com *
 *  Created: 2023-12-05
 *
 *****************************************************/
package com.software.service.auth;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.software.dao.user.UserDAO;
import com.software.domain.user.UserProfile;
import com.software.exceptions.ReCaptchaValidException;
import com.software.json.model.ReCaptchaAnswerVO;

@Service("ReCaptcha")
public class ReCaptchaImpl implements ReCaptcha {

    public static enum ErrorCodes {
        MISSING_INPUT_SECRET("missing-input-secret","The secret parameter is missing"),
        INVALID_INPUT_SECRET("invalid-input-secret","The secret parameter is invalid or malformed"),
        MISSING_INPUT_RESPONSE("missing-input-response", "The response parameter is missing"),
        INVALID_INPUT_RESPONSE("invalid-input-response", "The response parameter is invalid or malformed"),
        UNKNOWN_ERROR_DESCRIPTION("", "Unknown Captcha error occured");

        private final String key;
        private final String value;

        private ErrorCodes(final String keyA, final String valueA) {
            this.key = keyA;
            this.value = valueA;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public static String getErrorMsgByKey(final String key){
            final ErrorCodes[] values = ErrorCodes.values();
            for (final ErrorCodes errorCodes : values) {
                if(errorCodes.equals(key)){
                    return errorCodes.getValue();
                }
            }
            return UNKNOWN_ERROR_DESCRIPTION.getValue();
        }
    }

    private static final Logger LOGGER = Logger.getLogger(ReCaptchaImpl.class);
    private static final String URL = "https://www.google.com/recaptcha/api/siteverify";
    private static final String SECRET_KEY = "6LcxBQQTAAAAAFaqffo4TC8p7obAbJoZfj3_dJWc";

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private UserDAO userDao;

    @Override
    @Transactional(readOnly = true)
    public boolean shouldReCaptchaBeUsed(final String username) {
        final UserProfile userProfile = this.userDao.findByUsername(username);
        if (userProfile != null) {
            return (userProfile.getFailedAttempts() != null) && (userProfile.getFailedAttempts() >= 3);
        }
        return false;
    }

    @Override
    public void verify(final String username, final String response) throws ReCaptchaValidException {
        if (this.shouldReCaptchaBeUsed(username)) {
            this.verifyCaptchaResponse(response);
        }
    }

    private synchronized void verifyCaptchaResponse(final String response) throws ReCaptchaValidException {
        final MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("secret", SECRET_KEY);
        map.add("response", response);
        final ReCaptchaAnswerVO reCaptchaAnswerVO = this.restTemplate.postForObject(URL, map, ReCaptchaAnswerVO.class);
        LOGGER.info("Captcha verify result: " + reCaptchaAnswerVO);
        if (reCaptchaAnswerVO.getSuccess()) {
            return;
        }
        throwReCaptchaValidExceptionBasedOnErrorCode(reCaptchaAnswerVO);
    }


    private void throwReCaptchaValidExceptionBasedOnErrorCode(final ReCaptchaAnswerVO reCaptchaAnswerVO) throws ReCaptchaValidException {
        for (final String errorCode : reCaptchaAnswerVO.getErrorCodes()) {
            final String errorMsg = ErrorCodes.getErrorMsgByKey(errorCode);
            throw new ReCaptchaValidException(errorMsg);
        }
        throw new ReCaptchaValidException(ErrorCodes.UNKNOWN_ERROR_DESCRIPTION.getValue());
    }
}