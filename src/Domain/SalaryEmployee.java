/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Database.EmployeeDA;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author rando
 */
public class SalaryEmployee extends Employee {

    public double AnnualSalary;
    private Payroll SalaryPayroll;
    
    public SalaryEmployee() {

    }

    @Override
    public void setWithholding(Withholding wh) {
        this.EmployeeWithholding = wh;
        this.EmployeeID = wh.EmployeeID;
    }

    public void setPayroll(Payroll pr) {
        this.SalaryPayroll = pr;
    }

    public void findWithholdings(ArrayList<Withholding> Withholdings) {
        for (Withholding withholding : Withholdings) {
            if (withholding.EmployeeID == this.EmployeeID) {
                this.setWithholding(withholding);
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
        return this.EmployeeWithholding;
    }

    public Payroll getPayroll() {
        return this.SalaryPayroll;
    }

    public SalaryEmployee(String FirstName, String LastName, int EmployeeID, int SocialSecurityNumber, double AnnualSalary) {
        super(FirstName, LastName, EmployeeID, SocialSecurityNumber);
        this.AnnualSalary = AnnualSalary;
    }

    public double getAnnualSalary() {
        return AnnualSalary;
    }

    public void setAnnualSalary(double AnnualSalary) {
        this.AnnualSalary = AnnualSalary;
    }

    public double CalculateGrossPay() {
        return AnnualSalary / 52;
    }
    
    public double getWithholdings(){
     return EmployeeWithholding.Amount = SalaryPayroll.TotalDeductions;
    }
    
    public double CalculateNetPay(){
     return (AnnualSalary/ 52) - SalaryPayroll.TotalDeductions;
    }
    
    //@Override
    //public String toString() {
    //return " SalaryEmployee{ " + " FirstName= " + FirstName + ", lastName= " + LastName + " , EmployeeID= " + EmployeeID + ", SocialSecurityNumber= " + SocialSecurityNumber + " AnnualSalary= " + AnnualSalary + '}';
    //}
    //grosspay  calculate div by 52
}
