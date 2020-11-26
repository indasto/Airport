package com.java.automation.lab.fall.grinecivh.core22.domain.classes.util;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.Airport;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.PartOfTheRoute;

import java.util.*;

public class Route {
    private static final double EARTH_RADIUS = 6371;

    // String = название всего пути, который может включать в себя несколько пересадок. Полный путь состоит из
    // аэропортов, т.е. полёт из аэропорта А в аэропорт Б, далее из аэропорта Б в аэропорт В и т.д.
    private Map<String, List<Airport>> routes;

    public Route(){
        Map<String, List<Airport>> routes = new HashMap<>();
    }

    public void addRoute(String routeName, Airport... airportSequence) {
        routes.put(routeName, new ArrayList<>());
        for (int i = 0; i < airportSequence.length; i++) {
            routes.get(routeName).add(airportSequence[i]);

        }
    }

    public PartOfTheRoute getPartOfTheRoute(Route routeName, Airport fromAirport) {

        List<Airport> airports = routes.get(routeName);

        int indexOfAirport = -1;
        int i = 0;
        while (indexOfAirport == -1 && i < airports.size()) {
            if (fromAirport.equals(airports.get(i))) {
                indexOfAirport = i;
            }
        }

        int distance = (int) (findDistance(airports.get(i), airports.get(i + 1))) + 1;

        PartOfTheRoute part = new PartOfTheRoute(airports.get(i), airports.get(i + 1), distance);

        return part;
    }

    public double findDistance(Airport airport1, Airport airport2) {                                // "Haversine" formula for finding distance with a help of latitude and longitude
        double sin1 = Math.sin((airport1.getLatitude() - airport2.getLatitude()) / 2);
        double sin2 = Math.sin((airport1.getLongitude() - airport2.getLongitude()) / 2);
        return 2 * EARTH_RADIUS * Math.asin(Math.sqrt(sin1 * sin1 +
                sin2 * sin2 * Math.cos(airport1.getLatitude()) * Math.cos(airport2.getLatitude())));
    }

}
