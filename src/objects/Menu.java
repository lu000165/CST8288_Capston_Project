package objects;

import java.util.ArrayList;
import java.util.List;

import Connection.MenuItemConnection;

public class Menu{
	ArrayList<MenuItem> items;
	
	public Menu(ArrayList<MenuItem> items) {
		this.items = items;
	}

	public ArrayList<MenuItem> getItems() {
		return items;
	}

	public void setItems(ArrayList<MenuItem> items) {
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
	public static ArrayList<MenuItem> showAllItems(){
		ArrayList<MenuItem> menuItems = MenuItemConnection.showAllMenu();
		return menuItems;
	}

	


	
}