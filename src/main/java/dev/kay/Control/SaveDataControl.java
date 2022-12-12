package dev.kay.Control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import dev.kay.Model.Interface.IPerson;
import dev.kay.Model.Model.Food;
import dev.kay.Model.Model.FoodList;
import dev.kay.Model.Model.Staff;
import dev.kay.Model.Model.WorkList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public final class SaveDataControl {

    //TODO write method
    public static void saveCustomerList(ArrayList<IPerson> personArrayList){

    }

    //{"personArrayList":[{"name":"Huynh Minh Tri","age":25,"gender":4,"level":3,"address":"Ho Chi Minh","pass":"0763200603","orderList":{"foodList":{"foodArrayList":[{"name":"My tron Trung","id":"FOOD1","type":"My","price":25},{"name":"My tron Indome","id":"FOOD2","type":"My","price":27},{"name":"Banh bao trung muoi","id":"FOOD3","type":"Banh bao","price":25},{"name":"Banh bao trung cut","id":"FOOD4","type":"Banh bao","price":25},{"name":"Banh my nuong","id":"FOOD5","type":"Banh mi","price":38}]},"foodOrder":[]},"positionWork":5,"salary":6000,"date":1670857536059,"localDate":{"year":2022,"month":"DECEMBER","monthValue":12,"dayOfMonth":12,"chronology":{"id":"ISO","calendarType":"iso8601"},"dayOfWeek":"MONDAY","leapYear":false,"dayOfYear":346,"era":"CE"},"username":"Trikay"},{"name":"Le Pham Diem My","age":25,"gender":5,"level":2,"address":"Ho Chi Minh","pass":"0763200603","orderList":{"foodList":{"foodArrayList":[{"name":"My tron Trung","id":"FOOD1","type":"My","price":25},{"name":"My tron Indome","id":"FOOD2","type":"My","price":27},{"name":"Banh bao trung muoi","id":"FOOD3","type":"Banh bao","price":25},{"name":"Banh bao trung cut","id":"FOOD4","type":"Banh bao","price":25},{"name":"Banh my nuong","id":"FOOD5","type":"Banh mi","price":38}]},"foodOrder":[]},"positionWork":1,"salary":5000,"date":1670857536104,"localDate":{"year":2022,"month":"DECEMBER","monthValue":12,"dayOfMonth":12,"chronology":{"id":"ISO","calendarType":"iso8601"},"dayOfWeek":"MONDAY","leapYear":false,"dayOfYear":346,"era":"CE"},"username":"Trikay"},{"name":"Long Nguyen Huynh","age":25,"gender":4,"level":2,"address":"Ho Chi Minh","pass":"123456789","orderList":{"foodList":{"foodArrayList":[{"name":"My tron Trung","id":"FOOD1","type":"My","price":25},{"name":"My tron Indome","id":"FOOD2","type":"My","price":27},{"name":"Banh bao trung muoi","id":"FOOD3","type":"Banh bao","price":25},{"name":"Banh bao trung cut","id":"FOOD4","type":"Banh bao","price":25},{"name":"Banh my nuong","id":"FOOD5","type":"Banh mi","price":38}]},"foodOrder":[]},"positionWork":2,"salary":1000,"date":1670857536104,"localDate":{"year":2022,"month":"DECEMBER","monthValue":12,"dayOfMonth":12,"chronology":{"id":"ISO","calendarType":"iso8601"},"dayOfWeek":"MONDAY","leapYear":false,"dayOfYear":346,"era":"CE"},"username":"Staff"},{"name":"Dio Krando","age":25,"gender":4,"level":3,"address":"Ho Chi Minh","pass":"123456789","orderList":{"foodList":{"foodArrayList":[{"name":"My tron Trung","id":"FOOD1","type":"My","price":25},{"name":"My tron Indome","id":"FOOD2","type":"My","price":27},{"name":"Banh bao trung muoi","id":"FOOD3","type":"Banh bao","price":25},{"name":"Banh bao trung cut","id":"FOOD4","type":"Banh bao","price":25},{"name":"Banh my nuong","id":"FOOD5","type":"Banh mi","price":38}]},"foodOrder":[]},"positionWork":1,"salary":6000,"date":1670857536104,"localDate":{"year":2022,"month":"DECEMBER","monthValue":12,"dayOfMonth":12,"chronology":{"id":"ISO","calendarType":"iso8601"},"dayOfWeek":"MONDAY","leapYear":false,"dayOfYear":346,"era":"CE"},"username":"Staff"}]}
    public static void saveWorkList(WorkList workList){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\file\\WorkList.txt"));
            for(int i=0; i< workList.getPersonArrayList().size(); i++){
                Staff staff = (Staff) workList.getPersonArrayList().get(i);
                String s = staff.getName() +","+
                        staff.getAge() +","+
                        staff.getGender() +","+
                        staff.getLevel() +","+
                        staff.getAddress() +","+
                        staff.getPass() +","+
                        staff.getUsername();
                bufferedWriter.write(s);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        }catch (Exception e){

        }
    }

    //{"foodArrayList":[{"name":"My tron Trung","id":"FOOD1","type":"My","price":25},{"name":"My tron Indome","id":"FOOD2","type":"My","price":27},{"name":"Banh bao trung muoi","id":"FOOD3","type":"Banh bao","price":25},{"name":"Banh bao trung cut","id":"FOOD4","type":"Banh bao","price":25},{"name":"Banh my nuong","id":"FOOD5","type":"Banh mi","price":38}]}
    public static void saveFoodList(FoodList foodList){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src\\file\\FoodList.txt"));
            for(int i=0; i< foodList.getFoodArrayList().size(); i++){
                Food food = (Food) foodList.getFoodArrayList().get(i);
                String s = food.getName() +","+
                        food.getId() +","+
                        food.getType() + ","+
                        food.getPrice();
                bufferedWriter.write(s);
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
        }catch (Exception e){

        }
    }

}
