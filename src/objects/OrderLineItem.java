package objects;

import objects.MenuItem;

public class OrderLineItem{
	MenuItem item;
	int quantity;
	double linePrice;
	
	
	public OrderLineItem(MenuItem item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.linePrice= quantity*this.item.price;
	}
	public MenuItem getItem() {
		return item;
	}
	public void setItem(MenuItem item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return linePrice;
	}
	public void setPrice(double price) {
		this.linePrice = price;
	}
	
	
}