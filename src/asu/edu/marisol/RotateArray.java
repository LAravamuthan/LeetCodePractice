package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RotateArray {

    /**
     * Reverse the array algorithm, reverse the whole array, then 0 to k-1 elements and then
     * k to length - 1.
     *
     * @time-complexity - O (n), elements in nums array.
     * @space-complexity - O (1)
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int [] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int curr = start;
            int prev = nums[start];
            do {
                int next = (curr + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                curr = next;
                prev = temp;
                count++;
            } while (start != curr);
        }
    }

    public void rotate3(int[] nums, int k) {
        int[] a = new int[nums.length];
        k %= nums.length;
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
