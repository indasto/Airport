package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.IOConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.TicketDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.ObjectIO;

import java.util.List;

public class TicketDAOImplClasz implements TicketDAO {
    @Override
    public Ticket create(Ticket o) {
        new ObjectIO<Ticket>().write(o, IOConstant.TICKET_PATH);
        return o;
    }

    @Override
    public Ticket getById(int id) {
        return new ObjectIO<Ticket>().read(IOConstant.TICKET_PATH);
    }

    @Override
    public List<Ticket> get() {
        return null;
    }

    @Override
    public Ticket update(Ticket o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
