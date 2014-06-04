package com.ouchadam.jogame.parser;

class ResourceSettings {

    private final Rates metal;
    private final Rates crystal;
    private final Rates deuterium;

    ResourceSettings(Rates metal, Rates crystal, Rates deuterium) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
    }

    public Rates metal() {
        return metal;
    }

    public Rates crystal() {
        return crystal;
    }

    public Rates deuterium() {
        return deuterium;
    }

    public static class Rates {
        final long hour;
        final long day;
        final long week;

        public Rates(long hour, long day, long week) {
            this.hour = hour;
            this.day = day;
            this.week = week;
        }
    }

}
