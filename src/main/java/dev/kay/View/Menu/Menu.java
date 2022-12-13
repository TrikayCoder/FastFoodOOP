package dev.kay.View.Menu;

import dev.kay.Control.ReadDataControl;
import dev.kay.Model.Interface.IPerson;
import dev.kay.Model.Interface.IPersonList;
import dev.kay.Model.Model.Customer;
import dev.kay.Model.Model.CustomerList;
import dev.kay.Model.Model.FoodList;
import dev.kay.Model.Model.Staff;


import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
    private ArrayList<IPerson> personStaffArrayList;
    private ArrayList<IPerson> personManageArrayList;

    private FoodList foodList;
    private IPerson currentPerson;
    public Menu() {
        try{
            initData();
            initSignInSignUp();
        }catch (Exception e){
            System.out.println("Chuong trinh tam thoi bi loi, chung toi se khoi dong lai chuong trinh");
            initData();
            initSignInSignUp();
        }

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

    private void initSignInSignUp(){
        while (true){
            System.out.println("**********Welcome to FastFoodOOP***************");
            System.out.println("1, Sign In");
            System.out.println("2, Sign Up As Customer");
            System.out.print("Type: ");
            int mode = new Scanner(System.in).nextInt();
            if(mode == 1){
                initWelcome();
            }else if(mode == 2){
                initSignUpCustomer();
            }
        }
    }

    private void initSignUpCustomer() {
        IPersonList personList = new CustomerList();
        while (true){
            System.out.println("***************Welcome Customer******************");
            IPerson person = new Customer();
            System.out.print("Nhap UserName: ");
            person.setUsername(new Scanner(System.in).nextLine());
            System.out.print("Nhap PassWord: ");
            person.setPass(new Scanner(System.in).nextLine());
            System.out.print("Nhap Ho Va Ten: ");
            person.setName(new Scanner(System.in).nextLine());
            while (true){
                System.out.println("Chon Gioi Tinh: Male[4] - Female[5]");
                System.out.print("Type: ");
                int GENDER = new Scanner(System.in).nextInt();
                if(GENDER == IPerson.MALE){
                    person.setGender(IPerson.MALE);
                    break;
                }else if(GENDER == IPerson.FEMALE){
                    person.setGender(IPerson.FEMALE);
                    break;
                }else{
                    System.out.println("Ban da chon sai gioi tinh, moi ban nhap lai!");
                }
            }
            while (true){
                System.out.print("Nhap tuoi: ");
                int AGE = new Scanner(System.in).nextInt();
                if(AGE >= 18){
                    person.setAge(AGE);
                    break;
                }else{
                    System.out.println("Do tuoi sai quy dinh [Phai >= 18], moi ban nhap lai");
                }
            }
            System.out.print("Nhap dia chi: ");
            person.setAddress(new Scanner(System.in).nextLine());
            System.out.println("Ban co muon luu khong? Yes[1] - No[2]");
            int choose = new Scanner(System.in).nextInt();
            if(choose == 1){
                personList.add(person);
                personList.saveData();
                return;
            }else{
                return;
            }
        }
    }

    private void initWelcome() {
        ArrayList<IPerson> personArrayList = ReadDataControl.readWorkList();
        ArrayList<IPerson> personCustomerArrayList = ReadDataControl.readCustomerList();
        while (true){
            System.out.println("**********Welcome to FastFoodOOP***************");
            System.out.println("1, Sign in");
            System.out.println("2, Exit");
            System.out.print("Type: ");
            int mode = new Scanner(System.in).nextInt();
            if(mode == 1){
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
                            initStaffFunctionWithAccount((Staff)person);
                        }else{
                            initManageFunction(personStaffArrayList);
                        }
                    }
                }
                for(IPerson person : personCustomerArrayList){
                    if(userName.equals(person.getUsername()) && (passWord.equals(person.getPass()))){
                        System.out.println("Dang nhap thanh cong!");
                        isSignin = true;
                        currentPerson = person;
                        initCustomerFunction((Customer) person, foodList);
                    }
                }
                if (!isSignin){
                    System.out.println("Tai khoan khong ton tai!");
                }
            }else if(mode == 2){
                return;
            }
        }
    }

    private void initCustomerFunction(Customer person, FoodList foodList) {
        while (true){
            System.out.println("**********Welcome to Customer Function - Exit[-1]***************");
            System.out.println("1, Tao order de chung toi gui ve cho ban");
            System.out.println("2, Xem danh sach");
            System.out.println("3, Clear order");
            System.out.println("4, Clear all order");
            System.out.println("5, Dat Hang");
            int mode = new Scanner(System.in).nextInt();
            if(mode == 1){
                person.addOrder(foodList);
            }else if(mode == 2){
                person.getOrder();
            }else if(mode == 3){
                person.clearOrder();
            }else if(mode == 4){
                person.clearAllOrder();
            }else if(mode == 5){
                person.boughtOrderList();
            }else if(mode == -1){
                return;
            }
        }

    }

    private void initManageFunction(ArrayList<IPerson> personStaffArrayList) {
        initManageFunctionWithAccount((Staff) currentPerson, personStaffArrayList);
    }

    private void initManageFunctionWithAccount(Staff staff, ArrayList<IPerson> personStaffArrayList) {
        while (true){
            System.out.println("**********Welcome to Staff Function - Exit[-1]***************");
            System.out.println("Your account: " + staff.getName());
            System.out.println("Vui long chon chuc nang: ");
            System.out.println("1: Quan ly nhan vien");
            System.out.println("2: Quan ly Food");
            System.out.println("3: Sava moi du lieu");
            int mode = new Scanner(System.in).nextInt();
            if(mode == 1){
                staff.ManageStaff(personStaffArrayList);
            }else if(mode == 2){
                staff.manageFood(foodList);
            }else if(mode == 3){
                staff.saveAllData(personManageArrayList, personStaffArrayList, foodList);
            }
            else if(mode == -1){
                return;
            }
        }

    }



    private void initStaffFunctionWithAccount(Staff staff){
        while (true){
            System.out.println("**********Welcome to Staff Function - Exit[-1]***************");
            System.out.println("Your account: " + staff.getName());
            System.out.println("Vui long chon chuc nang: ");
            System.out.println("1: Tao Order List");
            System.out.println("2: Hien thi danh sach order");
            System.out.println("3: Xuat price");
            int mode = new Scanner(System.in).nextInt();
            if(mode == 1){
                staff.createOrderList();
            }else if(mode == 2) {
                staff.displayOrderList();
            }else if(mode == 3){
                staff.printPrice();
            }else if (mode == -1){
                return;
            }
        }

    }

}
