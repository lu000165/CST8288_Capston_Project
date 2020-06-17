package objects;

import java.util.ArrayList;
import java.util.List;

public class Menu{
	List<MenuItem> items;
	
	public Menu(List<MenuItem> items) {
		super();
		this.items = items;
	}

	public List<MenuItem> getItems() {
		return items;
	}

	public void setItems(List<MenuItem> items) {
		this.items = items;
	}
	
	public void addItems(MenuItem newItem){
		this.items.add(0, newItem);
	}
	public void removeItmes(List<MenuItem> items){
		for (int i=0; i<items.size(); i++){
			if(!items.get(i).isActive()){
				items.remove(i);
			}
		}
	}
	


	
}