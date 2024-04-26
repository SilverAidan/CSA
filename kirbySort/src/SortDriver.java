import java.awt.*;

import javax.swing.JFrame;

public class SortDriver {

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		Table t = new Table();
		frame.add(t);
		frame.setSize(1500, 800);
		frame.setTitle("Kirby Sorter");
		frame.setLocation(225, 100);
		frame.setVisible(true);
		frame.repaint();
	}
	
	public static void swap(Piece[] arr, int i , int j, JFrame f) {
		Color temp = arr[i].getC();
		arr[i].setC(arr[j].getC());
		arr[j].setC(temp);
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {}
		f.repaint();
	}
	
	public static void bubbleSort(Piece[] arr, JFrame f){
		boolean hasSwap; int scans = 0;
		do {
			hasSwap = false;
			for(int i = 0; i < arr.length - scans - 1; i++) {
				if(arr[i].compareTo(arr[i + 1]) > 0) {
					swap(arr, i, i+1, f);
					hasSwap = true;
				}
			}
			scans++;
		}while (hasSwap);
	}
	
	public static void insertionSort(Piece[] arr){
		for(int i = 1; i < arr.length; i++) {
			int j = i - 1;
			Piece temp = arr[i];
			while(j>=0 && arr[j].compareTo(temp) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}
	
	public static void selectionSort(Piece[] arr, JFrame frame){
		for(int i = 0; i < arr.length - 1; i++) {
			int minSpot = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j].compareTo(arr[minSpot]) > 0) {
					minSpot = j;
				}
			}
			swap(arr, minSpot, i, frame);
		}
	}
}
