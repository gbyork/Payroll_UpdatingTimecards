/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Database.EmployeeDA;
import Domain.Employee;
import Domain.HourlyEmployee;
import Domain.Timecard;
import Presentation.PayrollSystem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
        
        HttpSession session = request.getSession();
        
        
        String option = request.getParameter("option");
        System.out.println("TimecardServlet        option"  + option);
        //need to get all items intialized in new class payrollDA and call that initialize here
        
        String url = "/main.jsp";
        if (option.equals("list")) {
           Employee employee = (Employee)session.getAttribute("employee");
           System.out.println("employee: " + employee);
           
     //      
     //      ArrayList<Timecard> timecards = Timecard.getEmployeeTimecards(employee.getEmployeeID());
         //  session.setAttribute("timecards", timecards);
         //  url = "/timecardList.jsp";
           
           //Strong had good advice, ONE STEP AT A TIME break up parts
        }
        
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