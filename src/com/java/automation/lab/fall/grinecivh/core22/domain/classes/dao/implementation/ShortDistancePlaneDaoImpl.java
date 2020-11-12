package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.CargoPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.ShortDistancePlane;

import java.util.ArrayList;
import java.util.List;

public class ShortDistancePlaneDaoImpl implements PlaneDao<ShortDistancePlane> {
    private List<ShortDistancePlane> shortDistancePlanes;

    public ShortDistancePlaneDaoImpl() {
        shortDistancePlanes = new ArrayList<>();
    }

    @Override
    public boolean isItAvailable() {
        Boolean available = shortDistancePlanes.stream().anyMatch(pl -> {
            return pl.isInFlight();
        });

        return available;
    }

    @Override
    public ShortDistancePlane findPlane() {
        for (int i = 0; i < shortDistancePlanes.size(); i++) {
            if (!shortDistancePlanes.get(i).isInFlight()) {
                return shortDistancePlanes.get(i);
            }
        }

        return null;
    }

    @Override
    public void addPlane(ShortDistancePlane plane) {
        shortDistancePlanes.add(plane);
    }
}
