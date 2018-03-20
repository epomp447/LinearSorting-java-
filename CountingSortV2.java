import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

import java.util.Random;

public class CountingSortV2 {

	public static int n = 32;// controls size of Array
	public static int range = 400;

	public static void main(String[] args) {
		// int a[] = { 1, 4, 1, 2, 7, 5, 2 };
		// int A[] = { -1, -4, -1, -2, -7, -5, -2, 1, 4, 1, 2, 7, 5, 2 };
		System.out.println("\n\t ***Counting Sort (N : " + n + ")***");

		int[] arr = new int[n];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(range);
		}
		System.out.println("Before: " + Arrays.toString(arr));
		countSort(arr);

		double[] arr1 = new double[n];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = rand.nextDouble();
		}
		// double[] arr1 = { 0.10, 0.32, 0.98, 0.96, 0.65, 0.89, 0.55, 0.73, 0.87, 0.55,
		// 0.77, 0.46, 0.45, 0.75, 0.34,
		// 0.15, 0.51, 0.02, 0.85, 0.31 };
		// List<Double> arr2 = Arrays.asList(0.10, 0.32, 0.98, 0.96, 0.65, 0.89, 0.55,
		// 0.73, 0.87, 0.55, 0.77, 0.46, 0.45,
		// 0.75, 0.34, 0.15, 0.51, 0.02, 0.85, 0.31);
		// System.out.println(arr1.size());
		System.out.println("\n\t ***Bucket Sort (N : " + n + ")***");
		System.out.println("\nBefore: " + Arrays.toString(arr1));
		// insertionSort(arr2);
		bucketSort(arr1, n);
		System.out.println("After:  " + Arrays.toString(arr1));
		System.out.println("\n\tSorted Array Rounded to hundreth:  ");
		System.out.println("*******************************************");
		for (int i = 0; i < arr1.length; i++) {
			System.out.printf("*** \tindex : " + i + "\t***\t%.2f\t***", arr1[i]);
			System.out.println();
		}
		System.out.println("*******************************************");
	}

	public static void countSort(int[] arr) {
		int count[] = new int[range];
		int[] output = new int[arr.length];// initialize output array

		// store count of each character
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
		}
		// System.out.println("\n" + Arrays.toString(count));

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];// because first index is 0 in java
		}
		// System.out.println(Arrays.toString(count));

		// Build the output integer array
		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i]] - 1] = arr[i];
			// System.out.println("count[arr[i]] : " + count[arr[i]]);
			--count[arr[i]];
		}
		System.out.println("After:  " + Arrays.toString(output));
	}

	public static double[] bucketSort(double[] array, int n) {
		double high = array[0];
		double low = array[0];
		for (int i = 1; i < array.length; i++) { // find the range of input elements
			if (array[i] > high)
				high = array[i];
			if (array[i] < low)
				low = array[i];
		}

		List<Double> buckets[] = new ArrayList[n];
		for (int i = 0; i < n; i++) { // initialize buckets
			buckets[i] = new ArrayList();
		}

		double interval = ((double) (high - low + 1)) / n; // range of one bucket
		// System.out.println("interval= " + interval);

		for (int i = 0; i < array.length; i++) { // partition the input array
			buckets[(int) ((array[i] - low) / interval)].add((double) array[i]);

		}

		int pointer = 0;
		for (int i = 0; i < buckets.length; i++) {
			insertionSort(buckets[i]);
			for (int j = 0; j < buckets[i].size(); j++) { // merge the buckets
				array[pointer] = buckets[i].get(j);
				pointer++;

			}
		}
		return array;

	}

	public static void insertionSort(List<Double> A) {

		int i;
		double key;

		for (int j = 1; j < A.size(); j++) {
			key = A.get(j);
			i = j - 1;

			// Find position for element in subarray
			while (i >= 0 && A.get(i) > key) {

				A.set(i + 1, A.get(i));
				i = i - 1;
				A.set(i + 1, key);

			}
		}

		// System.out.println("Insertion Sort " + Arrays.toString(A));
	}

}
