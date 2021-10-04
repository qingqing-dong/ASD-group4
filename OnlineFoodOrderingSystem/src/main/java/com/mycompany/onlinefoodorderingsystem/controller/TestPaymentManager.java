/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.DBConnector;
import com.mycompany.onlinefoodorderingsystem.dao.PaymentManager;
import com.mycompany.onlinefoodorderingsystem.model.Payment;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TestPaymentManager {
     public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestPaymentManager().menu();
    }
    private  DBConnector connector;
    private  Connection conn;
    private  PaymentManager manager;
    
    public TestPaymentManager() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        manager = new PaymentManager(conn);
    }
    
    private void testCreate() throws SQLException {
         System.out.println("Enter the order id:");
        int orderid = Integer.parseInt(read("orderid"));
         System.out.println("Enter the card number: ");
        int cardnumber = Integer.parseInt(read("cardnumber"));
        System.out.println("Enter the amount: ");
        double amount = Double.parseDouble(read("amount"));
        System.out.println("Enter the payment method: ");
        String paymentmethod = read("PaymentMethod");
        System.out.println("Enter the paymentdate: ");
        String paymentdate = read("paymentdate");
        System.out.println("Adding payment to the database ");
        manager.createPayment(orderid,cardnumber,paymentmethod,paymentdate,amount);
        System.out.println("Payment added successfully ");
    }
    
    private void testRead() throws SQLException{
        int ID = Integer.parseInt(read("ID"));
        String date = read("DATE");
        Payment payment = manager.readPayment(ID, date);
        String exist = (payment != null) ? "Payment exists in the database" : "Payment does not exist!!!";
        System.out.println(exist);
    }

    private void testUpdate() throws SQLException{
         System.out.println("Enter the payment id:");
        int paymentID = Integer.parseInt(read("paymentID"));
         System.out.println("Enter the date:");
         String date = read("DATE");
         
          System.out.println("update the orderid:");
        int orderid = Integer.parseInt(read("orderid"));
        System.out.println("update the amount:");
        double amount = Double.parseDouble(read("amount"));
        System.out.println("update the paymentmethod:");
        String paymentmethod =  read("PaymentMethod");
        System.out.println("update the cardnumber:");
        int cardnumber = Integer.parseInt(read("cardnumber"));
       
        manager.updatePayment(paymentID, orderid,cardnumber,paymentmethod, date,amount);
        System.out.println("Payment details updated successfully ");
        System.out.println();
    }
    
    private void testDelete() throws SQLException{
        int ID = Integer.parseInt(read("ID"));
        manager.deletePayment(ID);
        System.out.println("Payment deleted successfully");
    }
    
    private void testFetch() throws SQLException{
        PrintStream printf = System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n","paymentID","orderid", "cardnumber","paymentMethod","paymentdate", "amount" );
        ArrayList<Payment> payments = manager.fecthPayments();
        payments.forEach(payment->System.out.printf("%-15s %-15s %-25s %-15s %-15s %-10s \n"
                + "",payment.getPaymentID(),payment.getOrderID(),payment.getCardnumber(),payment.getPaymentMethod(),payment.getPaymentDate(),payment.getAmount()));
        System.out.println();
    }
    
    private String read(String prompt) {
        System.out.print(prompt + ": ");
        return in.nextLine();
    }
    private void menu() throws SQLException{
        char c;
        help();
        while((c=read("Command [c/r/u/d/f/x]").charAt(0)) != 'x'){
            switch(c){
                case 'c': testCreate();break;
                case 'r': testRead(); break;
                case 'u': testUpdate(); break;
                case 'd': testDelete();break;
                case 'f': testFetch();break;
                default: help(); break;
            }
        }
    }
    private void help(){
        System.out.println("Database Operations: \n"
                + "c = Create Payment \n"
                + "r = Read Payment by paymentID-date \n"
                + "u = Update Payment by paymentID \n"
                + "d = Delete Payment by paymentID\n"
                + "f = Fetch all Payments\n");
    }
    
}
