package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation.planeImpl;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.PrivatePlane;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PrivatePlaneDaoImpl implements PlaneDao<PrivatePlane> {

    private List<PrivatePlane> privatePlanes;

    public PrivatePlaneDaoImpl() {
        privatePlanes = new ArrayList<>();
    }

    @Override
    public boolean isItAvailable() {
        Boolean available = privatePlanes.stream().anyMatch(pl -> {
            return pl.isInFlight();
        });

        return available;
    }

    @Override
    public PrivatePlane findPlane() {
        for (int i = 0; i < privatePlanes.size(); i++) {
            if (!privatePlanes.get(i).isInFlight()) {
                return privatePlanes.get(i);
            }
        }

        return null;
    }

    @Override
    public void addPlane(PrivatePlane plane) {
        privatePlanes.add(plane);
    }

    public List<PrivatePlane> getPrivatePlanes() {
        return privatePlanes;
    }

    public void setPrivatePlanes(List<PrivatePlane> privatePlanes) {
        this.privatePlanes = privatePlanes;
    }

    @Override
    public String toString() {
        return "PrivatePlaneDaoImpl{" +
                "privatePlanes=" + privatePlanes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivatePlaneDaoImpl that = (PrivatePlaneDaoImpl) o;
        return Objects.equals(privatePlanes, that.privatePlanes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(privatePlanes);
    }
}
