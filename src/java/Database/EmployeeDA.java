package Database;

import Domain.Employee;
import Domain.HourlyEmployee;
import Domain.SalaryEmployee;

import java.util.ArrayList;

public class EmployeeDA {
    
    private static ArrayList<Employee> employees = new ArrayList<Employee>(5);
    
    public static void add(Employee emp) {
        employees.add(emp);
    }
    
    public static Employee find(int ID){
        for (int i = 0; i < employees.size(); i++)
            if (employees.get(i).getEmployeeID() == ID)
                return employees.get(i);
        return null;
    }
    
    public static void initialize(){
        Employee e;
        
        e = new HourlyEmployee();
        e.setEmployeeID(1001);
        e.setFirstName("Alice");
        e.setLastName("Fontana");
        e.setSSN(123445555);
        e.setHourlyRate(10.0);
        e.setOvertimeRate(1.5);
        e.setUserID("User1");
        e.setPassword("user1");
        e.add();
        
        e = new HourlyEmployee();
        e.setEmployeeID(1002);
        e.setFirstName("Thomas");
        e.setLastName("Arlinton");
        e.setSSN(123445555);
        e.setHourlyRate(12.50);
        e.setOvertimeRate(1.5);
        e.setUserID("User2");
        e.setPassword("user2");
        e.add();
        
        e = new SalaryEmployee();
        e.setEmployeeID(1003);
        e.setFirstName("Bob");
        e.setLastName("Smith");
        e.setSSN(123445555);
        e.setSalary(52000);
        e.setUserID("User3");
        e.setPassword("user3");
        e.add();
        
        
        e = new SalaryEmployee();
        e.setEmployeeID(1004);
        e.setFirstName("Kim");
        e.setLastName("Johnson");
        e.setSSN(123445555);
        e.setSalary(65000);
        e.setUserID("User4");
        e.setPassword("user4");
        e.add();
        

    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
    
}