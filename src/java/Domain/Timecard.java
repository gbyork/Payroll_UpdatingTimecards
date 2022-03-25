package Domain;

import Database.TimecardDA;
import java.io.Serializable;
import java.text.DateFormat;

import java.util.ArrayList;

import java.util.Date;

public class Timecard implements Serializable {

    private Date date;
    private int employeeID;
    private double hoursWorked;
    private double overtimeHours;
    public int ID;

    /* public void add() {
        TimecardDA.add(this);
    }*/
    public String getDateFormatted() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormat.format(date);
    }
    public static Timecard find(Timecard tc){
        return TimecardDA.find(tc);
    }
    
    public Date getDate() {  
        return date;  
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public static ArrayList<Timecard> getEmployeeTimecards(int ID) {
        return TimecardDA.getEmployeeTimecards(ID);
    }

    public static ArrayList<Timecard> getEmployeeTimecards(int ID, Date begDate, Date endDate) {
        return TimecardDA.getEmployeeTimecards(ID, begDate, endDate);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getOvertimeHours() {
        return overtimeHours;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    //Timecard.getEmployeeTimecards(employees.getEmployeeID())
    // CRUD - Create Read Update Delete implementing this concept into
    public String toString() {
        return getDateFormatted() + "  " + employeeID + "  " + hoursWorked + "  " + overtimeHours + ID;
    }
}
