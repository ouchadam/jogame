package com.ouchadam.jogame.request;

import com.ouchadam.jogame.api.JogameRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class ApiRequest<T> {

    protected static final String BASE_LOGGED_IN_URL = "http://s125-en.ogame.gameforge.com/game/index.php";

    public T execute() {
        JogameRequest request = buildRequest();
        return onResult(open(request), request);
    }

    protected abstract JogameRequest buildRequest();

    protected Document open(JogameRequest jogameRequest) {
        return Jsoup.parse(jogameRequest.asRequest().body());
    }

    protected abstract T onResult(Document document, JogameRequest request);

}
