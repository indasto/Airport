package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.OfficeEmployees;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.AbstractPassengerPlane;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.service.ClientService;

import java.security.Security;
import java.util.*;

public class Airport {

    private transient ClientService clientService;
    private int code;
    private String address;
    private double latitude;
    private double longitude;
    private List<AbstractPassengerPlane> passengerPlanes;
    private List<Security> securities;
    private List<OfficeEmployees> officeEmployees;
    private List<AirlineCompany> airlineCompanies;


    public Airport() {
        clientService = ClientService.createClientService();
    }

    public Airport(ClientService clientService, int code, String address, double latitude, double longitude) {
        this.clientService = clientService;
        this.code = code;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;

        officeEmployees = new ArrayList<>();
        airlineCompanies = new ArrayList<>();
        securities = new ArrayList<>();
        passengerPlanes = new ArrayList<>();
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

    public ClientService getClientService() {
        return clientService;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<AbstractPassengerPlane> getPassengerPlanes() {
        return passengerPlanes;
    }

    public void setPassengerPlanes(List<AbstractPassengerPlane> passengerPlanes) {
        this.passengerPlanes = passengerPlanes;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    public List<OfficeEmployees> getOfficeEmployees() {
        return officeEmployees;
    }

    public void setOfficeEmployees(List<OfficeEmployees> officeEmployees) {
        this.officeEmployees = officeEmployees;
    }

    public List<AirlineCompany> getAirlineCompanies() {
        return airlineCompanies;
    }

    public void setAirlineCompanies(List<AirlineCompany> airlineCompanies) {
        this.airlineCompanies = airlineCompanies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airport airport = (Airport) o;

        if (code != airport.code) return false;
        if (Double.compare(airport.latitude, latitude) != 0) return false;
        if (Double.compare(airport.longitude, longitude) != 0) return false;
        if (clientService != null ? !clientService.equals(airport.clientService) : airport.clientService != null)
            return false;
        if (address != null ? !address.equals(airport.address) : airport.address != null) return false;
        if (passengerPlanes != null ? !passengerPlanes.equals(airport.passengerPlanes) : airport.passengerPlanes != null)
            return false;
        if (securities != null ? !securities.equals(airport.securities) : airport.securities != null) return false;
        if (officeEmployees != null ? !officeEmployees.equals(airport.officeEmployees) : airport.officeEmployees != null)
            return false;
        return airlineCompanies != null ? airlineCompanies.equals(airport.airlineCompanies) : airport.airlineCompanies == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = clientService != null ? clientService.hashCode() : 0;
        result = 31 * result + code;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (passengerPlanes != null ? passengerPlanes.hashCode() : 0);
        result = 31 * result + (securities != null ? securities.hashCode() : 0);
        result = 31 * result + (officeEmployees != null ? officeEmployees.hashCode() : 0);
        result = 31 * result + (airlineCompanies != null ? airlineCompanies.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Airport{");
        sb.append("clientService=").append(clientService);
        sb.append(", code=").append(code);
        sb.append(", address='").append(address).append('\'');
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", passengerPlanes=").append(passengerPlanes);
        sb.append(", securities=").append(securities);
        sb.append(", officeEmployees=").append(officeEmployees);
        sb.append(", airlineCompanies=").append(airlineCompanies);
        sb.append('}');
        return sb.toString();
    }
}
