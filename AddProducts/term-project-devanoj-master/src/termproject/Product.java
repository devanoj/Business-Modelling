package termproject;

import java.io.Serializable;

public class Product implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String quantity;
	private int price;
	private String expiryDate;
	
	
	public Product(String name,String quantity, int price, String expiryDate) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.expiryDate = expiryDate;
		
		
	}
	public String getexpiryDate() {
		return expiryDate;
	}
	public void setexpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getquantity() {
		return quantity;
	}
	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	
	
}
