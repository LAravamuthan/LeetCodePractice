package asu.edu.arav.amazon.interview.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    // Hashmap method
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numFrequency = new HashMap<Integer, Integer>();
        for (int num : nums) {
            numFrequency.put(num, numFrequency.getOrDefault(num, 0) + 1);
        }
        for (int key : numFrequency.keySet()) {
            if (numFrequency.get(key) > nums.length / 2) {
                return key;
            }
        }
        return -1;
    }

    // sorted way
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // divide and conquer
    public int majorityElement3(int[] nums) {
        return majorityElement3(nums, 0, nums.length - 1);
    }

    public int majorityElement3(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (high - low) / 2 + low;
        int left = majorityElement3(nums, low, mid);
        int right = majorityElement3(nums, mid + 1, high);
        int leftCount = returnCount(nums, low, mid, left);
        int rightCount = returnCount(nums, mid + 1, high, right);
        return leftCount > rightCount ? leftCount : rightCount;
    }

    public int returnCount(int[] nums, int s, int e, int key) {
        int count = 0;
        for (int i = s; i <= e; i++) {
            count += nums[i] == key ? 1 : 0;
        }
        return count;
    }

    //counting algorithm
    public int majorityElement4(int[] nums) {
        int count = 0;
        int key = -1;
        for (int n : nums) {
            if (count == 0) {
                key = n;
                count++;
            }
            count += key == n ? 1 : -1;
        }
        return key;
    }

    public boolean isMajorityElement(int[] nums, int target) {
        if (nums.length % 2 == 0) {
            return nums[nums.length / 2] == target && nums[nums.length / 2 + 1] == target;
        }
        return nums[nums.length / 2] == target;
    }

}