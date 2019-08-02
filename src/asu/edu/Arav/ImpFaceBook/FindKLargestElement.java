package asu.edu.Arav.ImpFaceBook;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FindKLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for (int i : nums) {
            if (minHeap.size() < k) {
                minHeap.add(i);
            } else {
                if (minHeap.peek() < i) {
                    minHeap.add(i);
                    minHeap.remove();
                }
            }
        }
        return minHeap.peek();
    }
}
