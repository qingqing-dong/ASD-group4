/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.DBStaffManager;
import com.mycompany.onlinefoodorderingsystem.dao.StaffDao;
import com.mycompany.onlinefoodorderingsystem.model.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Xin Chen
 */
@WebServlet(name = "StaffEditServlet", urlPatterns = {"/StaffEditServlet"})
public class StaffEditServlet extends HttpServlet {
    StaffDao staffDao = new StaffDao();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StaffEditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffEditServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
    
    /*
      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String gender = request.getParameter("gender");
        String streetNumber = request.getParameter("streetNumber");
        String streetName = request.getParameter("streetName");
        String suburb = request.getParameter("suburb");
        String state = request.getParameter("state");
        String zipcode = request.getParameter("zipcode");
        String address = streetNumber + "§" + streetName + "§" + suburb + "§" + state + "§" + zipcode;
        String phone_number = request.getParameter("phone_number");
        StaffDao manager = (StaffDao) session.getAttribute("manager");
        
        Staff staff = null;
        try {
            staff= manager.findStaff(email, password);
        } catch (SQLException ex) {
            Logger.getLogger(StaffEditServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(staff != null){
            session.setAttribute("staff", staff);
            request.getRequestDispatcher("staffUpdate.jsp").include(request, response);
        }else{
            session.setAttribute("existErr", "Customer does not exist in the database!");
            request.getRequestDispatcher("staffUpdate.jsp").include(request, response);
        }
        request.getRequestDispatcher("staffUpdate.jsp").include(request, response);
    }
*/
    /*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Staff staff = staffDao.getStaffById(1000);
        request.setAttribute("Staff", staff);
        request.getRequestDispatcher("staffInfo.jsp").forward(request, response);
    }
*/
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        Staff staff = staffDao.getStaffById(Integer.parseInt(request.getParameter("id")));
        System.out.println(staff);
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("staffInfo.jsp").forward(request, response);
    }


}
