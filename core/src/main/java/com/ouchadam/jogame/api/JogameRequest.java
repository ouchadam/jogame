package com.ouchadam.jogame.api;

import com.github.kevinsawicki.http.HttpRequest;

public class JogameRequest {

    private final HttpRequest request;

    public JogameRequest(HttpRequest request) {
        this.request = request;
    }

    public HttpRequest asRequest() {
        return request;
    }

    public String getRedirect() {
        return request.header("Location");
    }

}
