
public class Helicopter extends Vehicle{
	protected int maxPassengerWeight;
	
	Helicopter(){
		name = "Petercopter";
		condition = 5;
		miles = 0;
	}

	public Helicopter(String name, int condition, int miles, int maxPassengerWeight) {
		super();
		this.maxPassengerWeight = maxPassengerWeight;
	}
	
	public double getValue() {
		if(condition == 0)
			return 0;
		return (super.getValue() + (5000*maxPassengerWeight));
	}
	
	public double getScrapValue() {
		return ((super.getValue() + (5000*maxPassengerWeight)) * .3);
	}
	
	public String toString() {
		return super.toString() + "\n\nMax Weight: \n" + maxPassengerWeight;
	}
}
