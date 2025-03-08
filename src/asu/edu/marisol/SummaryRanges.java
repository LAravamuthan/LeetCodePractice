package asu.edu.marisol;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SummaryRanges {

    /**
     * This approach was one which I made in a rough way.
     * @time-complexity - O (n)
     * @space-complexity - O (n)
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) return ans;

        Integer s = nums[0];
        Integer e = null;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 == nums[i - 1])
                e = nums[i];
            else {
                if (e == null) {
                    ans.add(String.valueOf(s));
                } else {
                    ans.add(s + "->" + e);
                }
                s = nums[i];
                e = null;
            }
        }

        if (e == null) {
            ans.add(String.valueOf(s));
        } else {
            ans.add(s + "->" + e);
        }

        return ans;
    }

    /**
     * This approach was one which I made in a rough way in optimized way
     * @time-complexity - O (n)
     * @space-complexity - O (n) because the ans list is also considered as part of usage of memory
     */
    public List<String> summaryRanges3(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if (nums.length == 0) return ranges;

        int start = nums[0], end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1)
                end = nums[i];
            else {
                ranges.add(start == end ? String.valueOf(start) : start + "->" + end);
                start = end = nums[i];
            }
        }

        ranges.add(start == end ? String.valueOf(start) : start + "->" + end);

        return ranges;
    }

    /**
     * This approach is an efficient way of reaching state of change in invariables.
     * @time-complexity - O (n)
     * @space-complexity - O (n)
     */
    public List<String> summaryRanges2(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) i++;

            if (start != nums[i]) {
                ranges.add(start + "->" + nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }
        }

        return ranges;
    }
}
