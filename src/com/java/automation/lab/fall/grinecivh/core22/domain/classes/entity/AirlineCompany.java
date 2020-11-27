package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Dictionary;

import java.util.ArrayList;
import java.util.List;

public class AirlineCompany {

    private String companyName;
    private String entityAddress;
    private List<Airport> airports;
    private transient Dictionary dictionary;

    public AirlineCompany(String name, String entityAddress) {

        this.companyName = name;
        this.entityAddress = entityAddress;
        dictionary = new Dictionary();
        airports = new ArrayList<>();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEntityAddress() {
        return entityAddress;
    }

    public void setEntityAddress(String entityAddress) {
        this.entityAddress = entityAddress;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirlineCompany that = (AirlineCompany) o;

        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (entityAddress != null ? !entityAddress.equals(that.entityAddress) : that.entityAddress != null)
            return false;
        if (airports != null ? !airports.equals(that.airports) : that.airports != null) return false;
        return dictionary != null ? dictionary.equals(that.dictionary) : that.dictionary == null;
    }

    @Override
    public int hashCode() {
        int result = companyName != null ? companyName.hashCode() : 0;
        result = 31 * result + (entityAddress != null ? entityAddress.hashCode() : 0);
        result = 31 * result + (airports != null ? airports.hashCode() : 0);
        result = 31 * result + (dictionary != null ? dictionary.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AirlineCompany{");
        sb.append("companyName='").append(companyName).append('\'');
        sb.append(", entityAddress='").append(entityAddress).append('\'');
        sb.append(", airports=").append(airports);
        sb.append(", dictionary=").append(dictionary);
        sb.append('}');
        return sb.toString();
    }
}
