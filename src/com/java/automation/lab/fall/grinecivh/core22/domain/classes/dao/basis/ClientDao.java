package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.FlightService;

import java.util.List;

public interface ClientDao {

    public void addClient(Client client);

    public void removeClient(Client client);

    public List<Client> getClients();

    public void setClients(List<Client> clients);

    public FlightService getFm();

    public void setFm(FlightService fm);
}
