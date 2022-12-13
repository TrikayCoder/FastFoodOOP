package dev.kay.Model.Interface;

import dev.kay.Model.Model.FoodList;

public interface ICustomer {

    /**
     * Order food
     * @param foodList
     */
    public void addOrder(FoodList foodList);
    /**
     * Get order food
     */
    public void getOrder();
}
