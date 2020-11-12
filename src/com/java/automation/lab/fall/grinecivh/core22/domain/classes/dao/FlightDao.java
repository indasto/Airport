package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightArrive;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;

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
