/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class Validator {
    
   private String emailPattern = "([a-zA-Z0-9]+)(([._-])([a-zA-Z0-9]+))*(@)([a-z]+)(.)([a-z]{3})((([.])[a-z]{0,2})*)";      
   private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
   private String passwordPattern = "[a-z0-9]{4,}";       
         
     private String datePattern = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";    
   
   public Validator(){    }       

    
   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       
      return match.matches(); 
   }       

   public boolean checkEmpty(String email, String password){       

      return  email.isEmpty() || password.isEmpty();   
   }
   
   public boolean validateDate(String date){

      return validate(datePattern,date); 

   }     
   
   public boolean validateEmail(String email){                       
      return validate(emailPattern,email);   
   } 
   
   
   
   
       
   public boolean validateName(String name){
      return validate(namePattern,name); 
   }       
   

   public boolean validatePassword(String password){
      return validate(passwordPattern,password); 
   }          
  
   public void clear(HttpSession session){
       session.setAttribute("typeErr", "Enter type");
       session.setAttribute("priceErr", "Enter price");
       
       session.setAttribute("existErr", "");
       session.setAttribute("resultInfor", "");
   }
    
}