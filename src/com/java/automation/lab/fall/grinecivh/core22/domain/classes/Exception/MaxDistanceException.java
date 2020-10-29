package com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception;

public class MaxDistanceException extends IllegalArgumentException{
    public MaxDistanceException() {
        super("Wrong distance input");
    }
}