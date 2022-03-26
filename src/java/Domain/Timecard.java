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
    public ArrayList<Timecard> timecards;

    /* public void add() {
        TimecardDA.add(this);
    }*/
    public String getDateFormatted() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        return dateFormat.format(date);
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

    public static Timecard find(int ID) {
        return TimecardDA.find(ID);
    }
    
    public static ArrayList<Timecard> getTimecards() {
        return TimecardDA.timecards;
    }
    
    //add, update, delete, find
    //applying some CRUD!!
    
    
    public void addTimeCard(Timecard tc) {
        if (timecards == null) {
            timecards = new ArrayList<>();
        }
        timecards.add(tc);
    }

    public Timecard getTimecard(int id) {
        if (timecards == null) {
            return null;
        } else {
            for (Timecard tc : this.timecards) {
                if (id == tc.ID) {

                    return tc;
                }
            }
            return null;
        }
    }

    public void updateTimecard(Timecard tc) {
        if (this.getIndexOfTimecard(tc) > 0) {
            this.timecards.set(this.getIndexOfTimecard(tc), tc);
        }
    }

    public void deleteTimecard(Timecard tc) {
        if (this.getIndexOfTimecard(tc) > 0) {
            this.timecards.remove(this.getIndexOfTimecard(tc));
        }
    }

    private int getIndexOfTimecard(Timecard t) {
        Timecard match;
        int idx = 0;
        for (Timecard tc : this.timecards) {
            if (t.ID == tc.ID) {
                idx = this.timecards.indexOf(tc);
            }
        }
        return idx;
    }
    
    

    //Timecard.getEmployeeTimecards(employees.getEmployeeID())
    // CRUD - Create Read Update Delete implementing this concept into
    public String toString() {
        return getDateFormatted() + "  " + employeeID + "  " + hoursWorked + "  " + overtimeHours + ID;
    }
}
