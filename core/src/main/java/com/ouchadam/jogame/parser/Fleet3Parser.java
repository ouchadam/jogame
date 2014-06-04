package com.ouchadam.jogame.parser;

import org.jsoup.nodes.Document;

class Fleet3Parser implements Parser<String> {

    @Override
    public String parse(Document body) {
        System.out.println("Planet : " + body.select("meta[name=ogame-planet-id").attr("content"));
        System.out.println("Name : " + body.select("meta[name=ogame-planet-name").attr("content"));
        return body.select("input[name=token]").attr("value");
    }
}
