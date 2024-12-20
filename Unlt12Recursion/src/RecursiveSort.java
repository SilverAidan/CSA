import java.util.Arrays;

public class RecursiveSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3, 6, 10, 20, 25, 29, 32};
		int[] test = new int[100000000];
		for(int i = 0; i < test.length; i++) {
			test[i] = (int)(Math.random()*test.length);
		}
		System.out.println("Generated");
		mergeSort(test);
		//System.out.println(Arrays.toString(test));
		System.out.println("Done");
		
	}
	
	public static void mergeSort(int[] arr) {
		int left = 0; int right = arr.length-1;
		int[] aux = new int[arr.length];
		mergeRecursive(arr, aux, left, right);
	}
	
	public static void mergeRecursive(int[] arr, int[] aux, int left, int right) {
		if(left>=right)
			return;
		
		mergeRecursive(arr, aux, left, (left+right)/2);
		mergeRecursive(arr, aux, (left+right)/2+1, right);
		merge(arr, aux, left, right);
	}
	
	public static void merge(int[] arr, int[] aux, int left, int right) {
		int fingie1 = left;
		int fingie2 = (left + right)/2+1;
		int x = left;
		while(fingie1<=(left+right)/2 || fingie2<=right) {
			
			if(fingie2 > right || arr[fingie1] < arr[fingie2] && fingie1<=(left+right)/2) {
				aux[x++] = arr[fingie1++];
			}else {
				aux[x++] = arr[fingie2++];
			}
		}
		for(int i = left; i <=right; i++) {
			arr[i] = aux[i];
		}
	}
	
	
	public static int goodLook(int[] arr, int value, int leftie, int rightie) {
		if(leftie > rightie)
			return -1;
		int lookSpot = (leftie + rightie)/2;
		if (arr[lookSpot] == value)
			return lookSpot;
		else if (arr[lookSpot] > value)
			return goodLook(arr, value, leftie, lookSpot - 1);
		else
			return goodLook(arr, value, lookSpot + 1, rightie);
	}
}
