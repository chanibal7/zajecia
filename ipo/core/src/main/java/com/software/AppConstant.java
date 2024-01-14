package com.software;

public final class AppConstant {

    public static final class SessionAttribute {
        public static final String SHOW_RECAPTCHA = "showCaptcha";
        public static final String ADDITIONAL_LOGIN_ATTEMPT_ERROR_MESSAGE = "additionalLoginAttemptErrorMessage";
        public static final String SESSION_LOCALE = "sessionLocale";

        private SessionAttribute() {
            super();
        }

    }

    public static final class JobTypes {
        public static final String JOB = "job";
        public static final String SMS_SEND = "sms_send";
        public static final String SMS_RECEIVE = "sms_receive";
        public static final String EMAIL = "email";

        private JobTypes() {
            super();
        }

    }

    public enum Roles {
        ROLE_USAGE_AGREEMENT_PROVIDER, ROLE_PROJECT_MANAGER
    }

    private AppConstant() {
        super();
    }
}