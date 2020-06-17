package objects;
public class Material{
	String materialName;
	int materialQuantity;
	
	
	public Material(String materialName, int materialQuantity) {
		super();
		this.materialName = materialName;
		this.materialQuantity = materialQuantity;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public int getMaterialQuantity() {
		return materialQuantity;
	}
	public void setMaterialQuantity(int materialQuantity) {
		this.materialQuantity = materialQuantity;
	}
	
	
}