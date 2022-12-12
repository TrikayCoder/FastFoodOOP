package dev.kay.Model.Model;

import dev.kay.Model.Interface.IFood;
import dev.kay.Model.Model.FoodList;

import java.util.Scanner;

public class Food implements IFood {
	private String name;
	private String id;
	private String type;
	private int price;
	
	public Food() {
        super();
    }
	
    public Food(String name, String id, String type, int price) {
        super();
        this.name = name;
		this.id = id;
		this.type = type;
		this.price = price;
    }

	@Override
    public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int getPrice() {
		return this.price;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

	
	@Override
	    public String toString(){
	        return String.format("|%-3s | %-26s | %-5s |%n",
	        id, name, price);
	    }

}
