package com.ouchadam.jogame.parser;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ResourceSettingsParser implements Parser<ResourceSettings>{

    private static final int HOUR = 0;
    private static final int DAY = 1;
    private static final int WEEK = 2;

    @Override
    public ResourceSettings parse(Document body) {
        Elements select = body.select("td[class=label]").select("em");

        long[] metalValues = new long[3];
        long[] crystalValues = new long[3];
        long[] deuteriumValues = new long[3];

        int index = 0;
        for (Element element : select) {
            Elements select1 = element.parent().parent().select("td[class=undermark]");
            metalValues[index] = getRateValue(select1, HOUR);
            crystalValues[index] = getRateValue(select1, DAY);
            deuteriumValues[index] = getRateValue(select1, WEEK);
            index++;
            if (index > 3) {
                break;
            }
        }
        ResourceSettings.Rates metal = new ResourceSettings.Rates(metalValues[HOUR], metalValues[DAY] , metalValues[WEEK]);
        ResourceSettings.Rates crystal = new ResourceSettings.Rates(crystalValues[HOUR], crystalValues[DAY], crystalValues[WEEK]);
        ResourceSettings.Rates deuterium = new ResourceSettings.Rates(deuteriumValues[HOUR], deuteriumValues[DAY], deuteriumValues[WEEK]);
        return new ResourceSettings(metal, crystal, deuterium);
    }

    private long getRateValue(Elements select1, int index) {
        return Long.parseLong(select1.select("span.tooltip").get(index).text().replace(".", ""));
    }

}

