package Database;

import Domain.Timecard;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TimecardDA {
    private static ArrayList<Timecard> timecards = new ArrayList<Timecard>(5);
    private static ArrayList<Timecard> employeeTimecards = new ArrayList<Timecard>();
    
    public static void add(Timecard tc) {
        tc.setID(employeeTimecards.size());
        employeeTimecards.add(tc);  
    }
    
    public static void initialize(){
        Calendar calendar = Calendar.getInstance();
        Timecard t;
        Date date = new Date();
        
        calendar.set(2022, 1, 6);
        date = calendar.getTime();
        
        t = new Timecard();
        t.setDate(date);
        t.setEmployeeID(1001);
        t.setHoursWorked(40);
        t.setOvertimeHours(10);
     
        timecards.add(t);
        
        calendar.set(2022, 1, 7);
        date = calendar.getTime();
        t = new Timecard();
        t.setDate(date);
        t.setEmployeeID(1001);
        t.setHoursWorked(30);
        t.setOvertimeHours(5);
        
        timecards.add(t);
        
        calendar.set(2022, 1, 6);
        date = calendar.getTime();
        t = new Timecard();
        t.setDate(date);
        t.setEmployeeID(1002);
        t.setHoursWorked(40);
        t.setOvertimeHours(12.5);
    
        timecards.add(t);
        
        calendar.set(2022, 1, 7);
        date = calendar.getTime();
        t = new Timecard();
        t.setDate(date);
        t.setEmployeeID(1002);
        t.setHoursWorked(40);
        t.setOvertimeHours(12.5);
    
        timecards.add(t);
        
        
        
    
        
        t = new Timecard();
        t.setDate(date);
        t.setEmployeeID(1004);
        t.setHoursWorked(40);
        t.setOvertimeHours(5);
        timecards.add(t);
    }

    public static ArrayList<Timecard> getEmployeeTimecards(int ID) {
        employeeTimecards.clear();
                
        for (int i = 0; i < timecards.size(); i++)
            if (timecards.get(i).getEmployeeID() == ID)
               
                employeeTimecards.add(timecards.get(i));
        
        return employeeTimecards;
    }
    
    public static ArrayList<Timecard> getEmployeeTimecards(int ID, Date begDate, Date endDate) {
        employeeTimecards.clear();
        Timecard timecard = null;
                
        for (int i = 0; i < timecards.size(); i++){
            timecard = timecards.get(i);

            if (timecard.getEmployeeID() == ID){
                if(timecard.getDate().compareTo(begDate) >= 0 && timecard.getDate().compareTo(endDate) <= 0)
                    employeeTimecards.add(timecard);
            }
        }
        
        return employeeTimecards;
    }
}