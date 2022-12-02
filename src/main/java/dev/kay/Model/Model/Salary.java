package dev.kay.Model.Model;

import dev.kay.Control.SalaryControl;
import dev.kay.Model.Interface.ISalary;

public class Salary implements ISalary {
    private int currentSalary;

    @Override
    public int getCurrentSalary() {
        return currentSalary;
    }

    public Salary() {
    }

    @Override
    public void initSalary(int positionStaff) {
        this.currentSalary = SalaryControl.initSalary(positionStaff);
    }

    @Override
    public void chanceCurrentSalary(float percentChance, boolean isUp) {
        this.currentSalary = SalaryControl.chanceCurrentSalary(percentChance, isUp);
    }
}
