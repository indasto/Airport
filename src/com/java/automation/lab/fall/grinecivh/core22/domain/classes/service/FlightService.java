package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation.ArriveFlightDaoImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation.DepartureFlightDaoImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightArrive;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;

import java.util.Objects;

public class FlightService {

    private ArriveFlightDaoImpl arriveFlightDao;
    private DepartureFlightDaoImpl departureFlightDao;

    public FlightService(ArriveFlightDaoImpl arriveFlightDao, DepartureFlightDaoImpl departureFlightDao) {
        this.arriveFlightDao = arriveFlightDao;
        this.departureFlightDao = departureFlightDao;
    }

    public String getTicketId(Ticket ticket) {
        return departureFlightDao.getTicketId(ticket);
    }

    public boolean offerArriveFlight(FlightArrive fa) {
        return arriveFlightDao.offerArriveFlight(fa);
    }

    public boolean offerDepartureFlight(FlightDeparture fd) {
        return departureFlightDao.offerDepartureFlight(fd);
    }

    public boolean offerDepartureFlight(String routName, AirlineCompany airlineCompany) {
        return departureFlightDao.offerDepartureFlight(routName, airlineCompany);
    }

    public FlightDeparture pollDepartureFlight() {
        return departureFlightDao.pollDepartureFlight();
    }

    public FlightArrive pollArriveFlight() {
        return arriveFlightDao.pollArriveFlight();
    }

    public FlightDeparture peekDepartureFlight() {
        return departureFlightDao.peekDepartureFlight();
    }

    public FlightArrive peekArriveFlight() {
        return arriveFlightDao.peekArriveFlight();
    }

    public ArriveFlightDaoImpl getArriveFlightDao() {
        return arriveFlightDao;
    }

    public void setArriveFlightDao(ArriveFlightDaoImpl arriveFlightDao) {
        this.arriveFlightDao = arriveFlightDao;
    }

    public DepartureFlightDaoImpl getDepartureFlightDao() {
        return departureFlightDao;
    }

    public void setDepartureFlightDao(DepartureFlightDaoImpl departureFlightDao) {
        this.departureFlightDao = departureFlightDao;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightService that = (FlightService) o;
        return  Objects.equals(arriveFlightDao, that.arriveFlightDao) &&
                Objects.equals(departureFlightDao, that.departureFlightDao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arriveFlightDao, departureFlightDao);
    }

    @Override
    public String toString() {
        return "FlightService{" +
                "arriveFlightDao=" + arriveFlightDao +
                ", departureFlightDao=" + departureFlightDao +
                '}';
    }
}
