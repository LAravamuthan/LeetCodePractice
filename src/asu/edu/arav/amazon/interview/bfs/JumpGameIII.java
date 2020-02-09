package asu.edu.arav.amazon.interview.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/jump-game-iii/
 */

public class JumpGameIII {


    /**
     * @algo BFS
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */

    public boolean canReach(int[] arr, int start) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            if (arr[curIdx] == 0) return true;
            int cN1 = curIdx + arr[curIdx];
            int cN2 = curIdx - arr[curIdx];
            arr[curIdx] = -1;
            if (cN1 < arr.length && cN1 >= 0 && arr[cN1] != -1) {
                queue.add(cN1);
            }
            if (cN2 < arr.length && cN2 >= 0 && arr[cN2] != -1) {
                queue.add(cN2);
            }
        }
        return false;
    }
}
