package com.ouchadam.jogame.request;

import com.github.kevinsawicki.http.HttpRequest;

class SessionValidator {

    private static final String SESSION_EXPIRED_REDIRECT = "http://ogame.org";
    private static final int HTTP_SESSION_REDIRECT_CODE = 302;

    void validateSession(HttpRequest request) {
        if (sessionIsInvalid(request)) {
            throw new SessionException();
        }
    }

    private boolean sessionIsInvalid(HttpRequest request) {
        return isRedirect(request.code()) && isRedirectingToBadSession(request.location());
    }

    private boolean isRedirectingToBadSession(String url) {
        return SESSION_EXPIRED_REDIRECT.equals(url);
    }

    private boolean isRedirect(int code) {
        return code == HTTP_SESSION_REDIRECT_CODE;
    }

}
