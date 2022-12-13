package dev.kay.Model.Model;

import dev.kay.Control.SaveDataControl;
import dev.kay.Model.Interface.IPerson;
import dev.kay.Model.Interface.IStaff;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Staff extends Person implements IStaff {

    private OrderList orderList;
    private int positionWork;

    private int salary;
    private Date date;

    private LocalDate localDate;

    public OrderList getOrderList() {
        return orderList;
    }

    public void setOrderList(OrderList orderList) {
        this.orderList = orderList;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPositionWork() {
        return positionWork;
    }

    public void setPositionWork(int positionWork) {
        this.positionWork = positionWork;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }



    public Staff() {
        orderList = new OrderList();
    }

    public Staff(String name, int age, int gender, int level, String address, int positionWork, int salary) {
        super(name, age, gender, level, address);
        this.positionWork = positionWork;
        this.salary = salary;
        date = new Date();
        localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        orderList = new OrderList();
    }

    public void createOrderList() {
        System.out.println("*************Welcome to Create Order*******************");
        System.out.println("Vui long chon food them vao [Cancel: -1]");
        for(int i=0; i<orderList.getFoodList().getFoodArrayList().size(); i++){
            Food food = orderList.getFoodList().getFoodArrayList().get(i);
            System.out.println((i+1) + ": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
        }
        System.out.print("Type: ");
        int index = new Scanner(System.in).nextInt();
        if(index >= 0 && index < orderList.getFoodList().getFoodArrayList().size()) {
            Food food = orderList.getFoodList().getFoodArrayList().get(index);
            orderList.getFoodOrder().add(food);
            for(Food food1 : orderList.getFoodOrder()){
                System.out.println("Ban da them: " + food1.getId() + ", " + food1.getName() + ", " + food1.getType() + " - " + food1.getPrice() + "vnd");
            }
            createOrderList();
        }else if(index == -1){
            return;
        }else{
            createOrderList();
        }
    }

    public void displayOrderList() {
        System.out.println("*************Welcome to Display Orderlist*************");
        System.out.println("1: Add new Order");
        System.out.println("2: Remove Order");
        System.out.println("3: Clear order");
        System.out.println("4: Back");
        System.out.println("********Order List***********");
        for(int i=0; i<orderList.getFoodOrder().size(); i++){
            Food food = orderList.getFoodOrder().get(i);
            System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
        }
        System.out.print("Type: ");
        int mode = new Scanner(System.in).nextInt();
        if(mode == 1){
            createOrderList();
            displayOrderList();
        }else if(mode == 2){
            removeOrder();
            displayOrderList();
        }else if(mode == 3){
            orderList.getFoodOrder().clear();
            displayOrderList();
        }else{
            return;
        }
    }

    private void removeOrder() {
        System.out.println("*************Welcome to Remove Order [Exit: -1]*************");
        for(int i=0; i<orderList.getFoodOrder().size(); i++){
            Food food = orderList.getFoodOrder().get(i);
            System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
        }
        System.out.println("Chon so thu tu order ban muon xoa");
        System.out.println("Type: ");
        int index = new Scanner(System.in).nextInt();
        if(index >= 0){
            orderList.getFoodOrder().remove(index);
        }else{
            return;
        }
    }

    public void printPrice() {
        System.out.println("*************Welcome to Print Price Of Order [Exit: -1]*************");
        int price = 0;
        for(int i=0; i<orderList.getFoodOrder().size(); i++){
            Food food = orderList.getFoodOrder().get(i);
            price += food.getPrice();
            System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "K vnd");
        }
        System.out.println("Tong thanh tien la: " + price + "K vnd");
        System.out.print("Type: ");
        int mode = new Scanner(System.in).nextInt();
        if(mode == -1){
            return;
        }else{
            printPrice();
        }
    }

    public void ManageStaff(ArrayList<IPerson> personStaffArrayList) {
        while (true){
            System.out.println("**************Welcome to manage function - Exit [-1]*****************");
            System.out.println("1: Hien thi danh sach nhan vien");
            System.out.println("2: Them nhan vien");
            System.out.println("3: Xoa nhan vien");
            System.out.println("4: Chinh sua thong tin nhan vien");
            System.out.println("5: Tim kiem nhan vien");
            System.out.print("Type: ");
            int mode = new Scanner(System.in).nextInt();
            if(mode == 1){
                displayStaffDetail(personStaffArrayList);
            }else if(mode == 2){
                addNewStaff(personStaffArrayList);
            }else if(mode == 3){
                removeStaff(personStaffArrayList);
            }else if(mode == 4) {
                changeInfoStaff(personStaffArrayList);
            }else if(mode == 5){
                serchStaff(personStaffArrayList);
            }else if(mode == -1){
                return;
            }
        }
    }

    private void serchStaff(ArrayList<IPerson> personStaffArrayList) {
        ArrayList<IPerson> personArrayListSearch = new ArrayList<>();
        personArrayListSearch.addAll(personStaffArrayList);
        while (true){
            System.out.println("***************Search Staff - Exit[Exit]****************");
            for(int i=0; i < personArrayListSearch.size(); i++){
                Staff staff = (Staff) personArrayListSearch.get(i);
                System.out.println(i + 1 + ": " + staff.getName() + ", " +
                        staff.getAge() + ", " +
                        staff.getGender()+ ", " +
                        staff.getAddress()+ ", " +
                        staff.getSalary());
            }
            System.out.print("Type: ");
            String searchStr = new Scanner(System.in).nextLine();
            System.out.println("Your serch keyword: " + searchStr);
            if(searchStr.equals("Exit")) {
                return;
            }else if(searchStr.equals("")){
                personArrayListSearch.addAll(personStaffArrayList);
            }else{
                personArrayListSearch.clear();
                for(int i=0; i< personStaffArrayList.size(); i++){
                    Staff staff = (Staff) personStaffArrayList.get(i);
                    if(staff.getName().contains(searchStr) ||
                            staff.getAddress().contains(searchStr) ||
                            String.valueOf(staff.getAge()).contains(searchStr)){
                        personArrayListSearch.add(personStaffArrayList.get(i));
                    }
                }
            }
        }
    }

    private void changeInfoStaff(ArrayList<IPerson> personStaffArrayList) {
        while (true){
            System.out.println("**************Change Staff - Exit [-1]*****************");
            for(int i=0; i < personStaffArrayList.size(); i++){
                Staff staff = (Staff) personStaffArrayList.get(i);
                System.out.println(i + 1 + ": " + staff.getName() + ", " +
                        staff.getAge() + ", " +
                        staff.getGender()+ ", " +
                        staff.getAddress()+ ", " +
                        staff.getSalary());
            }
            System.out.print("Nhap so thu tu nhan vien can chinh sua: ");
            int index = new Scanner(System.in).nextInt();
            if(index == -1){
                return;
            }else if(index >= 0 && index < personStaffArrayList.size()){
                personStaffArrayList.set(index, changeInfoStaffHelper( personStaffArrayList.get(index)));
            }else{
                System.out.println("Loi, nhan vien khong ton tai");
            }
        }
    }

    private IPerson changeInfoStaffHelper(IPerson person) {
        while (true){
            System.out.println("*********Chge Staff Helper**********");
            Staff staff = (Staff) person;
            System.out.println(staff.getName() + ", " +
                    staff.getAge() + ", " +
                    staff.getGender()+ ", " +
                    staff.getAddress()+ ", " +
                    staff.getSalary());
            System.out.println("Lua chon noi dung can thay doi - Exit[-1]");
            System.out.println("1,Ho va ten");
            System.out.println("2, Gioi tinh");
            System.out.println("3, Tuoi");
            System.out.println("4, Dia chi");
            System.out.println("5, Chuc vu");
            System.out.println("6, Muc luong");
            int mode = new Scanner(System.in).nextInt();
            if(mode == -1){
                return person;
            }else if(mode == 1){
                System.out.print("Nhap Ten Nhan Vien: ");
                person.setName(new Scanner(System.in).nextLine());
            }else if(mode == 2){
                while (true){
                    System.out.println("Chon Gioi Tinh Nhan Vien: Male[4] - Female[5]");
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
            }else if(mode == 3){
                while (true){
                    System.out.print("Nhap tuoi nhan vien: ");
                    int AGE = new Scanner(System.in).nextInt();
                    if(AGE >= 18){
                        person.setAge(AGE);
                        break;
                    }else{
                        System.out.println("Do tuoi sai quy dinh [Phai >= 18], moi ban nhap lai");
                    }
                }
            }else if(mode == 4){
                System.out.print("Nhap dia chi: ");
                person.setPass(new Scanner(System.in).nextLine());
            }else if(mode == 5){
                while (true){
                    System.out.println("Chon chuc vu cho nhan vien - Manage[3] - Staff[2]");
                    System.out.print("Type: ");
                    int level = new Scanner(System.in).nextInt();
                    if(level == IPerson.MANAGE){
                        person.setLevel(IPerson.MANAGE);
                        break;
                    }else if(level == IPerson.STAFF){
                        person.setLevel(IPerson.STAFF);
                        break;
                    }else{
                        System.out.println("Ban nhap sai quy dinh, moi nhap lai!");
                    }
                }
            }else if(mode == 6){
                System.out.print("Nhap muc luong cua nhan vien: ");
                person.setSalary(new Scanner(System.in).nextInt());
            }
        }
    }

    private void removeStaff(ArrayList<IPerson> personStaffArrayList) {
        while (true){
            System.out.println("**************Remove Staff - Exit [-1]*****************");
            for(int i=0; i < personStaffArrayList.size(); i++){
                Staff staff = (Staff) personStaffArrayList.get(i);
                System.out.println(i + 1 + ": " + staff.getName() + ", " +
                        staff.getAge() + ", " +
                        staff.getGender()+ ", " +
                        staff.getAddress()+ ", " +
                        staff.getSalary());
            }
            System.out.print("Nhap so thu tu nhan vien can xoa: ");
            int index = new Scanner(System.in).nextInt() -1;
            if(index == -1){
                return;
            }else if(index >= 0 && index < personStaffArrayList.size()){
                personStaffArrayList.remove(index);
                System.out.println("Xoa thanh cong!");
            }else{
                System.out.println("Loi xoa, nhan vien khong ton tai");
            }
        }
    }

    private void addNewStaff(ArrayList<IPerson> personStaffArrayList) {
        while (true){
            System.out.println("************Add New Staff************");
            IPerson person = new Staff();
            System.out.print("Nhap UserName: ");
            person.setUsername(new Scanner(System.in).nextLine());
            System.out.print("Nhap PassWord");
            person.setPass(new Scanner(System.in).nextLine());
            System.out.print("Nhap Ten Nhan Vien: ");
            person.setName(new Scanner(System.in).nextLine());
            while (true){
                System.out.println("Chon Gioi Tinh Nhan Vien: Male[4] - Female[5]");
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
                System.out.print("Nhap tuoi nhan vien: ");
                int AGE = new Scanner(System.in).nextInt();
                if(AGE >= 18){
                    person.setAge(AGE);
                    break;
                }else{
                    System.out.println("Do tuoi sai quy dinh [Phai >= 18], moi ban nhap lai");
                }
            }
            System.out.print("Nhap dia chi: ");
            person.setPass(new Scanner(System.in).nextLine());
            while (true){
                System.out.println("Chon chuc vu cho nhan vien - Manage[3] - Staff[2]");
                System.out.print("Type: ");
                int level = new Scanner(System.in).nextInt();
                if(level == IPerson.MANAGE){
                    person.setLevel(IPerson.MANAGE);
                    break;
                }else if(level == IPerson.STAFF){
                    person.setLevel(IPerson.STAFF);
                    break;
                }else{
                    System.out.println("Ban nhap sai quy dinh, moi nhap lai!");
                }
            }
            System.out.print("Nhap muc luong cua nhan vien: ");
            person.setSalary(new Scanner(System.in).nextInt());
            System.out.println("Ban co muon luu nhan vien? [Yes[1] - No[Any]");
            System.out.print("Type: ");
            int choose = new Scanner(System.in).nextInt();
            if(choose == 1){
                personStaffArrayList.add(person);
                return;
            }else{
                return;
            }
        }
    }

    private void displayStaffDetail(ArrayList<IPerson> personStaffArrayList) {
        while (true){
            System.out.println("**************Display staff list detail [Exit: -1]*****************");
            for(int i=0; i < personStaffArrayList.size(); i++){
                Staff staff = (Staff) personStaffArrayList.get(i);
                System.out.println(i + 1 + ": " + staff.getName() + ", " +
                        staff.getAge() + ", " +
                        staff.getGender()+ ", " +
                        staff.getAddress()+ ", " +
                        staff.getSalary());
            }
            System.out.print("Type: ");
            int mode = new Scanner(System.in).nextInt();
            if(mode == -1){
                return;
            }
        }

    }


    public void manageFood(FoodList foodList) {
        while (true){
            System.out.println("***********Welcome to Manage Food - Exit [-1]************");
            System.out.println("1, Dan sach food");
            System.out.println("2, Them Food");
            System.out.println("3, Xoa Food");
            System.out.println("4, Chinh sua thong tin Food");
            System.out.println("5, Tim kiem food");
            int mode = new Scanner(System.in).nextInt();
            if(mode == -1){
                return;
            }else if(mode == 1){
                watchListOfFood(foodList);
            }else if(mode == 2){
                addNewFood(foodList);
            }else if(mode == 3){
                removeFood(foodList);
            }else if(mode == 4){
                changeInfoFood(foodList);
            }else if(mode == 5){
                searchFood(foodList);
            }
        }


    }

    private void searchFood(FoodList foodList) {
        FoodList foodListSearch = new FoodList();
        while (true){
            System.out.println("***************Search Food - Exit[Exit]****************");
            for(int i=0; i<foodListSearch.getFoodArrayList().size(); i++){
                Food food = foodListSearch.getFoodArrayList().get(i);
                System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
            }
            System.out.print("Type: ");
            String searchStr = new Scanner(System.in).nextLine();
            System.out.println("Your serch keyword: " + searchStr);
            if(searchStr.equals("Exit")) {
                return;
            }else if(searchStr.equals("")){
                foodListSearch.getFoodArrayList().addAll(foodList.getFoodArrayList());
            }else{
                foodListSearch.getFoodArrayList().clear();
                for(int i=0; i< foodList.getFoodArrayList().size(); i++){
                    Food food = foodList.getFoodArrayList().get(i);
                    if(food.getName().contains(searchStr) ||
                            food.getType().contains(searchStr) ||
                            food.getId().contains(searchStr) ||
                    String.valueOf(food.getPrice()).contains(searchStr)){
                        foodListSearch.getFoodArrayList().add(food);
                    }
                }
            }
        }
    }

    //TODO WRITE NHANH KO CHET ME GIO DKM
    private void changeInfoFood(FoodList foodList) {
        while (true){
            System.out.println("************Chance Info Food - Exit [-1]**************");
            for(int i=0; i<foodList.getFoodArrayList().size(); i++){
                Food food = foodList.getFoodArrayList().get(i);
                System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
            }
            System.out.print("Chon vi tri cua food ban muon thay doi: ");
            int index = new Scanner(System.in).nextInt() - 1;
            if(index >= 0 && index < foodList.getFoodArrayList().size()){
                Food food = changeInfoFoodHelper(foodList.getFoodArrayList().get(index));
                if(food != null){
                   foodList.getFoodArrayList().set(index, food);
                }
            }else if (index == -1){
                return;
            }
        }

    }

    private Food changeInfoFoodHelper(Food food) {
        while (true){
            System.out.println("**********Change Info Food Helper - Exit[-1] - Save And Exit [-2]**********");
            System.out.println("1, Name");
            System.out.println("2, Type");
            System.out.println("3, Price");
            System.out.print("Type: ");
            int choose = new Scanner(System.in).nextInt();
            if (choose == 1){
                System.out.print("Nhap ten food: ");
                food.setName(new Scanner(System.in).nextLine());
            }else if(choose == 2){
                System.out.print("Nhap type food: ");
                food.setType(new Scanner(System.in).nextLine());
            }else if(choose == 3){
                System.out.print("Nhap price food: ");
                food.setPrice(new Scanner(System.in).nextInt());
            }else if(choose == -1){
                return null;
            }else if(choose == -2){
                return food;
            }
        }
    }

    private void removeFood(FoodList foodList) {
        while (true){
            System.out.println("**********Remove Food - Exit [-1]");
            for(int i=0; i<foodList.getFoodArrayList().size(); i++){
                Food food = foodList.getFoodArrayList().get(i);
                System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
            }
            System.out.print("Chon so thu tu cua food muon xoa: ");
            int index = new Scanner(System.in).nextInt() - 1;
            if(index == -1){
                return;
            }else if(index >= 0 && index < foodList.getFoodArrayList().size()){
                foodList.getFoodArrayList().remove(index);
                System.out.println("Xoa thanh cong!");
            }else{
                System.out.println("Loi xoa, nhan vien khong ton tai");
            }
        }
    }

    private void addNewFood(FoodList foodList) {
        while (true){
            System.out.println("****************Add New Food****************");
            Food food = new Food();
            System.out.print("Nhap ten food: ");
            food.setName(new Scanner(System.in).nextLine());
            int index_Id = 1;
            boolean b = true;
            while (true){
                String ID_FOOD = null;
                for(Food food1 : foodList.getFoodArrayList()){
                    ID_FOOD = "FOOD" + String.valueOf(index_Id);
                    if(ID_FOOD.equals(food1.getId())){
                        b = false;
                    }
                }
                if(b){
                    food.setId(ID_FOOD);
                    break;
                }else{
                    index_Id++;
                    b = true;
                }
            }
            System.out.print("Nhap Type: ");
            food.setType(new Scanner(System.in).nextLine());
            System.out.print("Nhap price: ");
            food.setPrice(new Scanner(System.in).nextInt());
            System.out.println("Ban co muon luu food? [Yes[1] - No[Any]");
            System.out.print("Type: ");
            int choose = new Scanner(System.in).nextInt();
            if(choose == 1){
                foodList.getFoodArrayList().add(food);
                return;
            }else{
                return;
            }

        }
    }

    private void watchListOfFood(FoodList foodList) {
        while (true){
            System.out.println("***************Danh sach Food - Exit [-1]*********************");
            for(int i=0; i<foodList.getFoodArrayList().size(); i++){
                Food food = foodList.getFoodArrayList().get(i);
                System.out.println( i+1 +": " + food.getId() + ", " + food.getName() + ", " + food.getType() + " - " + food.getPrice() + "vnd");
            }
            System.out.print("Type: ");
            int mode = new Scanner(System.in).nextInt();
            if(mode == -1){
                return;
            }
        }

    }

    public void saveAllData(ArrayList<IPerson> personManageArrayList, ArrayList<IPerson> personStaffArrayList, FoodList foodList) {
        System.out.println("****************Welcome to Save All Data******************");
        WorkList workList = new WorkList(new ArrayList<>());
        for(IPerson person : personManageArrayList){
            workList.getPersonArrayList().add(person);
        }
        System.out.println("Saving Manager List...");
        for (IPerson person : personStaffArrayList){
            workList.getPersonArrayList().add(person);
        }
        System.out.println("Saving Staff Normal List...");
        workList.saveData();
        System.out.println("Saving Food List...");
        foodList.saveData();
        System.out.println("Completed Saving! :[]");
        return;
    }
}
