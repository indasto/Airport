package com.java.automation.lab.fall.grinecivh.core22.domain.classes;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.Client;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.Ticket;
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

        for (int i = 0; i < tickets.size(); i++) {

            ClassLevel classLevel = tickets.get(i).getCl();

            if(classLevel == ClassLevel.ECONOM){
                sum+= economTariffPerKm * tickets.get(i).getFlight().getDistance();

            } else if (classLevel == ClassLevel.BUSINESS){
                sum+= businessTariffPerKm * tickets.get(i).getFlight().getDistance();
            } else {
                sum+= firstClassTarifPerKm * tickets.get(i).getFlight().getDistance();
            }

        }

        return sum;
    }

    private static double calculateRegular(double kg){
        return kg*regularLuggageTariffPerKg;
    }

    private static double calculateCarryOn(int quantity){
        return quantity*tariffPerCarryOnLuggage;
    }
}

