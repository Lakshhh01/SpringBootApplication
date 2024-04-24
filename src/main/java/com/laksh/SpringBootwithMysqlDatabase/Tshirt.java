package com.laksh.SpringBootwithMysqlDatabase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Tshirt")
public class Tshirt {
	
	@Id
	@Column(name="id")
	int id;
	@Column(name="brand")
	String brand;
	@Column(name="sizeInCm")
	int sizeInCm;
	@Column(name="color")
	String color;
	@Column(name="price")
	double price;
	

	public Tshirt() {
		// TODO Auto-generated constructor stub
	}


	public Tshirt(int id,String brand, int sizeInCm, String color, double price) {
		super();
		this.id=id;
		this.brand = brand;
		this.sizeInCm = sizeInCm;
		this.color = color;
		this.price = price;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public int getSizeInCm() {
		return sizeInCm;
	}


	public void setSizeInCm(int sizeInCm) {
		this.sizeInCm = sizeInCm;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	

}
