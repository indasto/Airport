package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.IOConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.ClientDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.ObjectIO;

import java.util.List;

public class ClientDAOImplClasz implements ClientDAO {
    @Override
    public Client create(Client o) {
        new ObjectIO<Client>().write(o, IOConstant.RQ_PATH);
        return o;
    }

    @Override
    public Client getById(int id) {
        return new ObjectIO<Client>().read(IOConstant.RQ_PATH);
    }

    @Override
    public List<Client> get() {
        return null;
    }

    @Override
    public Client update(Client o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}

