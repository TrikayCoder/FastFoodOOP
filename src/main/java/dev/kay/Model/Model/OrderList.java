package dev.kay.Model.Model;

import java.util.ArrayList;

public class OrderList{
   private FoodList foodList;

   private ArrayList<Food> foodOrder;

    public ArrayList<Food> getFoodOrder() {
        return foodOrder;
    }

    public void setFoodOrder(ArrayList<Food> foodOrder) {
        this.foodOrder = foodOrder;
    }

    public FoodList getFoodList() {
        return foodList;
    }

    public void setFoodList(FoodList foodList) {
        this.foodList = foodList;
    }

    public OrderList() {
        foodList = new FoodList();
        foodOrder = new ArrayList<>();
    }

    public OrderList(FoodList foodList) {
        this.foodList = foodList;
        foodOrder = new ArrayList<>();
    }
}
