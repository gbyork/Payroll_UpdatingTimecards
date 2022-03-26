/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Database.EmployeeDA;
import Database.PayrollSystemDA;
import Domain.Employee;
import Domain.HourlyEmployee;
import Domain.SalaryEmployee;
import Domain.Timecard;
import Presentation.PayrollSystem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rando
 */
public class TimecardServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // @Override
    //public void init() {
    //     EmployeeDA empDb = new EmployeeDA();
    //     TimecardDA timeDb = new TimecardDA();
    // }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PayrollSystemDA.initialize();
        //ServletContext sc = getServletContext();
        HttpSession session = request.getSession();

        String option = request.getParameter("option");
        System.out.println("TimecardServlet        option" + option);

        if (option.equals("nope")) {
            String NotReady = "This feature has not been added yet";
            session.setAttribute("NotReady", NotReady);
            response.sendRedirect("welcome.jsp");
            //edit will have hidden element TimecardID (timecardID will be added to domain.timecard)
        }

        //list screen will have add button at bottom and a return button to the welcome page
        if (option.equals("list")) {
            //employee info
            String SalaryMsg = "You are a salary employee";
            Employee employees = (Employee) session.getAttribute("employee");
            //System.out.println("employee: " + employees);
            session.setAttribute("employee", employees);

            ArrayList<Timecard> timecards = Timecard.getEmployeeTimecards(employees.getEmployeeID());
            //System.out.println("timecard: " + timecards);

            session.setAttribute("timecards", timecards);

            if (timecards == null) {
                session.setAttribute("SalaryMsg", SalaryMsg);
            }
            response.sendRedirect("timecardList.jsp");
        }

        if (option.equals("edit")) {
          
            int ID;
            String timecardIDString = request.getParameter("timecardID");
            Employee employees = (Employee) session.getAttribute("employee");
            ID = Integer.parseInt(timecardIDString);
            Timecard timecards = Timecard.find(ID);
            
            Timecard time = new Timecard();
            time.setEmployeeID(employees.employeeID);
            time.setHoursWorked(0.0);
            time.setOvertimeHours(0.0);
            
            
            
            timecards.addTimeCard(time);
            
            response.sendRedirect("timecard.jsp");
            
          
           
        }
        //making back out options so user isn't trapped on pages
        if (option.equals("cancel")){
            
            response.sendRedirect("timecardList.jsp");    
        }
        
        if (option.equals("back")){
            
            response.sendRedirect("welcome.jsp"); 
        }
        
        if (option.equals("addpage")) {
            Employee employees = (Employee) session.getAttribute("employee");
            ArrayList<Timecard> timecards = Timecard.getEmployeeTimecards(employees.getEmployeeID());
            
            Timecard addedtimecard = new Timecard();
            Calendar calendar = Calendar.getInstance();
            Timecard t;
            Date date = new Date();
        
            calendar.set(2022, 1, 8);
            date = calendar.getTime();
            addedtimecard.setHoursWorked(1.0);
            addedtimecard.setOvertimeHours(1.0);
            addedtimecard.setDate(date);
            
            timecards.add(addedtimecard);
 
            session.setAttribute("timecards",timecards);
            response.sendRedirect("addPage.jsp");
        }
        
        if (option.equals("add")) {
            
            Employee employees = (Employee) session.getAttribute("employee");
            
            int ID;
            
            String timecardIDString = request.getParameter("timecardID");
            ID = Integer.parseInt(timecardIDString);
            Timecard timecards = Timecard.find(ID);
            String HourQuantityString = request.getParameter("hoursWorked");
            String OvertimeQuantityString = request.getParameter("overtimeHours");
            //need to add date
            
            
          
              
            
            session.setAttribute("timecards",timecards);
            response.sendRedirect("timecardList.jsp");
            
            
        }
         //make delete button padright to add button that just deletes timecardlike this
         //timecards.delete.ID(max) or something like that
          if (option.equals("update")){
           
            Employee employees = (Employee) session.getAttribute("employee");
            //int HourQuantity;
            //int OvertimeQuantity;
            int ID;
            
            String timecardIDString = request.getParameter("timecardID");
            ID = Integer.parseInt(timecardIDString);
            Timecard timecards = Timecard.find(ID);
            
            String HourQuantityString = request.getParameter("hoursWorked");
            String OvertimeQuantityString = request.getParameter("overtimeHours");
            
            
            timecards.updateTimecard(timecards);
            // timecards.updateTimecard(timecards);
            session.setAttribute("timecards",timecards);
           
            
            
        }

        
         if (option.equals("delete")) {
            Employee employees = (Employee) session.getAttribute("employee");
            int ID;
            String timecardIDString = request.getParameter("timecardID");
            ID = Integer.parseInt(timecardIDString);
            Timecard timecards = Timecard.find(ID);
            
            timecards.deleteTimecard(timecards);
            
            
            session.setAttribute("timecards", timecards);
            response.sendRedirect("timecardList.jsp");
         } 
 
    //Strong had good advice, ONE STEP AT A TIME break up parts
         
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

//  3/14/2022 Overall amazing progress, got all buttons added and they redirect to where they are suppose to go
//   even started analyzing examples of assignment 2, possibly try serializing all domain classes.
//  Tomorrow's goal should be to - get messages working for salaryemployee and message for calculate
// 
//3/15/2022 Good progress again. Got error message for calculate button working.
//Been looking into what to do about this Timecard.getEmployeeTimecard issue
//If I need to, I can redo my lab 1 info and implement my login screen into Strong's lab 1
//3/16/2022 Made methods in Domain.Hourlyemployee and Domain.Employee for EmployeeTimecard
// Used CRUD - Create, Read, Update, Delete logic EmployeeTimecard
//3/17/2022 Reviewed methods created and worked on debugging them. Was able to get EmployeeTimecards
//plugged into Servlet, when running it appears that Employee is passing as null though
// I need to look through code to see what could be causing it. My first idea is that it is
// because of PayrollSystem.java class
// More fat progress!! Added add,update,and delete methods into servlet so now they are called here
// issue seen with "tc" not being recognized, but overall this is looking pretty good!
// 3/22/2022 got PayrollSystemDA implemented into servlet code, problem with employee appearing as null
//still happening.
//Big moves by making timecardList.jsp changes and timecard.jsp
// 3/24/2022 HUGGGGE moves!!!! got timecard information displaying for correct employee
//was able to fix issue by implementing Professor Strong's lab 1
//got CRUD methods corrected and moved to proper class, timecard
//added find methods for timecard
// 3/25/2022 worked on creating methods in timecard servlet such as
// add,update,and delete and worked on getting them to correctly call to domain.timecard
// methods




