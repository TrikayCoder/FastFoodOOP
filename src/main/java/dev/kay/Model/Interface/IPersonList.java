package dev.kay.Model.Interface;

import java.util.ArrayList;

public interface IPersonList {
    public static final int NONE_VALUE = -999;

    /**
     * Add new person into person list
     * @param iPerson Object of Person
     */
    public void add(IPerson iPerson);

    /**
     * Remove person in person list
     * @param iPerson Object of Person
     * @return true if complete remove person <br>
     * false if incomplete
     */
    public boolean remove(IPerson iPerson);

    /**
     * Search Person in person list
     * @param iPerson  Object of Person
     * @return position of person list <br>
     * if person can't find, it will return {@link IPersonList#NONE_VALUE}
     */
    public int search(IPerson iPerson);

    /**
     * Get One Person in the list of person
     * @param position index of person in list of person
     * @return Person
     */
    public IPerson getPerson(int position);

    public ArrayList<IPerson> getPersonArrayList();

    public void setPersonArrayList(ArrayList<IPerson> personArrayList);

    public abstract void saveData(

    );
}
