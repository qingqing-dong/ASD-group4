/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.onlinefoodorderingsystem.dao.DBConnector;
import com.mycompany.onlinefoodorderingsystem.dao.MenuDao;
import com.mycompany.onlinefoodorderingsystem.dao.OrderDao;
import com.mycompany.onlinefoodorderingsystem.model.MenuItem;
import com.mycompany.onlinefoodorderingsystem.model.Order;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.Test;


/**
 *
 * @author 47288
 */
public class OrderTest {
    private DBConnector connector;
    private Connection conn;
    private OrderDao db;
    public OrderTest() throws ClassNotFoundException, SQLException{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new OrderDao(conn);
    }
    
        @Test
    public void testAdd() throws SQLException{
        db.createOrder(1001,101,5,50,"10/5/2021");
        assertTrue(db.checkOrder(1001,101));
    }
    
    
     @Test
    public void testRead() throws SQLException{
         Order list = db.findOrder(101);
         assertTrue(list != null);
    }
    
    public void testUpdate() throws SQLException{
        db.updateOrder(1001, 101, 10, 100);
        Order order = db.findOrder(101);
        assertTrue(order.getAmount()!=100 && order.getQuantity()==10);
    }
    
    @Test
    public void testDelete() throws SQLException{
        db.deleteOrder(1001, 101);
        assertTrue(db.checkOrder(1002,101)==false);
    }
    
   
    
  
    
}
