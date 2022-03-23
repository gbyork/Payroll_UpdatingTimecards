/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Database.EmployeeDA;
import Domain.Employee;
import Domain.HourlyEmployee;
import Domain.SalaryEmployee;
import Domain.Timecard;
import Presentation.PayrollSystem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        ServletContext sc = getServletContext();
        HttpSession session = request.getSession();

        String option = request.getParameter("option");
        System.out.println("TimecardServlet        option" + option);

        if (option.equals("nope")) {
            String NotReady = "This feature has not been added yet";
            session.setAttribute("NotReady", NotReady);
            response.sendRedirect("welcome.jsp");

            //edit will have hidden element TimecardID (timecardID will be added to domain.timecard)
        }
        String url = "/welcome.jsp";

        //list screen will have add button at bottom and a return button to the welcome page
        if (option.equals("list")) {
            Employee employees = (Employee) session.getAttribute("employee");
            System.out.println("employee: " + employees);
            
            ArrayList<Timecard> EmployeeTimecards = employees.EmployeeTimecards;
            System.out.println("timecard: " + EmployeeTimecards);
          //  session.setAttribute("timecards", EmployeeTimecards);
            session.setAttribute("employee", employees);
            if (employees == null) {
                response.sendRedirect("timecardList.jsp");
            } else {
              //   ArrayList<Timecard> EmployeeTimecards = employees.EmployeeTimecards;

                System.out.println("timecard: " + EmployeeTimecards);
                session.setAttribute("employee", employees);
                // session.setAttribute("timecards", EmployeeTimecards);
                response.sendRedirect("timecardList.jsp");

            }}
        if (option.equals("add")) {

                response.sendRedirect("timecard.jsp");
        }
       
            /*
         if (option.equals("delete")) {
            Employee employees = (Employee) session.getAttribute("employee");
            ArrayList<Timecard> EmployeeTimecards = employees.EmployeeTimecards;
          //  employees.deleteTimecard(tc);
            session.setAttribute("timecards", EmployeeTimecards);
            
            response.sendRedirect("timecardList.jsp");
            
 
        }
        //all that needs to be edited is hoursworked, overtime, and date
        if (option.equals("edit")) {
            url = "/timecard.jsp";
            int quantity;
            Employee employees = (Employee) session.getAttribute("employee");
         //   employees.updateTimecard(tc);
            
            //String productCode = request.getParameter("productCode");
           // String quantityString = request.getParameter("quantity");

           // try {
           //     quantity = Integer.parseInt(quantityString);
           // } catch (NumberFormatException e) {
           //     quantity = 1;
            }

            //       employees.updateTimecard(productCode, quantity);
            //       session.setAttribute("timecards", EmployeeTimecards);
            //       url = "/cart.jsp";
        
        sc.getRequestDispatcher(url)
                .forward(request, response);
    }
    //    session.setAttribute("");
    //   employee.addTimeCard(t);
    //
    //    ArrayList<Timecard> timecards = Timecard.getEmployeeTimecards(employee.getEmployeeID());
    //    session.setAttribute("timecards", timecards);
    //  response.sendRedirect("timecardList.jsp");

    //Strong had good advice, ONE STEP AT A TIME break up parts
             */
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


// Lab 3 code from class
/* 
private static DateFormat dateFormatShort = DateFormat.getDateInstance(DateFormat.SHORT);
if (option.equals("save")){
Timecard timecard= (Timecard)session.get.attribute
id = employee.getEmployeeID();
String dateString = request.getParameter("date");
(do this with all date into)
Date date = new Date()
try{
date=dateFormatShort.parse(dateString);
}
catch (Exception e){
System.out.println(e.getMessage());
}
double hours= double.parseDouble(hoursString);
}
double hours=Double.parseDouble(hoursString);

public String getHoursWorkedFormatted(){
NumberFormat numberFormat = NumberFormat.getinstance();
numberFormat.setMinimumFractionDigits(2);
return numberFormat.format(hoursWorked;
}
}




*/