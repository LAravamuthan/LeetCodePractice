package asu.edu.AravL.easy;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }
        k = k % nums.length;
        int moves = 0;
        int firstIndex = 0;
        while (moves < nums.length) {
            int bufferElement = nums[firstIndex];
            int currentIndex = firstIndex;
            do {
                int nextIndex = (currentIndex + k) % nums.length;
                int tempForNextDoRound = nums[nextIndex];
                nums[nextIndex] = bufferElement;
                bufferElement = tempForNextDoRound;
                currentIndex = nextIndex;
                moves++;
            } while (currentIndex != firstIndex);
            firstIndex++;
        }
    }

}
