package Database;

public class PayrollSystemDA {
    public static void initialize() {
        EmployeeDA.initialize();
        TimecardDA.initialize();
        WithholdingTypeDA.initialize();
    }
}
