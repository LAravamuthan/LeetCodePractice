package asu.edu.aravl.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note:
//
//The solution set must not contain duplicate triplets.
//
//Example:
//
//Given array nums = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

public class ThreeSum {
	public static void main(String args[]) {
		int[] input = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(input));
	}

	public static List<List<Integer>> threeSum(int[] nums) {

		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		List<Integer> input = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			input.add(nums[i]);
		}
		int sum = 0;
		// sort the elements
		Collections.sort(input);
		// we will have to consider only n-2 terms as the others will be checked as part
		// of the inner loop
		for (int i = 0; i < input.size() - 2; i++) {
			
			if (i == 0 || (i > 0 && !input.get(i).equals(input.get(i - 1)))) {
				int low = i + 1;// start from i + 1 index
				int high = input.size() - 1;// use the last element for comparision too
				sum = sum - input.get(i);
				while (low < high) {
					if (sum == input.get(low) + input.get(high)) {// once a match is found
						ArrayList<Integer> innerAnswer = new ArrayList<Integer>();
						// note down the answer
						innerAnswer.add(input.get(i));
						innerAnswer.add(input.get(low));
						innerAnswer.add(input.get(high));
						answer.add(innerAnswer);
						// to the next different element from lower side so as to prune duolicates
						while (low < high && input.get(low).equals(input.get(low + 1)))
							low++;
						// to the previous different element from higher side so as to prune duolicates
						while (low < high && input.get(high).equals(input.get(high - 1)))
							high--;
						// below two are for next best solutions
						low++;
						high--;
					} else if (input.get(low) + input.get(high) < sum) {
						// if sum is lower than intended sum increase the value to be included
						low++;
					} else
						// if sum is higher than intended sum decrease the value to be included
						high--;
				}
			}
			sum = 0;
		}
		return answer;
	}
}
