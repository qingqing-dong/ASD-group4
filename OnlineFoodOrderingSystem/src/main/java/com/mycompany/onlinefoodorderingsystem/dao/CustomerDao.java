package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerDao extends BaseDao {
    

    public void updateCustomer(Customer customer) {
   
        String sql = "update customer set FIRSTNAME=?, LASTNAME=?, EMAIL=?, PASSWORD=?, GENDER=? , ADDRESS=?, PHONENUMBER=?  where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,customer.getFirstName());
            ps.setString(2,customer.getLastName());
            ps.setString(3,customer.geteMail());
            ps.setString(4,customer.getPassword());
            ps.setString(5,customer.getGender());
            ps.setString(6,customer.getAddress());
            ps.setString(7,customer.getPhoneNumber());
            ps.setInt(8,customer.getId());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } 

    }
    
    public Customer findCustomer(String email, String password) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'");
        ResultSet rs = ps.executeQuery();

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
 
    public Customer getCustomerById(int id){
       
        try {
            PreparedStatement ps = connection.prepareStatement("select * from customer where id=" + id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("FIRSTNAME"));
                customer.setLastName(rs.getString("LASTNAME"));
                customer.seteMail(rs.getString("EMAIL"));
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setGender(rs.getString("GENDER"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setPhoneNumber(rs.getString("PHONENUMBER"));
                return customer;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}