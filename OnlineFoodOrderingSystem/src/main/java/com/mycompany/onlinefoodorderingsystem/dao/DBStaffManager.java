/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.Staff;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Xin Chen
 */
public class DBStaffManager {
    
    private Statement st;

    public DBStaffManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

//Find user by email and password in the database   
    public Staff findStaff(String email, String password) throws SQLException {
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters               
        String fetch = "SELECT * FROM ofos.staff WHERE EMAIL='" + email + "' AND PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String staffEmail = rs.getString(4);
            String staffPassword = rs.getString(5);
            if (staffEmail.equals(email) && staffPassword.equals(password)) {
                int staffID = rs.getInt(1);
                String staffFirstName = rs.getString(2);
                String staffLastName = rs.getString(3);
                String staffGender = rs.getString(6);
                String staffAddress = rs.getString(7);
                String staffPhone = rs.getString(8);
                String position = rs.getString(9);
                return new Staff(staffID, staffFirstName, staffLastName, staffEmail, staffPassword, staffGender, staffAddress, staffPhone, position);
            }
        }
        return null;
    }

//Add a user-data into the database   
    public void addStaff(String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber, String position) throws SQLException {                   //code for add-operation       
        st.executeUpdate("INSERT INTO ofos.staff (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, GENDER, ADDRESS, PHONENUMBER, POSITION) " + "VALUES('" + firstName + "','" + lastName + "','" + eMail + "','" + password + "','" + gender + "','" + address + "','" + phoneNumber + "','" + position + "')");
    }

//update a user details in the database   
    public void updateStaff(String userID, String firstName, String lastName, String eMail, String password, String gender, String address, String phoneNumber, String position) throws SQLException {
        //code for update-operation   
        st.executeUpdate("UPDATE ofos.staff SET FIRSTNAME='" + firstName + "', LASTNAME='" + lastName + "',EMAIL='" + eMail + "',PASSWORD='" + password + "',GENDER='" + gender + "',ADDRESS='" + address + "', PHONENUMBER='" + phoneNumber + "', POSITION='" + position + "' WHERE ID=" + userID + "");
    }

//delete a user from the database   
    public void deleteStaff(String userID) throws SQLException {
        //code for delete-operation   
        st.executeUpdate("DELETE FROM ofos.staff WHERE USERID=" + userID + "");
    }

    public ArrayList<Staff> fetchStaffs() throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM ofos.staff");
        ArrayList<Staff> staffs = new ArrayList();

        while (rs.next()) {
            int staffID = rs.getInt(1);
            String staffFirstName = rs.getString(2);
            String staffLastName = rs.getString(3);
            String staffEmail = rs.getString(4);
            String staffPassword = rs.getString(5);
            String staffGender = rs.getString(6);
            String staffAddress = rs.getString(7);
            String staffPhone = rs.getString(8);
            String position = rs.getString(9);
            staffs.add(new Staff(staffID, staffFirstName, staffLastName, staffEmail, staffPassword, staffGender, staffAddress, staffPhone, position));
        }
        return staffs;
    }

    public boolean checkStaff(String userID) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM ofos.staff WHERE USERID=" + userID + "");
        if (rs.next()) {
            return true;
        }
        return false;
    }

    
}
