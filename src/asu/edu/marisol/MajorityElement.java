package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class MajorityElement {

    /**
     * Boyer-Moore Majority Voting Algorithm.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1)
     */
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;
        Integer candidate = null;
        int count = 0;

        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }

    /**
     * Divide and conquer way of doing things.
     *
     * @time-complexity - O (NlgN).
     * @space-complexity - O (lgN)
     */
    public int majorityElement2(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;

        return majorityElement(nums, 0, nums.length - 1);
    }

    private int count(int[] nums, int candidate, int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            if (nums[i] == candidate) count++;
        }

        return count;
    }

    private int majorityElement(int[] nums, int low, int high) {
        if (low == high) return nums[low];

        int mid = (high - low)/2 + low;
        int leftCandidate = majorityElement(nums, low, mid);
        int rightCandidate = majorityElement(nums, mid + 1, high);

        if (leftCandidate == rightCandidate) return leftCandidate;

        int leftCount = count(nums, leftCandidate, low, high);
        int rightCount = count(nums, rightCandidate, low, high);

        return leftCount > rightCount ? leftCandidate : rightCandidate;
    }

    /**
     * Divide and conquer way of doing things second practice.
     *
     * @time-complexity - O(NlogN).
     * @space-complexity - O (logN)
     */
    public int majorityElement3(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;

        return findMajority(nums, 0, nums.length - 1);
    }

    private int countValue(int[] nums, int left, int right, int value) {
        int count = 0;
        for (int i = left; i <= right; i++)
            if (nums[i] == value) count++;
        return count;
    }

    private int findMajority(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;

        int leftMajority = findMajority(nums, left, mid);
        int rightMajority = findMajority(nums, mid + 1, right);

        int leftCount = countValue(nums, left, mid, leftMajority);
        int rightCount = countValue(nums, mid + 1, right, rightMajority);

        return leftCount > rightCount ? leftMajority : rightMajority;
    }
}
