package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker;

import java.util.Objects;

public class Pilot extends AbstractWorker {

    private String license;

    public Pilot(String firstName, String lastName, int age, double soot, int salary, String education, String license) {
        super(firstName, lastName, age, salary, soot, education);

        this.license = license;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Pilot pilot = (Pilot) o;

        return license != null ? license.equals(pilot.license) : pilot.license == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (license != null ? license.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pilot{");
        sb.append("license='").append(license).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
