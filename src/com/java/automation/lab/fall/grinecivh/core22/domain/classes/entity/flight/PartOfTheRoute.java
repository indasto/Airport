package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.Airport;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.LongDistancePlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.MediumDistancePlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.ShortDistancePlane;

import java.util.Map;

public class PartOfTheRoute {

    private Airport fromAirport;
    private Airport toAirport;
    private int distance;

    public PartOfTheRoute(Airport from, Airport to, int distance) {
        fromAirport = from;
        toAirport = to;
        this.distance = distance;
    }

    public Class findPassengerPlaneClass() {

        Class cl = null;

        if (distance > 50 && distance <= 250) {
            cl = ShortDistancePlane.class;
        } else if (distance <= 5000) {
            cl = MediumDistancePlane.class;
        } else if (distance <= 15000) {
            cl = LongDistancePlane.class;
        }

        return cl;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PartOfTheRoute part = (PartOfTheRoute) o;

        if (distance != part.distance) return false;
        if (fromAirport != null ? !fromAirport.equals(part.fromAirport) : part.fromAirport != null) return false;
        return toAirport != null ? toAirport.equals(part.toAirport) : part.toAirport == null;
    }

    @Override
    public int hashCode() {
        int result = fromAirport != null ? fromAirport.hashCode() : 0;
        result = 31 * result + (toAirport != null ? toAirport.hashCode() : 0);
        result = 31 * result + distance;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PartOfTheRoute{");
        sb.append("fromAirport=").append(fromAirport);
        sb.append(", toAirport=").append(toAirport);
        sb.append(", distance=").append(distance);
        sb.append('}');
        return sb.toString();
    }
}
