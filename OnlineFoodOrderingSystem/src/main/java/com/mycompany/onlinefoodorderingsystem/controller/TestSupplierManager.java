/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.DBConnector;
import com.mycompany.onlinefoodorderingsystem.dao.SupplierManager;


import com.mycompany.onlinefoodorderingsystem.model.Supplier;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class TestSupplierManager {
    public static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new TestSupplierManager().menu();
    }
    private  DBConnector connector;
    private  Connection conn;
    private  SupplierManager manager;
    
    public TestSupplierManager() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        manager = new SupplierManager(conn);
    }
    
    private void testCreate() throws SQLException {
         
         System.out.println("Enter the contact name: ");
         String contactname = read("contactname");
         System.out.println("Enter the Company: ");
         String company = read("company");
         System.out.println("Enter the phone number: ");
         int phonenumber = Integer.parseInt(read("phonenumber"));
        System.out.println("Enter the status: ");
        String status = read("status");
        System.out.println("Adding supplier to the database ");
        manager.createSupplier(contactname,company,phonenumber,status);
        System.out.println("Supplier added successfully ");
    }
    
    private void testRead() throws SQLException{
        String company = read("company");
       
        Supplier supplier = manager.readSupplier(company);
        String exist = (supplier != null) ? "Payment exists in the database" : "Supplier does not exist!!!";
        System.out.println(exist);
    }

    private void testUpdate() throws SQLException{
        System.out.println("Enter the SupplierID: ");
         int ID = Integer.parseInt(read("ID"));
          System.out.println("Update the contact name: ");
         String contactname = read("contactname");
         System.out.println("Update the Company: ");
         String company = read("company");
         System.out.println("Update the phone number: ");
         int phonenumber = Integer.parseInt(read("phonenumber"));
        System.out.println("Update the status: ");
        String status = read("status");
        System.out.println("Update supplier to the database ");
       
        manager.updateSupplier(ID, contactname,company,phonenumber, status);
        System.out.println("Supplier details updated successfully ");
        System.out.println();
    }
    
    private void testDelete() throws SQLException{
        int ID = Integer.parseInt(read("ID"));
        manager.deleteSupplier(ID);
        System.out.println("Supplier deleted successfully");
    }
    
    private void testFetch() throws SQLException{
        PrintStream printf = System.out.printf("%-15s %-15s %-25s %-15s %-15s \n","supplierID","contactname", "company","phonenumber","status" );
        ArrayList<Supplier> suppliers = manager.fecthSuppliers();
        suppliers.forEach(supplier->System.out.printf("%-15s %-15s %-25s %-15s %-15s \n"
                + "",supplier.getSupplierID(),supplier.getContactName(),supplier.getCompany(),supplier.getSupplierPhoneNum(),supplier.getStatus()));
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
                + "c = Create Supplier \n"
                + "r = Read Supplier by supplierID \n"
                + "u = Update Supplier by supplierID \n"
                + "d = Delete Supplier by supplierID\n"
                + "f = Fetch all Suppliers\n");
    }
    
}
