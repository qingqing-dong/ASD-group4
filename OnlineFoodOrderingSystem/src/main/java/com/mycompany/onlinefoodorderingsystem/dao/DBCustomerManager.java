/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Xin Chen
 */
public class DBCustomerManager {
    
    Statement st;

    public DBCustomerManager(Connection conn) throws SQLException {
        this.st = conn.createStatement();
    }


//Find user by email and password in the database   
    public Customer findCustomer(String email, String password) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               
        String fetch = "SELECT * FROM customer WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String customerEmail = rs.getString(4);
            String customerPassword = rs.getString(5);
            if (customerEmail.equals(email) && customerPassword.equals(password)) {
                int customerID = rs.getInt(1);
                String customerFirstName = rs.getString(2);
                String customerLastName = rs.getString(3);
                String customerGender = rs.getString(6);
                String customerAddress = rs.getString(7);
                String customerPhone = rs.getString(8);
                return new Customer(customerID, customerFirstName, customerLastName, customerEmail, customerPassword, customerGender, customerAddress, customerPhone);
            }
        }
        return null;
    }
    
    //get customer through ID
   public Customer getCustomerById(int id) throws SQLException{
      
        String fetch ="select * from customer where CUSTOMER_ID="+id;
        ResultSet rs = st.executeQuery(fetch);
        if(rs.next()){
            Customer customer = new Customer();
            customer.setId(rs.getInt("CUSTOMER_ID"));
            customer.setFirstName(rs.getString("FIRSTNAME"));
            customer.setLastName(rs.getString("LASTNAME"));
            customer.seteMail(rs.getString("EMAIL"));
            customer.setPassword(rs.getString("PASSWORD"));
            customer.setGender(rs.getString("GENDER"));
            customer.setAddress(rs.getString("ADDRESS"));
            customer.setPhoneNumber(rs.getString("PHONENUMBER"));
            return customer;
        }
           
        return null;
    }

//Add a user-data into the database   
    public void addCustomer(String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO ofos.customer (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GENDER, ADDRESS, PHONENUMBER) " + "VALUES('" + firstName + "','" + lastName + "','" + eMail + "','" + password + "','" + gender + "','" + address + "','" + phoneNumber + "')");
    }

//update a user details in the database   
    public void updateCustomer(String userID, String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE customer SET FIRSTNAME='" + firstName + "', LASTNAME='" + lastName + "',EMAIL='" + eMail + "',PASSWORD='" + password + "',GENDER='" + gender + "',ADDRESS='" + address + "', PHONENUMBER='" + phoneNumber + "' WHERE USERID=" + userID + "");
    }

//delete a user from the database   
    public void deleteCustomer(String userID) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELETE FROM customer WHERE USERID=" + userID + "");
    }

    public ArrayList<Customer> fetchCustomers() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM customer");
        ArrayList<Customer> customers = new ArrayList();

        while (rs.next()) {
            int customerID = rs.getInt(1);
            String customerFirstName = rs.getString(2);
            String customerLastName = rs.getString(3);
            String customerEmail = rs.getString(4);
            String customerPassword = rs.getString(5);
            String customerGender = rs.getString(6);
            String customerAddress = rs.getString(7);
            String customerPhone = rs.getString(8);
            boolean subscription = rs.getBoolean(9);
            customers.add(new Customer(customerID, customerFirstName, customerLastName, customerEmail, customerPassword, customerGender, customerAddress, customerPhone));
        }
        return customers;
    }

    public boolean checkCustomer(String userID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM customer WHERE USERID=" + userID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }
}
