package com.revature.models;

import java.util.Objects;

public class Order {

	private int id;
	private String customerUsername;
	private int item_id;
	private int flavor1_id;
	private int flavor2_id;
	
	public Order() {
		
	}
	
	public Order(String customerUsername, int item_id, int flavor1_id, int flavor2_id) {
		super();
		this.customerUsername = customerUsername;
		this.item_id = item_id;
		this.flavor1_id = flavor1_id;
		this.flavor2_id = flavor2_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
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
		return Objects.hash(customerUsername, flavor1_id, flavor2_id, id, item_id);
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
		return Objects.equals(customerUsername, other.customerUsername) && Objects.equals(flavor1_id, other.flavor1_id)
				&& Objects.equals(flavor2_id, other.flavor2_id) && id == other.id && item_id == other.item_id;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", customerUsername=" + customerUsername + ", item_id=" + item_id + ", flavor1_id="
				+ flavor1_id + ", flavor2_id=" + flavor2_id + "]";
	}
	
	
	
}
