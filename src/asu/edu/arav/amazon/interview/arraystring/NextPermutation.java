package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int i = nums.length - 1;
        for (; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) break;
        }
        if (i > 0) {
            int minMaxIdx = -1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i - 1]) {
                    minMaxIdx = minMaxIdx == -1 ? j : nums[minMaxIdx] > nums[j] ? j : minMaxIdx;
                }
            }
            int temp = nums[i - 1];
            nums[i - 1] = nums[minMaxIdx];
            nums[minMaxIdx] = temp;
        }
        reverseFromIndex(nums, i);
    }

    public void reverseFromIndex(int[] nums, int j) {
        for (int i = j; i < (nums.length - j) / 2 + j; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i + j];
            nums[nums.length - 1 - i + j] = temp;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        np.nextPermutation(new int[]{1, 3, 2});
    }


}
