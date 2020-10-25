package com.java.automation.lab.fall.grinecivh.core22.domain.enums;

public enum EnglishLevel {
    BEGINNER("Beginer"),
    PRE_INTERMEDIATE("Pre-intermediate"),
    INTERMEDIATE("Intermediate"),
    UPPER_INTERMEDIATE("Upper-intermediate"),
    ADVANCED("Advanced"),
    FLUENT("Fluent");

    String engLvl;
    EnglishLevel(String str){
        engLvl = str;
    }

    public String getEngLvl() {
        return engLvl;
    }


    @Override
    public String toString() {
        return "English level: "+ engLvl;
    }
}
