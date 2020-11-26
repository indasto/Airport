package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock.PlaneDaoImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Route;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.*;

import java.util.List;

public class PlaneService {

    private PlaneDao<ShortDistancePlane> shortDistancePlaneDao;
    private PlaneDao<MediumDistancePlane> mediumDistancePlaneDao;
    private PlaneDao<LongDistancePlane> longDistancePlaneDao;
    private PlaneDao<PrivatePlane> privatePlaneDao;
    private Route route;

    public PlaneService(Route route) {
        shortDistancePlaneDao = new PlaneDaoImpl<>();
        mediumDistancePlaneDao = new PlaneDaoImpl<>();
        longDistancePlaneDao = new PlaneDaoImpl();
        privatePlaneDao = new PlaneDaoImpl<>();
        this.route = route;
    }

    public boolean isPlaneAvailable(Class<?> cl) {
        boolean available = false;

        if (cl.equals(ShortDistancePlane.class)) {
            available = shortDistancePlaneDao.isItAvailable();
        } else if (cl.equals(MediumDistancePlane.class)) {
            available = mediumDistancePlaneDao.isItAvailable();
        } else if (cl.equals(LongDistancePlane.class)) {
            available = longDistancePlaneDao.isItAvailable();
        } else if (cl.equals(PrivatePlane.class)) {
            available = privatePlaneDao.isItAvailable();
        }

        return available;
    }

    public <T extends AbstractPassengerPlane> void create(T plane) {

        Class<?> cl = plane.getClass();

        if (cl.equals(ShortDistancePlane.class)) {
            shortDistancePlaneDao.create((ShortDistancePlane) plane);
        } else if (cl.equals(MediumDistancePlane.class)) {
            mediumDistancePlaneDao.create((MediumDistancePlane) plane);
        } else if (cl.equals(LongDistancePlane.class)) {
            longDistancePlaneDao.create((LongDistancePlane) plane);
        } else if (cl.equals(PrivatePlane.class)) {
            privatePlaneDao.create((PrivatePlane) plane);
        }

    }

    public AbstractPassengerPlane findPlane(Class<?> cl) {

        AbstractPassengerPlane plane = null;

        if (cl.equals(ShortDistancePlane.class)) {
            plane = shortDistancePlaneDao.findPlane();
        } else if (cl.equals(MediumDistancePlane.class)) {
            plane = mediumDistancePlaneDao.findPlane();
        } else if (cl.equals(LongDistancePlane.class)) {
            plane = longDistancePlaneDao.findPlane();
        } else if (cl.equals(PrivatePlane.class)) {
            plane = privatePlaneDao.findPlane();
        }

        return plane;
    }

    public AbstractPassengerPlane getById(int id, Class<?> cl) {

        AbstractPassengerPlane plane = null;

        if (cl.equals(ShortDistancePlane.class)) {
            plane = shortDistancePlaneDao.getById(id);
        } else if (cl.equals(MediumDistancePlane.class)) {
            plane = mediumDistancePlaneDao.getById(id);
        } else if (cl.equals(LongDistancePlane.class)) {
            plane = longDistancePlaneDao.getById(id);
        } else if (cl.equals(PrivatePlane.class)) {
            plane = privatePlaneDao.getById(id);
        }

        return plane;
    }

    public List<? extends AbstractPassengerPlane> get(Class<?> cl) {

        if (cl.equals(ShortDistancePlane.class)) {
            return shortDistancePlaneDao.get();
        } else if (cl.equals(MediumDistancePlane.class)) {
            return mediumDistancePlaneDao.get();
        } else if (cl.equals(LongDistancePlane.class)) {
            return longDistancePlaneDao.get();
        } else if (cl.equals(PrivatePlane.class)) {
            return privatePlaneDao.get();
        }

        return null;
    }

    public int deleteById(int id, Class<?> cl) {

        if (cl.equals(ShortDistancePlane.class)) {
            return shortDistancePlaneDao.deleteById(id);
        } else if (cl.equals(MediumDistancePlane.class)) {
            return mediumDistancePlaneDao.deleteById(id);
        } else if (cl.equals(LongDistancePlane.class)) {
            return longDistancePlaneDao.deleteById(id);
        } else if (cl.equals(PrivatePlane.class)) {
            return privatePlaneDao.deleteById(id);
        }

        return -1;
    }

}
