package asu.edu.marisol;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ContainsDuplicateII {

    /**
     * Mathematics problem.
     *
     * @time-complexity - O(logN).
     * @space-complexity - O(min(n,k)).
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (i - k >= 0) set.remove(nums[i - k]);
        }

        return false;
    }
}
