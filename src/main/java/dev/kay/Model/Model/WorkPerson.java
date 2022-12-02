package dev.kay.Model.Model;

import dev.kay.Model.Interface.IContract;
import dev.kay.Model.Interface.ISalary;
import dev.kay.Model.Interface.IWorkPerson;
import dev.kay.Model.Model.Person;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class WorkPerson extends Person implements IWorkPerson {
    private int positionWork;
    private ISalary iSalary;
    private IContract iContract;

    private Date date;

    private LocalDate localDate;

    private int salaryBonus;

    public int getSalaryBonus() {
        return salaryBonus;
    }

    public void setSalaryBonus(int salaryBonus) {
        this.salaryBonus = salaryBonus;
    }

    public int getPositionWork() {
        return positionWork;
    }

    public void setPositionWork(int positionWork) {
        this.positionWork = positionWork;
    }

    public ISalary getiSalary() {
        return iSalary;
    }

    public void setiSalary(ISalary iSalary) {
        this.iSalary = iSalary;
    }

    public IContract getiContract() {
        return iContract;
    }

    public void setiContract(IContract iContract) {
        this.iContract = iContract;
    }

    public WorkPerson() {
    }

    public WorkPerson(String name, int age, int gender, int level, String address, int positionWork, ISalary iSalary, IContract iContract) {
        super(name, age, gender, level, address);
        this.positionWork = positionWork;
        this.iSalary = iSalary;
        date = new Date();
        localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public int getYearEndBonus(){
        if(positionWork == POSITION_CHEF){
            return iSalary.getCurrentSalary() * 5;
        }else if(positionWork == POSITION_SALE){
            return iSalary.getCurrentSalary() * 7;
        }else if(positionWork == POSITION_MARKETING){
            return iSalary.getCurrentSalary() * 8;
        }else if(positionWork == POSITION_TECHNICAL){
            return iSalary.getCurrentSalary() * 7;
        }else if(positionWork == POSITION_MANAGE_STORE){
            return iSalary.getCurrentSalary() * 9;
        }else if(positionWork == POSITION_MANAGE_GROUND_STORE){
            return iSalary.getCurrentSalary() * 12;
        }else if(positionWork == POSITION_MANAGE_ALL_GROUND_STORE){
            return iSalary.getCurrentSalary() * 16;
        }
        return 0;
    }

    public void addSalaryBonus(int salaryBonus){
        this.salaryBonus += salaryBonus;
    }

    @Override
    public int solveFinalSalary(ISalary isalary) {
        int finalSalary = 0;
        if(localDate.getMonthValue() == 12){
            finalSalary += getYearEndBonus();
        }
        finalSalary += salaryBonus;
        return finalSalary;
    }

    //TODO WRITE METHOD
    @Override
    public void isGenerateContract(boolean isGenerate) {
        if(isGenerate){
            if(iContract == null){
                iContract = new Contract();
            }
        }

    }

    @Override
    public void isCancelContract(boolean isCancel) {
        if(isCancel){
            if(iContract != null){
                iContract = null;
            }
        }
    }
}
