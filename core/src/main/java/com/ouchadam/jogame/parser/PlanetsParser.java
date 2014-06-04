package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.Planet;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class PlanetsParser implements Parser<List<Planet>> {

    private static final String DIV_SMALLPLANET = "div.smallplanet";
    private static final String PLANET_NAME = "span.planet-name";
    private static final String PLANET_IMAGE = "img.planetPic";
    private static final String DIV_MOON = "a.moonlink";
    private static final String COORDS = "span.planet-koords";

    @Override
    public List<Planet> parse(Document body) {
        List<Planet> planets = new ArrayList<Planet>();
        Elements divs = body.select(DIV_SMALLPLANET);
        for (Element div : divs) {
            String name = div.select(PLANET_NAME).text();
            String planetImage = div.select(PLANET_IMAGE).attr("src");

            PlanetInfo planetInfo = getPlanetInfo(div);
            Planet tmp = new Planet(planetInfo.id, name, planetImage, planetInfo.coords, planetInfo.size, planetInfo.temp);

            Elements moon = div.select(DIV_MOON);
            if (moon.size() > 0) {
                // TODO handle moons
            }
            planets.add(tmp);
        }
        return planets;
    }

    private PlanetInfo getPlanetInfo(Element div) {
        Element link = div.select("a").get(0);
        String info = link.attr("title");

        PlanetInfo planetInfo = new PlanetInfo();
        planetInfo.coords = div.select(COORDS).text();
        String[] split = info.split("<BR>");
        planetInfo.size = split[1];
        planetInfo.temp = split[2];

        String href = link.attr("href");
        planetInfo.id = Integer.valueOf(href.substring(href.indexOf("&cp=") + "&cp=".length()));
        return planetInfo;
    }

    private static class PlanetInfo {
        private String coords;
        private String temp;
        private String size;
        private int id;
    }

}
