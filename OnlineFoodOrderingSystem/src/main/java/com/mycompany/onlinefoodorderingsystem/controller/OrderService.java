/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.onlinefoodorderingsystem.controller;

import com.mycompany.onlinefoodorderingsystem.dao.OrderDao1;
import com.mycompany.onlinefoodorderingsystem.model.Order;
import java.util.List;

/**
 *
 * @author 47288
 */
class OrderService {
    private OrderDao1 dao = new OrderDao1();
	
	public void createOrder(Order order) {
		dao.createOrder(order);
	}
	
	public List<Order> findAll(){
		return dao.findAll();
	}

	public Order findById(Long id) {
		return dao.findById(id);
	}

	public void delete(Long id) {
		 dao.delete(id);
	}
	
	public void submit(Long id) {
		 dao.submit(id);
	}
	
	public void update(Long id, String name, String address, String num) {
		 dao.update(id,name,address,num);
	}
}
