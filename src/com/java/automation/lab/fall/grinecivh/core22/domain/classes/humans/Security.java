package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans;

import java.util.Objects;

public class Security extends AbstractWorker{

    private String equipment;

    public Security(String firstName, String lastName, int age, int soot, double salary, String education) {
        super(firstName, lastName, age, salary,education);
        this.equipment = equipment;
    }

    public void patrolArea() {}

    public void checkForDocuments(){}

    public void detainPerson(AbstractHuman person){}

    public String getEquipment() {
        return equipment;
    }


    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }


    @Override
    public String toString() {
        return super.toString() +
                "Equipment: " + equipment;
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

        Security security = (Security) ref;

        return Objects.equals(equipment, security.equipment);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + equipment.hashCode();
    }
}
