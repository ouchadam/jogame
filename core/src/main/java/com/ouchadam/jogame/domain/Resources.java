package com.ouchadam.jogame.domain;

public class Resources {

    private final long metal;
    private final long crystal;
    private final long deuterium;

    public Resources(long metal, long crystal, long deuterium) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
    }

    public long getMetal() {
        return metal;
    }

    public long getCrystal() {
        return crystal;
    }

    public long getDeuterium() {
        return deuterium;
    }
}
