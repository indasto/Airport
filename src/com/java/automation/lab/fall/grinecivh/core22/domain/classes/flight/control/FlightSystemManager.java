package com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes.PlaneManager;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.ClassLevel;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class FlightSystemManager {
    private PlaneManager pm;
    private List<FlightArrive> flightArrives;
    private List<FlightDeparture> flightDepartures;


    public FlightSystemManager(PlaneManager pm) {
        this.pm = pm;
    }

    public void addArriveFlight(FlightArrive fa)  {
        flightArrives.add(fa);
    }

    public void addDepartureFlight(FlightDeparture fd)  {
        if (pm.isPlaneAvailable(fd.getDistance())){
            fd.setPlane(pm.getPlane(fd.getDistance()));
            flightDepartures.add(fd);
        } else {
            System.out.println("Can't set the flight");
        }
    }

    public String getTicketId(Ticket ticket){

        FlightDeparture fd = ticket.getFlight();

        for (int i = 0; i < flightDepartures.size(); i++) {
            if (flightDepartures.get(i).equals(fd)){
                ClassLevel classLvl= ticket.getCl();
                if(classLvl == ClassLevel.FIRST){
                    return "First class "+ flightDepartures.get(i).getPlane().getName() + flightDepartures.get(i).getPlane().bookFirstClassSit();
                } else if (classLvl == ClassLevel.BUSINESS){
                    return "Business class "+ flightDepartures.get(i).getPlane().getName() + flightDepartures.get(i).getPlane().bookFirstClassSit();
                } else if (classLvl == ClassLevel.ECONOM){
                    return "Econom class "+ flightDepartures.get(i).getPlane().getName() + flightDepartures.get(i).getPlane().bookFirstClassSit();
                }
            }
        }

        return null;
    }


    public List<FlightArrive> getFlightArrives() {
        return flightArrives;
    }

    public List<FlightDeparture> getFlightDepartures() {
        return flightDepartures;
    }

    public PlaneManager getPm() {
        return pm;
    }

    public void setFlightArrives(LinkedList<FlightArrive> flightArrives) {
        this.flightArrives = flightArrives;
    }

    public void setFlightDepartures(LinkedList<FlightDeparture> flightDepartures) {
        this.flightDepartures = flightDepartures;
    }

    public void setPm(PlaneManager pm) {
        this.pm = pm;
    }


    @Override
    public String toString() {
        return
                "Plane Manager: " + pm + ", Flight Arrives=" + flightArrives +
                ", FlightDepartures=" + flightDepartures;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        FlightSystemManager that = (FlightSystemManager) ref;
        return  Objects.equals(pm, that.pm) &&
                Objects.equals(flightArrives, that.flightArrives) &&
                Objects.equals(flightDepartures, that.flightDepartures);
    }

    @Override
    public int hashCode() {
        return flightDepartures.hashCode()+ flightArrives.hashCode() + pm.hashCode();
    }
}
