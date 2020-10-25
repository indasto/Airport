package com.java.automation.lab.fall.grinecivh.core22.domain.classes.planes;

import java.util.*;

public class PlaneManager {

    private List<CargoPlane> cargoPlanes;
    private List<ShortDistancePlane> shortDistancePlanes;
    private List<MediumDistancePlane> mediumDistancePlanes;
    private List<LongDistancePlane> longDistancePlanes;
    private List<PrivatePlane> privatePlanes;

    public PlaneManager(CargoPlane[] cp, ShortDistancePlane[] up, MediumDistancePlane[] bp, LongDistancePlane[] ep) throws RuntimeException {

        if (cp == null || up == null || bp == null || ep == null) {
            throw new RuntimeException();
        }

        Collections.addAll(cargoPlanes, cp);
        Collections.addAll(shortDistancePlanes, up);
        Collections.addAll(mediumDistancePlanes, bp);
        Collections.addAll(longDistancePlanes, ep);
    }

    public boolean isPlaneAvailable(int distanceKm) {
        boolean available = false;

        if (distanceKm > 50 && distanceKm <= 2500) {
            available = isItAvailable(this.shortDistancePlanes);
        } else if (distanceKm <=5000){
            available = isItAvailable(this.mediumDistancePlanes);
        } else if (distanceKm > 50){
            available = isItAvailable(this.longDistancePlanes);
        }

        return available;
    }

    public AbstractPassengerPlane getPlane(int distanceKm){
        if (distanceKm > 50 && distanceKm <= 2500) {

        } else if (distanceKm <=5000){

        } else if (distanceKm > 50){
        }

        return null;
    }

    public AbstractPassengerPlane findPlane(List<? extends AbstractPassengerPlane> plane){

        for (int i = 0; i < plane.size(); i++) {
            if (!plane.get(i).isInFlight()) {
                return plane.get(i);
            }
        }

        return null;
    }

    public boolean isPrivatePlaneAvailable(){

        boolean available = isItAvailable(this.privatePlanes);
        return  available;
    }


    private boolean isItAvailable(List<? extends AbstractPassengerPlane> plane) {

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

    public void setCargoPlanes(ArrayList<CargoPlane> cargoPlanes) {
        this.cargoPlanes = cargoPlanes;
    }

    public void setLongDistancePlanes(ArrayList<LongDistancePlane> longDistancePlanes) {
        this.longDistancePlanes = longDistancePlanes;
    }

    public void setMediumDistancePlanes(ArrayList<MediumDistancePlane> mediumDistancePlanes) {
        this.mediumDistancePlanes = mediumDistancePlanes;
    }

    public void setPrivatePlanes(ArrayList<PrivatePlane> privatePlanes) {
        this.privatePlanes = privatePlanes;
    }

    public void setShortDistancePlanes(ArrayList<ShortDistancePlane> shortDistancePlanes) {
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
