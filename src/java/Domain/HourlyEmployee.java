package Domain;

import Database.TimecardDA;
import java.util.Date;
import java.util.ArrayList;
import Database.PayrollDA;
import java.io.Serializable;

/**
 *
 * @author rando
 */
public class HourlyEmployee extends Employee implements Serializable {

    private double HourlyRate;
    private double Overtime;
  //  public ArrayList<Timecard> EmployeeTimecards;
    private Payroll HourlyPayroll;
    private Withholding HourlyEmployeeWithholding;
    
    @Override
    public void setWithholding(Withholding wh) {
        this.HourlyEmployeeWithholding = wh;
        
    }

    public void setPayroll(Payroll pr) {
        this.HourlyPayroll = pr;
    }

    @Override 
    public void addTimeCard(Timecard tc) {
        if (EmployeeTimecards == null) {
            EmployeeTimecards = new ArrayList<>(); 
        }
        EmployeeTimecards.add(tc);
    }
    
    public Timecard getTimecard(int id) {
        if (EmployeeTimecards == null) {
            return null; 
        }
        else {
            for (Timecard tc : this.EmployeeTimecards) {
                if (id == tc.Id) {
                    
                   return tc; 
                }  
            }
            return null;
        }
    }
    
    public void updateTimecard(Timecard tc) {
        if (this.getIndexOfTimecard(tc) > 0) {
            this.EmployeeTimecards.set(this.getIndexOfTimecard(tc), tc);
        }
    }
    public void deleteTimecard(Timecard tc) {
        if (this.getIndexOfTimecard(tc) > 0) {
            this.EmployeeTimecards.remove(this.getIndexOfTimecard(tc));
        }
    }
    
    private int getIndexOfTimecard(Timecard t) {
        Timecard match;
        int idx = 0; 
        for (Timecard tc : this.EmployeeTimecards) {
            if (t.Id == tc.Id) {
                idx = this.EmployeeTimecards.indexOf(tc); 
            }
        }
        return idx; 
    }
    
    // CRUD - Create Read Update Delete implementing this concept into
    // this code and should do the same for other classes such as
    //payroll and withholdings in Domain.Employee when the time comes

   /* @Override
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
*/
    public Withholding getWithholding() {
        return this.HourlyEmployeeWithholding;
    }

    public Payroll getPayroll() {
        return this.HourlyPayroll;
    }

    public ArrayList<Timecard> getTimeCards() {
        return this.EmployeeTimecards;
    }

    public HourlyEmployee() {

    }

    public HourlyEmployee(String FirstName, String LastName, int EmployeeID, int SocialSecurityNumber, double HourlyRate, double Overtime, String Password, String UserID) {
        super(FirstName, LastName, EmployeeID, SocialSecurityNumber,Password,UserID);
        this.HourlyRate = HourlyRate;
        this.Overtime = Overtime;
    }

    public double getHourlyRate() {
        return HourlyRate;
    }

    public void setHourlyRate(double HourlyRate) {
        this.HourlyRate = HourlyRate;
    }

    public double getOvertime() {
        return Overtime;
    }

    public void setOvertime(double Overtime) {
        this.Overtime = Overtime;
    }
   
    
    public double CalculateGrossPay(Timecard tc) {
        return (HourlyRate * tc.HoursWorked) + (1.5 * HourlyRate * Overtime);
    }

    public double getTotalDeductions() {
        return HourlyEmployeeWithholding.Amount;
    }

    public double CalculateNetPay(Timecard tc) {
        return ((HourlyRate * tc.HoursWorked) + (1.5 * HourlyRate * Overtime))-HourlyEmployeeWithholding.Amount;
    }

    @Override
    public String toString() {
        return " HourlyEmployee{ " + " FirstName= " + FirstName + ", lastName= " + LastName + ", EmployeeID= " + EmployeeID + " , SocialSecurityNumber= " + SocialSecurityNumber + " HourlyRate= " + HourlyRate + " Overtime= " + Overtime + '}';
    }
    // get timecard and add up the hours here
    // need to link timecard with employees before this works
   
     
}

// Hourly Employee will have the attributes: hourly rate and 
//overtime rate. Add the get and set methods for each attribute.

