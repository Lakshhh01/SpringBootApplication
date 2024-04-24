package com.laksh.SpringBootwithMysqlDatabase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="seller")
public class Seller {
	@Id
	@Column(name="sellerid")
	int sellerId;
	
	@Column(name="tshirtid")
	int tshirtId;
	@Column(name="sellername")
	String sellerName;
	
	public Seller(int id,int tshirtId, String sellerName) {
		super();
		this.tshirtId = tshirtId;
		this.sellerName = sellerName;
		this.sellerId=id;
	}
	
	public Seller() {
		// TODO Auto-generated constructor stub
	}

	public int getTshirtId() {
		return tshirtId;
	}

	public void setTshirtId(int tshirtId) {
		this.tshirtId = tshirtId;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	
	

}
