import java.awt.Point;
import java.util.Arrays;

public class squareArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr2D;
		arr2D = new int[4][3];
		arr2D[2] = new int[] {1, 2, 3 , 4};
		arr2D[3][1] = 9;
		
		char[][] arr2D2 = new char[6][];
		for(int i = 0; i < arr2D2.length; i++) {
			arr2D2[i] = new char[6];
			for(int j = 0; j < arr2D2[i].length; j++) {
				arr2D2[i][j] = '.';
			}
		}
		for(int i = 0; i < arr2D2.length; i++) {
			for(int j = 0; j < arr2D2[i].length; j++) {
				double r = Math.random();
				if(r < 0.4) {
					arr2D2[i][j] = 'S';
				}
				if(r > 0.8) {
					arr2D2[i][j] = 'E';
				}
			}
		}
		for(int col = 0; col < 6; col++) {
			if(arr2D2[5][col]=='.') {
				arr2D2[5][col]='R';
			}
		}
		moveHan(arr2D2);
		shootHan(arr2D2);
		showBoard(arr2D2);
		arr2D2 = rotateBoard(arr2D2);
		showBoard(arr2D2);
		battleRound(arr2D2);
		
	}
	public static void battleRound(char[][] field) {
		char[][] next = new char[field.length][field[0].length];
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				int goodGuys = 0; int badGuys = 0;
				if (i > 0) {
					if ((field[i-1][j] == 'R') || (field[i-1][j] == 'E')) {
						goodGuys++;
					}
					if (field[i-1][j] == 'S') {
						badGuys++;
					}
				}
				
				if (i < field.length-1) {
					if ((field[i+1][j] == 'R') || (field[i+1][j] == 'E')) {
						goodGuys++;
					}
					if (field[i+1][j] == 'S') {
						badGuys++;
					}
				}
				
				if (j > 0) {
					if ((field[i][j-1] == 'R') || (field[i][j-1] == 'E')) {
						goodGuys++;
					}
					if (field[i][j-1] == 'S') {
						badGuys++;
					}
				}
				
				if (j < field[0].length-1) {
					if ((field[i][j+1] == 'R') || (field[i][j+1] == 'E')) {
						goodGuys++;
					}
					if (field[i][j+1] == 'S') {
						badGuys++;
					}
				}
				next[i][j] = field[i][j];
				if(next[i][j] == 'S' && goodGuys > 1) {
					next[i][j] = 'X';
				}
				if((next[i][j] == 'R' || next[i][j] == 'E') && badGuys > 1) {
					next[i][j] = 'X';
				}
			}
		}
		showBoard(next);
	}
	public static char[][] rotateBoard(char[][] field) {
		char[][] output = new char[field[0].length][field.length];
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field[i].length; j++) {
				output[j][field.length-i-1] = field[i][j];
			}
		}
		return output;
	}
	public static void shootHan(char[][] field) {
		Point loc = null;
		for(int i = 0; i < field.length; i++)
			for(int j = 0; j < field.length; j++)
				if(field[i][j] =='H')
					loc = new Point(i,j);
		if(loc == null)
			return;
		int direc = (int)(Math.random()*4);
		int pathRow, pathColumn;
		switch(direc) {
			case 0: //North
				pathRow = -1; pathColumn = 0;
				break;
			case 1: //East
				 pathRow = 0; pathColumn = 1;
				break;
			case 2: //South
				pathRow = 1; pathColumn = 0;
				break;
			default: //West
				pathRow = 0; pathColumn = -1;
				break;
		}
		loc.x += pathRow; loc.y += pathColumn;
		while((loc.x >= 0 && loc.x < field.length)&&(loc.y >= 0 && loc.y < field[0].length)) {
			field[loc.x][loc.y] = '!';
			loc.x += pathRow; loc.y += pathColumn;
		}
	}
	public static void moveHan(char[][] field) {
		for(int i = 0; i < field.length; i++) {
			for(int j = 0; j < field.length; j++) {
				if(field[i][j] =='H')
					field[i][j] = '.';
			}
		}
		int r = (int)(Math.random()*field.length);
		int c = (int)(Math.random()*field.length);
		field[r][c] = 'H';
	}
	
	public static void showBoard(char[][] crr2D) {
		for(char[] row:crr2D) {
			for(char c:row)
				System.out.print(c + " ");
			System.out.println();
		}
		System.out.println();
	}
}
