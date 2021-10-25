package com.mycompany.onlinefoodorderingsystem.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String eMail;
    private String gender;
    private String phoneNumber;
    private String password;
    

    public Customer(){}
    
    public Customer(int id, String firstName, String lastName, String eMail, String gender, String address,String phoneNumber, String password){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void seteMail(String eMail){
        this.eMail = eMail;
    }
    
    public String geteMail(){
        return eMail;
    }
    
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhoneNumber(){
        return phoneNumber;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
}
