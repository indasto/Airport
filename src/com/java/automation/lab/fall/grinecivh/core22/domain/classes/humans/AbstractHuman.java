package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.Exception.WrongAgeException;

import java.util.Objects;

public abstract class AbstractHuman {

    private String firstName;
    private String lastName;
    private int age;

    public AbstractHuman(String firstName, String lastName, int age) throws WrongAgeException {

        if (age < 0 || age >130) {
            throw new WrongAgeException();
        }

        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "First name: " + firstName +", Last name: " + lastName + ", age: " + age;
    }

    @Override
    public boolean equals(Object ref) {
        if (this == ref) {
            return true;
        }

        if (ref == null || getClass() != ref.getClass()) {
            return false;
        }

        AbstractHuman that = (AbstractHuman) ref;

        return  age == that.age &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return firstName.hashCode()+lastName.hashCode();
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
