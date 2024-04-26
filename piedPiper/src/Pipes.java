import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

public class Pipes {
	private char[][] Board;
	private Point a;
	private Point b;
	
	public Pipes(Scanner doc) {
		boolean first = true;
		ArrayList<String> Board1D = new ArrayList<String>();
		while(doc.hasNext()) {
			Board1D.add(doc.next());
		}
		Board = new char[Board1D.size()][Board1D.get(1).length()];
		for(int i = 0; i < Board1D.size(); i++) {
			for(int j = 0; j < Board1D.get(i).length(); j++) {
				if(Board1D.get(i).charAt(j) == 'A' && first) {
					a = new Point(i, j);
					first = false;
				}else if(Board1D.get(i).charAt(j) == 'A') {
					b = new Point(i, j);
				}
				Board[i][j] = Board1D.get(i).charAt(j);
			}	
		}
	}
	
	public boolean solve() {
		if(makeMove(a.x, a.y-1)) {
			return true;
		}
		if(makeMove(a.x, a.y+1)) {
			return true;
		}
		if(makeMove(a.x-1, a.y)) {
			return true;
		}
		if(makeMove(a.x+1, a.y)) {
			return true;
		}
		return false;
	}
	
	public boolean makeMove(int row, int col){
		if(row >= Board.length || col >= Board[0].length || row < 0 || col < 0) {
			return false;
		}
		if(row == b.x && col == b.y) {
			return true;
		}
		if(Board[row][col] == 'x' || Board[row][col] == '.') {
			return false;
		}
		char old = Board[row][col];
		
		if(Board[row][col] == '|') {
			Board[row][col] = '.';
			if(makeMove(row+1, col)) {
				return true;
			}
			if(makeMove(row-1, col)) {
				return true;
			}
		}
		
		if(Board[row][col] == '-') {
			Board[row][col] = '.';
			if(makeMove(row, col+1)) {	
				return true;
			}	
			if(makeMove(row, col-1)) {;
				return true;
			}
		}
		Board[row][col] = old;
		return false;
	}
	
	public String toString() {
		String output = "";
		for(int i = 0; i < Board.length; i++) {
			for(int j = 0; j < Board[i].length; j++) {
				output+= Board[i][j];
			}
			output += "\n";
		}
		output += a + "\n" + b;
		return output;
	}

	public char[][] getBoard() {
		return Board;
	}

	public void setBoard(char[][] board) {
		Board = board;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}
	
	
}
