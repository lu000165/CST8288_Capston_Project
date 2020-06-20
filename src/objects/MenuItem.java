package objects;
public class MenuItem{
	int id;
	String name;
	String des;
	int price;
	boolean active;
	
	
	public MenuItem(int id,String name, String des, int price, boolean active){
		this.id = id;
		this.name=name;
		this.des=des;
		this.price=price;
		this.active=active;
	}
	public int getId(){
		return this.id;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

	
}