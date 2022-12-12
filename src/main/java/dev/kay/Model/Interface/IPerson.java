package dev.kay.Model.Interface;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.kay.Model.Model.Person;

public interface IPerson {
    public static final int COSTUMER = 1;
    public static final int STAFF = 2;
    public static final int MANAGE = 3;

    public static final int MALE = 4;
    public static final int FEMALE = 5;

    public static final int GENDER_PRIVATE = 6;

    public int gteSalary();

    public void setSalary(int salary);

    public String getPass();

    public String getUsername();

    public void setPass(String pass);

    public void setUsername(String username);

    public String getName();

    public void setName(String name);

    public int getAge();

    public void setAge(int age);

    public int getGender();

    public void setGender(int gender);

    public int getLevel();

    public void setLevel(int level);

    public String getAddress();

    public void setAddress(String address);


}
