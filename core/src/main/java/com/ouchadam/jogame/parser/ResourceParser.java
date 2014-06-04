package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.Resources;

import org.jsoup.nodes.Document;

class ResourceParser implements Parser<Resources>{

    @Override
    public Resources parse(Document body) {
        return new Resources(getMetal(body), getCrystal(body) , getDeuterium(body));
    }

    private long getMetal(Document html) {
        return Long.parseLong(format(html.select("span[id=resources_metal]").text()));
    }

    private long getCrystal(Document html) {
        return Long.parseLong(format(html.select("span[id=resources_crystal]").text()));
    }

    private long getDeuterium(Document html) {
        return Long.parseLong(format(html.select("span[id=resources_deuterium]").text()));
    }

    private String format(String input) {
        return input.replace(".", "");
    }

}

