import java.util.Arrays;
import java.util.Random;

public class CountingSort {
	public static int min=0;
	public static int max=0;
public static int n=10;
public static int range=50;
	public static void main(String[] args) {
		int a[] = { 1, 4, 1, 2, 7, 5, 2 };
		int A[] = { -1, -4, -1, -2, -7, -5, -2, 1, 4, 1, 2, 7, 5, 2 };
		System.out.println(Arrays.toString(a));
		countingSort(a);

		

		countingSortV2(a);
		int list[] = new int[19];
		int enumerate = 0;
		for (int i = -9; i <= list.length / 2; i++) {
			list[i - i + enumerate++] = i;
			
		}
		Arrays.sort(list);
		System.out.println("\n" + Arrays.toString(A));
		
		//countingSortV3(A);
		
		int[] arr = new int[n];
		Random rand = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(range);
		}
		countingSortV2(arr);
	}

	static void countingSort(int[] arr) {
		int[] count = new int[10];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count[0] += 1;
			}
			if (arr[i] == 1) {
				count[1] += 1;
			}
			if (arr[i] == 2) {
				count[2] += 1;
			}
			if (arr[i] == 3) {
				count[3] += 1;
			}
			if (arr[i] == 4) {
				count[4] += 1;
			}
			if (arr[i] == 5) {
				count[5] += 1;
			}
			if (arr[i] == 6) {
				count[6] += 1;
			}
			if (arr[i] == 7) {
				count[7] += 1;
			}
			if (arr[i] == 8) {
				count[8] += 1;
			}
			if (arr[i] == 9) {
				count[9] += 1;
			}

		}
		System.out.println("\n" + Arrays.toString(count));

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		System.out.println(Arrays.toString(count));
	}

	static void countingSortV2(int[] arr) {
		int count[] = new int[range];
		int[] output = new int[arr.length];
		// store count of each character
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
		}
		System.out.println("\n" + Arrays.toString(count));

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		System.out.println(Arrays.toString(count));
		// Build the output character array
		for (int i = 0; i < arr.length; i++) {
			output[count[arr[i]] - 1] = arr[i];
			System.out.println("count[arr[i]] : " + count[arr[i]]);
			--count[arr[i]];
		}
		System.out.println(Arrays.toString(output));
	}

	static void countingSortV3(int[] arr) {
		int count[] = new int[20];
		int output[] = new int[arr.length];
		int n = arr.length;

		System.out.println("n = "+ n);
		int[] m = getMinMax(arr, n);
		int min = m[0];
		int max = m[1];

		
		
		int [] counts=new int [max-min+1];
		
		
		for (int i = 0; i < arr.length; i++) {
			counts[arr[i]-min]+=1;
		}

		System.out.println("\n" + Arrays.toString(counts));
		  int k = 0;

		    for (int j = max; j >= min; j--){
		        for (int i = 0; i < counts[j - min]; i++){
		            arr[k++] = j;
		        }
		    }
		    System.out.println("\n" + Arrays.toString(counts));
	// Change count[i] so that count[i] now contains actual
	// position of this character in output array
	for (int i = 1; i < counts.length; i++) {
		counts[i] += counts[i - 1];
		}
	System.out.println(Arrays.toString(counts));

		// Build the output character array
		for (int i = 0; i < arr.length; i++) {
			//output[counts[arr[i]] -1] = arr[i];
			 System.out.println("count[arr[i]] : "+count[arr[i]]);
			counts[arr[i]] -= 1;
		}
		System.out.println(Arrays.toString(output));
	}

	public static int[] getMinMax(int arr[], int n) {
		int i;
		if (n % 2 == 0) {

			if (arr[0] > arr[1]) {
				max = arr[0];
				min = arr[1];

			} else {
				min = arr[0];
				max = arr[1];

			}

			i = 2; /* set the starting index for loop */
		}
		/*
		 * If array has odd number of elements then initialize the first element as
		 * minimum and maximum
		 */
		else {
			min = arr[0];
			max = arr[0];
			i = 1; /* set the starting index for loop */
		}
		/*
		 * In the while loop, pick elements in pair and compare the pair with max and
		 * min so far
		 */
		while (i < n - 1) {

			if (arr[i] > arr[i + 1]) {
				if (arr[i] > max) {

					max = arr[i];

				}
				if (arr[i + 1] < min) {

					min = arr[i + 1];

				}

			} else {
				if (arr[i + 1] > max) {

					max = arr[i + 1];

				}
				if (arr[i] < min) {

					min = arr[i];

				}
			}
			i += 2; // Increment the index by 2, two elements are processed in loop

		}
		System.out.print("\nMinimum element is " + min);
		System.out.println("\nMaximum element is " + max);

		int[] a = { min, max };
		return a;
	}
}
