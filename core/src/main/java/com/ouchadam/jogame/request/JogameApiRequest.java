package com.ouchadam.jogame.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.ouchadam.jogame.api.JogameRequest;
import com.ouchadam.jogame.api.JogameRequestBuilder;
import com.ouchadam.jogame.api.Session;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class JogameApiRequest<T> extends ApiRequest<T> {

    private static final String DEFAULT_PLANET = "default_planet";
    private final SessionValidator sessionValidator;
    private final String planet;

    JogameApiRequest(SessionValidator sessionValidator) {
        this(sessionValidator, DEFAULT_PLANET);
    }

    protected JogameApiRequest(SessionValidator sessionValidator, String planet) {
        this.sessionValidator = sessionValidator;
        this.planet = planet;
    }

    @Override
    final protected Document open(JogameRequest jogameRequestBuilder) {
        HttpRequest request = jogameRequestBuilder.asRequest();
        sessionValidator.validateSession(request);
        return Jsoup.parse(request.body());
    }

    protected abstract JogameRequest buildRequest(Session session, String planet);

    @Override
    final protected JogameRequest buildRequest() {
        throw new RuntimeException("Should not be used");
    }

    @Override
    final public T execute() {
        throw new RuntimeException("Should not be used");
    }

    final public T execute(Session session) {
        JogameRequest jogameRequest = buildRequest(session, planet);
        return onResult(open(jogameRequest), jogameRequest);
    }

    protected void attachPlanet(String planet, JogameRequestBuilder.builder builder) {
        if (hasPlanet()) {
            builder.planet(planet);
        }
    }

    private boolean hasPlanet() {
        return !DEFAULT_PLANET.equals(planet);
    }

}
