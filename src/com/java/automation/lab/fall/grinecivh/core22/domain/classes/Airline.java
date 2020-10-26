package com.java.automation.lab.fall.grinecivh.core22.domain.classes;

import java.util.*;

public class Airline {

    private List<Airport> airports;
    private String companyName;
    private String entityAddress;
    private List<String> comments;

    public Airline(String name, String entityAddress, ArrayList<String> comments) {

        this.companyName = name;
        this.comments = comments;
        this.entityAddress = entityAddress;
        airports = new ArrayList<>();
    }

    public void addAirport(Airport airport){
        airports.add(airport);
    }

    public void removeAirport(int code){
        for (int i = 0; i < airports.size(); i++) {
            if(airports.get(i).getCode() == code){
                airports.remove(i);
                break;
            }
        }
    }

    public void addComment(String... com) {
        for (int i = 0; i < com.length; i++) {
            comments.add(com[i]);
        }
    }

    @Override
    public String toString() {
        return  "Company name: " + companyName + ", Entity address: " +
                entityAddress + ", Comments: " + comments + "Airports: " + airports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(airports, airline.airports) &&
                Objects.equals(companyName, airline.companyName) &&
                Objects.equals(entityAddress, airline.entityAddress) &&
                Objects.equals(comments, airline.comments);
    }

    @Override
    public int hashCode() {
        return companyName.hashCode() + comments.hashCode();
    }
}
