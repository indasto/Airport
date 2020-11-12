package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;

public interface ClientDao {

    public void addClient(Client client);

    public void removeClient(Client client);
}
