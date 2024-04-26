
public class Panda extends Bear implements CanBreed{
	protected int bambooEaten;
	public Panda(String name, String furColor, int b) {
		super();
		this.name = name;
		this.furColor = furColor;
		bambooEaten = b;
	}
	public Panda() {
		this("Po", "whiteBlack", 10);
	}
	public String speak() {
		return super.speak() + "im cute \n";
	}
	public int eat() {
		return ++bambooEaten;
	}
	
	public Panda breed(Object other) {
		// TODO Auto-generated method stub
		if(other instanceof Panda) {
			Panda p = new Panda();
			p.name = this.name + ((Bear)other).name;
			return p;
		}
		return null;
	}
}
