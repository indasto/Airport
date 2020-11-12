package com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.dao;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.entity.Client;

public interface ClientDao {
    public void addClient(Client client);

    public void removeClient(Client client);
}
