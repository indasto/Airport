package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.client;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception.LuggageWeightException;

public abstract class Luggage {

    private double kg;
    private String name;

    public Luggage(String thing, double kg) throws LuggageWeightException {

        if (kg < 0) {
            throw new LuggageWeightException();
        }

        this.kg = kg;
        this.name = thing;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) throws LuggageWeightException {
        if (kg < 0) {
            throw new LuggageWeightException();
        }

        this.kg = kg;

    }

    @Override
    public String toString() {
        return "Luggage " + name + ", kg=" + kg;
    }
}
