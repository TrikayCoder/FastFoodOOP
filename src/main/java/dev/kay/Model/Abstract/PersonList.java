package dev.kay.Model.Abstract;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import dev.kay.Model.Interface.IPerson;
import dev.kay.Model.Interface.IPersonList;
import dev.kay.Model.Model.WorkList;

import java.util.ArrayList;

public abstract class PersonList implements IPersonList {
    private ArrayList<IPerson> personArrayList;

    public ArrayList<IPerson> getPersonArrayList() {
        return personArrayList;
    }

    public void setPersonArrayList(ArrayList<IPerson> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public PersonList() {
    }

    public PersonList(ArrayList<IPerson> personArrayList) {
        this.personArrayList = personArrayList;
    }



    /**
     *THIS METHOD IS Obligatory for all SubClass <br>
     * It will sava a list of person into database
     */
    public abstract void saveData();

    @Override
    public void add(IPerson iPerson) {
        personArrayList.add(iPerson);
    }

    @Override
    public boolean remove(IPerson iPerson) {
        return personArrayList.remove(iPerson);
    }

    @Override
    public int search(IPerson iPerson) {
        if(personArrayList.contains(iPerson)){
            return personArrayList.indexOf(iPerson);
        }else{
            return NONE_VALUE;
        }
    }

    @Override
    public IPerson getPerson(int position) {
        if(position >=0 && position < personArrayList.size()){
            return personArrayList.get(position);
        }else{
            return null;
        }
    }
}
