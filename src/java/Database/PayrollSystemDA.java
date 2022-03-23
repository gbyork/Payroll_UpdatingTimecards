/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author rando
 */
public class PayrollSystemDA {
    private static boolean initialized = false;
     public static void initialize() {
        EmployeeDA.initialize();
        TimecardDA.initialize();
     //   WithholdingDA.initialize();
        PayrollDA.initialize();
        initialized = true;
    }
     
}
