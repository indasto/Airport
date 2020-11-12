package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.AirlineCompany;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.flight.FlightDeparture;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;

public interface DepartureFlightDao {

    public boolean offerDepartureFlight(FlightDeparture fd);

    public boolean offerDepartureFlight(String routName, AirlineCompany airlineCompany);

    public FlightDeparture pollDepartureFlight();

    public FlightDeparture peekDepartureFlight();

    public String getTicketId(Ticket ticket);
}
