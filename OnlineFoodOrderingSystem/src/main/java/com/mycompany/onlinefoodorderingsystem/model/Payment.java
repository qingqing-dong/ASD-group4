/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.model;

/**
 *
 * @author ADMIN
 */
public class Payment {
     private int PaymentID;
    
    private int OrderID;
    private String PaymentMethod;
    private int cardnumber;
    private double amount;
    private String PaymentDate;
    
    public Payment(){}

    public Payment(int OrderID,int cardnumber,String PaymentMethod,String PaymentDate,double amount) {
        this.OrderID = OrderID;
      
        this.PaymentMethod = PaymentMethod;
        this.cardnumber = cardnumber;
        this.amount = amount;
        this.PaymentDate = PaymentDate;
    
    }
    
    public Payment(int PaymentID,int OrderID, int cardnumber,String PaymentMethod,String PaymentDate,double amount) {
        this.PaymentID = PaymentID;
         this.OrderID = OrderID;
       
        this.PaymentMethod = PaymentMethod;
        this.cardnumber = cardnumber;
        this.amount = amount;
        this.PaymentDate = PaymentDate;
    }

    public void updateInfo(int OrderID,int cardnumber,String PaymentMethod,String PaymentDate,double amount) {
        this.OrderID = OrderID;
       
        this.PaymentMethod = PaymentMethod;
        this.cardnumber = cardnumber;
        this.amount = amount;
        this.PaymentDate = PaymentDate;
    }

    public int getPaymentID() {
        return PaymentID;
    }

    public void setPaymentID(int PaymentID) {
        this.PaymentID = PaymentID;
    }


    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getPaymentMethod() {
        return PaymentMethod;
    }

    public void setPaymentMethod(String PaymentMethod) {
        this.PaymentMethod = PaymentMethod;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return PaymentDate;
    }

    public void setPaymentDate(String PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

   
    
}
