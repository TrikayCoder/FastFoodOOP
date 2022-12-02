package dev.kay.Model.Model;

import dev.kay.Model.Interface.IOrderList;

public class Costumer extends Person {
    private boolean isMember;
    private IOrderList orderList;

    private float TotalCost;


    public IOrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(IOrderList orderList) {
        this.orderList = orderList;
    }

    public float getTotalCost() {
        return TotalCost;
    }

    public void setTotalCost(float totalCost) {
        TotalCost = totalCost;
    }

    public Costumer() {
    }

    public Costumer(String name, int age, int gender, int level, String address, boolean isMember, IOrderList orderList, float totalCost) {
        super(name, age, gender, level, address);
        this.isMember = isMember;
        this.orderList = orderList;
        TotalCost = totalCost;
    }
}
