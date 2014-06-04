package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.Planet;
import com.ouchadam.jogame.domain.Resources;
import com.ouchadam.jogame.domain.page.EveryPage;
import com.ouchadam.jogame.domain.page.Meta;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

class EveryPageParser implements Parser<EveryPage> {

    private final Parser<List<Planet>> planetsParser;
    private final Parser<Resources> resourcesParser;

    EveryPageParser(Parser<List<Planet>> planetsParser, Parser<Resources> resourcesParser) {
        this.planetsParser = planetsParser;
        this.resourcesParser = resourcesParser;
    }

    @Override
    public EveryPage parse(Document body) {
        return new EveryPage(resourcesParser.parse(body), planetsParser.parse(body), createMeta(body.select("head").get(0)));
    }

    private Meta createMeta(Element element) {
        return new Meta(getMetaText(element, "ogame-planet-id"), getMetaText(element, "ogame-player-name"), getMetaText(element, "ogame-alliance-name"));
    }

    private String getMetaText(Element element, String metaName) {
        return element.select("meta[name=" + metaName + "]").attr("content").trim();
    }
}
