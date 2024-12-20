public class Inception {
	public static int games;
	
	public static void main(String[] args) {
		//System.out.println(fact(5));
		//System.out.println(fib(10));
		int[] bruh = {1, 2, 3};
		//System.out.println(add(bruh, 0));
		//hanoi(4, 0, 2, 1);
		//games = 5;
		//System.out.println(showScenarios(0, 0, ""));
		//Queens elizabeth = new Queens(8);
		//elizabeth.solveIt(0);
		//System.out.println(elizabeth);
		Knight Lancelot = new Knight(8);
		Lancelot.start(0, 0);
		System.out.println(Lancelot);
	}
	public static int fact(int x) { 
		if(x <= 0) {
			return 1;
		}
		return x*fact(x-1);
	}
	
	public static int fib(int x) { 
		if(x <= 2)
			return 1;
		return fib(x-1)+fib(x-2);
	}
	
	public static int add(int[] x, int fingy) { 
		if(fingy >= x.length) {
			return 0;
		}
		return x[fingy] + add(x, fingy+1);
	}
	
	public static int showScenarios(int wins, int losses, String chain) {
		if(wins == games/2 + 1 || losses == games/2 + 1) {
			System.out.println(chain);
			return 1;
		}
		
		return showScenarios(wins + 1, losses, chain + "W")+ showScenarios(wins, losses + 1, chain + "L");
	}
	
	public static void hanoi(int rings, int from, int to, int extra) {
		if(rings <= 0) {
			return;
		}
		hanoi(rings-1, from, extra, to);
		System.out.println("move " + rings + " from " + from + " to " + to);
		hanoi(rings-1, extra, to, from);
	}
}
