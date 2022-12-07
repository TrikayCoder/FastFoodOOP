package dev.kay.Model.Interface;

import java.util.ArrayList;

public interface IOrderList {

    /**
     * Generate new Order list
     * @param iFoods List of food
     */
    public void generateOrder(ArrayList<IFood> iFoods);

    /**
     * Get all list of Order
     * @return A list of Order
     */
    public ArrayList<IFood> getOrder();

    /**
     * Add Food into Order list
     * @param iFood Food to add
     */
    public void addOrder(IFood iFood);

    /**
     * Remove Food from Order list
     * @param iFood Food to remove
     */
    public void removeOrder(IFood iFood);

    /**
     * Clear list of order
     */
    public void clearOrder();
}
