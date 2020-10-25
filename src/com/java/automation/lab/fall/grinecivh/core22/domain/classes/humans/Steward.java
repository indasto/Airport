package com.java.automation.lab.fall.grinecivh.core22.domain.classes.humans;

import com.java.automation.lab.fall.grinecivh.core22.domain.enums.EnglishLevel;

public class Steward extends AbstractWorker {

    private EnglishLevel englishLevel;

    public Steward(String firstName, String lastName, int age, int soot, double salary, String education, EnglishLevel englishLvl) {
        super(firstName, lastName, age, salary, education);

        this.englishLevel = englishLvl;
    }

    public EnglishLevel getEnglishLvl() {
        return englishLevel;
    }

    public void setEnglish_lvl(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
    }

    @Override
    public String toString() {
        return super.toString() +
                "English Lvl: " + englishLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Steward steward = (Steward) o;
        return englishLevel == steward.englishLevel;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + englishLevel.hashCode();
    }
}
