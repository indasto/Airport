package com.java.automation.lab.fall.grinecivh.core22.domain.classes;

import java.util.*;

public class AirlineCompany {

    private List<Airport> airports;
    private String companyName;
    private String entityAddress;
    private List<String> comments;

    public AirlineCompany(String name, String entityAddress, ArrayList<String> comments) {

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

    public List<Airport> getAirports() {
        return airports;
    }

    public List<String> getComments() {
        return comments;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getEntityAddress() {
        return entityAddress;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEntityAddress(String entityAddress) {
        this.entityAddress = entityAddress;
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
        AirlineCompany airlineCompany = (AirlineCompany) o;
        return Objects.equals(airports, airlineCompany.airports) &&
                Objects.equals(companyName, airlineCompany.companyName) &&
                Objects.equals(entityAddress, airlineCompany.entityAddress) &&
                Objects.equals(comments, airlineCompany.comments);
    }

    @Override
    public int hashCode() {
        return companyName.hashCode() + comments.hashCode();
    }
}
