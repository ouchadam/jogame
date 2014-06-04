package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.Research;
import com.ouchadam.jogame.domain.Status;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ResearchParser implements Parser<List<Research>> {

    @Override
    public List<Research> parse(Document body) {
        List<Research> researchItems = new ArrayList<Research>();
        Elements select = body.select("div[class=buildingimg]");
        try {
            for (Element element : select) {
                String name = findResearchName(element);
                if (name.isEmpty()) {
                    continue;
                }
                Status status = Status.from(findStatus(element));
                Research.Type type = Research.Type.from(name);
                int level = findLevel(element);
                int id = findId(element);

                researchItems.add(new Research(type, level, status, id));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return researchItems;
    }

    private Integer findId(Element element) {
        return Integer.valueOf(element.select("a").attr("ref"));
    }

    private String findStatus(Element element) {
        return element.parent().parent().className();
    }

    private int findLevel(Element element) {
        Elements select2 = element.select("span[class=level]");
        return Integer.valueOf(select2.get(0).textNodes().get(1).text().trim());
    }

    private String findResearchName(Element element) {
        Elements select1 = element.select("span[class=textlabel]");
        return select1.text().trim();
    }

}
