package com.java.automation.lab.fall.grinecivh.core22.domain.classes;

import java.util.*;

public class Airline {

    private HashMap<String,Integer> codeForCity;   // Where String city, Integer code of the airport
    private String companyName;
    private String entityAddress;
    private List<String> comments;

    public Airline(String name, String entityAddress, ArrayList<String> comments, HashMap<String,Integer> codes){

        this.companyName = name;
        this.comments = comments;
        this.entityAddress = entityAddress;
        this.codeForCity = codes;
    }



    public void addComment(String ... com){
        for (int i = 0; i < com.length; i++) {
            comments.add(com[i]);
        }
    }

    @Override
    public String toString() {
        return "Cities and their codes " + codeForCity + ", Company name: " + companyName + ", Entity address: " +
                entityAddress + ", Comments: " + comments;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        Airline airline = (Airline) ref;

        return Objects.equals(codeForCity, airline.codeForCity) &&
                Objects.equals(companyName, airline.companyName) &&
                Objects.equals(entityAddress, airline.entityAddress) &&
                Objects.equals(comments, airline.comments);
    }

    @Override
    public int hashCode() {
        return companyName.hashCode() + comments.hashCode();
    }
}
