/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.onlinefoodorderingsystem.dao.DBCustomerManager;
import com.mycompany.onlinefoodorderingsystem.dao.DBStaffManager;
import com.mycompany.onlinefoodorderingsystem.dao.StaffDao;
import com.mycompany.onlinefoodorderingsystem.model.Customer;
import com.mycompany.onlinefoodorderingsystem.model.Staff;
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
public class StaffInfoTest {
    StaffDao manager = new StaffDao();
   
    @Test
    public void UpdateTest() throws SQLException {
        Staff newStaff = new Staff(1000,"Justea","Ssda","adf@ere.csk","Female","dfsdf","1231231","cd12345","Manager");
        manager.updateStaff(newStaff);
        Staff staff = manager.getStaffById(1000);
        String fName = staff.getFirstName();
        String lName = staff.getLastName();
        String sPosition = staff.getPosition();
        
        assertEquals("Justea",fName);
        assertEquals("Ssda",lName);
        assertEquals("Manager",sPosition);
        
    }
}
