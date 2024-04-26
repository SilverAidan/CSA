
public class Truck extends Car{
	Truck(){
		name = "Mater";
		condition = 5;
		miles = 0;
	}

	public Truck(String name, int condition, int miles) {
		super();
		this.name = name;
		this.condition = condition;
		this.miles = miles;
	}
	
	public boolean Tow(Vehicle other) {
		if(other instanceof Truck || other.getCondition() == 0)
			return false;
		other.setCondition(0);
		return true;
	}
}
