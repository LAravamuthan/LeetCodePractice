package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * Trying the two pointer approach.
     *
     * @time-complexity - O(n), number of elements.
     * @space-complexity - O(1).
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int j = 1; // position where new element is to be filled.
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                count++;
            } else {
                count = 1; // new element has been found.
            }
            // if the count is in manageable range move the position where new element has to
            // be filled
            if (count <= 2) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
