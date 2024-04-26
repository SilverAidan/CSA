import java.util.ArrayList;

public class Towers implements Hanoi{
	private ArrayList<Integer> left = new ArrayList<Integer>();
	private ArrayList<Integer> middle = new ArrayList<Integer>();
	private ArrayList<Integer> right = new ArrayList<Integer>();
	
	public Towers() {
		for(int i = 5; i > 0; i--)
			left.add(i);
	}
	
	public Towers(int size) {
		for(int i = 0; i < size; i++)
			left.set(i, i+1);
	}

	public Towers(ArrayList<Integer> left, ArrayList<Integer> middle, ArrayList<Integer> right) {
		this.left = left;
		this.middle = middle;
		this.right = right;
	}
	
	public String toString() {
		String output = "";
		int height = Math.max(left.size(), right.size());
		height = Math.max(height, middle.size());
		for(int i = height-1; i >= 0; i--) {
			if(i < left.size())
				output += " " + left.get(i) + "\t";
			if(i < middle.size())
				output += " " + middle.get(i) + "\t";
			if(i < right.size())
				output += " " + right.get(i) + "\t";
			output += "\n";
		}
		output += "‾‾‾\t‾‾‾\t‾‾‾ ";
		return output;
	}

	public int getCount() {
		return left.size() + right.size() + middle.size();
	}
	
	public void reset() {
		left.clear();
		middle.clear();
		right.clear();
		for(int i = this.getCount(); i > 0; i--)
			left.add(i);
	}
	
	public void setTower(int rings) {
		left.clear();
		middle.clear();
		right.clear();
		for(int i = rings; i > 0; i--)
			left.add(i);
	}
	
	public boolean isSolved() {
		if(left.size() == 0 && middle.size() == 0) {
			for(int i = getCount(); i >= 0; i--)
				if(right.get(i) != (right.get(i + 1) + 1))
					return false;
			return true;
		}
		return false;
	}
	
	public boolean makeMove(int one, int two) {
		
	}

	public ArrayList<Integer> getLeft() {
		return left;
	}

	public void setLeft(ArrayList<Integer> left) {
		this.left = left;
	}

	public ArrayList<Integer> getMiddle() {
		return middle;
	}

	public void setMiddle(ArrayList<Integer> middle) {
		this.middle = middle;
	}

	public ArrayList<Integer> getRight() {
		return right;
	}

	public void setRight(ArrayList<Integer> right) {
		this.right = right;
	}

}
