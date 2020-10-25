package com.java.automation.lab.fall.grinecivh.core22.domain.enums;

public enum Profession {
    SELLER("Seller"),
    REGISTRAR("Registrar"),
    CLEANER("Cleaner"),
    CONSULTANT("Consultant"),
    OFFICE_WORKER("Office worker");

    String prof;
    Profession(String str){
        this.prof = str;
    }

    public String getProf() {
        return prof;
    }

    @Override
    public String toString() {
        return "Profession: " + prof;
    }
}
