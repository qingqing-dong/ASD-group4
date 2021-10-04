/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.PaymentManager;
import com.mycompany.onlinefoodorderingsystem.model.Payment;
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
@WebServlet(name = "UpdatePaymentServlet", urlPatterns = {"/UpdatePaymentServlet"})
public class UpdatepaymentServlet extends HttpServlet {
 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int PaymentID = Integer.parseInt(request.getParameter("PaymentID"));
        int orderid = Integer.parseInt(request.getParameter("orderid"));
        String date = request.getParameter("date");
        String paymentmethod = request.getParameter("paymentmethod");
        int cardnumber = Integer.parseInt(request.getParameter("cardnumber"));
        int amount = Integer.parseInt(request.getParameter("amount"));
        PaymentManager paymentManager = (PaymentManager) session.getAttribute("paymentManager");
      
       
     
       // Validator validator = new Validator();
       // validator.clear(session);
        /* if(!validator.validateDate(date)){
            session.setAttribute("dateErr","Date format incorrect");
            request.getRequestDispatcher("findpayment.jsp").include(request, response);
            
        }else{*/
        try{
                Payment payment = new Payment(PaymentID,orderid,cardnumber,paymentmethod,date,amount);
                if (payment != null) {
                session.setAttribute("payment", payment);
                paymentManager.updatePayment(PaymentID,orderid,cardnumber,paymentmethod,date,amount);
                session.setAttribute("resultInfor", "Update was successful");
                request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
            } else {
                session.setAttribute("resultInfor", "Update was not successful!");
                request.getRequestDispatcher("viewsearchpayment.jsp").include(request, response);
            }
           
        }catch (SQLException ex){
            Logger.getLogger(UpdatepaymentServlet.class.getName()).log(Level.SEVERE, null, ex); 
            
         }     
     
      }
  //  }

}
