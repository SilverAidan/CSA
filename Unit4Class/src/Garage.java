
public class Garage {
	private VroomVroom car1, car2, car3;
	private String street;
	public Garage(VroomVroom car1, VroomVroom car2, VroomVroom car3, String street) {
		super();
		this.car1 = car1;
		this.car2 = car2;
		this.car3 = car3;
		this.street = street;
	}
	public VroomVroom getCar1() {
		return car1;
	}
	public void setCar1(VroomVroom car1) {
		this.car1 = car1;
	}
	public VroomVroom getCar2() {
		return car2;
	}
	public void setCar2(VroomVroom car2) {
		this.car2 = car2;
	}
	public VroomVroom getCar3() {
		return car3;
	}
	public void setCar3(VroomVroom car3) {
		this.car3 = car3;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String toString() {
		String output = "";
		output += car1 + "\n\n" + car2 + "\n\n" + car3 + " located at ";
		output += street + " street";
		
		return output;
	}
	
}
