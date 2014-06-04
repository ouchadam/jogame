package com.ouchadam.jogame.request;

import com.ouchadam.jogame.api.JogameRequest;
import com.ouchadam.jogame.api.JogameRequestBuilder;
import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.Buildable;
import com.ouchadam.jogame.domain.Page;
import com.ouchadam.jogame.parser.Parser;

import java.util.List;

import org.jsoup.nodes.Document;

class ResourceBuildingsRequest extends JogameApiRequest<List<Buildable>> {

    private final Parser<List<Buildable>> buildableParser;

    ResourceBuildingsRequest(SessionValidator sessionValidator, String planet, Parser<List<Buildable>> buildableParser) {
        super(sessionValidator, planet);
        this.buildableParser = buildableParser;
    }

    @Override
    protected JogameRequest buildRequest(Session session, String planet) {
        JogameRequestBuilder.Get builder = JogameRequestBuilder.get()
                .url(BASE_LOGGED_IN_URL)
                .page(Page.resources.name())
                .session(session);
        attachPlanet(planet, builder);
        return builder.build();
    }

    @Override
    protected List<Buildable> onResult(Document doc, JogameRequest request) {
        return buildableParser.parse(doc);
    }

}
