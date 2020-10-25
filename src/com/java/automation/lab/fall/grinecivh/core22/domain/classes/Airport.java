package com.java.automation.lab.fall.grinecivh.core22.domain.classes;

import java.security.Security;
import java.util.*;

public class Airport {

    private Registry registry;
    private List<Security> securities;
    private int code;

    public static void main(String[] args) {
        //creating all the stuff
    }

    public Registry getRegistry() {
        return registry;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setRegistry(Registry registry) {
        this.registry = registry;
    }

    public void setSecurities(ArrayList<Security> securities) {
        this.securities = securities;
    }


    @Override
    public String toString() {
        return  "Registry: " + registry + ", securities: " + securities +
                ", Airport code" + code;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        Airport airport = (Airport) ref;

        return code == airport.code &&
                Objects.equals(registry, airport.registry) &&
                Objects.equals(securities, airport.securities);
    }

    @Override
    public int hashCode() {
        return registry.hashCode()+securities.hashCode();
    }
}
