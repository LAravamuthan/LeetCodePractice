package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class TwoSum {

    /**
     * This approach is the simplest I know.
     * @time-complexity - O (n)
     * @space-complexity - O (n)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) return new int[] { -1, -1 };

        // map of val and idx of the same.
        Map<Integer, Integer> numStore = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            if (numStore.getOrDefault(target - nums[i], -1) != -1) {
                return new int[] { numStore.get(target - nums[i]), i };
            } else {
                numStore.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }
}
