package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.Buildable;
import com.ouchadam.jogame.domain.Status;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ResourceBuildableParser implements Parser<List<Buildable>> {

    @Override
    public List<Buildable> parse(Document body) {
        Elements ecke = body.select("span.ecke");
        List<Buildable> buildables = new ArrayList<Buildable>();
        try {
            for (Element element : ecke) {
                Status status = Status.from(element.parent().parent().parent().parent().className().trim());
                Element select = element.select("span[class=textlabel]").get(0);
                Buildable.Type name = Buildable.Type.from(select.text().trim());

                switch (name) {
                    case SOLAR_SATELLITE:
                        break;

                    default:
                        int level = Integer.valueOf(select.parent().textNodes().get(1).text().trim());
                        String upgradeLink = getUpgradeLink(element, status);
                        buildables.add(new Buildable(name, level, status, upgradeLink));
                        break;
                }

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return buildables;
    }

    private String getUpgradeLink(Element element, Status status) {
        String upgradeLink = Buildable.NO_UPGRADE_LINK;
        if (status == Status.ON) {
            Elements select1 = element.parent().parent().select("div.buildingimg");
            Elements a = select1.select("a");
            String rawLink = a.attr("onclick");
            int linkStart = rawLink.indexOf('\'');
            upgradeLink = rawLink.substring(linkStart + 1, rawLink.indexOf('\'', linkStart + 1)).trim();
        }
        return upgradeLink;
    }

}
