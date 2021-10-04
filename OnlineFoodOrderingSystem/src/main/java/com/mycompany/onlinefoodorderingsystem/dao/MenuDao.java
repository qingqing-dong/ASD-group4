/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.MenuItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuDao extends BaseDao {
    public List<MenuItem> getMenu(){
        List<MenuItem> menu = new LinkedList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from menu");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MenuItem item = new MenuItem();
                item.setId(rs.getInt("id"));
                item.setType(rs.getString("type"));
                item.setDescription(rs.getString("description"));
                item.setName(rs.getString("name"));
                item.setUnit(rs.getString("unit"));
                item.setPicture(rs.getString("picture"));
                item.setPrice(rs.getDouble("price"));
                menu.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return menu;
    }
    
    public MenuItem getMenuItemById(int id){
        try {
            PreparedStatement ps = connection.prepareStatement("select * from menu where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                MenuItem item = new MenuItem();
                item.setId(rs.getInt("id"));
                item.setType(rs.getString("type"));
                item.setDescription(rs.getString("description"));
                item.setName(rs.getString("name"));
                item.setUnit(rs.getString("unit"));
                item.setPicture(rs.getString("picture"));
                item.setPrice(rs.getDouble("price"));
                return item;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
