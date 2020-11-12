package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPlane;

import java.util.List;

public interface PlaneDao {
    public boolean isPlaneAvailable(Class <?> cl);

    public void addPlane(AbstractPlane plane);

    public AbstractPassengerPlane findPlane(List<? extends AbstractPassengerPlane> plane);

    public AbstractPassengerPlane getPassengerPlane(Class <?> cl);

}
