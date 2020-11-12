package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.workers.entity;

import java.util.Objects;

public class Pilot extends AbstractWorker {

    private int soot;
    private String license;

    public Pilot(String firstName, String lastName, int age, int soot, double salary, String education, String license) {
        super(firstName, lastName, age, salary,education);

        this.soot = soot;
        this.license=license;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Soot: " + soot +
                ", License: " + license;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        if (!super.equals(ref)) {
            return false;
        }

        Pilot pilot = (Pilot) ref;

        return  soot == pilot.soot &&
                Objects.equals(license, pilot.license);
    }

    @Override
    public int hashCode() {
        return soot + license.hashCode()+license.hashCode();
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setSoot(int soot) {
        this.soot = soot;
    }


    public int getSoot() {
        return soot;
    }

    public String getLicense() {
        return license;
    }
}
