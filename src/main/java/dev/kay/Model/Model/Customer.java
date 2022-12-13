package dev.kay.Model.Model;

import dev.kay.Model.Interface.ICustomer;

import java.util.Scanner;
import java.util.SortedMap;

public class Customer extends Person implements ICustomer {
    private OrderList orderList;

    public Customer() {
        orderList = new OrderList();
    }

    @Override
    public void addOrder(FoodList foodList) {
        while (true){
            System.out.println("*****************Add new Order - Exit[-1]******************");
            for(int i=0; i<foodList.getFoodArrayList().size(); i++){
                Food food = foodList.getFoodArrayList().get(i);
                System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
            }
            System.out.print("Chon food ban muon order theo so thu tu: ");
            int choose = new Scanner(System.in).nextInt();
            if(choose == -1){
                return;
            }else if(choose >=0 && choose < foodList.getFoodArrayList().size()){
                orderList.getFoodOrder().add(foodList.getFoodArrayList().get(choose));
                System.out.println("Them Order Thanh Cong!");
                getOrder();
            }
        }
    }

    @Override
    public void getOrder() {
        System.out.println("******************Order List*******************");
        int price = 0;
        for(int i=0; i<orderList.getFoodOrder().size(); i++){
            Food food = orderList.getFoodOrder().get(i);
            price += food.getPrice();
            System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
        }
        System.out.println("Tong price: " + price);
    }

    public void clearOrder() {
        while (true){
            System.out.println("*******************Welcome to clear order - Exit[-1]***********");
            for(int i=0; i<orderList.getFoodOrder().size(); i++){
                Food food = orderList.getFoodOrder().get(i);
                System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
            }
            System.out.print("Chon so thu tu cua order ban muon xoa: ");
            int index = new Scanner(System.in).nextInt();
            if(index == -1){
                return;
            }else if(index >=0 && index < orderList.getFoodOrder().size()){
                orderList.getFoodOrder().remove(index);
            }
        }
    }

    public void clearAllOrder() {
        orderList.getFoodOrder().clear();
        getOrder();
        return;
    }

    public void boughtOrderList() {
        if(orderList.getFoodOrder().size() > 0){
            System.out.println("***********888Chung toi se giao hang den ban trong thoi gian som nhat**************");
            getOrder();
            return;
        }else{
            System.out.println("Ban chua co Order trong OrderList!");
        }
    }
}
