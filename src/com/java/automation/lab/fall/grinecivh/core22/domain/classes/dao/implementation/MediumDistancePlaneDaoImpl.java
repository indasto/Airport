package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.CargoPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.MediumDistancePlane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MediumDistancePlaneDaoImpl implements PlaneDao<MediumDistancePlane> {

    private List<MediumDistancePlane> mediumDistancePlanes;

    public MediumDistancePlaneDaoImpl() {
        mediumDistancePlanes = new ArrayList<>();
    }

    @Override
    public boolean isItAvailable() {
        Boolean available = mediumDistancePlanes.stream().anyMatch(pl -> {
            return pl.isInFlight();
        });

        return available;
    }

    @Override
    public MediumDistancePlane findPlane() {
        for (int i = 0; i < mediumDistancePlanes.size(); i++) {
            if (!mediumDistancePlanes.get(i).isInFlight()) {
                return mediumDistancePlanes.get(i);
            }
        }

        return null;
    }

    @Override
    public void addPlane(MediumDistancePlane plane) {
        mediumDistancePlanes.add(plane);
    }

    public List<MediumDistancePlane> getMediumDistancePlanes() {
        return mediumDistancePlanes;
    }

    public void setMediumDistancePlanes(List<MediumDistancePlane> mediumDistancePlanes) {
        this.mediumDistancePlanes = mediumDistancePlanes;
    }


    @Override
    public String toString() {
        return "MediumDistancePlaneDaoImpl{" +
                "mediumDistancePlanes=" + mediumDistancePlanes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MediumDistancePlaneDaoImpl that = (MediumDistancePlaneDaoImpl) o;
        return Objects.equals(mediumDistancePlanes, that.mediumDistancePlanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediumDistancePlanes);
    }
}
