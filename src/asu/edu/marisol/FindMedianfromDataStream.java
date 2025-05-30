package asu.edu.marisol;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {


    private PriorityQueue<Integer> minHeap ;
    private PriorityQueue<Integer> maxHeap;

    public FindMedianfromDataStream() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    /**
     * Two heap approach.
     *
     * @time-complexity - O (long).
     * @space-complexity - O (k).
     */
    public void addNum(int num) {
        if (minHeap.size() == 0) {
            minHeap.offer(num);
        } else if (minHeap.size() == maxHeap.size()) {
            if (num < maxHeap.peek()) {
                int movElement = maxHeap.poll();
                maxHeap.offer(num);
                minHeap.offer(movElement);
            } else {
                minHeap.offer(num);
            }
        } else {
            if (num > minHeap.peek()) {
                int movElement = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(movElement);
            } else {
                maxHeap.offer(num);
            }
        }
    }

    /**
     * Two heap approach.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1).
     */
    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else return minHeap.peek();
    }



    /**
     * Two heap approach.
     *
     * @time-complexity - O (long).
     * @space-complexity - O (k).
     */
    public void addNum1(int num) {
        if (minHeap.size() == 0)
            minHeap.add(num);
        else if (minHeap.size() == maxHeap.size()) {
            if (num < maxHeap.peek()) {
                int numMove = maxHeap.poll();
                maxHeap.offer(num);
                minHeap.offer(numMove);
            } else
                minHeap.offer(num);
        }
        else {
            if (num > minHeap.peek()) {
                int numMove = minHeap.poll();
                minHeap.offer(num);
                maxHeap.offer(numMove);
            } else
                maxHeap.offer(num);
        }
    }

    /**
     * Two heap approach.
     *
     * @time-complexity - O (1).
     * @space-complexity - O (1).
     */
    public double findMedian2() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else return minHeap.peek();
    }



}
