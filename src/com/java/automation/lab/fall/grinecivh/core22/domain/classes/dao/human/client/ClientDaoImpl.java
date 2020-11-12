package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.human.client;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.flight.FlightDaoImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.ServiceEmployees;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Price;
import com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.dao.ClientDao;

import java.util.*;

public class ClientDaoImpl implements ClientDao {
    private static ClientDaoImpl clientDaoImpl;
    private List<ServiceEmployees> airportPersonals;
    private List<Client> clients;
    private FlightDaoImpl fm;

    private ClientDaoImpl(FlightDaoImpl fm, ServiceEmployees... se) {
        this.fm = fm;
        airportPersonals = new ArrayList<>();
        clients = new LinkedList<>();

        for (int i = 0; i < se.length; i++) {
            airportPersonals.add(se[i]);
        }
    }

    private ClientDaoImpl() {
        clients = new LinkedList<>();
    }

    public static ClientDaoImpl createRegistry() {
        if (clientDaoImpl == null) {
            return new ClientDaoImpl();
        } else {
            return clientDaoImpl;
        }
    }

    public static ClientDaoImpl createRegistry(FlightDaoImpl fm, ServiceEmployees... se) {
        if (clientDaoImpl == null) {
            return new ClientDaoImpl(fm,se);
        } else {
            return clientDaoImpl;
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

    public FlightDaoImpl getFm() {
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

    public void setFm(FlightDaoImpl fm) {
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

        ClientDaoImpl clientDaoImpl = (ClientDaoImpl) ref;

        return  Objects.equals(airportPersonals, clientDaoImpl.airportPersonals) &&
                Objects.equals(clients, clientDaoImpl.clients) &&
                Objects.equals(fm, clientDaoImpl.fm);
    }

    @Override
    public int hashCode() {
        return clients.hashCode()+ airportPersonals.hashCode();
    }
}
