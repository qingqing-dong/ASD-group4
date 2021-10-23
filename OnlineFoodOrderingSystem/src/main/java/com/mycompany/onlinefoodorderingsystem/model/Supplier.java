/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.model;

/**
 *
 * @author ADMIN
 */
public class Supplier {
    private int SupplierID;
    private String ContactName;
    private String Company;
    private int SupplierPhoneNum;
    private String Status;
    
    public Supplier(){}
    
    public Supplier(int SupplierID, String ContactName, String Company, int SupplierPhoneNum,String Status){
        this.SupplierID = SupplierID;
        this.ContactName = ContactName;
        this.Company = Company;
        this.SupplierPhoneNum = SupplierPhoneNum;
        this.Status = Status;
    }
    
    public Supplier(String ContactName, String Company, int SupplierPhoneNum,String Status){
        
        this.ContactName = ContactName;
        this.Company = Company;
        this.SupplierPhoneNum = SupplierPhoneNum;
        this.Status = Status;
    }
    
    public void updateInfo(String ContactName, String Company, int SupplierPhoneNum,String Status) {
        this.ContactName = ContactName;
        this.Company = Company;
        this.SupplierPhoneNum = SupplierPhoneNum;
        this.Status = Status;
    }

    public int getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(int SupplierID) {
        this.SupplierID = SupplierID;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String ContactName) {
        this.ContactName = ContactName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public int getSupplierPhoneNum() {
        return SupplierPhoneNum;
    }

    public void setSupplierPhoneNum(int SupplierPhoneNum) {
        this.SupplierPhoneNum = SupplierPhoneNum;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}
