package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.PropertyConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.ClientDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;

import java.util.List;
import java.util.Objects;

public class ClientService extends BaseService{

    private static ClientService clientService;
    private ClientDAO clientDao = CLIENT_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));

    private ClientService() {
    }

    public static ClientService createClientService() {
        if (clientService == null) {
            clientService = new ClientService();
        }

        return clientService;
    }

    public Client create(Client client) {
        return clientDao.create(client);
    }

    public Client getById(int id) {
        return clientDao.getById(id);
    }

    public List<Client> get() {
        return clientDao.get();
    }

    Client update(Client client) {
        return clientDao.update(client);
    }

    Client deleteById(int id) {
        return clientDao.getById(id);
    }


}
