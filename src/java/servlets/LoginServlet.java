
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Presentation.PayrollSystem;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.PayrollDA;
import Database.EmployeeDA;
import Database.PayrollSystemDA;
import Database.TimecardDA;
import Database.WithholdingDA;
import Domain.Employee;
import Presentation.LoginException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rando
 */
public class LoginServlet extends HttpServlet {

    public ArrayList<Employee> Employees;
    PayrollSystem PrSystem;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init() {

        EmployeeDA empDb = new EmployeeDA();
        PrSystem = new PayrollSystem();
        PrSystem.Employees = empDb.getEmployees();

    }

    protected ArrayList<Employee> processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PayrollSystemDA.initialize();
        HttpSession session = request.getSession();
        String username = request.getParameter("UserID");
        String password = request.getParameter("Password");
        Employee loggedIn = null;

        try {
            loggedIn = PrSystem.Login(username, password);
            session.setAttribute("employee", loggedIn);
            if (loggedIn == (null)) {
                throw new LoginException("Access denied - Username and password are incorrect");
                     
            }
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("employee", loggedIn);
            response.sendRedirect("welcome.jsp");

        } catch (LoginException ex) {
            request.setAttribute("msg", ex.getMessage());
            response.sendRedirect("login.jsp");

        }
        return null;
        
    }

/*   if (loggedIn==Employees) {
                    HttpSession session = request.getSession();
                    
                    
                    
                    //employee equals logins
                    //employee setattribute
                    session.setAttribute("username", username);
                    session.setAttribute("password", password);
                    //session.setAttribute("employee", employee);
                    response.sendRedirect("welcome.jsp");
                    
                    
                    
                } else {

                    throw new LoginException("Access denied - Username and password are incorrect");

                }
            } catch (LoginException ex) {

                HttpSession session = request.getSession();
                session.setAttribute("msg", ex.getMessage());
                response.sendRedirect("login.jsp");
            }
 *//*
        out.println("<title>Servlet LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");

        out.println("</body>");
        out.println("</html>");

    }

return null;*/


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
