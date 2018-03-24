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
		// double[] arr1 = { 0.10, 0.32, 0.98, 0.96, 0.65, 0.89, 0.55, 0.73, 0.87, 0.55,
		// 0.77, 0.46, 0.45, 0.75, 0.34,
		// 0.15, 0.51, 0.02, 0.85, 0.31 };
		// List<Double> arr2 = Arrays.asList(0.10, 0.32, 0.98, 0.96, 0.65, 0.89, 0.55,
		// 0.73, 0.87, 0.55, 0.77, 0.46, 0.45,
		// 0.75, 0.34, 0.15, 0.51, 0.02, 0.85, 0.31);
		// System.out.println(arr1.size());
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
/*Sample Output:

	 ***Bucket Sort (N : 20)***

Before: [0.5041627791062595, 0.3096798756532111, 0.7237664287566757, 0.10372221276415172, 0.5779641635403974, 0.22727944824461477, 0.6779172949092807, 0.16822387853806964, 0.3084472811079102, 0.46029059143986883, 0.2820082321810664, 0.5414015508643718, 0.6279062695044962, 0.38818720513615923, 0.44210391850786157, 0.454080273548921, 0.8506685396454199, 0.31183428071530317, 0.858621780159413, 0.2338424817798821]
 Bucket [0]	====>	[0.10372221276415172, 0.16822387853806964]
 Bucket [1]	====>	[0.22727944824461477, 0.2338424817798821]
 Bucket [2]	====>	[0.2820082321810664, 0.3084472811079102, 0.3096798756532111, 0.31183428071530317]
 Bucket [3]	====>	[0.38818720513615923, 0.44210391850786157, 0.454080273548921]
 Bucket [4]	====>	[0.46029059143986883, 0.5041627791062595, 0.5414015508643718]
 Bucket [5]	====>	[0.5779641635403974, 0.6279062695044962]
 Bucket [6]	====>	[0.6779172949092807]
 Bucket [7]	====>	[0.7237664287566757]
 Bucket [8]	====>	[0.8506685396454199, 0.858621780159413]
 Bucket [9]	====>	[empty]
 Bucket [10]	====>	[empty]
 Bucket [11]	====>	[empty]
 Bucket [12]	====>	[empty]
 Bucket [13]	====>	[empty]
 Bucket [14]	====>	[empty]
 Bucket [15]	====>	[empty]
 Bucket [16]	====>	[empty]
 Bucket [17]	====>	[empty]
 Bucket [18]	====>	[empty]
 Bucket [19]	====>	[empty]
After:  [0.10372221276415172, 0.16822387853806964, 0.22727944824461477, 0.2338424817798821, 0.2820082321810664, 0.3084472811079102, 0.3096798756532111, 0.31183428071530317, 0.38818720513615923, 0.44210391850786157, 0.454080273548921, 0.46029059143986883, 0.5041627791062595, 0.5414015508643718, 0.5779641635403974, 0.6279062695044962, 0.6779172949092807, 0.7237664287566757, 0.8506685396454199, 0.858621780159413]

	Sorted Array Rounded to hundreth:  
*******************************************
*** 	index : 0	***	0.10	***
*** 	index : 1	***	0.17	***
*** 	index : 2	***	0.23	***
*** 	index : 3	***	0.23	***
*** 	index : 4	***	0.28	***
*** 	index : 5	***	0.31	***
*** 	index : 6	***	0.31	***
*** 	index : 7	***	0.31	***
*** 	index : 8	***	0.39	***
*** 	index : 9	***	0.44	***
*** 	index : 10	***	0.45	***
*** 	index : 11	***	0.46	***
*** 	index : 12	***	0.50	***
*** 	index : 13	***	0.54	***
*** 	index : 14	***	0.58	***
*** 	index : 15	***	0.63	***
*** 	index : 16	***	0.68	***
*** 	index : 17	***	0.72	***
*** 	index : 18	***	0.85	***
*** 	index : 19	***	0.86	***
*******************************************
*/
