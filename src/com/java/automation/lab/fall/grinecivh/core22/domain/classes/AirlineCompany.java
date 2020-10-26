package com.java.automation.lab.fall.grinecivh.core22.domain.classes;

import java.util.*;

public class AirlineCompany {

    private String companyName;
    private String entityAddress;
    private List<String> comments;

    public AirlineCompany(String name, String entityAddress, ArrayList<String> comments) {

        this.companyName = name;
        this.comments = comments;
        this.entityAddress = entityAddress;
    }


    public void addComment(String... com) {
        for (int i = 0; i < com.length; i++) {
            comments.add(com[i]);
        }
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
                entityAddress + ", Comments: " + comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineCompany airlineCompany = (AirlineCompany) o;
        return Objects.equals(companyName, airlineCompany.companyName) &&
                Objects.equals(entityAddress, airlineCompany.entityAddress) &&
                Objects.equals(comments, airlineCompany.comments);
    }

    @Override
    public int hashCode() {
        return companyName.hashCode() + comments.hashCode();
    }
}
