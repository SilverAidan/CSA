public class Queens {
	private char[][] board;
	
	public Queens(int dim) {
		board = new char[dim][dim];
		for(int i = 0; i<dim;i++)
			for(int j = 0; j<dim;j++)
				board[i][j] = '.';
	}
	
	public boolean solveIt(int column) {
		if(column == board.length)
			return true;
		for(int i = 0; i < board.length; i++){
			if(isSafe(i,column)) {
				board[i][column] = 'Q';
				if(solveIt(column + 1)) {
					return true;
				}
				board[i][column] = '.';
			}
		}
		return false;
	}
	
	public String toString() {
		String output = "";
		for(char[] crr:board) {
			for(char c:crr)
				output += c + "  ";
			output +='\n';
		}
		return output;
	}
	
	public boolean isSafe(int row, int col) {
		for(int i = col; i>=0; i--)  //scan left
			if(board[row][i]=='Q')
				return false;
		//now scan up and left
		int i = row; int j = col;
		while(i>0&&j>0) {
			i--; j--;
			if(board[i][j]=='Q')
				return false;
		}
		i = row; j = col;
		//now scan down and left
		while(i<board.length-1&&j>0) {
			i++; j--;
			if(board[i][j]=='Q')
				return false;
		}
		return true;
	}

}