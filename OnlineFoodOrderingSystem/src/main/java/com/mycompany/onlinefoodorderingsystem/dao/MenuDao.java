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

    public List<MenuItem> getMenu() {
        List<MenuItem> menu = new LinkedList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from menu");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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

    public MenuItem getMenuItemById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("select * from menu where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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

    public List<MenuItem> searchMenuItem(String keyword) {
        List<MenuItem> menu = new LinkedList();
        try {
            PreparedStatement ps = connection.prepareStatement("select * from menu where type like ? or description like ? or name like ?");
            keyword = "%" + keyword + "%";
            ps.setString(1, keyword);
            ps.setString(2, keyword);
            ps.setString(3, keyword);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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

    public void createMenuItem(MenuItem menuItem) {
        try {
            PreparedStatement ps = connection.prepareStatement("insert into menu(type, description, name, unit, picture, price) values(?, ?, ?, ?, ?, ?)");
            ps.setString(1, menuItem.getType());
            ps.setString(2, menuItem.getDescription());
            ps.setString(3, menuItem.getName());
            ps.setString(4, menuItem.getUnit());
            ps.setString(5, menuItem.getPicture());
            ps.setDouble(6, menuItem.getPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateMenuItem(MenuItem menuItem) {
        try {
            PreparedStatement ps = connection.prepareStatement("update menu set type=?, description=?, name=?, unit=?, picture=?, price=? where id=?");
            ps.setString(1, menuItem.getType());
            ps.setString(2, menuItem.getDescription());
            ps.setString(3, menuItem.getName());
            ps.setString(4, menuItem.getUnit());
            ps.setString(5, menuItem.getPicture());
            ps.setDouble(6, menuItem.getPrice());
            ps.setInt(7, menuItem.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteMenuItemById(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("delete from menu where id=?");
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(MenuDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
