package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.human.client.ClientDaoImpl;

import java.security.Security;
import java.util.*;

public class Airport {

    private ClientDaoImpl clientDaoImpl;
    private List<Security> securities;
    private int code;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private List<AirlineCompany> airlineCompanies;

    public Airport() {
        clientDaoImpl = ClientDaoImpl.createRegistry();
    }

    public Airport(ClientDaoImpl reg, int code, String name, String address, double latitude, double longitude) {
        this.clientDaoImpl = reg;
        this.code = code;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;

        airlineCompanies = new ArrayList<>();
        securities = new ArrayList<>();
    }

    public void addAirlineCompany(AirlineCompany company) {
        airlineCompanies.add(company);
    }

    public void removeAirlineCompany(int index) {
        airlineCompanies.remove(index);
    }

    public AirlineCompany getAirlineCompany(String name) {
        AirlineCompany company = null;

        for (int i = 0; i < airlineCompanies.size(); i++) {
            if (airlineCompanies.get(i).getCompanyName().equals(name)) {
                company = airlineCompanies.get(i);
                break;
            }
        }

        return company;
    }

    public ClientDaoImpl getRegistry() {
        return clientDaoImpl;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setRegistry(ClientDaoImpl clientDaoImpl) {
        this.clientDaoImpl = clientDaoImpl;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Airport location: " + address + "Name: " + name + "ClientDaoImpl: " + clientDaoImpl + ", securities: " + securities +
                ", Airport code" + code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return code == airport.code &&
                Objects.equals(clientDaoImpl, airport.clientDaoImpl) &&
                Objects.equals(securities, airport.securities) &&
                Objects.equals(name, airport.name) &&
                Objects.equals(address, airport.address);
    }

    @Override
    public int hashCode() {
        return clientDaoImpl.hashCode() + securities.hashCode();
    }
}
