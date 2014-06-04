package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.FleetEvent;
import com.ouchadam.jogame.domain.MissionType;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class FleetParser implements Parser<List<FleetEvent>> {

    @Override
    public List<FleetEvent> parse(Document body) {
        Elements select = body.select("tr[class=eventFleet]");
        List<FleetEvent> fleetEvents = new ArrayList<FleetEvent>();

        Elements allianceAttack = body.select("tr.class:contains(allianceAttack)");
        if (!allianceAttack.isEmpty()) {
            for (Element element : allianceAttack) {
                fleetEvents.add(new FleetEvent(0L, getMissionType(element), isReturnFlight(element), getArrivalTime(element)));
            }
        }

        for (Element element : select) {
            fleetEvents.add(new FleetEvent(getId(element), getMissionType(element), isReturnFlight(element), getArrivalTime(element)));
        }
        return fleetEvents;
    }

    private long getId(Element element) {
        return Long.valueOf(element.attr("id").replaceAll("[^\\d.]", ""));
    }

    private MissionType getMissionType(Element element) {
        return MissionType.values()[Integer.valueOf(element.attr("data-mission-type"))];
    }

    private boolean isReturnFlight(Element element) {
        return Boolean.parseBoolean(element.attr("data-return-flight"));
    }

    private long getArrivalTime(Element element) {
        return Long.valueOf(element.attr("data-arrival-time")) * 1000L;
    }

}
