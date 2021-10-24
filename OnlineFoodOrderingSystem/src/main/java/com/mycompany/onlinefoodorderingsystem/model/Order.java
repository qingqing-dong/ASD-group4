package com.mycompany.onlinefoodorderingsystem.model;

import java.util.Date;
import java.util.List;

public class Order {
    private Long id;
    private String name;
    private String contactNum;
    private String address;
    private Double totalSum;
    private String createTime;
    private Integer state;
     private int ID;
        private int dishID;
        private int customerID;
        private int quantity;
        private int amount;
        private String orderDate;

    public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


    public Order(int ID,int dishID,int customerID,int quantity,int amount,String orderDate){
            this.ID=ID;
            this.dishID=dishID;
            this.customerID= customerID;
            this.quantity=quantity;
            this.amount=amount;
            this.orderDate=orderDate;
        }
        
        public Order(int dishID,int customerID,int quantity,int amount,String orderDate){
            this.dishID=dishID;
            this.customerID= customerID;
            this.quantity=quantity;
            this.amount=amount;
            this.orderDate=orderDate;

        }
        
        public Order(){
        }

   
        
        public void updateInfo(int ID,int dishID,int customerID,int quantity,int amount,String orderDate){
            this.ID=ID;
            this.dishID=dishID;
            this.customerID= customerID;
            this.quantity=quantity;
            this.amount=amount;
            this.orderDate=orderDate;
        }

    public int getID() {
        return ID;
    }

    public int getDishID() {
        return dishID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getQuantity() {
            return quantity;
        }

    public int getAmount() {
        return amount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDishID(int dishID) {
        this.dishID = dishID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}


	public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

