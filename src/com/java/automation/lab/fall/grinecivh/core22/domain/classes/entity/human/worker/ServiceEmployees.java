package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker;

import com.java.automation.lab.fall.grinecivh.core22.domain.enums.Profession;

public class ServiceEmployees extends AbstractWorker {

    private Profession profession;

    public ServiceEmployees(String firstName, String lastName, int age, int soot, double salary, String education, Profession prof) {
        super(firstName, lastName, age, salary, education);
        profession = prof;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Profession: " + profession;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) return true;
        if (ref == null || getClass() != ref.getClass()) return false;
        if (!super.equals(ref)) return false;
        ServiceEmployees that = (ServiceEmployees) ref;
        return profession == that.profession;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + profession.hashCode();
    }
}
