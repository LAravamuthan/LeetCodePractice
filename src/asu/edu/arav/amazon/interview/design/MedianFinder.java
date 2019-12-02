package asu.edu.arav.amazon.interview.design;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-median-from-data-stream/
 */
public class MedianFinder {

    // make a min heap - to store max elements
    // make  max heap - to store min elements

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;


    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    // when we add a num add the number in minHeap, then add smallest of min heap to max Heap
    // if min heap's size is lesser than maxheap then get the highest value from max heap insert it
    // in min Heap
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(minHeap.size() < maxHeap.size()){
            minHeap.offer(maxHeap.poll()); // because of this there only two states possible
            // either minHeap.size() > than maxheap.size() or both sizes are equal
        }

    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek() + maxHeap.peek())/2.0;
        }
        return minHeap.peek();
    }
}
