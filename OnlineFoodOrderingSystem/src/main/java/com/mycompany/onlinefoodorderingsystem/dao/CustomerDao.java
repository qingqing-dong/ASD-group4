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
    
    private Connection conn;
    
    public CustomerDao() throws ClassNotFoundException, SQLException {
        conn = (new DBConnector()).openConnection();
    }

    public void updateCustomer(Customer customer) {
   
        String sql = "update customer set FIRSTNAME=?, LASTNAME=?, EMAIL=?, PASSWORD=?, GENDER=? , ADDRESS=?, PHONENUMBER=?  where CUSTOMER_ID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,customer.getFirstname());
            ps.setString(2,customer.getLastname());
            ps.setString(3,customer.getEmail());
            ps.setString(4,customer.getPassword());
            ps.setString(5,customer.getGender());
            ps.setString(6,customer.getAddress());
            ps.setString(7,customer.getPhone());
            ps.setInt(8,customer.getId());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } 

    }

    public Customer getCustomerById(int id){
       
        try {
            PreparedStatement ps = connection.prepareStatement("select * from customer where CUSTOMER_ID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("CUSTOMER_ID"));
                customer.setFirstname(rs.getString("FIRSTNAME"));
                customer.setLastname(rs.getString("LASTNAME"));
                customer.setEmail(rs.getString("EMAIL"));
                customer.setPassword(rs.getString("PASSWORD"));
                customer.setGender(rs.getString("GENDER"));
                customer.setAddress(rs.getString("ADDRESS"));
                customer.setPhone(rs.getString("PHONENUMBER"));
                return customer;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}