package com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.AbstractHuman;

public class AbstractWorker extends AbstractHuman {

    private int salary;
    private double soot;
    private String education;

    public AbstractWorker(String firstName, String lastName, int age, int salary, double soot, String education) {
        super(firstName, lastName, age);

        this.education = education;
        this.salary = salary;
        this.soot = soot;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getSoot() {
        return soot;
    }

    public void setSoot(double soot) {
        this.soot = soot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        AbstractWorker that = (AbstractWorker) o;

        if (salary != that.salary) return false;
        return Double.compare(that.soot, soot) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + salary;
        temp = Double.doubleToLongBits(soot);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AbstractWorker{");
        sb.append("salary=").append(salary);
        sb.append(", soot=").append(soot);
        sb.append('}');
        return sb.toString();
    }
}
