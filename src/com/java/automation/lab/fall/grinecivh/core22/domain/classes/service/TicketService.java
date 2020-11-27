package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.PropertyConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.TicketDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;

import java.util.Collections;
import java.util.List;

public class TicketService extends BaseService {
    TicketDAO ticketDAO = TICKET_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));

    public Ticket create(Ticket o) {
        return ticketDAO.create(o);
    }

    public Ticket getById(int id) {
        return ticketDAO.getById(id);
    }

    public List<Ticket> get() {
        return ticketDAO.get();
    }

    public Ticket update(Ticket o) {
        return ticketDAO.update(o);
    }

    public int deleteById(int id) {
        return ticketDAO.deleteById(id);
    }
}
