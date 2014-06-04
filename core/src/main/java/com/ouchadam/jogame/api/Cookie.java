package com.ouchadam.jogame.api;

public class Cookie {

    private final String login;
    private final String prsess;
    private final String phpsessid;
    private final long expires;

    Cookie(String login, String prsess, String phpsessid, long expires) {
        this.login = login;
        this.prsess = prsess;
        this.phpsessid = phpsessid;
        this.expires = expires;
    }

    public static Cookie from(String exportedCookie, long expires) {
        return new CookieParser().parse(exportedCookie, expires);
    }

    public static Cookie from(String[] cookieHeader) {
        return new CookieParser().parse(cookieHeader);
    }

    public String export() {
        return phpsessid + "; " + prsess + "; " + login + ";";
    }

    public long expires() {
        return expires;
    }

    public String sessionId() {
        return phpsessid;
    }
}
