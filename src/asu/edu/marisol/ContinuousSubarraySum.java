package asu.edu.marisol;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ContinuousSubarraySum {

    /**
     * The prefix sum problem.
     *
     * @time-complexity - O(N).
     * @space-complexity - O(N).
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        int preFixMod = 0;
        Map<Integer, Integer> modSeen = new HashMap<>();
        modSeen.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            preFixMod = (preFixMod + nums[i]) % k;

            if (modSeen.containsKey(preFixMod)) {
                if (i - modSeen.get(preFixMod) > 1) return true;
                // even if the size is not bigger than 1 dont update the modSeen, because the want maximize size to
                // make it more than 2
            } else {
                modSeen.put(preFixMod, i);
            }
        }

        return false;
    }
}
