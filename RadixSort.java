import java.util.Arrays;
import java.util.Random;

public class RadixSort {
	public static int n = 20;// controls size of Array
	public static int range = 400;

	public static void main(String[] args) {
		int[] arr = new int[n];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(range);
		}
		System.out.println("\nBefore: " + Arrays.toString(arr));
		radixSort(arr);
		System.out.println("\nSorted Array:  " + Arrays.toString(arr));
	}

	public static int getMax(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}

	public static void radixSort(int[] arr) {
		int max = getMax(arr, arr.length);

		for (int i = 1; max / i > 0; i *= 10) {
			countSort(arr, i);
		}
	}

	public static void countSort(int[] arr, int e) {
		int count[] = new int[10];
		int[] output = new int[arr.length];// initialize output array
		int i;
		
		// store count of each character
		for (i = 0; i < arr.length; i++) {

			count[(arr[i] / e) % 10] += 1;

		}
		System.out.println("\ncount[]= " + Arrays.toString(count));
		// Change count[i] to actual position of this digit in output[]
		for (i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		 System.out.println("count[]= "+Arrays.toString(count));

		// Build the output integer array
		for (i = arr.length - 1; i >= 0; i--) {

			output[count[(arr[i] / e) % 10] - 1] = arr[i];
			--count[(arr[i] / e) % 10];
		}
		for (i = 0; i < arr.length; i++) {
			arr[i] = output[i];
			System.out.printf("arr[i] : \t %5d \n", arr[i]);
		}
		System.out.println("\n ");
	}
}
/*

Before: [297, 218, 88, 116, 277, 215, 349, 212, 95, 112, 72, 124, 158, 272, 275, 64, 215, 266, 224, 142]

count[]= [0, 0, 5, 0, 3, 4, 2, 2, 3, 1]
count[]= [0, 0, 5, 5, 8, 12, 14, 16, 19, 20]
arr[i] : 	   212 
arr[i] : 	   112 
arr[i] : 	    72 
arr[i] : 	   272 
arr[i] : 	   142 
arr[i] : 	   124 
arr[i] : 	    64 
arr[i] : 	   224 
arr[i] : 	   215 
arr[i] : 	    95 
arr[i] : 	   275 
arr[i] : 	   215 
arr[i] : 	   116 
arr[i] : 	   266 
arr[i] : 	   297 
arr[i] : 	   277 
arr[i] : 	   218 
arr[i] : 	    88 
arr[i] : 	   158 
arr[i] : 	   349 

 

count[]= [0, 6, 2, 0, 2, 1, 2, 4, 1, 2]
count[]= [0, 6, 8, 8, 10, 11, 13, 17, 18, 20]
arr[i] : 	   212 
arr[i] : 	   112 
arr[i] : 	   215 
arr[i] : 	   215 
arr[i] : 	   116 
arr[i] : 	   218 
arr[i] : 	   124 
arr[i] : 	   224 
arr[i] : 	   142 
arr[i] : 	   349 
arr[i] : 	   158 
arr[i] : 	    64 
arr[i] : 	   266 
arr[i] : 	    72 
arr[i] : 	   272 
arr[i] : 	   275 
arr[i] : 	   277 
arr[i] : 	    88 
arr[i] : 	    95 
arr[i] : 	   297 

 

count[]= [4, 5, 10, 1, 0, 0, 0, 0, 0, 0]
count[]= [4, 9, 19, 20, 20, 20, 20, 20, 20, 20]
arr[i] : 	    64 
arr[i] : 	    72 
arr[i] : 	    88 
arr[i] : 	    95 
arr[i] : 	   112 
arr[i] : 	   116 
arr[i] : 	   124 
arr[i] : 	   142 
arr[i] : 	   158 
arr[i] : 	   212 
arr[i] : 	   215 
arr[i] : 	   215 
arr[i] : 	   218 
arr[i] : 	   224 
arr[i] : 	   266 
arr[i] : 	   272 
arr[i] : 	   275 
arr[i] : 	   277 
arr[i] : 	   297 
arr[i] : 	   349 

 

Sorted Array:  [64, 72, 88, 95, 112, 116, 124, 142, 158, 212, 215, 215, 218, 224, 266, 272, 275, 277, 297, 349]

*/
