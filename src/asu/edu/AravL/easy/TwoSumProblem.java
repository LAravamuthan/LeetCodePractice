package asu.edu.AravL.easy;

import java.util.HashMap;
import java.util.Map;

/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/

public class TwoSumProblem {
	
	public int[] twoSum(int[] nums, int target) {
        
		Map<Integer, Integer> numIdxMap = new HashMap<Integer, Integer>();
		int [] resultindex=new int[2];
		for(int i = 0; i < nums.length; i ++) {
			if(numIdxMap.get(target - nums[i])!=null) {
				resultindex[0]=numIdxMap.get(target - nums[i]);
				resultindex[1]=i;
				return resultindex;
			}
			numIdxMap.put(nums[i], i);
		}
		return resultindex;
    }
	
	
}
