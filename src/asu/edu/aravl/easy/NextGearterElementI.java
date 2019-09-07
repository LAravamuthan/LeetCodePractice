package asu.edu.aravl.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class NextGearterElementI {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] ans = new int[findNums.length];

        Map<Integer, Integer> integerIntegerMap = new HashMap<Integer, Integer>();
        Stack<Integer> integerStack = new Stack<Integer>();

        integerStack.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            while (!integerStack.empty() && integerStack.peek() < nums[i]) {
                integerIntegerMap.put(integerStack.pop(), nums[i]);
            }
            integerStack.push(nums[i]);
        }

        while (!integerStack.empty()) {
            integerIntegerMap.put(integerStack.pop(), -1);
        }

        for (int i = 0; i < findNums.length; i++) {
            ans[i] = integerIntegerMap.get(findNums[i]);
        }
        return ans;
    }
}
