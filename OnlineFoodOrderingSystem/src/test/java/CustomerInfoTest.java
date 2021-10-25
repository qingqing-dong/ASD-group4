/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.onlinefoodorderingsystem.dao.CustomerDao;
import com.mycompany.onlinefoodorderingsystem.dao.DBCustomerManager;
import com.mycompany.onlinefoodorderingsystem.model.Customer;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.Mock;
/**
 *
 * @author Xin Chen
 */
public class CustomerInfoTest {
    
    @Test
    public void UpdateTest() throws SQLException {
        CustomerDao manager = new CustomerDao();
        
        Customer newCustomer = new Customer(100,"Juste","Ssd","adf@ere.ck","cd12345","Female","dfsdf","1231231");
        manager.updateCustomer(newCustomer);
        
        Customer customer =  manager.getCustomerById(100);
        assertEquals("Juste",customer.getFirstName());
        assertEquals("Ssd",customer.getLastName());
    }

    
    
}
