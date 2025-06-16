package asu.edu.marisol;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ShortestSubarraywithSumatLeastK {

    /**
     * Priority queue to store the prefix and its index, to handle negative numbers in num list.
     *
     * @time-complexity - O (NlogN).
     * @space-complexity - O (1)
     */
    public int shortestSubarray(int[] nums, int k) {

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        long res = nums.length + 1;
        long curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum >= k) res = Math.min(res, i + 1);

            while (!pq.isEmpty() && curSum - pq.peek()[0] >= k)
                res = Math.min(res, i - pq.poll()[1]);

            pq.offer(new long[] {curSum, i});
        }

        return res == nums.length + 1 ? -1 : (int) res;
    }


    /**
     * Monotonic Stack Approach, where whenever you find last element running sum is bigger than you yours, that
     * element can't make better contribution than this element. After that find the best contributor in the stack
     * which can provide you the least size of subArray.
     *
     * @time-complexity - O (NlogN).
     * @space-complexity - O (1)
     */
    public int shortestSubarray2(int[] nums, int k) {

        List<Pair<Long, Integer>> stack = new ArrayList<>();

        // very imp step given this is the reference for including first element.
        // this is very important for subarray starting at 0 index.
        stack.add(new Pair<>(0L, -1));
        long runningSum = 0;
        int res = nums.length + 1;

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];

            while (!stack.isEmpty() && stack.get(stack.size() - 1).getKey() >= runningSum)
                stack.remove(stack.size() - 1);

            stack.add(new Pair<>(runningSum, i));
            int possibleIndex = findMaxIndex(stack, runningSum - k);
            if (possibleIndex != -1)
                res = Math.min(res, i - stack.get(possibleIndex).getValue());

        }

        return res == nums.length + 1 ? -1 : res;
    }

    private int findMaxIndex(List<Pair<Long, Integer>> nums, long target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums.get(mid).getKey() <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return right;
    }


    /**
     * We know that the runningSum once smaller the previous number they can not be part of the answer. Now how to make
     * sure we don't have search from the front. What we do is from answer from front and keep on removing the value
     * if it conforms to the targetSum, because the number being removed even if matched with someone later on wont
     * give the shortest subarray size.
     *
     * @time-complexity - O (N).
     * @space-complexity - O (N)
     */
    public int shortestSubarray3(int[] nums, int k) {

        Deque<Pair<Long, Integer>> dq = new ArrayDeque<>();
        long runningSum = 0;
        int res = nums.length + 1;
        dq.addLast(new Pair<>(0L, -1));

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            while (!dq.isEmpty() && runningSum - dq.peekFirst().getKey() >= k)
                res = Math.min(res, i - dq.pollFirst().getValue());

            while (!dq.isEmpty() && dq.peekLast().getKey() >= runningSum)
                dq.pollLast();

            dq.addLast(new Pair<>(runningSum, i));
        }

        return res == nums.length + 1 ? -1 : res;
    }

}
