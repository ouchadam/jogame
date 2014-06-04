package com.ouchadam.jogame.demo;

import com.ouchadam.jogame.api.Session;
import com.ouchadam.jogame.domain.Buildable;
import com.ouchadam.jogame.domain.FleetEvent;
import com.ouchadam.jogame.domain.Planet;
import com.ouchadam.jogame.domain.Research;
import com.ouchadam.jogame.domain.page.Overview;
import com.ouchadam.jogame.request.RequestFactory;

import java.util.List;

public class Main {

    public static void main(String... args) {
        validateCredentials();
        RequestFactory requestFactory = RequestFactory.newInstance();
        Session session = requestFactory.login(Constants.USERNAME, Constants.PASSWORD).execute();

        Overview overview = requestFactory.overview().execute(session);
        List<Planet> planets = overview.everyPage().getPlanets();

        List<Research> research = requestFactory.research(getId(planets.get(1))).execute(session);
        List<Buildable> resourceBuildings = requestFactory.resourceBuildings(getId(planets.get(1))).execute(session);
        List<Buildable> facilitiesBuildings = requestFactory.facilityBuildings(getId(planets.get(1))).execute(session);
        List<FleetEvent> fleetEvents = requestFactory.fleetEvent().execute(session);

        print("Planets", planets);
        print("Research", research);
        print("Resource Buildings", resourceBuildings);
        print("Facility Buildings", facilitiesBuildings);
        print("Fleet Events", fleetEvents);
    }

    private static String getId(Planet planet) {
        return String.valueOf(planet.id);
    }

    private static void validateCredentials() {
        if (Constants.USERNAME.isEmpty() || Constants.PASSWORD.isEmpty()) {
            throw new RuntimeException("Username or password has not been set");
        }
    }

    private static void print(String title, List<?> list) {
        System.out.println(title);
        System.out.println("");
        for (Object o : list) {
            System.out.println(o);
        }
        System.out.println("");
    }

}
