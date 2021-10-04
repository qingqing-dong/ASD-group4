/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;
import com.mycompany.onlinefoodorderingsystem.dao.DBConnector;
import com.mycompany.onlinefoodorderingsystem.dao.OrderDao;


import java.util.logging.*;
import com.mycompany.onlinefoodorderingsystem.model.*;
import java.io.PrintStream;
import java.sql.Date;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author 47288
 */
public class testOrderDao {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private OrderDao db;
    
    public static void main (String [] agrs) throws ClassNotFoundException, SQLException{
        (new testOrderDao()).runQueries();;
    }
    
    public testOrderDao() throws ClassNotFoundException, SQLException{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new OrderDao(conn);
    }
    
    private char readChoice(){
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException{
        char c = readChoice();
        while(c!='*'){
            switch (c){
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                    break;    
                case 'S':
                    showAll();
                    break; 
                default: System.out.println("Unknow Command");
            }
        }
    }

    private void testAdd() throws SQLException {
        System.out.print("Dish ID:");
        int dishID = Integer.parseInt(in.nextLine());
        System.out.print("customer ID : ");
        int customerID = Integer.parseInt(in.nextLine());
        System.out.print("quantity: ");
        int quantity = Integer.parseInt(in.nextLine());
        System.out.print("amount: ");
        int amount = Integer.parseInt(in.nextLine());
        System.out.print("Order date: ");
        String date = in.nextLine();
        db.createOrder(dishID, customerID, quantity, amount,date);
        System.out.println("Device is add to the databse."); //To change body of generated methods, choose Tools | Templates.
    }

    private void testRead() throws SQLException {
        System.out.print("Device name: ");
        int customerID = Integer.parseInt(in.nextLine());
        Order order = db.findOrder(customerID);
        if(order != null ){
            System.out.println("order " + order.getID() + " exists in the database.");
        }
        else{
            System.out.println("Order does not exists.");
        }//To change body of generated methods, choose Tools | Templates.
    }

    private void testUpdate() throws SQLException {
        System.out.print("Dish ID:");
        int dishID = Integer.parseInt(in.nextLine());
        System.out.print("customer ID : ");
        int customerID = Integer.parseInt(in.nextLine()); 
          System.out.print("QUANTITY: ");
            int quantity = Integer.parseInt(in.nextLine());
             System.out.print("AMOUNT: ");
            int amount = Integer.parseInt(in.nextLine());
//To change body of generated methods, choose Tools | Templates.
         if(db.checkOrder(dishID, customerID)){
            
            db.updateOrder(dishID, customerID, quantity, amount);
        }
        else{System.out.println("Order does not exists.");}
    }

    private void testDelete() throws SQLException {
        System.out.print("Dish ID:");
        int dishID = Integer.parseInt(in.nextLine());
        System.out.print("customer ID : ");
        int customerID = Integer.parseInt(in.nextLine()); 
        //To change body of generated methods, choose Tools | Templates.
         if(db.checkOrder(dishID, customerID)){
            db.deleteOrder(dishID, customerID);
        }
        else{System.out.println("Device does not exists.");}
        
    }
        
    

    private void showAll() throws SQLException {
        PrintStream printf = System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n","paymentID","orderid", "cardnumber","paymentMethod","paymentdate", "amount" );
        ArrayList<Order>  list = db.listAllOrder();
        list.forEach(order->System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n"
                + "",order.getID(),order.getDishID(),order.getCustomerID(),order.getQuantity(),order.getAmount(),order.getOrderDate()));
        System.out.println();
        //To change body of generated methods, choose Tools | Templates.
    }
}


