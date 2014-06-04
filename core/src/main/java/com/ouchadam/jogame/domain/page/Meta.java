package com.ouchadam.jogame.domain.page;

public class Meta {

    private final String currentPlanetId;
    private final String playerName;
    private final String allianceName;

    public Meta(String currentPlanetId, String playerName, String allianceName) {
        this.currentPlanetId = currentPlanetId;
        this.playerName = playerName;
        this.allianceName = allianceName;
    }

    public String getCurrentPlanetId() {
        return currentPlanetId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getAllianceName() {
        return allianceName;
    }
}
