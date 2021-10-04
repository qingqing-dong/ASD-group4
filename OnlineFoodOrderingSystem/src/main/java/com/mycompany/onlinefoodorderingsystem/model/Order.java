/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.model;

import java.sql.Date;

/**
 *
 * @author 47288
 */
public class Order {
        private int ID;
        private int dishID;
        private int customerID;
        private int quantity;
        private int amount;
        private String orderDate;
        
        public Order(int ID,int dishID,int customerID,int quantity,int amount,String orderDate){
            this.ID=ID;
            this.dishID=dishID;
            this.customerID= customerID;
            this.quantity=quantity;
            this.amount=amount;
            this.orderDate=orderDate;
        }
        
        public Order(int dishID,int customerID,int quantity,int amount,String orderDate){
            this.dishID=dishID;
            this.customerID= customerID;
            this.quantity=quantity;
            this.amount=amount;
            this.orderDate=orderDate;

        }
        
        public Order(){
        }

   
        
        public void updateInfo(int ID,int dishID,int customerID,int quantity,int amount,String orderDate){
            this.ID=ID;
            this.dishID=dishID;
            this.customerID= customerID;
            this.quantity=quantity;
            this.amount=amount;
            this.orderDate=orderDate;
        }

    public int getID() {
        return ID;
    }

    public int getDishID() {
        return dishID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getQuantity() {
            return quantity;
        }

    public int getAmount() {
        return amount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }


        
        
        
}
