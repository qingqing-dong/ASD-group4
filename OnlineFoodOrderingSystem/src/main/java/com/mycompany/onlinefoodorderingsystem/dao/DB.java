/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;

import java.sql.Connection;

/**
 * Super class of DAO classes that stores the database information
 *
 */
public abstract class DB {

    protected String URL = "jdbc:mysql://localhost:3306/";//replace this string with your jdbc:derby local host url   
    protected String db = "ofos";//name of the database   
    protected String dbuser = "root";//db root user   
    protected String dbpass = "00000"; //db root password   
    protected String driver = "com.mysql.jdbc.Driver"; //jdbc client driver - built in with NetBeans   
    protected Connection conn; //connection null-instance to be initialized in sub-classes
    
}
