package dev.kay.Model.Model;


import dev.kay.Control.ReadDataControl;
import dev.kay.Control.SaveDataControl;

import java.util.ArrayList;

public class FoodList {
    private ArrayList<Food> foodArrayList;

    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    public void setFoodArrayList(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
    }

    public FoodList() {
        initFoods();
    }

    public FoodList(ArrayList<Food> foodArrayList) {
        this.foodArrayList = foodArrayList;
        initFoods();
    }

    private void initFoods() {
       foodArrayList = ReadDataControl.readFoodList();
    }

    public void saveData(){
        SaveDataControl.saveFoodList(FoodList.this);
    }
}