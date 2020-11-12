package com.java.automation.lab.fall.grinecivh.core22.domain.classes.main.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Dictionary;

import java.util.*;

public class AirlineCompany {

    private String companyName;
    private String entityAddress;
    private com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Dictionary dictionary;

    public AirlineCompany(String name, String entityAddress) {

        this.companyName = name;
        this.entityAddress = entityAddress;
        dictionary = new com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Dictionary();
    }


    public String getCompanyName() {
        return companyName;
    }

    public String getEntityAddress() {
        return entityAddress;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setEntityAddress(String entityAddress) {
        this.entityAddress = entityAddress;
    }

    public com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public String toString() {
        return "Company name: " + companyName + ", Entity address: " +
                entityAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirlineCompany airlineCompany = (AirlineCompany) o;
        return Objects.equals(companyName, airlineCompany.companyName) &&
                Objects.equals(entityAddress, airlineCompany.entityAddress) &&
                Objects.equals(dictionary, airlineCompany.dictionary);
    }

    @Override
    public int hashCode() {
        return companyName.hashCode() + dictionary.hashCode();
    }
}
