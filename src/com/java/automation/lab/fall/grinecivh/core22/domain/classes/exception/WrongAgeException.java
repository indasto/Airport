package com.java.automation.lab.fall.grinecivh.core22.domain.classes.exception;

public class WrongAgeException extends IllegalArgumentException{

    public WrongAgeException(){
        super("Age should be between of 0 and 130");
    }
}
