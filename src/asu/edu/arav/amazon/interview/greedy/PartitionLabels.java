package asu.edu.arav.amazon.interview.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/partition-labels/
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ansList = new ArrayList<Integer>();
        int[] lastIdx = new int[26];
        // storing the last Idx occurrence of each character
        for (int i = 0; i < S.length(); i++) {
            lastIdx[S.charAt(i) - 'a'] = i;
        }
        int boundary = 0, nextStartingIdx = 0;
        for (int i = 0; i < S.length(); i++) {
            boundary = Math.max(boundary, lastIdx[S.charAt(i) - 'a']);
            if (i == boundary) {
                ansList.add(nextStartingIdx - i + 1);
                nextStartingIdx = i + 1;
            }
        }
        return ansList;
    }
}
