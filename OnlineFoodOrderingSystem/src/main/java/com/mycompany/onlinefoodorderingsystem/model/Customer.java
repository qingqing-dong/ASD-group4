package com.mycompany.onlinefoodorderingsystem.model;

public class Customer {
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String gender;
    private String phoneNumber;
    private String password;
    

    public Customer(){}
    
    public Customer(int id, String firstname, String lastname, String email, String gender, String address,String phoneNumber, String password){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
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
    
    public void setPhone(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public String getPhone(){
        return phoneNumber;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
}
