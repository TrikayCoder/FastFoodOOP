package dev.kay.Control;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.kay.Model.Interface.IPerson;
import dev.kay.Model.Model.Food;
import dev.kay.Model.Model.Staff;
import dev.kay.Model.Model.WorkList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class ReadDataControl {

    public static ArrayList<IPerson> readWorkList() {
        ArrayList<IPerson> personArrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\file\\WorkList.txt"));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
               String[] data = s.split(",");
               IPerson person = new Staff();
               person.setName(data[0]);
               person.setAge(Integer.parseInt(data[1]));
               person.setGender(Integer.parseInt(data[2]));
               person.setLevel(Integer.parseInt(data[3]));
               person.setAddress(data[4]);
               person.setPass(data[5]);
               person.setUsername(data[6]);
               personArrayList.add(person);
            }
        } catch (Exception e) {
        }
        return personArrayList;
    }

    public static ArrayList<Food> readFoodList(){
        ArrayList<Food> foodArrayList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\file\\FoodList.txt"));
            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                String[] data = s.split(",");
               Food food = new Food();
               food.setName(data[0]);
               food.setId(data[1]);
               food.setType(data[2]);
               food.setPrice(Integer.parseInt(data[3]));
               foodArrayList.add(food);
            }
        } catch (Exception e) {
        }
        return foodArrayList;
    }
}
