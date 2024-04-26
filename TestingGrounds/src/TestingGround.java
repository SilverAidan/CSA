public class TestingGround {
	public static void main(String[] args) { 
		boolean isA = true;
		for(int i = 1 ; i <= 5 ; i++){
			for (int j=1; j<=i; j++){
				if(isA){System.out.print("a");
				}else{System.out.print("b");
				}isA = !isA;}
			System.out.println();}}}