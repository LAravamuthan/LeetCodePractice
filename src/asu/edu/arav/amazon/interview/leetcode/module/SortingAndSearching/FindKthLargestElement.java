package asu.edu.arav.amazon.interview.leetcode.module.SortingAndSearching;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < 2){
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int num : nums){
            if(minHeap.size() < k){
                minHeap.add(num);
            } else if (minHeap.peek() < num){
                minHeap.add(num);
                minHeap.remove();
            }
        }
        return minHeap.poll();
    }
}
