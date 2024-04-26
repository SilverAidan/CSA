
public class Car extends Vehicle{
	protected static int activeCars;
	
	Car(){
		super();
	}

	public Car(String name, int condition, int miles) {
		super();
		this.name = name;
		this.condition = condition;
		this.miles = miles;
	}
	
	public double getValue() {
		if(condition == 0)
			return 0;
		return (super.getValue() + (1000 * condition));
	}
	
	public double getScrapValue() {
		double value = ((tk + (ek*5)*0.1) - (500*(miles/1000)));
		if(value > 2000)
			return 2000;
		if(value < 0)
			return 0;
		return value;
	}
}
