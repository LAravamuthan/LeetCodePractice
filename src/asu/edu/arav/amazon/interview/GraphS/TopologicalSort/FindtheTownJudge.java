package asu.edu.arav.amazon.interview.GraphS.TopologicalSort;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-the-town-judge/
 */
public class FindtheTownJudge {

    /**
     * @algo - Arrays
     * @time-complexity - O(n)
     * @space-complexity - O(n)
     */

    public int findJudge(int N, int[][] trust) {
        if (trust == null || trust.length == 0) return 1;
        int[] inDeg = new int[N + 1];
        int[] outDeg = new int[N + 1];
        Set<Integer> nodes = new HashSet<>();
        for (int[] edge : trust) {
            outDeg[edge[0]]++;
            if (++inDeg[edge[1]] == N - 1) if (outDeg[edge[1]] == 0) nodes.add(edge[1]);
        }
        for (int node : nodes) {
            if (outDeg[node] == 0) return node;
        }
        return -1;
    }

    /* two optimal implementations are as below */
    public int findJudge1(int N, int[][] trust) {
        if (trust == null || trust.length == 0) return 1;
        int[] inDeg = new int[N + 1];
        int[] outDeg = new int[N + 1];
        for (int[] edge : trust) {
            inDeg[edge[1]]++;
            outDeg[edge[0]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (outDeg[i] == 0 && inDeg[i] == N-1) return i;
        }
        return -1;
    }

    public int findJudge2(int N, int[][] trust) {
        if (trust == null || trust.length == 0) return 1;
        int[] trustScore = new int[N + 1];
        for (int[] edge : trust) {
            trustScore[edge[1]]++;
            trustScore[edge[0]]--;
        }
        for (int i = 1; i <= N; i++) {
            if (trustScore[i] == N-1) return i;
        }
        return -1;
    }
}
