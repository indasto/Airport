package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.client.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.AbstractHuman;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.ticket.Ticket;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.ticket.TicketComparator;

import java.util.*;

public class Client extends AbstractHuman {

    private List<CarryOnLuggage> carryOnLuggages;
    private List<RegularLuggage> regularLuggages;
    private List<Ticket> tickets;
    private double totalPrice;

    public Client(String firstName, String lastName, int age, Ticket ticket) {
        super(firstName,lastName,age);
        tickets.add(ticket);
        carryOnLuggages = new ArrayList<>();
        regularLuggages = new ArrayList<>();
        tickets = new LinkedList<>();
    }

    public Client(String firstName, String lastName, int age) {
        super(firstName,lastName,age);
        carryOnLuggages = new ArrayList<>();
        regularLuggages = new ArrayList<>();
        tickets = new LinkedList<>();
    }

    public void addLuggage(String name, double kg){
        if (kg < 5){
            carryOnLuggages.add(new CarryOnLuggage(name,kg));
        } else {
            regularLuggages.add(new RegularLuggage(name,kg));
        }
    }

    public List<CarryOnLuggage> getCarryOnLuggages() {
        return carryOnLuggages;
    }

    public List<RegularLuggage> getRegularLuggages() {
        return regularLuggages;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setCarryOnLuggages(List<CarryOnLuggage> carryOnLuggages) {
        this.carryOnLuggages = carryOnLuggages;
    }

    public void setRegularLuggages(List<RegularLuggage> regularLuggages) {
        this.regularLuggages = regularLuggages;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void ticketsSort(){
        Collections.sort(tickets, TicketComparator.ticketPriceComparator);
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        Client client = (Client) ref;

        return  Double.compare(client.totalPrice, totalPrice) == 0 &&
                Objects.equals(carryOnLuggages, client.carryOnLuggages) &&
                Objects.equals(regularLuggages, client.regularLuggages) &&
                Objects.equals(tickets, client.tickets);
    }

    @Override
    public int hashCode() {
        return carryOnLuggages.hashCode()+tickets.hashCode()+regularLuggages.hashCode();
    }

    @Override
    public String toString() {
        return super.toString() +
                ",  Carry on Luggage: " + carryOnLuggages +
                ", Regular Luggage: " + regularLuggages +
                ", tickets: " + tickets +
                ", total price: " + totalPrice;
    }
}
