import java.util.*;
import java.awt.*;

import javax.swing.JFrame;

public class LookSee {

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame();
		frame.setSize(300, 600);
		frame.setTitle("Blue Color Sorter");
		Block bloks[] = new Block[20];
		for(int i = 0; i < bloks.length; i++) {
			Color c = new Color(0,0,(int)(Math.random()*256));
			bloks[i] = new Block(c, i*frame.getHeight()/bloks.length);
		}
		Table t = new Table(bloks, frame.getWidth(), frame.getHeight());
		frame.add(t);
		frame.setVisible(true);
		bubbleSort(bloks, frame);
		frame.repaint();
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
				if(arr[i].compareTo(arr[i + 1]) > 0) {
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
				if(arr[i] > arr[i + 1]) {
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
