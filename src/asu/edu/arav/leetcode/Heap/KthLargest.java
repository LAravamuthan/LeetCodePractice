package asu.edu.arav.leetcode.Heap;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    int heapSize = 0;

    public KthLargest(int k, int[] nums) {
        heapSize = k;
        for(int num : nums){
            add(num);
        }
    }
    public int add(int val) {
        if(minHeap.size() < heapSize){
            minHeap.add(val);
        }else{
            if(minHeap.peek() < val){
                minHeap.add(val);
                minHeap.remove();
            }
        }
        return minHeap.peek();
    }
}
