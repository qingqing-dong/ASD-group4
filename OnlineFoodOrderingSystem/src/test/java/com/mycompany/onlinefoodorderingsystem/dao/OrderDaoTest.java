/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.Order;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 47288
 */
public class OrderDaoTest {
    
    private DBConnector connector;
    private Connection conn;
    private OrderDao db;
    public OrderDaoTest() throws ClassNotFoundException, SQLException {
        connector = new DBConnector();
        conn = connector.openConnection();
        db = new OrderDao(conn);
    }
   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createOrder method, of class OrderDao.
     */
    @Test
    public void testAdd() throws SQLException {
        db.createOrder(1001, 101, 5, 50, "10/5/2021");
        assertTrue(db.checkOrder(1001, 101));
    }
    
    
    @Test
    public void testRead() throws SQLException {
        Order list = db.findOrder(101);
        assertTrue(list != null);
    }
    @Test
    public void testDelete() throws SQLException {
       
        db.deleteOrder(1001, 101);
        assertTrue(db.findOrder(101)==null);
    }
    
}
