package Database;

import Domain.Employee;
import Domain.Timecard;
import Database.EmployeeDA;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import Domain.HourlyEmployee;

/**
 *
 * @author rando
 */
public class TimecardDA {

    public static ArrayList<Timecard> Timecards = new ArrayList<Timecard>();

   // public static void add(Timecard tc) {
     //   tc.set Id(Timecards.size());
     //   Timecards.add(tc);
  //  }
//started adding timecards

    public static void initialize() {

        Timecard a;

        Calendar c = Calendar.getInstance();

        a = new Timecard();
        c.set(2022, 1, 12);
        a.setDate(c.getTime());
        a.setEmployeeID(103);
        a.setHoursWorked(8);
        a.setOvertime(0);

        Timecards.add(a);
        a = new Timecard();
        c.set(2022, 1, 13);
        a.setDate(c.getTime());
        a.setEmployeeID(104);
        a.setHoursWorked(8);
        a.setOvertime(0);
        Timecards.add(a);
    }
    //hourlyemployee will call get employeeid

    //
    public static ArrayList<Timecard> getTimecard() {
        return Timecards;
    }

}
