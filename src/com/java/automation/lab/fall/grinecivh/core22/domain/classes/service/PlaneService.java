package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation.*;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.Route;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.*;

import java.util.*;

public class PlaneService {

    private CargoPlaneDaoImpl cargoPlaneDao;
    private ShortDistancePlaneDaoImpl shortDistancePlaneDao;
    private MediumDistancePlaneDaoImpl mediumDistancePlaneDao;
    private LongDistancePlaneDaoImpl longDistancePlaneDao;
    private PrivatePlaneDaoImpl privatePlaneDao;
    private Route route;

    public PlaneService(Route route) {
        cargoPlaneDao = new CargoPlaneDaoImpl();
        shortDistancePlaneDao = new ShortDistancePlaneDaoImpl();
        mediumDistancePlaneDao = new MediumDistancePlaneDaoImpl();
        longDistancePlaneDao = new LongDistancePlaneDaoImpl();
        privatePlaneDao = new PrivatePlaneDaoImpl();
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
        } else if (cl.equals(CargoPlane.class)) {
            available = cargoPlaneDao.isItAvailable();
        }

        return available;
    }

    public <T extends AbstractPlane> void addPlane(T plane) {

        Class<?> cl = plane.getClass();

        if (cl.equals(ShortDistancePlane.class)) {
            shortDistancePlaneDao.addPlane((ShortDistancePlane) plane);
        } else if (cl.equals(MediumDistancePlane.class)) {
            mediumDistancePlaneDao.addPlane((MediumDistancePlane) plane);
        } else if (cl.equals(LongDistancePlane.class)) {
            longDistancePlaneDao.addPlane((LongDistancePlane) plane);
        } else if (cl.equals(PrivatePlane.class)) {
            privatePlaneDao.addPlane((PrivatePlane) plane);
        } else if (cl.equals(CargoPlane.class)) {
            cargoPlaneDao.addPlane((CargoPlane) plane);
        }
    }

    public AbstractPassengerPlane getPassengerPlane(Class<?> cl) {

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

    public CargoPlaneDaoImpl getCargoPlaneDao() {
        return cargoPlaneDao;
    }

    public void setCargoPlaneDao(CargoPlaneDaoImpl cargoPlaneDao) {
        this.cargoPlaneDao = cargoPlaneDao;
    }

    public ShortDistancePlaneDaoImpl getShortDistancePlaneDao() {
        return shortDistancePlaneDao;
    }

    public void setShortDistancePlaneDao(ShortDistancePlaneDaoImpl shortDistancePlaneDao) {
        this.shortDistancePlaneDao = shortDistancePlaneDao;
    }

    public MediumDistancePlaneDaoImpl getMediumDistancePlaneDao() {
        return mediumDistancePlaneDao;
    }

    public void setMediumDistancePlaneDao(MediumDistancePlaneDaoImpl mediumDistancePlaneDao) {
        this.mediumDistancePlaneDao = mediumDistancePlaneDao;
    }

    public LongDistancePlaneDaoImpl getLongDistancePlaneDao() {
        return longDistancePlaneDao;
    }

    public void setLongDistancePlaneDao(LongDistancePlaneDaoImpl longDistancePlaneDao) {
        this.longDistancePlaneDao = longDistancePlaneDao;
    }

    public PrivatePlaneDaoImpl getPrivatePlaneDao() {
        return privatePlaneDao;
    }

    public void setPrivatePlaneDao(PrivatePlaneDaoImpl privatePlaneDao) {
        this.privatePlaneDao = privatePlaneDao;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }


    @Override
    public String toString() {
        return "PlaneService{" +
                "cargoPlaneDao=" + cargoPlaneDao +
                ", shortDistancePlaneDao=" + shortDistancePlaneDao +
                ", mediumDistancePlaneDao=" + mediumDistancePlaneDao +
                ", longDistancePlaneDao=" + longDistancePlaneDao +
                ", privatePlaneDao=" + privatePlaneDao +
                ", route=" + route +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneService that = (PlaneService) o;
        return Objects.equals(cargoPlaneDao, that.cargoPlaneDao) &&
                Objects.equals(shortDistancePlaneDao, that.shortDistancePlaneDao) &&
                Objects.equals(mediumDistancePlaneDao, that.mediumDistancePlaneDao) &&
                Objects.equals(longDistancePlaneDao, that.longDistancePlaneDao) &&
                Objects.equals(privatePlaneDao, that.privatePlaneDao) &&
                Objects.equals(route, that.route);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cargoPlaneDao, shortDistancePlaneDao, mediumDistancePlaneDao, longDistancePlaneDao, privatePlaneDao, route);
    }
}
