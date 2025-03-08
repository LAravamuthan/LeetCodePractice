package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RemoveElement {

    /**
     * Remove element using two pointers, with one pointer moving faster the other,
     * Useful when many elements are to be removed.
     *
     * @time-complexity - O (n)
     * @space-complexity - O (1)
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Remove element using two pointers, in this approach we push the designated value to
     * the end of the array.
     * Useful when elements are to be removed are rare.
     *
     * @time-complexity - O (n)
     * @space-complexity - O (1)
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while(i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else i++;
        }
        return n;
    }
}
