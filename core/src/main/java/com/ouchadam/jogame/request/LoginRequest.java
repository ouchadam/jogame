package com.ouchadam.jogame.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.ouchadam.jogame.api.Cookie;
import com.ouchadam.jogame.api.JogameRequest;
import com.ouchadam.jogame.api.JogameRequestBuilder;
import com.ouchadam.jogame.api.Session;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.nodes.Document;

class LoginRequest extends ApiRequest<Session> {

    private static final String LOGIN_URL = "http://en.ogame.gameforge.com/main/login";

    private static final String PARAM_UNIVERSE = "uni";
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "pass";
    private static final String PARAM_KID = "kid";
    private static final String YAKINI_UNIVERSE = "s125-en.ogame.gameforge.com";

    private final String username;
    private final String password;

    LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    protected JogameRequest buildRequest() {
        JogameRequest form = JogameRequestBuilder.post().url(LOGIN_URL).form(createParams(username, password));
        String redirect = form.getRedirect();
        if (redirect.contains("Error")) {
            throw new RuntimeException("Login failed");
        }
        return JogameRequestBuilder.get().url(redirect).build();
    }

    private Map<String, String> createParams(String username, String password) {
        Map<String, String> params = new HashMap<String, String>();
        params.put(PARAM_UNIVERSE, YAKINI_UNIVERSE);
        params.put(PARAM_LOGIN, username);
        params.put(PARAM_PASSWORD, password);
        params.put(PARAM_KID, "");
        return params;
    }

    @Override
    protected Session onResult(Document ignore, JogameRequest request) {
        try {
            return new Session(getCookie(request.asRequest()));
        } catch (HttpRequest.HttpRequestException e) {
            throw new RuntimeException("Session failed");
        }
    }

    private Cookie getCookie(HttpRequest httpRequest) {
        String[] cookies = httpRequest.headers("Set-Cookie");
        return Cookie.from(cookies);
    }
}
