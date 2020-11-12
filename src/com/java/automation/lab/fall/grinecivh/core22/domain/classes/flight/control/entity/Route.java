package com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.main.entity.Airport;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes.entity.LongDistancePlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes.entity.MediumDistancePlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes.entity.ShortDistancePlane;

import java.util.*;

public class Route {
    private static final double EARTH_RADIUS = 6371;
    private Airport mainAirport;
    private Map<String, Map<String, Integer>> routes;  // First String = name of the route, Integer = distance

    public Route(Airport mainAirport) {
        this.mainAirport = mainAirport;
        new HashMap<>();
    }

    public void addRoute(String routeName, Airport... airportSequence) {
        routes.put(routeName, new LinkedHashMap<String, Integer>());
        for (int i = 0; i < airportSequence.length; i++) {
            String address = airportSequence[i].getAddress();

            int distance;
            if (i == 0) {
                distance = (int) this.findDistance(mainAirport,airportSequence[i]) + 1;
            } else {
                distance = (int) this.findDistance(airportSequence[i-1],airportSequence[i]);
            }
            routes.get(routes.size() - 1).put(address, distance);
        }
    }

    public Map<String, Integer> getRoute(String routeName){
        return routes.get(routeName);
    }

    public double findDistance(Airport airport1, Airport airport2) {                                // "Haversine" formula for finding distance with a help of latitude and longitude
        double sin1 = Math.sin((airport1.getLatitude() - airport2.getLatitude()) / 2);
        double sin2 = Math.sin((airport1.getLongitude() - airport2.getLongitude()) / 2);
        return 2 * EARTH_RADIUS * Math.asin(Math.sqrt(sin1 * sin1 +
                sin2 * sin2 * Math.cos(airport1.getLatitude()) * Math.cos(airport2.getLatitude())));
    }

    public int getMaxDistance(String routeName) {

        Map<String,Integer> hm = routes.get(routeName);

        int maxDist = 0;
        for (Integer distance : hm.values()){
            if (distance>maxDist){
                maxDist = distance;
            }
        }

        return maxDist;
    }

    public int getDistance(String routeName, String address){
        Map<String,Integer> hm = routes.get(routeName);

        return hm.get(address);
    }

    public Class findPassengerPlaneClass(String routeName, String address){
        Map<String,Integer> hm = routes.get(routeName);
        int distance = hm.get(address);

        Class cl = null;

        if(distance> 50 && distance <=250){
            cl = ShortDistancePlane.class;
        } else if (distance <= 5000) {
            cl = MediumDistancePlane.class;
        } else if (distance <= 15000){
           cl = LongDistancePlane.class;
        }

        return cl;
    }

}
