
import com.mycompany.onlinefoodorderingsystem.controller.MenuServlet;
import com.mycompany.onlinefoodorderingsystem.dao.MenuDao;
import com.mycompany.onlinefoodorderingsystem.model.MenuItem;
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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jiahong Li
 */
public class MenuTest {
    
    MenuDao menuDao = new MenuDao();

    @Test
    public void testServlet() throws Exception {
        List<MenuItem> list = menuDao.getMenu();
        assertTrue(list.size()>0);
    }
    
    @Test
    public void testGetMenuItemById() throws Exception {
        MenuItem item = menuDao.getMenuItemById(1);
        assertEquals("Tamal", item.getName());
    }
    
}
