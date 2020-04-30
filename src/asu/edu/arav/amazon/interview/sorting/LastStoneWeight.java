package asu.edu.arav.amazon.interview.sorting;

import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/last-stone-weight/
 */
public class LastStoneWeight {

    /**
     * @algo MaxHeap
     * @time-complexity O(NlogN)
     * @time-complexity O(N)
     */

    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) pq.add(stone);
        while (pq.size() > 1) {
            int l = pq.poll();
            int ls = pq.poll();
            if (l > ls) pq.add(l - ls);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
