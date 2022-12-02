package dev.kay.Model.Interface;

public interface ISalary {

    /**
     * Init salary for each position staff
     * @param positionStaff position of staff
     */
    public void initSalary(int positionStaff);

    /**
     * Chance current salary of one staff
     * @param percentChance percent change (Ex: 0.2f mean 20%)
     * @param isUp true if is up salary, false if down salary
     */
    public void chanceCurrentSalary(float percentChance, boolean isUp);

    public int getCurrentSalary();
}
