package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Trying the two pointer approach.
     *
     * @time-complexity - O(n), number of elements.
     * @space-complexity - O(1).
     */
    public int removeDuplicates(int[] nums) {

        int prevUniqueIdx = 0;

        for (int nextUniqueIdx = 1; nextUniqueIdx < nums.length; nextUniqueIdx++) {
            if (nums[prevUniqueIdx] != nums[nextUniqueIdx]) nums[++prevUniqueIdx] = nums[nextUniqueIdx];
        }

        return prevUniqueIdx + 1;
    }

}
