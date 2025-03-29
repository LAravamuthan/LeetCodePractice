package asu.edu.marisol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ThreeSum {

    /**
     *  sort and twoSum II, O(nlogn + n^2).
     *
     * @time-complexity - O(nlogn + n^2).
     * @space-complexity - O(n).
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSumII(nums, i);
            }
        }
        return res;
    }

    List<List<Integer>> res = new ArrayList<>();

    private void twoSumII(int[] nums, int i) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                lo++;
            } else if (sum > 0) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[i] == nums[i - 1]) lo++;
            }
        }
    }


    public List<List<Integer>> threeSum2(int[] nums) {

        Set<Integer> duplicates = new HashSet<>();
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (duplicates.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int compliment = -nums[i] - nums[j];
                    if (seen.containsKey(compliment) && seen.get(compliment) == i) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], compliment);
                        Collections.sort(triplet);
                        res.add(triplet);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return res;
    }

}
