package com.ouchadam.jogame.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class CookieParser {

    private static final String LOGIN_TAG = "login_100217=";
    private static final String PRSESS_TAG = "prsess_100217=";
    private static final String PHPSESSID_TAG = "PHPSESSID=";
    private static final String EXPIRES_TAG = "expires=";
    private static final String DATE_FORMAT = "EEE, d-MMM-yyyy HH:mm:ss zzz";

    public Cookie parse(String exportedCookie, long expires) {
        String login = find(LOGIN_TAG, exportedCookie);
        String prsess = find(PRSESS_TAG, exportedCookie);
        String phpsessid = find(PHPSESSID_TAG, exportedCookie);
        return new Cookie(login, prsess, phpsessid, expires);
    }

    public Cookie parse(String[] cookieHeaders) {
        List<String> headers = breakDownHeaders(cookieHeaders);
        String login = find(LOGIN_TAG, headers);
        String prsess = find(PRSESS_TAG, headers);
        String phpsessid = find(PHPSESSID_TAG, headers);
        long expires = toLongDate(headers);
        return new Cookie(login, prsess, phpsessid, expires);
    }

    private long toLongDate(List<String> headers) {
        String expiresString = find(EXPIRES_TAG, headers, 1).substring(EXPIRES_TAG.length());
        // Fri, 16-May-2014 11:28:32 GMT
        SimpleDateFormat parserSDF = new SimpleDateFormat(DATE_FORMAT);
        try {
            return parserSDF.parse(expiresString).getTime();
        } catch (ParseException e) {
            throw new RuntimeException("Couldn't parse date : " + expiresString, e);
        }
    }

    private List<String> breakDownHeaders(String[] cookieHeaders) {
        List<String> cookies = new ArrayList<String>();
        for (String cookieHeader : cookieHeaders) {
            String[] split = cookieHeader.split(";");
            Collections.addAll(cookies, split);
        }
        return cookies;
    }

    private String find(String tag, List<String> input) {
        return find(tag, input, 0);
    }

    private String find(String tag, List<String> input, int ignoreCount) {
        int ignored = 0;
        Iterator<String> iterator = input.iterator();
        while (iterator.hasNext()) {
            String cookieHeader = iterator.next();
            if (cookieHeader.contains(tag)) {
                iterator.remove();
                if (ignored == ignoreCount) {
                    return cookieHeader.trim();
                } else {
                    ignored++;
                }
            }
        }
        throw new RuntimeException("Cookie doesn't contain : " + tag);
    }

    private String find(String tag, String input) {
        if (input.contains(tag)) {
            int start = input.indexOf(tag);
            int end = input.indexOf(';', start);
            return input.substring(start, end);
        }
        throw new RuntimeException("Cookie doesn't contain : " + tag);
    }

}
