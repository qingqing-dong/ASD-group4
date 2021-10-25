
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
 * @author
 */
public class MenuTest {

    MenuDao menuDao = new MenuDao();

    @Test
    public void testGetAllMenuItem() throws Exception {
        List<MenuItem> list = menuDao.getMenu();
        assertTrue(list.size()>0);
    }
    
    @Test
    public void testGetMenuItemById() throws Exception {
        MenuItem item = menuDao.getMenuItemById(1);
        assertEquals("Tamal", item.getName());
    }
    
    @Test
    public void testCreateMenuItemById() throws Exception {
        List<MenuItem> list = menuDao.getMenu();
        int oldSize = list.size();
        MenuItem item = new MenuItem();
        item.setName("Test Name");
        item.setDescription("Test Des");
        item.setType("Test Type");
        item.setUnit("Test unit");
        item.setPrice(10.99);
        item.setPicture("");
        menuDao.createMenuItem(item);
        list = menuDao.getMenu();
        assertEquals(oldSize+1, list.size());
    }
    
    @Test
    public void testUpdateMenuItemById() throws Exception {
        List<MenuItem> list = menuDao.getMenu();
        MenuItem oldItem = list.get(list.size()-1);
        oldItem.setName("Update Name");
        menuDao.updateMenuItem(oldItem);
        MenuItem updatedItem = menuDao.getMenuItemById(oldItem.getId());
        assertEquals("Update Name", updatedItem.getName());
    }
    
    @Test
    public void testDeleteMenuItemById() throws Exception {
        List<MenuItem> list = menuDao.getMenu();
        int oldSize = list.size();
        int id = list.get(oldSize-1).getId();
        menuDao.deleteMenuItemById(id);
        list = menuDao.getMenu();
        assertEquals(oldSize-1, list.size());
    }
}
