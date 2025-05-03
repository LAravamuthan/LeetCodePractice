package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NextPermutation {

    /**
     * Next permutation finding, first lowest from right side and swap that with smallest greater element.
     * then reverse the elements.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        } // now 'i' holds the first decreasing element.

        if (i >= 0) {
            int j = n - 1;
            // find the smallest highest number more than the decreasing element.
            while (nums[j] <= nums[i]) j--;

            // now j holds the smallest element that is greater than nums[i].
            swap(nums, i, j);
        }

        reverse(nums, i + 1, n - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        for (int start = i; start < i + (j - i + 1) / 2; start++) {
            swap(nums, start, j - (start - i));
        }
    }

}
