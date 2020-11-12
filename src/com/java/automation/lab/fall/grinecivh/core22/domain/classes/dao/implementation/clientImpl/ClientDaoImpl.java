package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation.clientImpl;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.FlightService;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Price;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.ClientDao;

import java.util.*;

public class ClientDaoImpl implements ClientDao {

    private List<Client> clients;
    private FlightService fm;

    public ClientDaoImpl(FlightService fm) {

        this.fm = fm;
        clients = new LinkedList<>();

    }

    public ClientDaoImpl() {
        clients = new LinkedList<>();
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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public FlightService getFm() {
        return fm;
    }

    public void setFm(FlightService fm) {
        this.fm = fm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDaoImpl clientDao = (ClientDaoImpl) o;
        return Objects.equals(clients, clientDao.clients) &&
                Objects.equals(fm, clientDao.fm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients, fm);
    }

    @Override
    public String toString() {
        return "ClientDaoImpl{" +
                "clients=" + clients +
                ", fm=" + fm +
                '}';
    }
}
