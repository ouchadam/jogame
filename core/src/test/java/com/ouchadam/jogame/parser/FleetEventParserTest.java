package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.DocHelper;
import com.ouchadam.jogame.domain.FleetEvent;
import com.ouchadam.jogame.domain.MissionType;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

public class FleetEventParserTest {

    private static final long UNIX_TIME_CODE_OFFSET = 1000L;
    private FleetParser fleetParser;

    @Before
    public void setUp() {
        fleetParser = new FleetParser();
    }

    @Test
    public void testName() {
        List<FleetEvent> result = fleetParser.parse(DocHelper.open("event_list.txt"));

        assertFleetEvent(result.get(0), MissionType.MISSION_EXPEDITION, (1399146640 * UNIX_TIME_CODE_OFFSET));
        assertFleetEvent(result.get(result.size() - 1), MissionType.MISSION_ATTACK, (1399234902 * UNIX_TIME_CODE_OFFSET));
    }

    @Test
    public void testName1() {
        List<FleetEvent> results = fleetParser.parse(DocHelper.open("event_list_alliance_attack.txt"));

        assertFleetEvent(results.get(0), MissionType.MISSION_UNION_ATTACK, 0l);
    }

    private static void assertFleetEvent(FleetEvent fleetEvent, MissionType missionType, long arrivalTime) {
        assertThat(fleetEvent.getMissionType()).isEqualTo(missionType);
        assertThat(fleetEvent.getArrivalTime()).isEqualTo(arrivalTime);
    }

}
