package com.ecommerce.productinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productinfo")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(length=20)
	private String name;
	private String model;
	private  float price;
	public int getproductid() {
		return id;
	}
	public void setProductid(int id) {
		this.id = id;
	}
	public String getProductName() {
		return name;
	}
	public void setProductName(String name) {
		this.name = name;
	}
	public String getProductModel() {
		return model;
	}
	public void setProducModel(String model) {
		this.model = model;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}