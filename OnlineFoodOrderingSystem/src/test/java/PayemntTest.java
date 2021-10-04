
import com.mycompany.onlinefoodorderingsystem.dao.DBConnector;

import com.mycompany.onlinefoodorderingsystem.dao.PaymentManager;
import com.mycompany.onlinefoodorderingsystem.model.Payment;

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
import org.mockito.Mock;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class PayemntTest {
    private DBConnector connector;
    private Connection conn;
    private PaymentManager db;
    public PayemntTest() throws ClassNotFoundException, SQLException{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new PaymentManager(conn);
    }
    
  /*  @Test
    public void testAdd() throws SQLException{
        db.createPayment(10,10,"visa","10/5/2021",20);
        assertTrue(db.checkPayment(10));
    }
    @Test
    public void testRead() throws SQLException{
         Payment list = db.readPayment(10,"10/5/2021");
         assertTrue(list != null);
    }*/
   /* @Test
    public void testUpdate() throws SQLException{
        db.updatePayment(10, 12, 555, "bankcard","01/11/2021",30);
        Payment payment = db.readPayment(10,"01/11/2021");
        assertTrue(payment.getAmount()==30&& payment.getCardnumber()==555&& payment.getPaymentMethod().equals("bankcard"));
    }*/
    
    /*@Test
    public void testDelete() throws SQLException{
        assertTrue(db.checkPayment(10));
        db.deletePayment(10);
        assertTrue(db.readPayment(10,"01/11/2021")==null);
    }*/
}
