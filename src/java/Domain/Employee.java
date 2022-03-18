package Domain;

import Database.EmployeeDA;
import java.util.ArrayList;
import java.util.Date;
import Domain.Withholding;
import Database.WithholdingDA;
import java.io.Serializable;

/**
 *
 * @author rando
 */
public abstract class Employee implements Serializable {
// In this class I will need to make method FindByUserID

    public String FirstName;
    public String LastName;
    public int EmployeeID;
    public int SocialSecurityNumber;
    public Payroll EmployeePayroll;
    public Withholding EmployeeWithholding;
    public String UserID;
    public String Password;
    public boolean IsAuthenticated;
    public Employee LoggedInEmployee;
    public ArrayList<Timecard> EmployeeTimecards;
    public ArrayList<Employee> Employees;

    public Employee() {

    }

    public Employee(String FirstName, String LastName, int EmployeeID, int SocialSecurityNumber, String UserID, String Password) {
        super();
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.EmployeeID = EmployeeID;
        this.SocialSecurityNumber = SocialSecurityNumber;
        this.Password = Password;
        this.UserID = UserID;

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

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    public void addTimeCard(Timecard t) {
    }
    public Timecard getTimecard(int id) {
        return null;
        
    }
       
    
    public void updateTimecard(Timecard tc) {
        
        }
    
    public void deleteTimecard(Timecard tc) {
       
    }
    
    private int getIndexOfTimecard(Timecard t) {
        return 0;
        
    }
}
