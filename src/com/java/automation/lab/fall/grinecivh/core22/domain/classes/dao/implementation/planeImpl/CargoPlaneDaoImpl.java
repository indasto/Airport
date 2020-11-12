package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation.planeImpl;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.CargoPlane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CargoPlaneDaoImpl implements PlaneDao<CargoPlane> {

    private List<CargoPlane> cargoPlanes;

    public CargoPlaneDaoImpl() {
        cargoPlanes = new ArrayList<>();
    }

    @Override
    public boolean isItAvailable() {
        Boolean available = cargoPlanes.stream().anyMatch(pl -> {
            return pl.isInFlight();
        });

        return available;
    }

    @Override
    public CargoPlane findPlane() {
        for (int i = 0; i < cargoPlanes.size(); i++) {
            if (!cargoPlanes.get(i).isInFlight()) {
                return cargoPlanes.get(i);
            }
        }

        return null;
    }

    @Override
    public void addPlane(CargoPlane plane) {
        cargoPlanes.add(plane);
    }

    public List<CargoPlane> getCargoPlanes() {
        return cargoPlanes;
    }

    public void setCargoPlanes(List<CargoPlane> cargoPlanes) {
        this.cargoPlanes = cargoPlanes;
    }

    @Override
    public String toString() {
        return "CargoPlaneDaoImpl{" +
                "cargoPlanes=" + cargoPlanes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CargoPlaneDaoImpl that = (CargoPlaneDaoImpl) o;
        return Objects.equals(cargoPlanes, that.cargoPlanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoPlanes);
    }
}
