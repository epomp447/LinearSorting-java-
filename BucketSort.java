import java.util.Arrays;
import java.util.Random;

// file:    bucketsort.java
// author:  epomp447
// Description: Implementation of bucketSort in O(n) time
//			
//			illustrating a very fast sorting program for natural numbers in
//          a reasonably small range only
//
//          bucketsort works as follows: The minimum and maximum of the 
//          range of numbers is found.  Then an array of "buckets" is 
//          allocated for each integral value between the minimum and
//          maximum inclusive.  The number of each value in the original
//          array is counted by one pass over the latter, using the datum
//          as an index into the bucket array.
//
//          This method is O(N) where N is the number of elements to be sorted;
//          a prime example of the use of the linear-addressing principle.
//
//          If the range of numbers is to large, the bucket array can't be
//          allocated and the method will fail.


public class BucketSort {
	public static int n = 20;
	public static int range = Integer.MAX_VALUE;

	public static void main(String[] args) {
		
		int[] arr = new int[n];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(range);
		}
		System.out.println("Before: " + Arrays.toString(arr));
		try {
		bucketSort(arr, arr.length);
		}finally {
		System.out.println("Error");
		}
		
		System.out.println("After:  " + Arrays.toString(arr));
	}

	static void bucketSort(int array[], int N) {
		if (N <= 0)
			return; // Case of empty array

		int min = array[0];
		int max = min;
		for (int i = 1; i < N; i++) // Find the minimum and maximum
			if (array[i] > max)
				max = array[i];
			else if (array[i] < min)
				min = array[i];

		int bucket[] = new int[max - min + 1]; // Create buckets

		for (int i = 0; i < N; i++) // "Fill" buckets
			bucket[array[i] - min]++; // by counting each datum

		int i = 0;
		for (int b = 0; b < bucket.length; b++) // "Empty" buckets
			for (int j = 0; j < bucket[b]; j++) // back into array
				array[i++] = b + min; // by creating one per count
	}

	public static void InsertionSort(int A[]) {

		System.out.println("\n\tInsertion Sort");
		int i, key;
		// Increment Sorted Subarray
		for (int j = 1; j < A.length; j++) {
			key = A[j];
			i = j - 1;

			// Find position for element in subarray
			while (i >= 0 && A[i] > key) {

				A[i + 1] = A[i];
				i = i - 1;
				A[i + 1] = key;

			}
		}
	}
}
