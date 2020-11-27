package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.IOConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.ObjectIO;

import java.util.List;

public class PlaneDAOImplClasz  <T extends AbstractPassengerPlane> implements PlaneDao<T> {
    @Override
    public boolean isItAvailable() {
        return false;
    }

    @Override
    public T findPlane() {
        return new ObjectIO<T>().read(IOConstant.PLANE_PATH);
    }

    @Override
    public T create(T o) {
        new ObjectIO<T>().write(o, IOConstant.PLANE_PATH);
        return o;
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
