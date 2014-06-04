package com.ouchadam.jogame.parser;

import com.ouchadam.jogame.domain.ActiveConstructions;
import com.ouchadam.jogame.domain.Buildable;
import com.ouchadam.jogame.domain.FleetEvent;
import com.ouchadam.jogame.domain.Research;
import com.ouchadam.jogame.domain.page.EveryPage;

import java.util.List;

public class ParserFactory {

    private Parser<ActiveConstructions> activeConstructions;
    private Parser<EveryPage> everyPage;
    private Parser<List<Research>> research;
    private Parser<List<Buildable>> buildable;
    private Parser<List<FleetEvent>> fleetEvent;
    private Parser<String> fleet3;

    public Parser<ActiveConstructions> activeConstructions() {
        if (activeConstructions == null) {
            activeConstructions = new ActiveContructionParser();
        }
        return activeConstructions;
    }

    public Parser<EveryPage> everyPage() {
        if (everyPage == null) {
            everyPage = new EveryPageParser(new PlanetsParser(), new ResourceParser());
        }
        return everyPage;
    }

    public Parser<List<Research>> research() {
        if (research == null) {
            research = new ResearchParser();
        }
        return research;
    }

    public Parser<List<Buildable>> resource() {
        if (buildable == null) {
            buildable = new ResourceBuildableParser();
        }
        return buildable;
    }

    public Parser<List<FleetEvent>> fleetEvent() {
        if (fleetEvent == null) {
            fleetEvent = new FleetParser();
        }
        return fleetEvent;
    }

    public Parser<String> fleet3() {
        if (fleet3 == null) {
            fleet3 = new Fleet3Parser();
        }
        return fleet3;
    }

}
