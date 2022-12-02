package dev.kay.Model.Model;

import dev.kay.Model.Interface.IPerson;

public class Person implements IPerson {
    private String name;
    private int age;
    private int gender;
    private int level;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person() {
    }

    public Person(String name, int age, int gender, int level, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.level = level;
        this.address = address;
    }


}
