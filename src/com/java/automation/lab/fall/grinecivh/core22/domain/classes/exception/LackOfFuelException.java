package com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception;

public class LackOfFuelException extends Exception{
    public LackOfFuelException() {
        super("Don't enough fuel to fly");
    }
}
