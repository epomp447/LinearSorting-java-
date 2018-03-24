import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	public static int n = 20;//controls input size
	public static int range = 50;//controls element range

	public static void main(String[] args) {
		// int a[] = { 1, 4, 1, 2, 7, 5, 2 };
		// int A[] = { -1, -4, -1, -2, -7, -5, -2, 1, 4, 1, 2, 7, 5, 2 };

		System.out.println("\n\t ***Counting Sort (N : " + n + ")***");

		int[] arr = new int[n];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(range);
		}
		System.out.println("\nBefore: " + Arrays.toString(arr));

		countSort(arr);
		System.out.println("After:  " + Arrays.toString(arr));

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
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}

	}
}
/*Sample Output:

	 ***Counting Sort (N : 20)***

Before: [31, 10, 15, 43, 48, 28, 1, 35, 30, 44, 31, 31, 45, 13, 30, 21, 38, 2, 17, 1]
After:  [1, 1, 2, 10, 13, 15, 17, 21, 28, 30, 30, 31, 31, 31, 35, 38, 43, 44, 45, 48]

*/