package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.TicketDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketDAOImpl implements TicketDAO {
    private List<Ticket> tickets;

    public TicketDAOImpl() {
        tickets = new ArrayList<>();
    }

    @Override
    public Ticket create(Ticket o) {
        tickets.add(o);
        return o;
    }

    @Override
    public Ticket getById(int id) {
        return tickets.get(id);
    }

    @Override
    public List<Ticket> get() {
        return Collections.unmodifiableList(tickets);
    }

    @Override
    public Ticket update(Ticket o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        tickets.remove(id);
        return id;
    }
}
