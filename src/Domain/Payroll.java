/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Database.EmployeeDA;
import Database.PayrollDA;
import Database.TimecardDA;
import Database.WithholdingDA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rando
 */
public class Payroll {

    public Date Date;
    public int EmployeeID;
    public double GrossPay;
    public double TotalDeductions;
    public double NetPay;

    public Payroll() {

    }

    public Payroll(Date Date, int EmployeeID, double GrossPay, double TotalDeductions, double NetPay) {
        this.Date = Date;
        this.EmployeeID = EmployeeID;
        this.GrossPay = GrossPay;
        this.TotalDeductions = TotalDeductions;
        this.NetPay = NetPay;

    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public double getGrossPay() {
        return GrossPay;
    }

    public void setGrossPay(double GrossPay) {
        this.GrossPay = GrossPay;
    }

    public double getTotalDeductions() {
        return TotalDeductions;
    }

    public void setTotalDeductions(double TotalDeductions) {
        this.TotalDeductions = TotalDeductions;
    }

    public double getNetPay() {
        return NetPay;
    }

    public void setNetPay(double NetPay) {
        this.NetPay = NetPay;
    }

    public static ArrayList<Payroll> getPayrolls() {
        return PayrollDA.getPayrolls();
    }
    
    
    
    
  /*  public double NetPayCalculation(Double NetPay) {
    return GrossPay - TotalDeductions;
    }
    */
    // calculate payroll in here     

    //calculategross pay in employee.java do nothing with it just return 0
    //its used as a default
    //hourly employee calculategrosspay
    //salary employee calculategrosspay would just be AnnualSalary / 52
    

    
    //call employee to calculate grosspay for 
    //employee loop inside of it look for calculategrosspay to get grosspay
    //loop through withholding types in the employee loop
    // grosspay minus  total deductions = netpay
    

    public String toString() {
        return " Payroll Date and Employees { " + " Date " + Date +  " This Day Was Worked By EmployeeID= " + EmployeeID + '}';
    }
    //idea for looping through employees and if they match to calculate gross pay */
}

//Create a Payroll class with the attributes: date, employee ID, gross pay, total deductions, and net 
//pay.  Add all of the get and set methods for the attributes.  
