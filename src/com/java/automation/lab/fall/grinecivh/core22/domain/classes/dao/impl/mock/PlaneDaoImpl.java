package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.LongDistancePlane;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlaneDaoImpl<T extends AbstractPassengerPlane> implements PlaneDao <T> {

    private List<T> planes;

    public PlaneDaoImpl() {
        planes = new ArrayList<>();
    }

    @Override
    public boolean isItAvailable() {
        return planes.stream().anyMatch(pl -> {
            return pl.isInFlight();
        });
    }

    @Override
    public T findPlane() {
        for (int i = 0; i < planes.size(); i++) {
            if (!planes.get(i).isInFlight()) {
                return planes.get(i);
            }
        }

        return null;
    }

    @Override
    public T create(T o) {
        planes.add(o);
        return o;
    }

    @Override
    public T getById(int id) {
        return planes.get(id);
    }

    @Override
    public List<T> get() {
        return Collections.unmodifiableList(planes);
    }

    @Override
    public T update(T o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        planes.remove(id);
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaneDaoImpl<?> planeDao = (PlaneDaoImpl<?>) o;

        return planes != null ? planes.equals(planeDao.planes) : planeDao.planes == null;
    }

    @Override
    public int hashCode() {
        return planes != null ? planes.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlaneDaoImpl{");
        sb.append("planes=").append(planes);
        sb.append('}');
        return sb.toString();
    }
}
