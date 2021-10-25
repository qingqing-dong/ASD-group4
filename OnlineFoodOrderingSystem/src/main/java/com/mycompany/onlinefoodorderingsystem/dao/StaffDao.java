package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.Staff;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaffDao extends BaseDao {
    

    public void updateStaff(Staff staff) {
   
        String sql = "update staff set FIRSTNAME=?, LASTNAME=?, EMAIL=?, PASSWORD=?, GENDER=? , ADDRESS=?, PHONENUMBER=?, POSITION=?  where id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,staff.getFirstName());
            ps.setString(2,staff.getLastName());
            ps.setString(3,staff.geteMail());
            ps.setString(4,staff.getPassword());
            ps.setString(5,staff.getGender());
            ps.setString(6,staff.getAddress());
            ps.setString(7,staff.getPhoneNumber());
            ps.setString(8,staff.getPosition());
            ps.setInt(9,staff.getId());
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        } 

    }
 
    public Staff getStaffById(int id){
       
        try {
            PreparedStatement ps = connection.prepareStatement("select * from staff where id=" + id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Staff staff = new Staff();
                staff.setId(rs.getInt("id"));
                staff.setFirstName(rs.getString("FIRSTNAME"));
                staff.setLastName(rs.getString("LASTNAME"));
                staff.seteMail(rs.getString("EMAIL"));
                staff.setPassword(rs.getString("PASSWORD"));
                staff.setGender(rs.getString("GENDER"));
                staff.setAddress(rs.getString("ADDRESS"));
                staff.setPhoneNumber(rs.getString("PHONENUMBER"));
                staff.setPosition(rs.getString("POSITION"));
                
                return staff;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Staff findStaff(String email, String password) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               

        PreparedStatement ps = connection.prepareStatement("SELECT * FROM staff WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String customerEmail = rs.getString(4);
            String customerPassword = rs.getString(5);
            if (customerEmail.equals(email) && customerPassword.equals(password)) {
                
                int id = rs.getInt(1);
                String FirstName = rs.getString(2);
                String LastName = rs.getString(3);
                String Gender = rs.getString(6);
                String Address = rs.getString(7);
                String Phone = rs.getString(8);
                String Position = rs.getString(9);
                Staff staff = new Staff(id, FirstName, LastName, email, password, Gender, Address, Phone, Position);
                return staff;
            }
        }
        return null;
    }
}