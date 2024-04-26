import java.awt.Color;
import java.util.Arrays;

import javax.swing.JFrame;

public class testingGrounds {

	public static void main(String[] args) {
		String word = "zebra";
		word = alphaSort(word);//aberz
		//System.out.println(word);
		Pet[] pets = new Pet[10];
		for(int i = 0; i < pets.length; i++) {
			pets[i] = new Pet();
		}
		insertionSort(pets);
		for(Pet pet : pets) {
			//System.out.println(pet);
		}
		
		int[][] D2 = new int[][] {{5,-2,4}, {6,-1,-7},{-8, 0, 2}};
		int[] negatives = new int[4];
		int[] positives = new int[5];
		int[] longie = new int[9];
		
		int t = 0;
		for(int i = 0; i < D2.length; i++) {
			for(int j = 0; j < D2.length; j++) {
				if(D2[i][j] < 0) {
					negatives[(i + j)%4] = D2[i][j];
				}
				if(D2[i][j] > 0) {
					positives[(i + j)%5] = D2[i][j];
				}
			}
		}
		bubbleSort(negatives);
		insertionSort(positives);
		for(int n : negatives) {
			longie[t] = n;
			t++;
		}
		for(int p : positives) {
			 longie[t] = p;
			 t++;
		}
		System.out.println(Arrays.toString(longie));
	}
	
	public static String alphaSort(String str) {
		Character[] c = new Character[str.length()];
		String output = "";
		for(int i = 0; i < str.length(); i++) {
			c[i] = (Character)str.charAt(i);
		}
		insertionSort(c);
		for(int i = 0; i < str.length(); i++) {
			output += c[i];
		}
		return output;	
		
	}
	
	public static void insertionSort(Comparable[] arr){
		for(int i = 1; i < arr.length; i++) {
			int j = i - 1;
			Comparable temp = arr[i];
			while(j>=0 && arr[j].compareTo(temp) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void swap(Block[] arr, int i , int j, JFrame f) throws InterruptedException {
		Color temp = arr[i].getC();
		arr[i].setC(arr[j].getC());
		arr[j].setC(temp);
		Thread.sleep(200);
		f.repaint();
	}
	
	public static void bubbleSort(Block[] arr, JFrame f) throws InterruptedException{
		boolean hasSwap; int scans = 0;
		do {
			hasSwap = false;
			for(int i = 0; i < arr.length - scans - 1; i++) {
				if(arr[i].compareTo(arr[i + 1]) < 0) {
					swap(arr, i, i+1, f);
					hasSwap = true;
				}
			}
			scans++;
		}while (hasSwap);
	}
	
	public static int goodLook(int[] arr, int value) {
		int leftie = 0;
		int rightie = arr.length-1;
		while(leftie <= rightie) {
			int lookSpot = (leftie + rightie)/2;
			System.out.println(lookSpot);
			if(arr[lookSpot] == value) {
				return lookSpot;
			}
			else if(arr[lookSpot] > value) {
				rightie = lookSpot - 1;
			}else {
				leftie = lookSpot + 1;
			}
		}
		
		return -1;
	}
	
	public static void bubbleSort(int[] arr){
		boolean hasSwap; int scans = 0;
		do {
			hasSwap = false;
			for(int i = 0; i < arr.length - scans - 1; i++) {
				if(arr[i] < arr[i + 1]) {
					swap(arr, i, i+1);
					hasSwap = true;
				}
			}
			scans++;
		}while (hasSwap);
	}
	
	public static void insertionSort(int[] arr){
		for(int i = 1; i < arr.length; i++) {
			int j = i - 1;
			int temp = arr[i];
			while(j>=0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void selectionSort(int[] arr){
			for(int i = 0; i < arr.length - 1; i++) {
				int minSpot = i;
				for(int j = i+1; j < arr.length; j++) {
					if(arr[j] < arr[minSpot]) {
						minSpot = j;
					}
				}
				swap(arr, minSpot, i);
			}
	}
	
	public static void swap(int[] arr, int i , int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int goodLook(Comparable[] arr, Comparable value) {
		int leftie = 0;
		int rightie = arr.length-1;
		while(leftie <= rightie) {
			int lookSpot = (leftie + rightie)/2;
			if(arr[lookSpot].equals(value)) {
				return lookSpot;
			}
			else if(arr[lookSpot].compareTo(value) > 0) {
				rightie = lookSpot - 1;
			}else {
				leftie = lookSpot + 1;
			}
		}
		
		return -1;
	}


}
