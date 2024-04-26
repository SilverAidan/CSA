import java.util.Scanner;

public class PawnDriver {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("How large would you like the board to be: ");
		int size = read.nextInt();
		BoardWithPawns Game = new BoardWithPawns(size);
		while(!Game.isWon()) {
			System.out.println(Game);
			System.out.println("\nwhich column would you like to move: ");
			int col = read.nextInt();
			boolean viableMove = Game.movePawn(col);
			if(Game.isStalemate()) {
				System.out.println("Stalemate");
				break;
			}
			if(viableMove) {
				Game.setTurn(!Game.isTurn());
			}else {
				System.out.println("Invalid Move");
				Game.setTurn(Game.isTurn());
			}
		}
	}
}