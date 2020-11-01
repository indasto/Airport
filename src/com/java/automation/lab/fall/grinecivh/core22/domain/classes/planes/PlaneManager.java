package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.Route;

import java.util.*;

public class PlaneManager {

    private List<CargoPlane> cargoPlanes;
    private List<ShortDistancePlane> shortDistancePlanes;
    private List<MediumDistancePlane> mediumDistancePlanes;
    private List<LongDistancePlane> longDistancePlanes;
    private List<PrivatePlane> privatePlanes;
    private Route route;

    public PlaneManager(CargoPlane[] cp, ShortDistancePlane[] up, MediumDistancePlane[] bp, LongDistancePlane[] ep) throws RuntimeException {

        if (cp == null || up == null || bp == null || ep == null) {
            throw new RuntimeException();
        }

        Collections.addAll(cargoPlanes, cp);
        Collections.addAll(shortDistancePlanes, up);
        Collections.addAll(mediumDistancePlanes, bp);
        Collections.addAll(longDistancePlanes, ep);
    }

    public PlaneManager(){
        cargoPlanes = new ArrayList<>();
        shortDistancePlanes = new ArrayList<>();
        mediumDistancePlanes = new ArrayList<>();
        longDistancePlanes = new ArrayList<>();
        privatePlanes = new ArrayList<>();
    }

    public boolean isPlaneAvailable(Class <?> cl) {
        boolean available = false;

        if (cl.equals(ShortDistancePlane.class)) {
            available = isItAvailable(this.shortDistancePlanes);
        } else if (cl.equals(MediumDistancePlane.class)){
            available = isItAvailable(this.mediumDistancePlanes);
        } else if (cl.equals(LongDistancePlane.class)){
            available = isItAvailable(this.longDistancePlanes);
        } else if (cl.equals(PrivatePlane.class)){
            available = isItAvailable(this.privatePlanes);
        } else if (cl.equals(CargoPlane.class)){
            available = isItAvailable(this.cargoPlanes);
        }

        return available;
    }

    public void addPlane(AbstractPlane plane){
        Class<?> cl = plane.getClass();
        if (cl.equals(ShortDistancePlane.class)) {
            shortDistancePlanes.add((ShortDistancePlane)plane);
        } else if (cl.equals(MediumDistancePlane.class)){
            mediumDistancePlanes.add((MediumDistancePlane)plane);
        } else if (cl.equals(LongDistancePlane.class)){
            longDistancePlanes.add((LongDistancePlane) plane);
        } else if (cl.equals(PrivatePlane.class)){
            privatePlanes.add((PrivatePlane)plane);
        } else if (cl.equals(CargoPlane.class)){
            cargoPlanes.add((CargoPlane)plane);
        }
    }

    public AbstractPassengerPlane findPlane(List<? extends AbstractPassengerPlane> plane){

        for (int i = 0; i < plane.size(); i++) {
            if (!plane.get(i).isInFlight()) {
                return plane.get(i);
            }
        }

        return null;
    }

    public AbstractPassengerPlane getPassengerPlane(Class <?> cl){
        AbstractPassengerPlane plane = null;

        if (cl.equals(ShortDistancePlane.class)) {
            plane = findPlane(this.shortDistancePlanes);
        } else if (cl.equals(MediumDistancePlane.class)){
            plane = findPlane(this.mediumDistancePlanes);
        } else if (cl.equals(LongDistancePlane.class)){
            plane = findPlane(this.longDistancePlanes);
        } else if (cl.equals(PrivatePlane.class)){
            plane = findPlane(this.privatePlanes);
        }

        return plane;
    }


    private boolean isItAvailable(List<? extends AbstractPlane> plane) {

        for (int i = 0; i < plane.size(); i++) {
            if (!plane.get(i).isInFlight()) {
                return true;
            }
        }

        return false;
    }

    public List<CargoPlane> getCargoPlanes() {
        return cargoPlanes;
    }

    public List<LongDistancePlane> getLongDistancePlanes() {
        return longDistancePlanes;
    }

    public List<MediumDistancePlane> getMediumDistancePlanes() {
        return mediumDistancePlanes;
    }

    public List<PrivatePlane> getPrivatePlanes() {
        return privatePlanes;
    }

    public List<ShortDistancePlane> getShortDistancePlanes() {
        return shortDistancePlanes;
    }

    public void setCargoPlanes(List<CargoPlane> cargoPlanes) {
        this.cargoPlanes = cargoPlanes;
    }

    public void setLongDistancePlanes(List<LongDistancePlane> longDistancePlanes) {
        this.longDistancePlanes = longDistancePlanes;
    }

    public void setMediumDistancePlanes(List<MediumDistancePlane> mediumDistancePlanes) {
        this.mediumDistancePlanes = mediumDistancePlanes;
    }

    public void setPrivatePlanes(List<PrivatePlane> privatePlanes) {
        this.privatePlanes = privatePlanes;
    }

    public void setShortDistancePlanes(List<ShortDistancePlane> shortDistancePlanes) {
        this.shortDistancePlanes = shortDistancePlanes;
    }


    @Override
    public String toString() {
        return "Cargo Planes: " + cargoPlanes +
                ", Short Distance Planes: " + shortDistancePlanes +
                ", Medium Distance Planes: " + mediumDistancePlanes +
                ", Long Distance Planes: " + longDistancePlanes +
                ", Private Planes: " + privatePlanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneManager that = (PlaneManager) o;
        return Objects.equals(cargoPlanes, that.cargoPlanes) &&
                Objects.equals(shortDistancePlanes, that.shortDistancePlanes) &&
                Objects.equals(mediumDistancePlanes, that.mediumDistancePlanes) &&
                Objects.equals(longDistancePlanes, that.longDistancePlanes) &&
                Objects.equals(privatePlanes, that.privatePlanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoPlanes, shortDistancePlanes, mediumDistancePlanes, longDistancePlanes, privatePlanes);
    }
}
