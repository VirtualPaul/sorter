import java.util.Arrays;
import java.io.*;

public class sort {
	
	public static void main(String[] args) throws IOException {
		System.out.print("\n**************************\n");
		System.out.print("Welcome to Sorter\n");
		System.out.print("Ver 0.1\n");
		System.out.print("Created 6/5/2015 by Paul Lacey\n\n");
		System.out.print("See which sorting algorithm performs the best!\n");
		System.out.print("**************************\n\n");

		System.out.print("enter csv nums to be sorted:");
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		String in = stdin.readLine();
		String[] strings = in.split("\\s*,\\s*");

		int[] nums = new int[strings.length];
		for (int i = 0; i < strings.length; ++i) {
			nums[i] = Integer.parseInt(strings[i]);
		}
		insertionSort(nums);
		selectionSort(nums);
		bubbleSort(nums);
	}

	private static void insertionSort(int[] nums) {
		int loop = 0;
		int[] array = Arrays.copyOfRange(nums, 0, nums.length);

		System.out.print("\n********* Insertion Sort **********\n");
		// printNumsArray(array);

		for (int i = 1; i < array.length; ++i) {
			for(int k = i; k > 0 && array[k] < array[k-1]; --k) {
				swap(array,k,k-1);
				// printNumsArray(array);
				++loop;
			}
			++loop;
		}
		System.out.println("Iterations: " + loop);
	}

	private static void selectionSort(int[] nums) {
		int loop = 0;
		int[] array = Arrays.copyOfRange(nums, 0, nums.length);

		System.out.print("\n********* Selection Sort **********\n");
		// printNumsArray(array);

		for (int i = 0; i < array.length; ++i) {
			int k = i;
			for (int j = 1 + i; j < array.length; ++j) {
				if (array[j] < array[k])
					k = j;
				printNumsArray(array);
				++loop;
			}
			swap(array, i, k);	
			// printNumsArray(array);
			++loop;
		}
		System.out.println("Iterations: " + loop);
	}

	private static void bubbleSort(int[] nums) {
		int loop = 0;
		int[] array = Arrays.copyOfRange(nums, 0, nums.length);

		System.out.print("\n********* Bubble Sort **********\n");
		// printNumsArray(array);
		for (int i=0; i < array.length; ++i) {
			
			boolean swapped = false;
			for(int j = array.length-1; j > i ; --j) {
				if(array[j] < array[j-1]) {
					swap(array, j, j-1);
					swapped = true;
				}
				if (swapped) {
					// printNumsArray(array);
				}
				++loop;
			}
			++loop;
			if(!swapped)
				break;
		}
		System.out.println("Iterations: " + loop);
	}

	private static void printNumsArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

	private static void printStringArray(String[] array) {
		System.out.println(Arrays.toString(array));
	}

	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}