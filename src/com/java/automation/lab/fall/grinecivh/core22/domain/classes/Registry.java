package com.java.automation.lab.fall.grinecivh.core22.domain.classes;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.FlightSystemManager;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.ServiceEmployees;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.Ticket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Registry {
    private List<ServiceEmployees> airportPersonals;
    private List<Client> clients;
    private FlightSystemManager fm;

    public Registry(FlightSystemManager fm, ServiceEmployees... se) {
        this.fm = fm;
        airportPersonals = new ArrayList<>();
        clients = new LinkedList<>();

        for (int i = 0; i < se.length; i++) {
            airportPersonals.add(se[i]);
        }
    }

    public void addClient(Client cl)  {

        List<Ticket> tickets = cl.getTickets();
        for (int i = 0; i <tickets.size();i++) {
            String id = fm.getTicketId(tickets.get(i));
            tickets.get(i).setFlightId(id);
        }

        Price.calculatePrice(cl);
        clients.add(cl);
    }



    public List<ServiceEmployees> getAirportPersonals() {
        return airportPersonals;
    }

    public FlightSystemManager getFm() {
        return fm;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setAirportPersonals(List<ServiceEmployees> airportPersonals) {
        this.airportPersonals = airportPersonals;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setFm(FlightSystemManager fm) {
        this.fm = fm;
    }

    @Override
    public String toString() {
        return "Service employees: " + airportPersonals + ", clients: " + clients +
                ", Flight system manager: " + fm;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        Registry registry = (Registry) ref;

        return  Objects.equals(airportPersonals, registry.airportPersonals) &&
                Objects.equals(clients, registry.clients) &&
                Objects.equals(fm, registry.fm);
    }

    @Override
    public int hashCode() {
        return clients.hashCode()+ airportPersonals.hashCode();
    }
}
