package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker;

import com.java.automation.lab.fall.grinecivh.core22.domain.enums.Profession;

public class OfficeEmployees extends AbstractWorker {

    private Profession position;

    public OfficeEmployees(String firstName, String lastName, int age, double soot, int salary, String education, Profession prof) {
        super(firstName, lastName, age, salary, soot, education);
        position = prof;
    }

    public Profession getPosition() {
        return position;
    }

    public void setPosition(Profession position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Profession: " + position;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) return true;
        if (ref == null || getClass() != ref.getClass()) return false;
        if (!super.equals(ref)) return false;
        OfficeEmployees that = (OfficeEmployees) ref;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + position.hashCode();
    }
}
