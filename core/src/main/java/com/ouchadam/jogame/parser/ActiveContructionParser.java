package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.ActiveConstructions;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ActiveContructionParser implements Parser<ActiveConstructions> {

    @Override
    public ActiveConstructions parse(Document body) {
        Elements divs = body.select("div.content-box-s");
        // Buildings, Research, Shipyard
        int tableIndex = 0;
        for (Element div : divs) {
            Elements tableHolder = div.select("div.content");

            Elements table = tableHolder.select("table[class=construction active]").select("tr");

            if (table.size() > 1) {
                switch (tableIndex) {
                    case 0:
                        getActiveBuilding(table);
                        break;

                    case 1:
                        getActiveResearch(table);
                        break;

                    case 2:
                        getActiveShipyard(table);
                        break;

                    default:
                        throw new RuntimeException("unhandled case : " + tableIndex);
                }
            }
            tableIndex++;
        }
        return new ActiveConstructions();
    }

    private void getActiveBuilding(Elements table) {
        String name = table.get(0).select("th").text();
        String count = table.get(1).select("td[class=desc ausbau").text();
        System.out.println("Active building : " + name + " Count : " + count);
        System.out.println("");
    }

    private void getActiveShipyard(Elements table) {
        String name = table.get(0).select("th").text();
        String count = table.get(1).select("div[class=transport_ecke]").text();
        System.out.println("Active shipyard : " + name + " Count : " + count);
        System.out.println("");
    }

    private void getActiveResearch(Elements table) {
        String name = table.get(0).select("th").text();
        String count = table.get(1).select("td[class=desc ausbau").text();
        System.out.println("Active research : " + name + " Count : " + count);
        System.out.println("");
    }

}
