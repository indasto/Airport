package com.java.automation.lab.fall.grinecivh.core22.domain.interfaces.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception.LackOfFuelException;

public interface Fly {
    public void fly(double distanceKm) throws LackOfFuelException;

}
