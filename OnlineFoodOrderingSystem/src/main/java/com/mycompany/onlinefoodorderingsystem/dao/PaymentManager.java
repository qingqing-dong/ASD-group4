/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mycompany.onlinefoodorderingsystem.model.Payment;

/**
 *
 * @author ADMIN
 */
public class PaymentManager {
    private Statement st;
    ArrayList<Payment> temp = new ArrayList();
    public PaymentManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    //Create a Payment
    public void createPayment(int OrderID,int cardnumber,String PaymentMethod,String PaymentDate,double amount) throws SQLException{
        String columns = "INSERT INTO OFOS.PAYMENT(ORDERID,CARDNUMBER,PAYMENTMETHOD,PAYMENTDATE,AMOUNT)";
        String values = "VALUES("+OrderID+","+cardnumber+",'"+PaymentMethod+"','"+PaymentDate+"',"+amount+")";
        st.executeUpdate(columns+values);
    }
    //Read Payment by paymentID and date
     public Payment readPayment(int PaymentID, String PaymentDate) throws SQLException {
        String fetch = "SELECT * FROM OFOS.PAYMENT WHERE PAYMENTID=" + PaymentID + " AND PAYMENTDATE='" + PaymentDate + "'";//read from where paymentID = and date = 

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            int paymentID = Integer.parseInt(rs.getString(1));
            String paymentdate = rs.getString(5);

            if (paymentID == PaymentID && paymentdate.equals(paymentdate)) {
                int orderid = Integer.parseInt(rs.getString(2));
               
                String paymentMethod = rs.getString(4);
                int cardnumber = Integer.parseInt(rs.getString(3));
                double amount = Integer.parseInt(rs.getString(6));

                return new Payment(paymentID, orderid,cardnumber,paymentMethod, paymentdate, amount);
            }
        }
        return null;
    }
     
     public  Payment getRecordById(int PaymentID){  
         try{
    
        String getp = "SELECT * FROM OFOS.PAYMENT WHERE PAYMENTID=" + PaymentID + "";
  
        ResultSet rs=st.executeQuery(getp);  
        while(rs.next()){  
           
            int paymentID = Integer.parseInt(rs.getString(1));
            if (paymentID == PaymentID) {
               int orderid = Integer.parseInt(rs.getString(2));
                String paymentdate = rs.getString(5);
                String paymentMethod = rs.getString(4);
                int cardnumber = Integer.parseInt(rs.getString(3));
                double amount = Integer.parseInt(rs.getString(6));
                return new Payment(paymentID, orderid,cardnumber,paymentMethod, paymentdate, amount);
            }  
        }
         }catch(Exception e){System.out.println(e);}  
         return null;
}  
     
     
    //Update payment by paymentID and date
    public void updatePayment(int PaymentID,int OrderID,int cardnumber,String PaymentMethod,String PaymentDate,double amount) throws SQLException {
        String update = "UPDATE OFOS.PAYMENT SET PAYMENTMETHOD='" + PaymentMethod + "',CARDNUMBER=" + cardnumber + ", AMOUNT="+amount+" WHERE PAYMENTID=" + PaymentID + " AND PAYMENTDATE='" + PaymentDate + "'";
        st.executeUpdate(update);
    }
    //delete payment by paymentID
    public void deletePayment(int ID) throws SQLException {
        String delete = "DELETE FROM OFOS.PAYMENT WHERE PAYMENTID=" + ID + "";
        st.executeUpdate(delete);
    }
    
     //Fetch all Payments from the database [i.e used when displaying a table on the view]
    public ArrayList<Payment> fecthPayments() throws SQLException {
        String fetch = "select * from OFOS.PAYMENT";
        ResultSet rs = st.executeQuery(fetch);
        

        while (rs.next()) {
            
            int ID = Integer.parseInt(rs.getString(1));
            int orderid = Integer.parseInt(rs.getString(2));
             String paymentdate = rs.getString(5);
             String paymentMethod = rs.getString(4);
             int cardnumber = Integer.parseInt(rs.getString(3));
             double amount = Integer.parseInt(rs.getString(6));
            temp.add(new Payment(ID,orderid,cardnumber,paymentMethod,paymentdate,amount));
        }
        return temp;
    }
    
    public boolean checkPayment(int PaymentID) throws SQLException{
           String fetch ="SELECT * FROM OFOS.PAYMENT WHERE PAYMENTID=" + PaymentID + "";
           ResultSet rs = st.executeQuery(fetch);
           
           while(rs.next()){
               int ID = Integer.parseInt(rs.getString(1));
              
               if (ID == PaymentID){
                   return true;
               }
           }
           return false;
       }
}
