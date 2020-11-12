package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.workers.entity;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans.AbstractHuman;

import java.util.Objects;

public class AbstractWorker extends AbstractHuman {

    private double salary;
    private String education;

    public AbstractWorker(String firstName, String lastName, int age, double salary, String education) throws RuntimeException {
        super(firstName, lastName, age);

        this.salary = salary;
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Salary: " + salary +
                ", Education: " + education;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        if (!super.equals(ref)) return false;

        AbstractWorker that = (AbstractWorker) ref;

        return  Double.compare(that.salary, salary) == 0 &&
                Objects.equals(education, that.education);
    }

    @Override
    public int hashCode() {
        int hash = (int) salary;
        return education.hashCode() + hash;
    }

    public double getSalary() {
        return salary;
    }

    public String getEducation() {
        return education;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}
