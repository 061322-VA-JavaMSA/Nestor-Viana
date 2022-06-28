package com.revature.misc;

public class Items {
	
	private int id;
	private String name;
	private String description;
	private float price;
	
	public Items(int id, String description, float price) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
	}
	public Items() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return  id + "\t" + name + "\t" + description + "\t $" + String.format("%,.2f", price);
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
