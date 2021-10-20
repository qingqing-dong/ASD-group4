/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.DBStaffManager;
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
@WebServlet(name = "StaffUpdateServlet", urlPatterns = {"/StaffUpdateServlet"})
public class StaffUpdateServlet extends HttpServlet {

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
            out.println("<title>Servlet StaffUpdateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StaffUpdateServlet at " + request.getContextPath() + "</h1>");
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
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String userID = request.getParameter("submitted");
        String position = request.getParameter("position");
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
        Staff staff = new Staff(0, first_name, last_name, email, password, gender, address, phone_number, position);
        DBStaffManager manager = (DBStaffManager) session.getAttribute("manager");

        if(staff != null){
            session.setAttribute("staff", staff);
            try {
                manager.updateStaff(userID, first_name, last_name, email, password, gender, address, phone_number, position);
            } catch (SQLException ex) {
                Logger.getLogger(StaffUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.setAttribute("updated", "Update was successfully!");
            request.getRequestDispatcher("staffInfo.jsp").include(request, response);
        }else{
            session.setAttribute("updated", "Update was not successfully!");
            request.getRequestDispatcher("staffUpdate.jsp").include(request, response);
        }
        response.sendRedirect("staffInfo.jsp");
    }
}
