package Database;

import Domain.Employee;
import Domain.SalaryEmployee;
import Domain.HourlyEmployee;
import Domain.Timecard;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author rando
 */
public class EmployeeDA {

    private static ArrayList<Employee> Employees = new ArrayList<Employee>();
    
        
    public static void initialize() {
        Employee a;



        Random random = new Random(); 
        a = new HourlyEmployee();
        a.setFirstName("Robert");
        a.setLastName("Jones");
        a.setHourlyRate(40);
        a.setOvertime(4);
        a.setEmployeeID(103);
        a.setSocialSecurityNumber(523094784);
        a.setUserID("User1");
        a.setPassword("user1");
        
        
        for (int i = 0; i < (random.nextInt(99) + 1); i++) {
            Timecard t = new Timecard(); 
            t.Date = new Date(); 
            t.EmployeeID = 103; 
            double min = 0.1; 
            double max = 70.0; 
            double x = (Math.random() * ((max - min) + 1)) + min; 
            double xround = Math.round(x * 100.0) / 100.0; 
            t.HoursWorked =xround; 
            t.Overtime = 0.5; 
            t.Id = i+1; 
            a.addTimeCard(t);
        }
        Employees.add(a);
        
        a = new HourlyEmployee();
        a.setFirstName("Justin");
        a.setLastName("James");
        a.setHourlyRate(40);
        a.setOvertime(2);
        a.setEmployeeID(104);
        a.setSocialSecurityNumber(523094386);
        a.setUserID("User2");
        a.setPassword("user2");
        Employees.add(a);
        
        a = new SalaryEmployee();
        a.setFirstName("Bob");
        a.setLastName("Smith");
        a.setAnnualSalary(500);
        a.setEmployeeID(101);
        a.setSocialSecurityNumber(555121212);
        a.setUserID("User3");
        a.setPassword("user3");
        Employees.add(a);

        a = new SalaryEmployee();
        a.setFirstName("John");
        a.setLastName("Doe");
        a.setAnnualSalary(1200);
        a.setEmployeeID(102);
        a.setSocialSecurityNumber(555121213);
        a.setUserID("User4");
        a.setPassword("user4");
        Employees.add(a);

        

      
    }

    //return employees 
    public static ArrayList<Employee> getEmployees() {
        return Employees;
    }


}
