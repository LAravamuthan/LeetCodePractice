package asu.edu.marisol;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class SlidingWindowMedian {

    /**
     * Median sliding window.
     *
     * @time-complexity - O (n).
     * @space-complexity - O (n).
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> hi = new PriorityQueue<>();

        double[] median = new double[nums.length - k + 1];

        Map<Integer, Integer> inValidValues = new HashMap<>();

        // i for nums , itr for median and balance for managing the two heaps.
        int i = 0, itr = 0;
        for (; i < k; i++) lo.offer(nums[i]);
        for (int j = 0; j < k/2; j++) hi.offer(lo.poll());
        while (i < nums.length) {
            median[itr++] = findMedian(lo, hi, k);

            // Rules of balance:
            // -ve to indicate lo needs more valid nums.
            // +ve to indicate hi needs more valid nums.
            int number_out = nums[i - k];
            int number_in = nums[i++];
            int balance = 0;
            inValidValues.put(number_out, inValidValues.getOrDefault(number_out, 0) + 1);

            balance += number_out <= lo.peek() ? -1 : 1;

            if (!lo.isEmpty() && number_in <= lo.peek()) {
                lo.offer(number_in);
                balance++;
            } else {
                hi.offer(number_in);
                balance--;
            }

            // Rebalance now based on value of the balance value
            if (balance < 0) {
                lo.offer(hi.poll());
                balance++;
            }

            if (balance > 0) {
                hi.offer(lo.poll());
                balance--;
            }

            cleanupHeap(lo, inValidValues);
            cleanupHeap(hi, inValidValues);
        }

        median[itr] = findMedian(lo, hi, k);
        return median;
    }

    private double findMedian(PriorityQueue<Integer> lo, PriorityQueue<Integer> hi, int k) {
        if ((k % 2) == 1) return lo.peek();
        return ((double) hi.peek() + lo.peek()) / 2.0;
    }

    private void cleanupHeap(PriorityQueue<Integer> pq, Map<Integer, Integer> inValidValues) {
        while (!pq.isEmpty() && inValidValues.containsKey(pq.peek())) {
            inValidValues.put(pq.peek(), inValidValues.get(pq.peek()) - 1);
            if (inValidValues.get(pq.peek()) == 0) inValidValues.remove(pq.peek());
            pq.poll();
        }
    }


    /**
     * Median sliding window, with java methods usage, removing elements is O(n) hence results in TLE.
     *
     * @time-complexity - O (TBD).
     * @space-complexity - O (TBD).
     */
    public double[] medianSlidingWindow2(int[] nums, int k) {
        double [] medians = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            addNumber(nums[i]);
            if (i >= k - 1) {
                medians[i - k +  1] = getMedian(k);

            }
        }

        return medians;
    }

    private Map<Integer, Integer> expiredValues = new HashMap<>();
    private PriorityQueue<Integer> lo = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> hi = new PriorityQueue<>();

    private void addNumber(int num) {
        if (lo.isEmpty() || num <= lo.peek())
            lo.offer(num);
        else
            hi.offer(num);
        reBalance();
    }

    private void reBalance() {
        if (!lo.isEmpty() && expiredValues.containsKey(lo.peek()))
            cleanTop(lo);
        if (!hi.isEmpty() && expiredValues.containsKey(hi.peek()))
            cleanTop(hi);

        while (lo.size() > hi.size() + 1) hi.offer(lo.poll());
        while (hi.size() > lo.size()) lo.offer(hi.poll());
    }

    private void cleanTop(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && expiredValues.containsKey(heap.peek())) {
            expiredValues.put(heap.peek(), expiredValues.get(heap.peek()) - 1);
            if (expiredValues.get(heap.peek()) == 0) expiredValues.remove(heap.peek());
            heap.poll();
        }
    }

    private double getMedian(int k) {
        if (k % 2 == 1) return (double) lo.peek();
        return (double) lo.peek() / 2.0 + (double) hi.peek() / 2.0;
    }


}
