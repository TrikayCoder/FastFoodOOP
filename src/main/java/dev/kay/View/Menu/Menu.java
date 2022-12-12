package dev.kay.View.Menu;

import dev.kay.Control.ReadDataControl;
import dev.kay.Model.Interface.IPerson;
import dev.kay.Model.Interface.IStaff;
import dev.kay.Model.Model.FoodList;
import dev.kay.Model.Model.Staff;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Menu{
    private ArrayList<IPerson> personStaffArrayList;
    private ArrayList<IPerson> personManageArrayList;

    private FoodList foodList;
    private IPerson currentPerson;
    public Menu() {
        initData();
        initWelcome();
    }

    private void initData() {
        foodList = new FoodList();
        initStaff();
        initManage();
    }

    private void initManage() {
        personManageArrayList = new ArrayList<>();
        ArrayList<IPerson> personArrayList = ReadDataControl.readWorkList();
        for(IPerson person : personArrayList){
            if(person.getLevel() == IPerson.MANAGE){
                personManageArrayList.add(person);
            }
        }
    }

    private void initStaff() {
        personStaffArrayList = new ArrayList<>();
        ArrayList<IPerson> personArrayList = ReadDataControl.readWorkList();
        for(IPerson person : personArrayList){
            if(person.getLevel() == IPerson.STAFF){
                personStaffArrayList.add(person);
            }
        }
    }

    private void initWelcome() {
        ArrayList<IPerson> personArrayList = ReadDataControl.readWorkList();
        while (true){
            System.out.println("**********Welcome to FastFoodOOP***************");
            System.out.print("Nhap UserName: ");
            String userName = new Scanner(System.in).nextLine();
            System.out.print("Nhap PassWord: ");
            String passWord = new Scanner(System.in).nextLine();
            boolean isSignin = false;
            for(IPerson person : personArrayList){
                if(userName.equals(person.getUsername()) && (passWord.equals(person.getPass()))){
                    System.out.println("Dang nhap thanh cong!");
                    isSignin = true;
                    currentPerson = person;
                    if(person.getLevel() == IPerson.STAFF){
                        initStaffFunction();
                    }else{
                        initManageFunction(personStaffArrayList);
                    }
                }
            }
            if (!isSignin){
                System.out.println("Tai khoan khong ton tai!");
            }
        }
    }

    private void initManageFunction(ArrayList<IPerson> personStaffArrayList) {
        initManageFunctionWithAccount((Staff) currentPerson, personStaffArrayList);
    }

    private void initManageFunctionWithAccount(Staff staff, ArrayList<IPerson> personStaffArrayList) {
        System.out.println("**********Welcome to Staff Function***************");
        System.out.println("Your account: " + staff.getName());
        System.out.println("Vui long chon chuc nang: ");
        System.out.println("1: Quan ly nhan vien");
        System.out.println("2: Quan ly Food");
        System.out.println("3: Sava moi du lieu");
        int mode = new Scanner(System.in).nextInt();
        if(mode == 1){
            staff.ManageStaff(personStaffArrayList);
            initManageFunctionWithAccount((Staff)currentPerson, personStaffArrayList);
        }else if(mode == 2){
            staff.manageFood(foodList);
            initManageFunctionWithAccount((Staff)currentPerson, personStaffArrayList);
        }else if(mode == 3){
            staff.saveAllData(personManageArrayList, personStaffArrayList, foodList);
            initManageFunctionWithAccount((Staff)currentPerson, personStaffArrayList);
        }
    }

    private void initStaffFunction() {
        System.out.println("**********Welcome to Staff Function***************");
        System.out.println("Vui long chon tai khoan");
        for(int i=0; i< personStaffArrayList.size(); i++){
            System.out.println(i + ": " + personStaffArrayList.get(i).getName());
        }
        int account = new Scanner(System.in).nextInt();
        if(account >= 0 && account < personStaffArrayList.size()){
            currentPerson = personStaffArrayList.get(account);
            initStaffFunctionWithAccount((Staff)personStaffArrayList.get(account));
        }else{
            initStaffFunction();
        }
    }

    private void initStaffFunctionWithAccount(Staff staff){
        System.out.println("**********Welcome to Staff Function***************");
        System.out.println("Your account: " + staff.getName());
        System.out.println("Vui long chon chuc nang: ");
        System.out.println("1: Tao Order List");
        System.out.println("2: Hien thi danh sach order");
        System.out.println("3: Xuat price");
        System.out.println("4: Exit");
        int mode = new Scanner(System.in).nextInt();
        if(mode == 1){
            staff.createOrderList();
            initStaffFunctionWithAccount((Staff)currentPerson);
        }else if(mode == 2) {
            staff.displayOrderList();
            initStaffFunctionWithAccount((Staff) currentPerson);
        }else if(mode == 3){
            staff.printPrice();
            initStaffFunctionWithAccount((Staff) currentPerson);
        }else{
            initWelcome();
        }
    }

}
