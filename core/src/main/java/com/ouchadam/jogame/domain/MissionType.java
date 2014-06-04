package com.ouchadam.jogame.domain;

public enum MissionType {
    MISSION_NONE,
    MISSION_ATTACK,
    MISSION_UNION_ATTACK,
    MISSION_TRANSPORT,
    MISSION_DEPLOYMENT,
    MISSION_HOLD,
    MISSION_ESPIONAGE,
    MISSION_COLONIZATION,
    MISSION_HARVEST,
    MISSION_DESTROY,
    UNUSED_A,
    UNUSED_B,
    UNUSED_C,
    UNUSED_D,
    UNUSED_E,
    MISSION_EXPEDITION,
    MISSION_MISSILE;

    public String value() {
        return String.valueOf(ordinal());
    }
}
