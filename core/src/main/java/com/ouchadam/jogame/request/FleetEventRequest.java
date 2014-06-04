package com.ouchadam.jogame.request;

import com.ouchadam.jogame.api.JogameRequest;
import com.ouchadam.jogame.api.JogameRequestBuilder;
import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.FleetEvent;
import com.ouchadam.jogame.parser.Parser;

import java.util.List;

import org.jsoup.nodes.Document;

class FleetEventRequest extends JogameApiRequest<List<FleetEvent>> {

    private final Parser<List<FleetEvent>> fleetEventParser;

    FleetEventRequest(SessionValidator sessionValidator, Parser<List<FleetEvent>> fleetEventParser) {
        super(sessionValidator);
        this.fleetEventParser = fleetEventParser;
    }

    @Override
    protected JogameRequest buildRequest(Session session, String planet) {
        JogameRequestBuilder.Get builder = JogameRequestBuilder.get()
                .url(BASE_LOGGED_IN_URL)
                .session(session)
                .page("eventList")
                .param("ajax", "1");
        attachPlanet(planet, builder);
        return builder.build();
    }

    @Override
    protected List<FleetEvent> onResult(Document doc, JogameRequest request) {
        return fleetEventParser.parse(doc);
    }

}
