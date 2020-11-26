package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker;

import com.java.automation.lab.fall.grinecivh.core22.domain.enums.EnglishLevel;

public class Steward extends AbstractWorker {

    private EnglishLevel englishLevel;

    public Steward(String firstName, String lastName, int age, double soot, int salary, String education, EnglishLevel englishLvl) {
        super(firstName, lastName, age, salary, soot, education);

        this.englishLevel = englishLvl;
    }

    public EnglishLevel getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(EnglishLevel englishLevel) {
        this.englishLevel = englishLevel;
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
        int result = super.hashCode();
        result = 31 * result + (englishLevel != null ? englishLevel.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Steward{");
        sb.append("englishLevel=").append(englishLevel);
        sb.append('}');
        return sb.toString();
    }
}
