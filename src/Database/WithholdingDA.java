/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.util.ArrayList;
import Domain.Timecard;
import Domain.Withholding;

/**
 *
 * @author rando
 */
public class WithholdingDA {

    private static ArrayList<Withholding> Withholdings = new ArrayList<Withholding>();

    public static void initialize() {

        WithholdingDA.initialize();

        Withholding a;
        //creating withholding
      
        a = new Withholding();
        // need info for double EmployeeID, String Description, double Amount, double Rate
        a.setEmployeeID(101);
        a.setDescription("401k contributions");
        a.setAmount(480);
        a.setRate(2.5);

        Withholdings.add(a);

        a = new Withholding();
        a.setEmployeeID(102);
        a.setDescription("401k contributions");
        a.setAmount(480);
        a.setRate(2.5);

        Withholdings.add(a);

        a = new Withholding();
        a.setEmployeeID(103);
        a.setDescription("401k contributions");
        a.setAmount(480);
        a.setRate(2.5);

        Withholdings.add(a);

        a = new Withholding();
        a.setEmployeeID(104);
        a.setDescription("401k contributions");
        a.setAmount(480);
        a.setRate(2.5);

        Withholdings.add(a);
    }

    public static ArrayList<Withholding> getWithholding() {
        return Withholdings;
    }
}
