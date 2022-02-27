/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Database.EmployeeDA;
import java.util.ArrayList;
import java.util.Date;
import Domain.Withholding;
import Database.WithholdingDA;

/**
 *
 * @author rando
 */
public abstract class Employee {

    public String FirstName;
    public String LastName;
    public int EmployeeID;
    public int SocialSecurityNumber;
    public Payroll EmployeePayroll;
    public Withholding EmployeeWithholding;
    //there will be payroll, withholding, and timecard classes found throughout 
    //hourly,salary, and super class employee
    //these are used to link a connection between employee information and information between the other classes
    public Employee() {

    }

    public Employee(String FirstName, String LastName, int EmployeeID, int SocialSecurityNumber) {
        super();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmployeeID = EmployeeID;
        this.SocialSecurityNumber = SocialSecurityNumber;

    }

    public void setWithholding(Withholding wh) {
        this.EmployeeWithholding = wh;
        this.EmployeeID = wh.EmployeeID;
    }

    public void findWithholdings(ArrayList<Withholding> Withholdings) {
        for (Withholding withholding : Withholdings) {
            if (withholding.EmployeeID == this.EmployeeID) {
                this.setWithholding(withholding);
            }
        }
    }

    public Withholding getWithholding() {
        return this.EmployeeWithholding;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getSocialSecurityNumber() {
        return SocialSecurityNumber;
    }

    public void setSocialSecurityNumber(int SocialSecurityNumber) {
        this.SocialSecurityNumber = SocialSecurityNumber;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;

    }

    public void setAnnualSalary(double a) {
    }

    public double getAnnualSalary() {
        return 0.0;
    }

    public void setHourlyRate(double a) {
    }

    public double getHourlyrate() {
        return 0.0;
    }

    public void setOvertime(double a) {
    }

    public double getOvertime() {
        return 0.0;
    }

    public double getWithholdings() {
        return EmployeeWithholding.Amount;
    }

    public static ArrayList<Employee> getEmployees() {
        return EmployeeDA.getEmployees();
    }

    public double CalculateGrossPay() {
        return 0.0;
    }

    public double getTotalDeductions() {
        return EmployeeWithholding.Amount;
    }

    public double CalculateNetPay() {
        return 0.0;
    }

    // Ultimate toString (this way it is only printed once instead of making the main class bloated)
   // and having several tostrings   
    @Override
    public String toString() {
        String result = "";
        //result += "Employee{" + "FirstName=" + FirstName + ", lastName=" + LastName + ", EmployeeID=" + EmployeeID + ", SocialSecurityNumber=" + SocialSecurityNumber; 
        // Sweet thing that can be done to make main employee info display
        String employeeType = this instanceof SalaryEmployee ? "Salary" : "Hourly";

        result += "\n";
        result += "****************" + this.FirstName + " " + this.LastName + "*******************\n\n";
        result += "Social Security: " + this.SocialSecurityNumber + "\n";
        result += "Employee Type: " + employeeType + "\n";
        result += "Employee ID: " + this.EmployeeID + "\n";
        // thing that can be done to make salary/hourly specific info display on top of the default info
        if (this instanceof SalaryEmployee) {
            SalaryEmployee se = (SalaryEmployee) this;
            result += "Annual Salary: " + se.getAnnualSalary() + "\n";
            result += "Gross Pay: " + se.CalculateGrossPay() + "\n";
            result += "Current Method For Net Pay Not Functional. Please look in PayrollSystem.Java comments for more information" + "\n";
            //    result += "Net Pay: " + se.CalculateNetPay()+ "\n";
        } else if (this instanceof HourlyEmployee) {
            HourlyEmployee he = (HourlyEmployee) this;
            result += "Hours Worked: " + he.getTimeCard().HoursWorked + "\n";
            result += "Hourly Pay: " + he.getHourlyRate() + "\n";
            result += "Overtime: " + he.getOvertime()+ "\n";
            result += "Gross Pay: " + he.CalculateGrossPay() + "\n";
            result += "Current Method For Net Pay Not Functional. Please look in PayrollSystem.Java comments for more information" + "\n";
      //    result += "Net Pay: " + he.CalculateNetPay() + "\n";
        } else {
        }
        result += "\n*****************************************************\n";
        return result;
    }
}
