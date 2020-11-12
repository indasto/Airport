package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.dao;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.flight.control.dao.FlightSystemManager;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.entity.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.workers.entity.ServiceEmployees;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Price;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Registry {
    private static Registry registry;
    private List<ServiceEmployees> airportPersonals;
    private List<Client> clients;
    private FlightSystemManager fm;

    private Registry(FlightSystemManager fm, ServiceEmployees... se) {
        this.fm = fm;
        airportPersonals = new ArrayList<>();
        clients = new LinkedList<>();

        for (int i = 0; i < se.length; i++) {
            airportPersonals.add(se[i]);
        }
    }

    private Registry() {
        clients = new LinkedList<>();
    }

    public static Registry createRegistry(FlightSystemManager fm, ServiceEmployees... se){
        if (registry == null){
            return new Registry(fm, se);
        } else {
            return registry;
        }
    }

    public static Registry createRegistry(){
        if (registry == null){
            return new Registry();
        } else {
            return registry;
        }
    }

    public void addClient(Client client)  {

        List<Ticket> tickets = client.getTickets();

        tickets.stream().forEach(ticket -> {
            String id = fm.getTicketId(ticket);
            ticket.setFlightId(id);
        });

        Price.calculatePrice(client);
        clients.add(client);
    }

    public void removeClient(Client client){
        clients.remove(client);
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
