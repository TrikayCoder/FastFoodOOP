package dev.kay.Model.Model;

import dev.kay.Control.SaveDataControl;
import dev.kay.Model.Abstract.PersonList;
import dev.kay.Model.Interface.IPerson;

import java.util.ArrayList;

public class CostumerList extends PersonList {
    public CostumerList() {
    }

    public CostumerList(ArrayList<IPerson> personArrayList) {
        super(personArrayList);
    }
    @Override
    public void saveData() {
        SaveDataControl.saveCustomerList(getPersonArrayList());
    }
}
