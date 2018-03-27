import java.util.Arrays;
import java.util.Random;

public class CountingSort {

	public static int n = 20;//controls input size
	public static int range = 100;//controls element range

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
		System.out.println("*******************************************");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("*** \tindex : " + i + "\t***\t"+arr[i]+"\t***");
			System.out.println();
		}
		System.out.println("*******************************************");

	}
	/*Time complexity of this function:
	 *Total: O(4n+7) which is O(n) or Linear
	 */
	public static void countSort(int[] arr) {
		int count[] = new int[range];// O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function
		int[] output = new int[arr.length];// O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function

		// store count of each character
		for (int i = 0; i < arr.length; i++) {// O(n): Time Complexity of a loop is considered as O(n) if the loop variables is incremented / decremented by a constant amount.
			count[arr[i]] += 1;// O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function
		}

		for (int i = 1; i < count.length; i++) {// O(n): Time Complexity of a loop is considered as O(n) if the loop variables is incremented / decremented by a constant amount.
			count[i] += count[i - 1];// O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function
		}
		// Build the output integer array
		for (int i = 0; i < arr.length; i++) {// O(n): Time Complexity of a loop is considered as O(n) if the loop variables is incremented / decremented by a constant amount.
			output[count[arr[i]] - 1] = arr[i];// O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function
			--count[arr[i]];// O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function
		}
		for (int i = 0; i < arr.length; i++) {// O(n): Time Complexity of a loop is considered as O(n) if the loop variables is incremented / decremented by a constant amount.
			arr[i] = output[i];// O(1) if it doesn’t contain loop, recursion and call to any other non-constant time function
		}
	}
	
}
/*Sample Output:

	 ***Counting Sort (N : 20)***

Before: [31, 10, 15, 43, 48, 28, 1, 35, 30, 44, 31, 31, 45, 13, 30, 21, 38, 2, 17, 1]
After:  [1, 1, 2, 10, 13, 15, 17, 21, 28, 30, 30, 31, 31, 31, 35, 38, 43, 44, 45, 48]

*/