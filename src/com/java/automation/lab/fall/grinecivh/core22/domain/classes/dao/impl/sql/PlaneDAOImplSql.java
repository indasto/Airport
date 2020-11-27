package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.sql;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;

import java.util.List;

public class PlaneDAOImplSql <T extends AbstractPassengerPlane> implements PlaneDao <T> {

    @Override
    public boolean isItAvailable() {
        return false;
    }

    @Override
    public T findPlane() {
        return null;
    }

    @Override
    public T create(T o) {
        return null;
    }

    @Override
    public T getById(int id) {
        return null;
    }

    @Override
    public List<T> get() {
        return null;
    }

    @Override
    public T update(T o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
