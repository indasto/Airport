package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.ClientDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.implementation.clientImpl.ClientDaoImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;

import java.util.List;
import java.util.Objects;

public class ClientService {
    private static ClientService clientService;
    private ClientDao clientDao;

    private ClientService() {
    }

    public static ClientService createClientService() {
        if (clientService == null) {
            clientService = new ClientService();
        }

        return clientService;
    }

    public void addClient(Client client) {
        clientDao.addClient(client);
    }

    public void removeClient(Client client) {
        clientDao.removeClient(client);
    }

    public List<Client> getClients() {
        return clientDao.getClients();
    }

    public void setClients(List<Client> clients) {
        clientDao.setClients(clients);
    }

    public static ClientService getClientService() {
        return clientService;
    }

    public static void setClientService(ClientService clientService) {
        ClientService.clientService = clientService;
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDaoImpl clientDao) {
        this.clientDao = clientDao;
    }

    public FlightService getFm() {
        return clientDao.getFm();
    }

    public void setFm(FlightService fm) {
        clientDao.setFm(fm);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientService that = (ClientService) o;
        return Objects.equals(clientDao, that.clientDao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientDao);
    }

    @Override
    public String toString() {
        return "ClientService{" +
                "clientDao=" + clientDao +
                '}';
    }
}
