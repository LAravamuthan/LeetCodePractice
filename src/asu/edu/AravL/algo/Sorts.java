package asu.edu.AravL.algo;

import java.util.Random;

public class Sorts {

	public int[] insertionSort(int[] a) {

		// this sort took 2 and 12 secs for 100k and 200k integer elements
		// handling null condition
		if (a == null) {
			return a;
		}

		for (int j = 1; j < a.length; j++) { // position of integer to be sorted
			int key = a[j]; // the value that needs to be put at its right place
			int i = j - 1; // index of last sorted element
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i]; // pushing the bigger value to write, remember the value that has been lost here
									// is the value of a[j] i.e the key variable
				i--;
			}
			a[i + 1] = key; // putting the key integer at its correct location, never do a mistake here it
							// is embarrassing
		}
		return a;
	}

	public void merge(int[] a, int f, int m, int l) {

		/*
		 * 100 million elements were sorted in 13 secs 10 million elements in 1.5 secs 1
		 * million elements in .2 secs 100k elements in 0.027 secs 200k elements in 0.05
		 * secs
		 */
		int l1 = m - f + 1; // from first index to mid index +1 compensating for the length lost in the
							// previous step
		int r1 = l - m; // from the mid index to the last one

		int[] l_1 = new int[l1];
		int[] r_1 = new int[r1];

		for (int i = 0; i < l1; i++) {
			l_1[i] = a[f + i];// filling the left subarray remember the index 'f' till the middle element
		}

		for (int i = 0; i < r1; i++) {
			r_1[i] = a[m + i + 1];// filling the left subarray also 'm' wont be included in this subarray
		}

		int i = 0, j = 0;
		// we will be merging the two sorted subarrays now
		while (i < l1 && j < r1) {
			if (l_1[i] < r_1[j]) {
				a[f] = l_1[i];
				i++;
			} else {
				a[f] = r_1[j];
				j++;
			}
			f++;
		}

		// if one sub array becomes empty fill the resultant with the rest of elements
		// of the other array
		while (i < l1) {
			a[f] = l_1[i];
			f++;
			i++;
		}

		while (j < r1) {
			a[f] = r_1[j];
			f++;
			j++;
		}

	}

	public void mergeSort(int[] a, int f, int l) {
		if (f < l) {// of course the first index has to lower then the last index
			int m = (f + l) / 2; // floor function due to the presence of int here
			mergeSort(a, f, m); // Sort the left half
			mergeSort(a, m + 1, l); // Sort the right half
			merge(a, f, m, l);
		}
	}

	public int partition(int[] a, int p, int r) {
		int pivot = a[r]; // the element which we choose to make it the pivot.
		int i = p - 1; // the indexes till which all the elements are lesser than the pivot
		for (int j = p; j < r; j++) { // for elements to segregate would start from the first element but keep in
										// mind it wont include the last element ?? As thats the pivot u see // r-1 wont
										// be right
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp = a[r];
		a[r] = a[i + 1];
		a[i + 1] = temp;
		return i + 1;
	}

	public void quickSort(int[] a, int p, int r) {
		// Performance is comparable to merge sort, but the performance degrades
		// drastically if the pivoting is bad i.e stack overflow conditions will occur
		if (p < r) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	public static void main(String[] args) {
		Random rn = new Random();
		int[] input = new int[100000000];

		for (int i = 0; i < input.length; i++) {
			input[i] = rn.nextInt(10 - 1 + 1) + 1;
		}

		Sorts s = new Sorts();

		long startTime = System.nanoTime();
		// input = s.insertionSort(input);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);

		System.out.println("Time taken for insertion  sort " + duration / 1000000);

		for (int i = 0; i < input.length; i++) {
			input[i] = rn.nextInt(10 - 1 + 1) + 1;
		}

		startTime = System.nanoTime();
		s.mergeSort(input, 0, input.length - 1);
		endTime = System.nanoTime();
		duration = (endTime - startTime);

		/*
		 * for(int i = 0; i < input.length; i ++) { System.out.println(input[i] + "\t");
		 * }
		 */

		System.out.println("Time taken for Merge sort " + duration / 1000000);

		for (int i = 0; i < input.length; i++) {
			input[i] = rn.nextInt(10000000 - 1 + 1) + 1;
		}

		startTime = System.nanoTime();
		s.quickSort(input, 0, input.length - 1);
		endTime = System.nanoTime();
		duration = (endTime - startTime);

		/*
		 * for(int i = 0; i < input.length; i ++) { System.out.println(input[i] + "\t");
		 * }
		 */
		System.out.println("Time taken for Quick sort " + duration / 1000000);
	}

}
