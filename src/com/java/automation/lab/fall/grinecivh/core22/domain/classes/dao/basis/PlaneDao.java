package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPlane;

import java.util.List;

public interface PlaneDao<T extends AbstractPassengerPlane>  extends DAO<T>{

    public boolean isItAvailable();

    public T findPlane();

}
