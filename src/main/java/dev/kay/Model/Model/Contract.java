package dev.kay.Model.Model;

import dev.kay.Model.Interface.IContract;

public class Contract extends IContract {
    private final int[] beginWork = new int[3];
    private final int[] endWork = new int[3];
    private String term;
    public Contract() {
    }

    public void initBeginWork(int day, int month, int year){
        beginWork[0] = day;
        beginWork[1] = month;
        beginWork[2] = year;
    }

    public void initEndWork(int day, int month, int year){
        endWork[0] = day;
        endWork[1] = month;
        endWork[2] = year;
    }

    public void initTerm(String term){
        this.term = term;
    }



}
