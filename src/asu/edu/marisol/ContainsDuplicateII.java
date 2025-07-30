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

    /**
     * Mathematics problem.
     *
     * @time-complexity - O(logN).
     * @space-complexity - O(min(n,k)).
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) return true;
            seen.add(nums[i]);
            if (i - k >= 0) seen.remove(nums[i - k]);
        }

        return false;
    }
}
