package com.java.automation.lab.fall.grinecivh.core22.domain.classes.ticket;

import java.util.Comparator;

public class TicketComparator {

    public static Comparator<Ticket> ticketPriceComparator = new Comparator<Ticket>(){

        public int compare(Ticket t1, Ticket t2){
            return (int) (t1.getPrice() - t2.getPrice());
        }
    };
}
