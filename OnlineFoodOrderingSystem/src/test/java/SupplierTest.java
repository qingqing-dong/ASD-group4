
import com.mycompany.onlinefoodorderingsystem.dao.DBConnector;
import com.mycompany.onlinefoodorderingsystem.dao.SupplierManager;
import com.mycompany.onlinefoodorderingsystem.model.Supplier;

import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class SupplierTest {
    private DBConnector connector;
    private Connection conn;
    private SupplierManager db;
    public SupplierTest() throws ClassNotFoundException, SQLException{
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new SupplierManager(conn);
    }
   /* 
    @Test
    public void testRead() throws SQLException{
         Supplier list = db.readSupplier("CCC");
         assertTrue(list != null);
    }
    @Test
    public void testUpdate() throws SQLException{
        db.updateSupplier(4,"Sunny","CCC",111,"u");
        Supplier supplier = db.readSupplier("CCC");
        assertTrue(supplier.getSupplierPhoneNum()==111&& supplier.getStatus().equals("u")&&supplier.getCompany().equals("CCC")&& supplier.getContactName().equals("Sunny"));
    }*/
    /*
    @Test
    public void testAdd() throws SQLException{
        db.createSupplier("Zelene","CCC",123,"a");
        assertTrue(db.checkSupplier(6));
    }*/

    /*
    @Test
    public void testDelete() throws SQLException{
        assertTrue(db.checkPayment(25));
        db.deletePayment(25);
        assertTrue(db.readPayment(25,"01/11/2021")==null);
    }*/
}
