package dev.kay.Model.Interface;

public interface IWorkPerson {
    /**
     * This is position work of {@link IPerson#STAFF} level
     */
    public static final int POSITION_SALE = 1;
    /**
     * This is position work of {@link IPerson#STAFF} level
     */
    public static final int POSITION_CHEF = 2;
    /**
     * This is position work of {@link IPerson#STAFF} level
     */
    public static final int POSITION_TECHNICAL = 3;
    /**
     * This is position work of {@link IPerson#STAFF} level
     */
    public static final int POSITION_MARKETING = 4;

    /**
     * This is position work of {@link IPerson#MANAGE} level
     */
    public static final int POSITION_MANAGE_STORE = 5;

    /**
     * This is position work of {@link IPerson#MANAGE} level
     */
    public static final int POSITION_MANAGE_GROUND_STORE = 6;

    /**
     * This is position work of {@link IPerson#MANAGE} level
     */
    public static final int POSITION_MANAGE_ALL_GROUND_STORE = 7;

    /**
     * Solve final salary which Staff can get
     * @param isalary Salary of staff
     * @return final salary
     */
    public int solveFinalSalary(ISalary isalary);

    public void isGenerateContract(boolean isGenerate);

    public void isCancelContract(boolean isCancel);

}
