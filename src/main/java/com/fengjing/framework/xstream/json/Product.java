package com.fengjing.framework.xstream.json;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable{

	private String id;
	private String name;
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product(String id, String name, double price) {

	}

	public Product() {
	}

}
