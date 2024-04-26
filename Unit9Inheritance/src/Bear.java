
public class Bear implements CanBreed{
	protected String name;
	protected String furColor;
	protected int HP;
	
	public Bear() {
		name = "Winnie"; furColor = "Orange";
		HP = 100;
	}
	public String speak(){
		return "I'm a bear \n";
	}
	public String toString() {
		return name + " " + furColor + "\n" + HP + "HP";
	}
	public String bearBattle(Bear bear2) {
		if(this == bear2) {
			return "What are you doing??";
		}
		
		if(this instanceof KungFuPanda) {
			if(bear2 instanceof KungFuPanda) {
				return "No Contest";
			}else {
				bear2.HP = 0;
				return "I'll Soak These Hands With Your Blood!";
			}
		}
		
		if(bear2 instanceof KungFuPanda) {
				bear2.HP = 0;
				return "Tell my kids I love them";
		}
		if(this.getClass().equals(bear2.getClass())) {
			this.HP /= 2;
			return "They both lie dead..";
		}
		if(this instanceof Panda) {
			this.HP = 0;
			return "Why Winnie";
		}else {
			bear2.HP = 0;
			return "I got your honey mr bear";
		}
	}		
	
	public Object breed(Object other) {
		// TODO Auto-generated method stub
		if(other instanceof Bear && !(other instanceof Panda)) {
			Bear b = new Bear();
			b.name = this.name + ((Bear)other).name;
			return b;
		}
		return null;
		
	}
}
