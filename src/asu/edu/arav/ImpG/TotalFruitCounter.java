package asu.edu.arav.ImpG;

import asu.edu.aravl.utility.Counter;

public class TotalFruitCounter {

	/*
	 * The aim here in this sub method is to find a subarray in an array with
	 * maximum length satisfy the condition that it has to be of atmost two types
	 * values only, let us see how it goes
	 */

	public static int totalFruit(int[] tree) {
		int ans = 0;
		int lower = 0; // this variable here keeps the note of the last index from where we curretly
						// have only two type of integers

		Counter count = new Counter();// this HashMap keeps an count of the integer values and there corresponding
										// values into consideration for current count

		for (int i = 0; i < tree.length; i++) {
			count.add(tree[i], 1); // incresing count for each individual elements as and when they come
			while (count.size() > 2) {
				count.add(tree[lower], -1);// eliminate elements from the start
				if (count.get(tree[lower]) == 0) {
					count.remove(tree[lower]);
				}
				lower++;// noting the elements removed from consideration
			}
			ans = Math.max(ans, i - lower + 1); // making sure we capture the maximum possible value
		}
		return ans;
	}

	public static void main(String args[]) {

	}

}
