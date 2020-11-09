package com.java.automation.lab.fall.grinecivh.core22.domain.enums;

public enum ClassLevel {
    FIRST("First class"),
    BUSINESS("Business class"),
    ECONOM("Econom class");

    private String cl;
    ClassLevel(String str){
        this.cl = str;
    }

    public String getCl() {
        return cl;
    }

    @Override
    public String toString() {
        return "Class level: "+cl;
    }
}
