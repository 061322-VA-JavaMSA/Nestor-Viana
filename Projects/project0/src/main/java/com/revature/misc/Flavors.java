package com.revature.misc;

public class Flavors {

	private int id;
	private String flavor;
	
	public Flavors() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}
	@Override
	public String toString() {
		return id + "\t" + flavor;
	}
	
	
	
}
