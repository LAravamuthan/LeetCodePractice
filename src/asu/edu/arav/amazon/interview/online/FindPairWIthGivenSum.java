package asu.edu.arav.amazon.interview.online;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FindPairWIthGivenSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNodes = new HashMap<Integer, Integer>();
        visitedNodes.put(nums[0], 0);
        int[] result = new int[2];
        int resultHighest = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (visitedNodes.containsKey(target - 30 - nums[i])) {
                if (resultHighest < i && resultHighest < visitedNodes.get(target - 30 - nums[i])) {
                    result[0] = visitedNodes.get(target - 30 - nums[i]);
                    result[1] = i;
                    resultHighest = Math.max(i, visitedNodes.get(target - 30 - nums[i]));
                }
            }
        }
        return result;
    }
}
