
package com.example.sporty.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shoes {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long shoeid;
    private String productname;
     
    private int price;
   
    
	
	public Shoes() {

		// TODO Auto-generated constructor stub
	}



	public Shoes(Long shoeid, String productname, int price) {
		super();
		this.shoeid = shoeid;
		this.productname = productname;
		this.price = price;
	}



	public Long getShoeid() {
		return shoeid;
	}



	public void setShoeid(Long shoeid) {
		this.shoeid = shoeid;
	}



	public String getProductname() {
		return productname;
	}



	public void setProductname(String productname) {
		this.productname = productname;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Shoes [shoeid=" + shoeid + ", productname=" + productname + ", price=" + price + "]";
	}


}
