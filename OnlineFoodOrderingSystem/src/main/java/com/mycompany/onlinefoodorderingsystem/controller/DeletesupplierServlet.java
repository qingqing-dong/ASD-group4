/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.SupplierManager;
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
 * @author ADMIN
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class DeletesupplierServlet extends HttpServlet {

    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
         int supplierid = Integer.parseInt(request.getParameter("supplierid"));
         SupplierManager supplierManager = (SupplierManager)session.getAttribute("supplierManager");
       
        try{
             
                    supplierManager.deleteSupplier(supplierid);
                    session.setAttribute("resultInfor", "Delete supplier was successful!");
                    request.getRequestDispatcher("viewsearchsupplier.jsp").include(request, response);
               
        }catch(SQLException ex){
          Logger.getLogger(DeletesupplierServlet.class.getName()).log(Level.SEVERE, null, ex);     
        }
    

     }

}
