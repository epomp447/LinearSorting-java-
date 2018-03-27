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
/*

	 ***Bucket Sort (N : 20)***

Before: [0.8746702387767236, 0.2211997261330999, 0.860799286108636, 0.4524395046874081, 0.1376117353892432, 0.4657785061931601, 0.9280003292106171, 0.2503352267116916, 0.10437379371491551, 0.6025431257126795, 0.4108667715629143, 0.024343956926744847, 0.5918455173175013, 0.7437324875489989, 0.18070573738081475, 0.7573491926640816, 0.1403707195753361, 0.49849573628624655, 0.8491179085094744, 0.14862458794958522]
 Bucket [0]	====>	[0.024343956926744847, 0.10437379371491551]
 Bucket [1]	====>	[0.1376117353892432, 0.1403707195753361, 0.14862458794958522, 0.18070573738081475]
 Bucket [2]	====>	[0.2211997261330999, 0.2503352267116916]
 Bucket [3]	====>	[empty]
 Bucket [4]	====>	[0.4108667715629143, 0.4524395046874081, 0.4657785061931601, 0.49849573628624655]
 Bucket [5]	====>	[0.5918455173175013]
 Bucket [6]	====>	[0.6025431257126795]
 Bucket [7]	====>	[0.7437324875489989, 0.7573491926640816]
 Bucket [8]	====>	[0.8491179085094744, 0.860799286108636, 0.8746702387767236]
 Bucket [9]	====>	[0.9280003292106171]
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
After:  [0.024343956926744847, 0.10437379371491551, 0.1376117353892432, 0.1403707195753361, 0.14862458794958522, 0.18070573738081475, 0.2211997261330999, 0.2503352267116916, 0.4108667715629143, 0.4524395046874081, 0.4657785061931601, 0.49849573628624655, 0.5918455173175013, 0.6025431257126795, 0.7437324875489989, 0.7573491926640816, 0.8491179085094744, 0.860799286108636, 0.8746702387767236, 0.9280003292106171]

	Sorted Array Rounded to hundreth:  
*******************************************
*** 	index : 0	***	0.02	***
*** 	index : 1	***	0.10	***
*** 	index : 2	***	0.14	***
*** 	index : 3	***	0.14	***
*** 	index : 4	***	0.15	***
*** 	index : 5	***	0.18	***
*** 	index : 6	***	0.22	***
*** 	index : 7	***	0.25	***
*** 	index : 8	***	0.41	***
*** 	index : 9	***	0.45	***
*** 	index : 10	***	0.47	***
*** 	index : 11	***	0.50	***
*** 	index : 12	***	0.59	***
*** 	index : 13	***	0.60	***
*** 	index : 14	***	0.74	***
*** 	index : 15	***	0.76	***
*** 	index : 16	***	0.85	***
*** 	index : 17	***	0.86	***
*** 	index : 18	***	0.87	***
*** 	index : 19	***	0.93	***
*******************************************


*/
