package com.ouchadam.jogame.request;

import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.Buildable;
import com.ouchadam.jogame.domain.FleetEvent;
import com.ouchadam.jogame.domain.Research;
import com.ouchadam.jogame.domain.page.Overview;
import com.ouchadam.jogame.parser.ParserFactory;

import java.util.List;

public class RequestFactory {

    private final ParserFactory parserFactory;
    private final SessionValidator sessionValidator;

    public RequestFactory(ParserFactory parserFactory, SessionValidator sessionValidator) {
        this.parserFactory = parserFactory;
        this.sessionValidator = sessionValidator;
    }

    public static RequestFactory newInstance() {
        return new RequestFactory(new ParserFactory(), new SessionValidator());
    }

    public JogameApiRequest<List<Buildable>> resourceBuildings(String planet) {
        return new ResourceBuildingsRequest(sessionValidator, planet, parserFactory.resource());
    }

    public JogameApiRequest<List<Research>> research(String planet) {
        return new ResearchRequest(sessionValidator, planet, parserFactory.research());
    }

    public JogameApiRequest<Overview> overview(String planet) {
        return new OverviewRequest(sessionValidator, planet, parserFactory.everyPage(), parserFactory.activeConstructions());
    }

    public JogameApiRequest<Overview> overview() {
        return new OverviewRequest(sessionValidator, parserFactory.everyPage(), parserFactory.activeConstructions());
    }

    public ApiRequest<Session> login(String username, String password) {
        return new LoginRequest(username, password);
    }

    public JogameApiRequest<List<FleetEvent>> fleetEvent() {
        return new FleetEventRequest(sessionValidator, parserFactory.fleetEvent());
    }

    public JogameApiRequest<String> fleetToken(String planet) {
        return new FleetTokenRequest(sessionValidator, planet, parserFactory.fleet3());
    }

    public JogameApiRequest<List<Buildable>> facilityBuildings(String planet) {
        return new FacilityBuildingsRequest(sessionValidator, planet, parserFactory.resource());
    }
}
