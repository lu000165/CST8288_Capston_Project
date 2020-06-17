package objects;

import java.util.ArrayList;
import java.util.List;

public class Inventory{
	List<Material> ingredients;
	
	
	public Inventory(List<Material> ingredients) {
		super();
		this.ingredients = ingredients;
	}

	public List<Material> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Material> ingredients) {
		this.ingredients = ingredients;
	}
	
	public void addIngredients(Material newMaterial){
		this.ingredients.add(0,newMaterial);
	}
	
}