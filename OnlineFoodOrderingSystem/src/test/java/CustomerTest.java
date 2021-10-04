
import com.mycompany.onlinefoodorderingsystem.controller.CustomerUpdateServlet;
import com.mycompany.onlinefoodorderingsystem.dao.CustomerDao;
import com.mycompany.onlinefoodorderingsystem.model.Customer;
import java.io.PrintWriter;
import java.io.StringWriter;
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
public class CustomerTest {
       

        
        public void updateCustomerInfoTest() throws Exception {
            CustomerDao customerDao = new CustomerDao();
            Customer customer = new Customer();
            customer.setId(100);
            customer.setFirstname("Justiney");
            customer.setLastname("Jithin");
            customer.setEmail("justiney@gdk.com");
            customer.setPassword("00002");
            customer.setPhone("0123456789");
            customer.setGender("female");
            customer.setAddress("2 willis st");
            //Customer customer = new Customer(101, "Justiney","Jithin", "justiney@gdk.com","00002", "0123456789","Female", "2020-01-01");
            customerDao.updateCustomer(customer);
            Customer newCustomer = customerDao.getCustomerById(100);
            assertEquals("Justiney",newCustomer.getFirstname());
        }
}
