package dev.kay.Model.Model;

import com.google.gson.Gson;
import dev.kay.Control.ReadDataControl;
import dev.kay.Control.SaveDataControl;
import dev.kay.Model.Abstract.PersonList;

import dev.kay.Model.Interface.IPerson;
import dev.kay.Model.Interface.IStaff;

import java.util.ArrayList;

public class WorkList extends PersonList {

    public WorkList() {
        initData();
    }

    private void initData() {
        setPersonArrayList(ReadDataControl.readWorkList());
    }

    public WorkList(ArrayList<IPerson> personArrayList) {
        super(personArrayList);
    }

    @Override
    public void saveData() {
        SaveDataControl.saveWorkList(WorkList.this);
    }
}
