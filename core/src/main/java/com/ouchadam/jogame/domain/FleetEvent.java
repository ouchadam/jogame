package com.ouchadam.jogame.domain;

public class FleetEvent {

    private final long id;
    private final MissionType missionType;
    private final boolean isReturnFlight;
    private final long arrivalTime;

    public FleetEvent(long id, MissionType missionType, boolean isReturnFlight, long arrivalTime) {
        this.id = id;
        this.missionType = missionType;
        this.isReturnFlight = isReturnFlight;
        this.arrivalTime = arrivalTime;
    }

    public long getId() {
        return id;
    }

    public MissionType getMissionType() {
        return missionType;
    }

    public boolean isReturnFlight() {
        return isReturnFlight;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "FleetEvent{" +
                "id=" + id +
                ", missionType=" + missionType +
                ", isReturnFlight=" + isReturnFlight +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
