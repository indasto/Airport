package com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception;

public class LuggageWeightException extends IllegalArgumentException {
    public LuggageWeightException(){
        super("Luggage weight can't be below 0");
    }
}
