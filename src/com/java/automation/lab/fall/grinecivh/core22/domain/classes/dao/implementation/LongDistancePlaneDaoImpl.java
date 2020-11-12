package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.CargoPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.LongDistancePlane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LongDistancePlaneDaoImpl implements PlaneDao <LongDistancePlane> {

    private List<LongDistancePlane> longDistancePlanes;

    public LongDistancePlaneDaoImpl() {
        longDistancePlanes = new ArrayList<>();
    }

    @Override
    public boolean isItAvailable() {
        Boolean available = longDistancePlanes.stream().anyMatch(pl -> {
            return pl.isInFlight();
        });

        return available;
    }

    @Override
    public LongDistancePlane findPlane() {
        for (int i = 0; i < longDistancePlanes.size(); i++) {
            if (!longDistancePlanes.get(i).isInFlight()) {
                return longDistancePlanes.get(i);
            }
        }

        return null;
    }

    @Override
    public void addPlane(LongDistancePlane plane) {
        longDistancePlanes.add(plane);
    }

    public List<LongDistancePlane> getLongDistancePlanes() {
        return longDistancePlanes;
    }

    public void setLongDistancePlanes(List<LongDistancePlane> longDistancePlanes) {
        this.longDistancePlanes = longDistancePlanes;
    }


    @Override
    public String toString() {
        return "LongDistancePlaneDaoImpl{" +
                "longDistancePlanes=" + longDistancePlanes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongDistancePlaneDaoImpl that = (LongDistancePlaneDaoImpl) o;
        return Objects.equals(longDistancePlanes, that.longDistancePlanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longDistancePlanes);
    }
}
