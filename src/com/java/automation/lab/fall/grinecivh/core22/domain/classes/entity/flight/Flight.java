package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.FlightProcess;

import java.time.OffsetDateTime;

public class Flight implements FlightProcess {

    private OffsetDateTime sitDate;
    private OffsetDateTime arriveDate;
    private String sitGate;
    private String arriveGate;
    private AbstractPassengerPlane plane;
    private PartOfTheRoute routePart;

    public Flight(OffsetDateTime sitDate, OffsetDateTime arriveDate, String sitGate, String arriveGate,
                  AbstractPassengerPlane plane, PartOfTheRoute routePart) {
        this.sitDate = sitDate;
        this.arriveDate = arriveDate;
        this.sitGate = sitGate;
        this.arriveGate = arriveGate;
        this.plane = plane;
        this.routePart = routePart;
    }

    @Override
    public void takeoff(int time) {
        timeToProcess(time);
    }

    @Override
    public void land(int time) {
        timeToProcess(time);
    }

    private void timeToProcess(int time) {
    }

    public OffsetDateTime getSitDate() {
        return sitDate;
    }

    public void setSitDate(OffsetDateTime sitDate) {
        this.sitDate = sitDate;
    }

    public OffsetDateTime getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(OffsetDateTime arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getSitGate() {
        return sitGate;
    }

    public void setSitGate(String sitGate) {
        this.sitGate = sitGate;
    }

    public String getArriveGate() {
        return arriveGate;
    }

    public void setArriveGate(String arriveGate) {
        this.arriveGate = arriveGate;
    }

    public AbstractPassengerPlane getPlane() {
        return plane;
    }

    public void setPlane(AbstractPassengerPlane plane) {
        this.plane = plane;
    }

    public PartOfTheRoute getRoutePart() {
        return routePart;
    }

    public void setRoutePart(PartOfTheRoute routePart) {
        this.routePart = routePart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (sitDate != null ? !sitDate.equals(flight.sitDate) : flight.sitDate != null) return false;
        if (arriveDate != null ? !arriveDate.equals(flight.arriveDate) : flight.arriveDate != null) return false;
        if (sitGate != null ? !sitGate.equals(flight.sitGate) : flight.sitGate != null) return false;
        if (arriveGate != null ? !arriveGate.equals(flight.arriveGate) : flight.arriveGate != null) return false;
        if (plane != null ? !plane.equals(flight.plane) : flight.plane != null) return false;
        return routePart != null ? routePart.equals(flight.routePart) : flight.routePart == null;
    }

    @Override
    public int hashCode() {
        int result = sitDate != null ? sitDate.hashCode() : 0;
        result = 31 * result + (arriveDate != null ? arriveDate.hashCode() : 0);
        result = 31 * result + (sitGate != null ? sitGate.hashCode() : 0);
        result = 31 * result + (arriveGate != null ? arriveGate.hashCode() : 0);
        result = 31 * result + (plane != null ? plane.hashCode() : 0);
        result = 31 * result + (routePart != null ? routePart.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Flight{");
        sb.append("sitDate=").append(sitDate);
        sb.append(", arriveDate=").append(arriveDate);
        sb.append(", sitGate='").append(sitGate).append('\'');
        sb.append(", arriveGate='").append(arriveGate).append('\'');
        sb.append(", plane=").append(plane);
        sb.append(", routePart=").append(routePart);
        sb.append('}');
        return sb.toString();
    }
}
