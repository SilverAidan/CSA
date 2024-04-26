import java.util.ArrayList;

public interface Hanoi {
	// Method to get the count of rings on all pegs
	int getCount();

	// Method to reset the tower to the initial state
	void reset();

	// Method to set up the tower with a specific number of rings
	void setTower(int rings);

	// Method to check if the tower is solved
	boolean isSolved();

	// Method to make a move from one peg to another
	boolean makeMove(int from, int to);

	// Getter for the ArrayList representing the left peg
	ArrayList<Integer> getLeft();

	// Getter for the ArrayList representing the middle peg
	ArrayList<Integer> getMiddle();

	// Getter for the ArrayList representing the right peg
	ArrayList<Integer> getRight();

	// Setter for the ArrayList representing the left peg
	void setLeft(ArrayList<Integer> left);

	// Setter for the ArrayList representing the middle peg
	void setMiddle(ArrayList<Integer> middle);

	// Setter for the ArrayList representing the right peg
	void setRight(ArrayList<Integer> right);

	// Method to represent the board as a string
	String toString();
}
