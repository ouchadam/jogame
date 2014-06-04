package com.ouchadam.jogame.request;

import com.ouchadam.jogame.api.JogameRequest;
import com.ouchadam.jogame.api.JogameRequestBuilder;
import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.ActiveConstructions;
import com.ouchadam.jogame.domain.Page;
import com.ouchadam.jogame.domain.page.EveryPage;
import com.ouchadam.jogame.domain.page.Overview;
import com.ouchadam.jogame.parser.Parser;

import org.jsoup.nodes.Document;

class OverviewRequest extends JogameApiRequest<Overview> {

    private final Parser<EveryPage> everyPageParser;
    private final Parser<ActiveConstructions> activeConstructionParserParser;

    OverviewRequest(SessionValidator sessionValidator, Parser<EveryPage> everyPageParser, Parser<ActiveConstructions> constructionParser) {
        super(sessionValidator);
        this.everyPageParser = everyPageParser;
        this.activeConstructionParserParser = constructionParser;
    }

    OverviewRequest(SessionValidator sessionValidator, String planet, Parser<EveryPage> everyPageParser, Parser<ActiveConstructions> constructionParser) {
        super(sessionValidator, planet);
        this.everyPageParser = everyPageParser;
        this.activeConstructionParserParser = constructionParser;
    }

    @Override
    protected JogameRequest buildRequest(Session session, String planet) {
        JogameRequestBuilder.builder builder = JogameRequestBuilder.get()
                .url(BASE_LOGGED_IN_URL)
                .session(session)
                .page(Page.overview.name());
        attachPlanet(planet, builder);
        return builder.build();
    }

    @Override
    protected Overview onResult(Document doc, JogameRequest request) {
        EveryPage everyPage = everyPageParser.parse(doc);
        ActiveConstructions constructions = activeConstructionParserParser.parse(doc);
        return new Overview(everyPage, constructions);
    }

}
