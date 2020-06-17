package objects;
public class MenuItem{
	String name;
	String des;
	double price;
	boolean active;
	
	public MenuItem(String name, String des, double price, boolean active){
		this.name=name;
		this.des=des;
		this.price=price;
		this.active=active;
	}
	
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	
}