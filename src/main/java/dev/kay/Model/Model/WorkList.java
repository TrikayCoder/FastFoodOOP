package dev.kay.Model.Model;

import dev.kay.Control.SaveDataControl;
import dev.kay.Model.Abstract.PersonList;
import dev.kay.Model.Interface.IPerson;

import java.util.ArrayList;

public class WorkList extends PersonList {

    public WorkList() {
    }

    public WorkList(ArrayList<IPerson> personArrayList) {
        super(personArrayList);
    }

    @Override
    public void saveData() {
        SaveDataControl.saveWorkList(getPersonArrayList());
    }
}
