package objects;

import java.util.ArrayList;
import java.util.List;

public class Order{
	int orderNumber;
	List<OrderLineItem> lineitem;
	double total;
	Table table;
	String status;
	
	
	public Order(int orderNumber,List lineitem, Table table, String status) {
		super();
		this.orderNumber=orderNumber;
		this.lineitem = lineitem;
		this.table = table;
		this.status = status;
		this.total=this.getInvoice(lineitem);
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getInvoice(List<OrderLineItem> lineitem){
		double subtotal=0;
		for (int i=0; i<lineitem.size(); i++){
			subtotal=subtotal+ lineitem.get(i).linePrice;
		}
		return subtotal;
	}
	public List<OrderLineItem> getLineitem() {
		return lineitem;
	}
	public void setLineitem(List<OrderLineItem> lineitem) {
		this.lineitem = lineitem;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Table getTable() {
		return table;
	}
	public void setTable(Table table) {
		this.table = table;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}