
public class KungFuPanda extends Panda{
	protected String beltColor;
	public KungFuPanda() {
		super();
		this.name = "Jack Black";
		beltColor = "Black";
	}
	public String speak() {
		return "Hiyaa!! \n";
	}
	public String speak(int num) {
		String output = "";
		for(int i = 0; i < num; i++)
			output += this.speak() + super.speak();
		return output;
	}
}
