package Domain;

import Database.EmployeeDA;
import java.io.Serializable;

import java.util.Date;

import java.util.ArrayList;

public abstract class Employee implements Serializable{
    private int employeeID;
    private String firstName;
    private String lastName;
    private long SSN;
    public String UserID;
    public String Password;
    
    public void add() {
        EmployeeDA.add(this);
    }
    
    public double calculateGrossPay(Date date) {
        return 0.0;
    }
    
    public static Employee find(int ID){
        return EmployeeDA.find(ID);
    }

    public int getEmployeeID() {
        return employeeID;
    }
    
    public static ArrayList<Employee> getEmployees() {
        return EmployeeDA.getEmployees();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public long getSSN() {
        return SSN;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setHourlyRate(double hR) {}

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setOvertimeRate(double or) {}
    
    public void setSalary(double s) {}

    public void setSSN(long SSN) {
        this.SSN = SSN;
    }
   

    public double getHourlyrate() {
        return 0.0;
    }
    @Override
    public String toString(){
       
        return employeeID + "  " + lastName + ", " + firstName + "  " + SSN ;
        
        
    }
}