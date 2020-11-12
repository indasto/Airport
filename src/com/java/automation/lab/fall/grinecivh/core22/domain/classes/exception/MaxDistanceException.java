package com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception;

public class MaxDistanceException extends IllegalArgumentException{
    public MaxDistanceException() {
        super("Wrong distance input");
    }
}