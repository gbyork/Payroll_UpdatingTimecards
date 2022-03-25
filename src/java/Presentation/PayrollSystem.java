/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Domain.Employee;

import java.util.ArrayList;

/**
 *
 * @author rando
 */
//This class will be an initalized class that will be used to transfer info to servlet
//This will act similar to an api

public class PayrollSystem {
    
    public boolean IsAuthenticated; 
    public Employee LoggedInEmployee; 
    public ArrayList<Employee> Employees; 
    
     
           
    public Employee Login (String username, String password) {
        Employee employee = null; 
        for (Employee e : this.Employees) {
            if (username.equals(e.UserID)) {
                employee = e; 
            }
        }
        if (employee == null) {
            IsAuthenticated = false;  
            return employee;
        }
        else {
            if (password.equals(employee.Password)) {
                IsAuthenticated = true;
                LoggedInEmployee = employee; 
                return employee; 
            }
            else {
                IsAuthenticated = false;
                return employee; 
            }
        }
    }

}