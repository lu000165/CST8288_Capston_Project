package objects;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.OrderConnection;
import Connection.OrderItemConnection;

public class Order{
	int orderNumber;
	int tableNumber;
	List<OrderLineItem> lineitem;
	String status;
	
	
	public Order(int orderNumber, int tableNum,ArrayList<OrderLineItem> lineitem,String status) {
		this.orderNumber=orderNumber;
		this.tableNumber = tableNum;
		this.lineitem = lineitem;
		this.status = status;
	}
	
	//setter and getter
	
	public int getTableNumber(){
		return this.tableNumber;
	}
	public void setTableNumber(int tableNumber){
		this.tableNumber = tableNumber;
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public List<OrderLineItem> getLineitem() {
		return lineitem;
	}
	public void setLineitem(List<OrderLineItem> lineitem) {
		this.lineitem = lineitem;
	}
	public double getSubtotal() {
		double subtotal=0;
		for (int i=0; i<lineitem.size(); i++){
			subtotal=subtotal+ lineitem.get(i).linePrice;
		}
		return subtotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public static Order create(int tableNum) throws ClassNotFoundException, SQLException{
		Order order = OrderConnection.create(tableNum);
		return order;
	}


	public static void addItem(int orderId, int tableNumber, int menuItemId, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		OrderItemConnection.addItem(orderId,tableNumber,menuItemId,quantity);
	}


	
	
	
}