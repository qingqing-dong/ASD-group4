/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;


import com.mycompany.onlinefoodorderingsystem.dao.SupplierManager;
import com.mycompany.onlinefoodorderingsystem.model.Supplier;
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
@WebServlet(name = "UpdatesupplierServlet", urlPatterns = {"/UpdatesupplierServlet"})
public class UpdatesupplierServlet extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int supplierid = Integer.parseInt(request.getParameter("supplierid"));
        String contactname = request.getParameter("contactname");
        String company = request.getParameter("company");
        String status = request.getParameter("status");
        int supplierphonenum = Integer.parseInt(request.getParameter("supplierphonenum"));
        SupplierManager supplierManager = (SupplierManager) session.getAttribute("supplierManager");
      
       
     
        /*Validator validator = new Validator();
        validator.clear(session);
         if(!validator.validateDate(date)){
            session.setAttribute("dateErr","Date format incorrect");
            request.getRequestDispatcher("findpayment.jsp").include(request, response);
            
        }else{*/
        try{
                Supplier supplier = new Supplier(supplierid,contactname,company,supplierphonenum,status);
                if (supplier != null) {
                session.setAttribute("supplier", supplier);
                supplierManager.updateSupplier(supplierid,contactname,company,supplierphonenum,status);
                session.setAttribute("resultInfor", "Update was successful");
                request.getRequestDispatcher("viewsearchsupplier.jsp").include(request, response);
            } else {
                session.setAttribute("resultInfor", "Update was not successful!");
                request.getRequestDispatcher("viewsearchsupplier.jsp").include(request, response);
            }
           
        }catch (SQLException ex){
            Logger.getLogger(UpdatesupplierServlet.class.getName()).log(Level.SEVERE, null, ex); 
            
         }     
     
     // }     
     
     // }
    }

}
