package asu.edu.arav.ImpG;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedElements {

	public static List<Integer> findDisappearedNumbers(int[] nums) {

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			
			/*
			 * this while is to make that either the element is at its correct position(n[i]
			 * = i+1) or the correct position of current value already has an correct value,
			 * Till then swap the value with its correct index
			 */

			while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[i];
				nums[i] = nums[nums[i] - 1];
				nums[temp - 1] = temp;
			}
		}
		
		// once we have elements at their correct positions those 
		// index who don't have the correct value are the elements missing
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				result.add(i + 1);
			}
		}
		return result;
	}
	
	
	public static List<Integer> findDisappearedNumbers2(int[] nums) {

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			/*
			 * this method is even simpler mark the indexes which match the values negative
			 * the answer are those indexes which are none negative
			 */
			
			if(nums[Math.abs(nums[i])-1] > 0) {
				nums[Math.abs(nums[i])-1] = -nums[Math.abs(nums[i])-1];
			}
		}
		// select out the none negative indexes as they are the values
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] i = {4,3,2,7,8,2,3,1};
		System.out.println(findDisappearedNumbers2(i));
	}
}
