package asu.edu.arav.impfacebook;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int bufferElement = Integer.MIN_VALUE;
        int indexForNextUniqueNumber = -1;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (bufferElement == Integer.MIN_VALUE) {
                bufferElement = nums[i];
                count++;
                continue;
            }
            if (nums[i] == bufferElement) {
                count++;
                if (indexForNextUniqueNumber == -1 && count == 2) {
                    indexForNextUniqueNumber = i;
                }
                continue;
            }
            if (nums[i] != bufferElement && indexForNextUniqueNumber != -1) {
                int tmp = nums[i];
                nums[i] = nums[indexForNextUniqueNumber];
                nums[indexForNextUniqueNumber] = tmp;
                indexForNextUniqueNumber++;
                bufferElement = tmp;
                count = 1;
                continue;
            }
            if (nums[i] != bufferElement) {
                bufferElement = nums[i];
                count=1;
            }

        }

        return indexForNextUniqueNumber == -1 ? nums.length : indexForNextUniqueNumber;
    }
}
