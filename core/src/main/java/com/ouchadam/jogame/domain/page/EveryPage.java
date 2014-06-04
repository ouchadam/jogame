package com.ouchadam.jogame.domain.page;

import com.ouchadam.jogame.domain.Planet;
import com.ouchadam.jogame.domain.Resources;

import java.util.List;

public class EveryPage {

    private final Resources resources;
    private final List<Planet> planets;
    private final Meta meta;

    public EveryPage(Resources resources, List<Planet> planets, Meta meta) {
        this.resources = resources;
        this.planets = planets;
        this.meta = meta;
    }

    public Resources getResources() {
        return resources;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public Meta getMeta() {
        return meta;
    }
}
