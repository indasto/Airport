package com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.dao;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.entity.FlightArrive;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.entity.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.main.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.ticket.Ticket;

public interface FlightDao {
    public String getTicketId(Ticket ticket);

    public boolean offerArriveFlight(FlightArrive fa);

    public boolean offerDepartureFlight(FlightDeparture fd);

    public boolean offerDepartureFlight(String routName, AirlineCompany airlineCompany);

    public FlightDeparture pollDepartureFlight();

    public FlightArrive pollArriveFlight();

    public FlightDeparture peekDepartureFlight();

    public FlightArrive peekArriveFlight();

}
