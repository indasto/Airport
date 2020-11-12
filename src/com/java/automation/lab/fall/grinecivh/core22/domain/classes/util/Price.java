package com.java.automation.lab.fall.grinecivh.core22.domain.classes.util;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.enums.ClassLevel;

import java.util.List;

public class Price {

    private static double businessTariffPerKm = 1.35;
    private static double economTariffPerKm = 0.59;
    private static double firstClassTarifPerKm = 15.2;

    private static double regularLuggageTariffPerKg = 0.2;
    private static double tariffPerCarryOnLuggage = 0.2;

    private Price() {
    }

    public static double calculatePrice(Client cl) {

        double sum = 0;

        if (cl.getCarryOnLuggages()!=null){
            sum+=calculateCarryOn(cl.getCarryOnLuggages().size());
        }

        if (cl.getRegularLuggages()!=null){
            for (int i = 0; i < cl.getRegularLuggages().size(); i++) {
                double kg = cl.getRegularLuggages().get(i).getKg();
                sum+=calculateRegular(kg);
            }
        }

        List<Ticket> tickets = cl.getTickets();

        for (Ticket ticket: tickets) {
            sum+=getTicketPrice(ticket);
        }

        return sum;
    }

    public static double getTicketPrice(Ticket ticket){
        ClassLevel classLevel = ticket.getCl();

        double res = 0;
        if(classLevel == ClassLevel.ECONOM){
            res= economTariffPerKm * ticket.getFlight().getDistance();

        } else if (classLevel == ClassLevel.BUSINESS){
            res= businessTariffPerKm * ticket.getFlight().getDistance();
        } else {
            res= firstClassTarifPerKm * ticket.getFlight().getDistance();
        }

        return res;
    }

    private static double calculateRegular(double kg){
        return kg*regularLuggageTariffPerKg;
    }

    private static double calculateCarryOn(int quantity){
        return quantity*tariffPerCarryOnLuggage;
    }
}

