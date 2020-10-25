package com.java.automation.lab.fall.grinecivh.core22.domain.enums;

public enum AccessLevel {
    A1("Limited"),
    A2("Limited with additions"),
    B1("Standard"),
    B2("Extended standard"),
    C("All inclusive");

    private String lvl;
    AccessLevel(String str){
        this.lvl = str;
    }

    public String getLvl() {
        return lvl;
    }


    @Override
    public String toString() {
        return "Access level: " +lvl;
    }
}
