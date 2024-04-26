import java.util.ArrayList;

public class Marbles {
	private ArrayList<String> marbles;

	public Marbles(ArrayList<String> marbles) {
		super();
		this.marbles = marbles;
	}

	public ArrayList<String> getMarbles() {
		return marbles;
	}

	public void setMarbles(ArrayList<String> marbles) {
		this.marbles = marbles;
	}

	public Marbles(int count) {
		marbles = new ArrayList<String>();
		for(int i = 0; i < count; i++) {
			int r = (int) (Math.random()*4);
			switch(r) {
			case 1:
				marbles.add("yellow");
				break;
			case 2:
				marbles.add("blue");
				break;
			case 3:
				marbles.add("red");
				break;
			case 4:
				marbles.add("green");
				break;
			}

		}
	}
	
	public int steal(int count, Marbles other) {
		int toSteal = Math.min(count, other.marbles.size());
		for(int i = 0; i < toSteal; i++) {
			int rando = (int)(Math.random()*other.marbles.size());
			this.marbles.add(other.marbles.remove(rando));
		}
		
		return toSteal;
	}
	
	public int trade(Marbles other, String get, String give) {
		int count = 0;
		while(this.marbles.contains(give)&&other.marbles.contains(get)) {
			int getSpot = other.marbles.indexOf(get);
			int giveSpot = this.marbles.indexOf(give);
			this.marbles.add(other.marbles.remove(getSpot));
		}
		return count;
	}
}
