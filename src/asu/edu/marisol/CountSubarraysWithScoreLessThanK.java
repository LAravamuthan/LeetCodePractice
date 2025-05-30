package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CountSubarraysWithScoreLessThanK {

    /**
     * Simple solution IMO just understand to change sliding window size, in some problem the bigger size is an evident
     * answer, and we aim reduce the sliding window size. Here smaller size is evident answer we try to increase the window size.
     * We reduce it make to eligible again hence ans count increase happens outside the while loop.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (1).
     */
    public long countSubarrays(int[] nums, long k) {
        long sum = 0, count = 0;

        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            while (j <= i && sum * (i - j + 1) >= k) {
                sum -= nums[j];
                j++;
            }
            count += i - j + 1;
        }

        return count;
    }
}
