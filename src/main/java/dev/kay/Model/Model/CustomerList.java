package dev.kay.Model.Model;

import dev.kay.Control.ReadDataControl;
import dev.kay.Control.SaveDataControl;
import dev.kay.Model.Abstract.PersonList;

public class CustomerList extends PersonList {

    public CustomerList() {
        initData();
    }

    private void initData() {
        setPersonArrayList(ReadDataControl.readCustomerList());
    }

    @Override
    public void saveData() {
        System.out.println("fkjgjgjg");
        SaveDataControl.saveCustomerList(CustomerList.this);
    }
}
