package com.ouchadam.jogame.api;

public class Session {

    private final Cookie session;

    public Session(Cookie cookie) {
        this.session = cookie;
    }

    public String value() {
        return session.export();
    }

    public long getExpiration() {
        return session.expires();
    }

    public String getPhpSession() {
        return session.sessionId();
    }
}
