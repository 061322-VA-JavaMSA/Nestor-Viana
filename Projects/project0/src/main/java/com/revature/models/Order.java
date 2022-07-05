package com.revature.models;

import java.util.Objects;

public class Order {

	private int order_id;
	private int customer_id;
	private int item_id;
	private int flavor1_id;
	private int flavor2_id;
	private String customerUsername;
	private String item_name;
	private String flavor1;
	private String flavor2;
	private float price;
	
	public Order() {
		
	}
	
	public Order(int customer_id, int item_id, int flavor1_id, int flavor2_id) {
		super();
		this.customer_id = customer_id;
		this.item_id = item_id;
		this.flavor1_id = flavor1_id;
		this.flavor2_id = flavor2_id;
	}
	
	public Order(int order_id, String customerUsername, String item_name, String flavor1, String flavor2, float price) {
		super();
		this.order_id = order_id;
		this.customerUsername = customerUsername;
		this.item_name = item_name;
		this.flavor1 = flavor1;
		this.flavor2 = flavor2;
		this.price = price;
	}
	
	
	public int getOrderId() {
		return order_id;
	}

	public void setOrderId(int id) {
		this.order_id = id;
	}

	public int getCustomerId() {
		return customer_id;
	}

	public void setCustomerId(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getFlavor1_id() {
		return flavor1_id;
	}

	public void setFlavor1_id(int flavor1_id) {
		this.flavor1_id = flavor1_id;
	}

	public int getFlavor2_id() {
		return flavor2_id;
	}

	public void setFlavor2_id(int flavor2_id) {
		this.flavor2_id = flavor2_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer_id, flavor1_id, flavor2_id, order_id, item_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(customer_id, other.customer_id) && Objects.equals(flavor1_id, other.flavor1_id)
				&& Objects.equals(flavor2_id, other.flavor2_id) && order_id == other.order_id && item_id == other.item_id;
	}

	
	public String toString2() {
		return "Order [order_id=" + order_id + ", customer_id=" + customer_id + ", item_id=" + item_id + ", flavor1_id="
				+ flavor1_id + ", flavor2_id=" + flavor2_id + "]";
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public String getFlavor1() {
		return flavor1;
	}

	public void setFlavor1(String flavor1) {
		this.flavor1 = flavor1;
	}

	public String getFlavor2() {
		return flavor2;
	}

	public void setFlavor2(String flavor2) {
		this.flavor2 = flavor2;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "[order_id= " + order_id + ", customer_username= " + customerUsername + ", item = " + item_name + ", flavors = "
				+ flavor1 + " and " + flavor2 + ", price = $"+ String.format("%,.2f", price)  +"]";
		}
	
	
}
