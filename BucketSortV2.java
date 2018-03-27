import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BucketSortV2 {
	public static int n = 20;// controls size of Array

	public static void main(String[] args) {
		Random rand = new Random();
		double[] arr1 = new double[n];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = rand.nextDouble();
		}
		
		System.out.println("\n\t ***Bucket Sort (N : " + n + ")***");
		System.out.println("\nBefore: " + Arrays.toString(arr1));

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

	public static double[] bucketSort(double[] array, int n) {
		double high = array[0];
		double low = array[0];
		for (int i = 1; i < array.length; i++) { // find the range of input elements
			if (array[i] > high)
				high = array[i];
			if (array[i] < low)
				low = array[i];
		}

		List<Double> buckets[] = new ArrayList[n];//construct a "List of arrays"
		for (int i = 0; i < n; i++) { // initialize buckets
			buckets[i] = new ArrayList();
		}

		double interval = ((double) (high - low + 1)) / n; // range of one bucket

		for (int i = 0; i < array.length; i++) { // partition the input array
			buckets[(int) ((array[i] - low) / interval)].add((double) array[i]);

		}

		int pointer = 0;// specifies the current bucket
		for (int i = 0; i < buckets.length; i++) {
			insertionSort(buckets[i]);
			for (int j = 0; j < buckets[i].size(); j++) { // merge the buckets
				array[pointer] = buckets[i].get(j);
				pointer++;
			}
		}

		 /*Show Buckets (Debugging)*/
		 for (int i = 0; i < array.length; i++) {
		 if (buckets[i].isEmpty()) {
		 System.out.println(" Bucket ["+i+"]\t====>\t" + "[empty]");
		 }else
		 System.out.println(" Bucket ["+i+"]\t====>\t" + buckets[i]);
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
	}
}
