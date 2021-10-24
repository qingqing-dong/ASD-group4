package com.mycompany.onlinefoodorderingsystem.dao;

import com.mycompany.onlinefoodorderingsystem.model.Order;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderDao1 {
	
	public void createOrder(Order order) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/","Elijah","Elijah");
	        Statement st = conn.createStatement();
	        String sql = "INSERT INTO `order`(name,address,contactNum,totalSum,createDate,state,del) values(?,?,?,?,?,?,?)";
	        PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
	        ps.setString(2, order.getAddress());
	        ps.setString(1, order.getName());
	        ps.setString(3, order.getContactNum());
	        ps.setDouble(4, order.getTotalSum());
	        ps.setInt(6, 0);
	        ps.setInt(7, 0);
			Date d = new Date(); 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(d);
	        ps.setString(5, date);
	        ps.executeUpdate();
	        long id =0;
	        ResultSet resultSet = ps.getGeneratedKeys();
	        if(resultSet.next()){
	            id = resultSet.getLong(1);
	        }
	       
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Order> findAll(){
		List<Order> orderList = new ArrayList<Order>();
		String sql = "select * from `order` where del=0";
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/","Elijah","Elijah");
	        Statement st = conn.createStatement();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				Order order = new Order();
				order.setAddress(resultSet.getString("address"));
				order.setContactNum(resultSet.getString("contactNum"));
				order.setId(resultSet.getLong("id"));
				order.setName(resultSet.getString("name"));
				order.setTotalSum(resultSet.getDouble("totalSum"));
				order.setState(resultSet.getInt("state"));
				Timestamp timestamp = resultSet.getTimestamp("createDate");
				Date date = new Date(timestamp.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStr = sdf.format(date);
				order.setCreateTime(dateStr);
				
				
				orderList.add(order);
			}
			return orderList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			return orderList;
		}
	}

	public Order findById(Long id) {
		String sql = "select * from `order` where del=0 and id=" + id;
		Order order = new Order();
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/","Elijah","Elijah");
			 Statement st = conn.createStatement();
			 PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				order.setAddress(resultSet.getString("address"));
				order.setContactNum(resultSet.getString("contactNum"));
				order.setId(resultSet.getLong("id"));
				order.setName(resultSet.getString("name"));
				order.setTotalSum(resultSet.getDouble("totalSum"));
				order.setState(resultSet.getInt("state"));
				Timestamp timestamp = resultSet.getTimestamp("createDate");
				Date date = new Date(timestamp.getTime());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStr = sdf.format(date);
				order.setCreateTime(dateStr);
				
				
			}
			return order;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			return order;
		}
	}

	public void delete(Long id) {
		String sql = "UPDATE `order` SET del = 1 where id=" + id;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/","Elijah","Elijah");
			 conn.createStatement();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void submit(Long id) {
		String sql = "UPDATE `order` SET state = 1 where id=" + id;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/","Elijah","Elijah");
			 conn.createStatement();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Long id, String name, String address, String num) {
		String sql = "UPDATE `order` SET name = ?,address = ?, contactNum = ? where id = ?";
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/","Elijah","Elijah");
			 conn.createStatement();
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setString(1, name);
			 ps.setString(2, address);
			 ps.setString(3, num);
			 ps.setLong(4, id);
			 ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

  


	}
