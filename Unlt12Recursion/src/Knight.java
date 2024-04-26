public class Knight {
	int[][] board;
	static int rowMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
	static int colMove[] = {1, 2, 2, 1, -1, -2, -2, -1};
	int stepCount;
	
	public Knight(int dim) {
		board = new int[dim][dim];
		for(int i = 0; i<dim; i++)
			for(int j = 0; j<dim;j++)
				board[i][j] = 0;
		stepCount = 0;
	}
	
	public boolean tour(int row, int col) {
		if(stepCount == board.length*board[0].length) {
			return true;
		}
		for(int i = 0; i < 8; i++) {
			if(isSafe(row+rowMove[i], col+colMove[i])) {
				board[row+rowMove[i]][col+colMove[i]] = ++stepCount;
				if(tour(row+rowMove[i], col+colMove[i]))  {
					return true;
				}
				board[row+rowMove[i]][col+colMove[i]] = 0;
				stepCount--;
			}
		}
		return false;
	}
	
	public boolean start(int row, int col) {
		board[row][col] = 1;
		stepCount++;
		return tour(row, col);
	}
	
	public String toStringMour() {
		String output = "";
		for(int[] row:board) {
			for(int space:row) {
				output += space+" ";
				if(space<10)
					output+= " |";
				else
					output+="|";
			}
			output+="\n";
			for(int i = 0; i<board.length*4;i++)
				output +="-";
			output+="\n";
		}
		return output;
	}
	
	public boolean isSafe(int row, int col) {
		if(row < 0 || row >= board.length) {
			return false;
		}
		if(col < 0 || col >= board.length) {
			return false;
		}
		return board[row][col] == 0;
	}
	
	//better toString() (in my opinion) if interested
	public String toString() {
	        //top row of column labels
	        String[][] board = new String[this.board.length][];
	        for (int i = 0; i < this.board.length; i++) {
	            board[i] = new String[this.board[i].length];
	            for(int j = 0; j < this.board[i].length; j++) {
	                if (this.board[i][j] < 10) {
	                    board[i][j] = " " + this.board[i][j];
	                } else {
	                    board[i][j] = "" + this.board[i][j];
	                }
	            }
	        }
	            String output = "" + (char)9642;
	            for (int i = 0; i < board.length; i++) {
	                if (i / 10 == 0) {
	                    output += "0" + i;
	                } else {
	                    output += "" + i;
	                }
	                output += (char)9642;
	               
	            }
	            //2nd row (outside double layer border)
	            output += "\n" + (char)9556;
	            for (int i = 0; i < board.length - 1; i++) {
	                output += "" + (char)9552 + (char)9552 + (char)9572;
	            }
	            output += "" + (char)9552 + (char)9552 + (char)9559;
	            //middle section
	            for (int i = 0; i < board.length - 1; i++) {
	                output += "\n" + (char)9553;
	                // values
	                for (int j = 0; j < board[i].length - 1; j++) {
	                    output += "" + board[i][j] + "" + (char)9474;
	                }
	                // middle rows between
	                output += "" + board[i][board[i].length - 1] + "" + (char)9553 + "\n" + (char)9567;
	                for (int j = 0; j < board[i].length - 1; j++) {
	                    output += "" + (char)9472 + (char)9472 + (char)9532;
	                }
	                output += "" + (char)9472 + (char)9472 + (char)9570;
	               
	            }
	            //last row
	            output += "\n" + (char)9553;
	            for (int j = 0; j < board[0].length - 1; j++) {
	                output += "" + board[board.length - 1][j] + "" + (char)9474;
	            }
	            //last row of double layered
	            output += "" + board[board.length - 1][board.length - 1] + "" + (char)9553 + "\n" + (char)9562;
	            for (int i = 0; i < board.length - 1; i++) {
	                output += "" + (char)9552 + (char)9552 + (char)9575;
	            }
	            output += "" + (char)9552 + (char)9552 + (char)9565;
	            return output;
	        }
}