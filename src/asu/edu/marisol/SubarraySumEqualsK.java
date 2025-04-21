package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SubarraySumEqualsK {

    /**
     * Hashmap approach lets see how it works in the first place.
     *
     * @time-complexity - O (amount * coins).
     * @space-complexity - O (amount).
     */
    public int subarraySum(int[] nums, int k) {
        return 0;
    }

    /**
     * Cumulative sum approach, idea is if sum[j] - sum[i] = k, means between i and j there is subarray of sum k.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public int subarraySum2(int[] nums, int k) {
        int result = 0;

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum - k)) result += sumMap.get(sum - k);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
