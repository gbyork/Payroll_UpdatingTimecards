

 package Database;

import Domain.Employee;
import Domain.SalaryEmployee;
import Domain.HourlyEmployee;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 *
 * @author rando
 */
public class EmployeeDA {

    private static ArrayList<Employee> Employees = new ArrayList<Employee>();
    
    public EmployeeDA() {
    //Employee a; giving errors with subclass attributes 
//(for example: weeklysalary and hourly rate will both give errors and request you make them in domain.employee)
        Employee a;

//     Employee a; giving errors with subclass attributes, unable to define them
//     not sure why abstract class is so strict on its constructors
        a = new SalaryEmployee();
        a.setFirstName("Bob");
        a.setLastName("Smith");
        a.setAnnualSalary(500);
        a.setEmployeeID(101);
        a.setSocialSecurityNumber(555121212);
        a.setUserID("User1");
        a.setPassword("user1");
        Employees.add(a);

        a = new SalaryEmployee();
        a.setFirstName("John");
        a.setLastName("Doe");
        a.setAnnualSalary(1200);
        a.setEmployeeID(102);
        a.setSocialSecurityNumber(555121213);
        a.setUserID("User2");
        a.setPassword("user2");

        Employees.add(a);

        a = new HourlyEmployee();
        a.setFirstName("Robert");
        a.setLastName("Jones");
        a.setHourlyRate(40);
        a.setOvertime(4);
        a.setEmployeeID(103);
        a.setSocialSecurityNumber(523094784);
        a.setUserID("User3");
        a.setPassword("user3");
        Employees.add(a);

        a = new HourlyEmployee();
        a.setFirstName("Justin");
        a.setLastName("James");
        a.setHourlyRate(40);
        a.setOvertime(2);
        a.setEmployeeID(104);
        a.setSocialSecurityNumber(523094386);
        a.setUserID("User4");
        a.setPassword("user4");
        Employees.add(a);
    }
    
    //return employees 
    public static ArrayList<Employee> getEmployees() {
        return Employees;
    }

}
 

