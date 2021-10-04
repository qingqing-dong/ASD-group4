/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.MenuItem;
import com.mycompany.onlinefoodorderingsystem.model.Order;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author 47288
 */
public class OrderDao {

    
    private Statement st;
    public OrderDao(Connection conn) throws SQLException{
        st = conn.createStatement();
    }
    
    
    public void createOrder(int dishID,int customerID, int quantity,int amount,String orderDate) throws SQLException{
        String columns = "INSERT INTO ofos.`order` (`dishID`, `customerID`, quantity, amount, `orderDate`)";
        String values = "VALUES("+dishID+", "+customerID+","+quantity+","+amount+",'"+orderDate+"')";
        st.executeUpdate(columns+values);
    }
    
    public ArrayList<Order> listAllOrder() throws SQLException{
        String fetch = "SELECT * FROM ofos.`order`";
        ResultSet rs = st.executeQuery(fetch);
         ArrayList<Order> orderList = new ArrayList();
         while (rs.next()){
             int dishID = rs.getInt(2);
             int customer = rs.getInt(3);
             int quantity = rs.getInt(4);
             int amount = rs.getInt(5);
             String orderDate= rs.getString(6);
             orderList.add(new Order(dishID,customer,quantity,amount,orderDate));
         }
        return orderList;
    }
    
    public Order findOrder(int customerID) throws SQLException{
        String fetch = "SELECT * FROM ofos.`order` WHERE customerID = '"+customerID+"'";
        ResultSet rs = st.executeQuery(fetch);
         while (rs.next()){
         int customer = rs.getInt(3);

         if(customer ==customerID){
             int orderID = rs.getInt(1);
             int dishID = rs.getInt(2);
             int quantity = rs.getInt(4);
             int amount = rs.getInt(5);
             String orderDate= rs.getString(6);
             return new Order(orderID,dishID,customer,quantity,amount,orderDate);
         }
        }
        return null;
    }
    
    public void updateOrder(int dishID,int customerID,int quantity,int amount) throws SQLException{
        st.executeLargeUpdate("UPDATE ofos.`order` SET  quantity='"+quantity+"' , amount='"+amount+"' WHERE dishID ='"+dishID+"' and customerID = '"+customerID+"'");
       }
    
    public void deleteOrder(int dishID,int customerID) throws SQLException{
        st.executeUpdate("DELETE FROM ofos.`order` WHERE dishID = '"+dishID+"' and customerID='"+customerID+"'");
       }

    public boolean checkOrder(int dishID, int customerID) throws SQLException {
           String fetch ="SELECT * FROM ofos.`order` WHERE dishID = '"+dishID+"' and customerID= '"+customerID+"'";
           ResultSet rs = st.executeQuery(fetch);
           while(rs.next()){
               int id = rs.getInt(2);
               int cus = rs.getInt(3);
               if (id==dishID&& cus==customerID){
                   return true;
               }
           }
           return false;
       } 
    
}
