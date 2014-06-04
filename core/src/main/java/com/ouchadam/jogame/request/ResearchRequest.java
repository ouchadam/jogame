package com.ouchadam.jogame.request;

import com.ouchadam.jogame.api.JogameRequest;
import com.ouchadam.jogame.api.JogameRequestBuilder;
import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.Page;
import com.ouchadam.jogame.domain.Research;
import com.ouchadam.jogame.parser.Parser;

import java.util.List;

import org.jsoup.nodes.Document;

class ResearchRequest extends JogameApiRequest<List<Research>> {

    private final Parser<List<Research>> buildableParser;

    ResearchRequest(SessionValidator sessionValidator, String planet, Parser<List<Research>> buildableParser) {
        super(sessionValidator, planet);
        this.buildableParser = buildableParser;
    }

    @Override
    protected JogameRequest buildRequest(Session session, String planet) {
        JogameRequestBuilder.Get builder = JogameRequestBuilder.get()
                .url(BASE_LOGGED_IN_URL)
                .session(session)
                .page(Page.research.name());
        attachPlanet(planet, builder);
        return builder.build();
    }

    @Override
    protected List<Research> onResult(Document doc, JogameRequest request) {
        return buildableParser.parse(doc);
    }

}
