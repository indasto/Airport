package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock;


import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.ClientDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.FlightService;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Price;

import java.util.*;

public class ClientDAOImpl implements ClientDAO {

    private List<Client> clients;

    public ClientDAOImpl() {
        clients = new LinkedList<>();
    }

    @Override
    public Client create(Client o) {
        Price.calculatePrice(o);
        clients.add(o);
        return o;
    }

    @Override
    public Client getById(int id) {
        return clients.get(id);
    }

    @Override
    public List<Client> get() {
        return Collections.unmodifiableList(clients);
    }

    @Override
    public Client update(Client o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        clients.remove(id);
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientDAOImpl clientDAO = (ClientDAOImpl) o;

        return clients != null ? clients.equals(clientDAO.clients) : clientDAO.clients == null;
    }

    @Override
    public int hashCode() {
        return clients != null ? clients.hashCode() : 0;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ClientDAOImplClasz{");
        sb.append("clients=").append(clients);
        sb.append('}');
        return sb.toString();
    }
}
