package dev.kay.Model.Interface;

import dev.kay.Control.SaveDataControl;
import dev.kay.Model.Model.Food;
import dev.kay.Model.Model.FoodList;
import dev.kay.Model.Model.Staff;
import dev.kay.Model.Model.WorkList;

import java.util.ArrayList;
import java.util.Scanner;

public interface IStaff {
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

    public void createOrderList();

    public void displayOrderList();


    public void printPrice();

    public void ManageStaff(ArrayList<IPerson> personStaffArrayList);


    public void manageFood(FoodList foodList);

    public void saveAllData(ArrayList<IPerson> personManageArrayList, ArrayList<IPerson> personStaffArrayList, FoodList foodList);

}
