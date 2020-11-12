package com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception;

public class MaxFuelException extends IllegalArgumentException{

    public MaxFuelException(){
        super("Max fuel at least should be more then 1000 liters");
    }
}
