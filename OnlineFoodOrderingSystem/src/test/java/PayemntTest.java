
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
<<<<<<< Updated upstream
    
    /*@Test
    public void testAdd() throws SQLException{
        db.createPayment(10,10,"visa","10/5/2021",20);
        assertTrue(db.checkPayment(10));
    }*/
   /* @Test
=======
   @Test
>>>>>>> Stashed changes
    public void testRead() throws SQLException{
         Payment list = db.readPayment(25,"10/5/2021");
         assertTrue(list != null);
    }
    @Test
    public void testUpdate() throws SQLException{
        db.updatePayment(25, 12, 555, "visa","10/5/2021",30);
        Payment payment = db.readPayment(25,"10/5/2021");
        assertTrue(payment.getAmount()==30&& payment.getCardnumber()==555&& payment.getPaymentMethod().equals("visa"));
    }
    /*
    @Test
    public void testAdd() throws SQLException{
        db.createPayment(10,10,"visa","10/5/2021",20);
        assertTrue(db.checkPayment(25));
    }*/

    /*
    @Test
    public void testDelete() throws SQLException{
        assertTrue(db.checkPayment(25));
        db.deletePayment(25);
        assertTrue(db.readPayment(25,"01/11/2021")==null);
    }*/
}
