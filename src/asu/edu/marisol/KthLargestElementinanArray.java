package asu.edu.marisol;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class KthLargestElementinanArray {

    /**
     * Priority queue implementation.
     *
     * @time-complexity - O (NlogK).
     * @space-complexity - O (K)
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.remove();
        }

        return pq.peek();
    }


    /**
     * Counting sort implementation.
     *
     * @time-complexity - O (2N + M ~ N + M) where M is diff between largest and smallest value.
     * @space-complexity - O (M).
     */
    public int findKthLargest2(int[] nums, int k) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int num : nums) {
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }

        int[] count = new int[maxValue - minValue + 1];

        for (int num : nums) {
            count[num - minValue]++;
        }

        int kFromEnd = k;
        for (int i = count.length - 1; i >= 0; i--) {
            kFromEnd -= count[i];
            if (kFromEnd <= 0) return i + minValue;
        }

        return -1;
    }

}
