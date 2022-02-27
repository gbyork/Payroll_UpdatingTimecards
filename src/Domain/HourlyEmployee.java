/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Database.TimecardDA;
import java.util.Date;
import java.util.ArrayList;
import Database.PayrollDA;

/**
 *
 * @author rando
 */
public class HourlyEmployee extends Employee {

    private double HourlyRate;
    private double Overtime;
    private Timecard EmployeeTimecard;
    private Payroll HourlyPayroll;
    private Withholding HourlyEmployeeWithholding;
    
    @Override
    public void setWithholding(Withholding wh) {
        this.HourlyEmployeeWithholding = wh;
        
    }

    public void setPayroll(Payroll pr) {
        this.HourlyPayroll = pr;
    }

    public void setTimeCard(Timecard tc) {
        this.EmployeeTimecard = tc;
        this.Overtime = tc.Overtime;
    }

    @Override
    public void findWithholdings(ArrayList<Withholding> Withholdings) {
        for (Withholding withholding : Withholdings) {
            if (withholding.EmployeeID == this.EmployeeID) {
                this.setWithholding(withholding);
            }
        }
    }

    public void findTimecard(ArrayList<Timecard> Timecards) {
        for (Timecard timecard : Timecards) {
            if (timecard.EmployeeID == this.EmployeeID) {
                this.setTimeCard(timecard);
            }
        }
    }

    public void findPayroll(ArrayList<Payroll> Payrolls) {
        for (Payroll payroll : Payrolls) {
            if (payroll.EmployeeID == this.EmployeeID) {
                this.setPayroll(payroll);
            }
        }
    }

    public Withholding getWithholding() {
        return this.HourlyEmployeeWithholding;
    }

    public Payroll getPayroll() {
        return this.HourlyPayroll;
    }

    public Timecard getTimeCard() {
        return this.EmployeeTimecard;
    }

    public HourlyEmployee() {

    }

    public HourlyEmployee(String FirstName, String LastName, int EmployeeID, int SocialSecurityNumber, double HourlyRate, double Overtime) {
        super(FirstName, LastName, EmployeeID, SocialSecurityNumber);
        this.HourlyRate = HourlyRate;
        this.Overtime = Overtime;
    }

    public double getHourlyRate() {
        return HourlyRate;
    }

    public void setHourlyRate(double HourlyRate) {
        this.HourlyRate = HourlyRate;
    }

    public double getOvertime() {
        return Overtime;
    }

    public void setOvertime(double Overtime) {
        this.Overtime = Overtime;
    }
    //timecard will loop through this in timecard DA

    @Override
    public double CalculateGrossPay() {
        return (HourlyRate * EmployeeTimecard.HoursWorked) + (1.5 * HourlyRate * Overtime);
    }

    public double getTotalDeductions() {
        return EmployeeWithholding.Amount;
    }

    @Override
    public double CalculateNetPay() {
        return ((HourlyRate * EmployeeTimecard.HoursWorked) + (1.5 * HourlyRate * Overtime))-EmployeeWithholding.getAmount();
    }

    /*@Override
    public String toString() {
        return " HourlyEmployee{ " + " FirstName= " + FirstName + ", lastName= " + LastName + ", EmployeeID= " + EmployeeID + " , SocialSecurityNumber= " + SocialSecurityNumber + " HourlyRate= " + HourlyRate + " Overtime= " + Overtime + '}';
    }
    // get timecard and add up the hours here
    // need to link timecard with employees before this works
   
     */
}

// Hourly Employee will have the attributes: hourly rate and 
//overtime rate. Add the get and set methods for each attribute.
