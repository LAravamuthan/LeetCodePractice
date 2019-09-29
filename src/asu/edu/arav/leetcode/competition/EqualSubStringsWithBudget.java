package asu.edu.arav.leetcode.competition;

import asu.edu.aravl.utility.TwoPoint;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/get-equal-substrings-within-budget/
 */
public class EqualSubStringsWithBudget {


    public static int equalSubstring(String s, String t, int maxCost) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((s1, s2) -> s1[1] - s2[1]);
        for (int i = 0; i < s.length(); i++) {
            pq.offer(new int[]{i, Math.abs(s.charAt(i) - t.charAt(i))});
        }
        int count = 0;
        while (maxCost >= 0 && !pq.isEmpty()) {
            int[] res = pq.poll();
            if (maxCost - res[1] >= 0) {
                maxCost -= res[1];
                count++;
            }
        }
        return count;
    }

    public static int equalSubstringNew(String s, String t, int maxCost) {

        HashMap<Integer, Integer> indexCost = new HashMap<Integer, Integer>();
        int runningCost = maxCost;
        int length = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            indexCost.put(i, Math.abs(s.charAt(i) - t.charAt(i)));
            runningCost = runningCost - indexCost.get(i);
            if (runningCost >= 0) {
                right = i;
                length = Math.max(length, right - left + 1);
            }
            while (runningCost < 0) {
                runningCost += indexCost.get(left++);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        //System.out.println(equalSubstringNew("krrgw", "zjxss", 19));
        //System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
        int [][] in = {{0,0,0,0,0,1},{1,1,0,0,1,0},{0,0,0,0,1,1},{0,0,1,0,1,0},{0,1,1,0,0,0},{0,1,1,0,0,0}};
        //System.out.println(minimumMoves(in));
    }
}
