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

Before: [45, 24, 19, 97, 34, 36, 76, 37, 21, 4, 95, 16, 48, 65, 24, 34, 53, 39, 31, 53]
*******************************************
*** 	index : 0	***	4	***
*** 	index : 1	***	16	***
*** 	index : 2	***	19	***
*** 	index : 3	***	21	***
*** 	index : 4	***	24	***
*** 	index : 5	***	24	***
*** 	index : 6	***	31	***
*** 	index : 7	***	34	***
*** 	index : 8	***	34	***
*** 	index : 9	***	36	***
*** 	index : 10	***	37	***
*** 	index : 11	***	39	***
*** 	index : 12	***	45	***
*** 	index : 13	***	48	***
*** 	index : 14	***	53	***
*** 	index : 15	***	53	***
*** 	index : 16	***	65	***
*** 	index : 17	***	76	***
*** 	index : 18	***	95	***
*** 	index : 19	***	97	***
*******************************************


*/
