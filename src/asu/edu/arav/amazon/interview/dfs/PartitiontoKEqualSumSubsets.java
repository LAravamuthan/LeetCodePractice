package asu.edu.arav.amazon.interview.dfs;


/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */

public class PartitiontoKEqualSumSubsets {

    /**
     * @algo DFS
     * @time-complexity O(2 ^ n)
     * @space-complexity O(2 ^ n)
     */

    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return false;
        }
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        /* if the totalSum are not divisible by k then we cant divide them at all
         * if k==1 then its possible for sure as the left over elements will add up to
         * target */

        if (totalSum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return canPartition(nums, k, 0, 0, 0, totalSum / k, visited);
    }

    public boolean canPartition(int[] nums, int remainParitioning, int startidx, int eles, int curSum, int target, boolean[] visited) {
        if (remainParitioning == 1) {
            return true;
        }
        /* the curSum is more than the target dont go forward*/
        if (curSum > target) {
            return false;
        }

        /* the curSum is equal to the target then search the next partition starting from '0' idx
         * and start a new sum dont change visited array */
        if (curSum == target && eles > 0) {
            return canPartition(nums, remainParitioning - 1, 0, 0, 0, target, visited);
        }

        for (int i = startidx; i < nums.length; i++) {
            /* if the element is not visited then add to the sum check the next idx */
            if (!visited[i]) {
                visited[i] = true;
                if (canPartition(nums, remainParitioning, i + 1, eles + 1, curSum + nums[i], target, visited))
                    return true;
                /* backtrack once the recursion with current element is done */
                visited[i] = false;
            }
        }
        return false;
    }
}
