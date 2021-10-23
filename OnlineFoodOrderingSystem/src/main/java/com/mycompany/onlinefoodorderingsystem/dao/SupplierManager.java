/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;


import com.mycompany.onlinefoodorderingsystem.model.Supplier;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SupplierManager {
    private Statement st;
    ArrayList<Supplier> temp = new ArrayList();
    public SupplierManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    //Create a Supplier
    public void createSupplier(String ContactName, String Company, int SupplierPhoneNum,String Status) throws SQLException{
        String columns = "INSERT INTO OFOS.SUPPLIER(CONTACTNAME,COMPANY,SUPPLIERPHONENUM,STATUS)";
        String values = "VALUES('"+ContactName+"','"+Company+"',"+SupplierPhoneNum+",'"+Status+"')";
        st.executeUpdate(columns+values);
    }
    //Read Supplier by Company
     public Supplier readSupplier(String company) throws SQLException {
        String fetch = "SELECT * FROM OFOS.SUPPLIER WHERE COMPANY='" + company + "'";//read from where company =

        ResultSet rs = st.executeQuery(fetch);

        while (rs.next()) {
            String Company = rs.getString(3);
            

            if (company.equals(Company) ) {
                String contactname =  rs.getString(2);
                int supplierid = Integer.parseInt(rs.getString(1));
                int supplierphonenumber = Integer.parseInt(rs.getString(4));
                String status =  rs.getString(5);

                return new Supplier(supplierid,contactname, company,supplierphonenumber,status);
            }
        }
        return null;
    }
     
     public  Supplier getRecordById(int SupplierID){  
         try{
    
        String getp = "SELECT * FROM OFOS.SUPPLIER WHERE SUPPLIERID=" + SupplierID + "";
  
        ResultSet rs=st.executeQuery(getp);  
        while(rs.next()){  
           
            int supplierID = Integer.parseInt(rs.getString(1));
            if (supplierID == SupplierID) {
               
                String contactname =  rs.getString(2);
                String company =  rs.getString(3);
                int supplierphonenumber = Integer.parseInt(rs.getString(4));
                String status =  rs.getString(5);
                return new Supplier(supplierID,contactname, company,supplierphonenumber,status);
            }  
        }
         }catch(Exception e){System.out.println(e);}  
         return null;
}  
     
     
    //Update supplier by supplierid 
    public void updateSupplier(int SupplierID, String ContactName, String Company, int SupplierPhoneNum,String Status) throws SQLException {
        String update = "UPDATE OFOS.SUPPLIER SET CONTACTNAME='" + ContactName + "',COMPANY='" + Company + "', SUPPLIERPHONENUM="+SupplierPhoneNum+",STATUS='"+Status+"' WHERE SUPPLIERID="+ SupplierID +"";
    }
    //delete supplier by supplierid
    public void deleteSupplier(int ID) throws SQLException {
        String delete = "DELETE FROM OFOS.SUPPLIER WHERE SUPPLIERID=" + ID + "";
        st.executeUpdate(delete);
    }
    
     //Fetch all Suppliers from the database [i.e used when displaying a table on the view]
    public ArrayList<Supplier> fecthSuppliers() throws SQLException {
        String fetch = "select * from OFOS.SUPPLIER";
        ResultSet rs = st.executeQuery(fetch);
        

        while (rs.next()) {
            
            int supplierID = Integer.parseInt(rs.getString(1));
            String contactname =  rs.getString(2);
            String company =  rs.getString(3);
            int supplierphonenumber = Integer.parseInt(rs.getString(4));
            String status =  rs.getString(5);
            temp.add(new Supplier(supplierID,contactname,company,supplierphonenumber,status));
        }
        return temp;
    }
    
    public boolean checkSupplier(int SupplierID) throws SQLException{
           String fetch ="SELECT * FROM OFOS.SUPPLIER WHERE SUPPLIERID=" + SupplierID + "";
           ResultSet rs = st.executeQuery(fetch);
           
           while(rs.next()){
               int ID = Integer.parseInt(rs.getString(1));
              
               if (ID == SupplierID){
                   return true;
               }
           }
           return false;
       }
    
}
