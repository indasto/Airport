package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.AbstractHuman;

import java.util.Objects;

public class Security extends AbstractWorker {

    private String equipment;

    public Security(String firstName, String lastName, int age, double soot, int salary, String education) {
        super(firstName, lastName, age, salary, soot, education);
        this.equipment = equipment;
    }

    public void patrolArea() {
    }

    public void checkForDocuments() {
    }

    public void detainPerson(AbstractHuman person) {
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Security security = (Security) o;

        return equipment != null ? equipment.equals(security.equipment) : security.equipment == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (equipment != null ? equipment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Security{");
        sb.append("equipment='").append(equipment).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
