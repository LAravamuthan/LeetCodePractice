package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/path-with-maximum-minimum-value/
 */
public class PathWithMaximumMinimumValue {

    public static int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public static int maximumMinimumPath(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A[0].length; i++) {
                min = Math.min(min, A[0][i]);
            }
            return min;
        }
        boolean[][] aStatus = new boolean[A.length][A[0].length];
        int maximumMinimum = Integer.MIN_VALUE;
        Stack<List<Integer>> s = new Stack<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        l.add(0);
        l.add(0);
        l.add(A[0][0]);
        s.push(l);
        aStatus[0][0] = true;
        while (!s.isEmpty()) {
            List<Integer> sl = s.pop();
            if (sl.get(0) == A.length - 1 && sl.get(1) == A[0].length - 1) {
                maximumMinimum = Math.max(maximumMinimum, Math.min(sl.get(2), A[sl.get(0)][sl.get(1)]));
                continue;
            }
            for (int[] dir : dirs) {
                List<Integer> sn = new ArrayList<>();
                if (sl.get(0) + dir[0] >= 0 && sl.get(0) + dir[0] < A.length
                        && sl.get(1) + dir[1] >= 0 && sl.get(1) + dir[1] < A[0].length
                        && !aStatus[sl.get(0) + dir[0]][sl.get(1) + dir[1]]) {
                    sn.add(sl.get(0) + dir[0]);
                    sn.add(sl.get(1) + dir[1]);
                    sn.add(Math.min(sl.get(2), A[sl.get(0) + dir[0]][sl.get(1) + dir[1]]));
                    aStatus[sl.get(0) + dir[0]][sl.get(1) + dir[1]] = true;
                    s.push(sn);
                }
            }
        }
        return maximumMinimum;
    }

    public static void main(String[] args) {
        int[][] A = new int[2][6];
        A[0][0] = 2;
        A[0][1] = 2;
        A[0][2] = 1;
        A[0][3] = 2;
        A[0][4] = 2;
        A[0][5] = 2;
        A[1][0] = 1;
        A[1][1] = 2;
        A[1][2] = 2;
        A[1][3] = 2;
        A[1][4] = 1;
        A[1][5] = 2;
        System.out.println(maximumMinimumPathPr(A));
    }

    public static int maxiMinimum = Integer.MIN_VALUE;
    public static boolean[][] visited;
    public static int xMax = 0, yMax = 0;
    public static int[][] inA;

    public static int maximumMinimumPathRec(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A[0].length; i++) {
                min = Math.min(min, A[0][i]);
            }
        }
        inA = A;
        visited = new boolean[A.length][A[0].length];
        visited[0][0] = true;
        xMax = A.length;
        yMax = A[0].length;
        dfsUtil(0 + 1, 0, A[0][0]);
        dfsUtil(0, 0 + 1, A[0][0]);
        return maxiMinimum;
    }

    public static void dfsUtil(int x, int y, int min) {
        if (x < 0 || y < 0 || x >= xMax || y >= yMax) {
            return;
        }
        if (min <= maxiMinimum) {
            return;
        }
        if (visited[x][y] == true) {
            return;
        }
        if (x == xMax - 1 && y == yMax - 1) {
            maxiMinimum = Math.max(maxiMinimum, Math.min(min, inA[x][y]));
            return;
        }
        visited[x][y] = true;
        dfsUtil(x + 1, y, Math.min(min, inA[x][y]));
        dfsUtil(x, y + 1, Math.min(min, inA[x][y]));
        dfsUtil(x - 1, y, Math.min(min, inA[x][y]));
        dfsUtil(x, y - 1, Math.min(min, inA[x][y]));
        visited[x][y] = false;
    }

    public static int maximumMinimumPathPr(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < A[0].length; i++) {
                min = Math.min(min, A[0][i]);
            }
        }
        PriorityQueue<int[]> pqNodes = new PriorityQueue<>((s1, s2) -> s2[2] - s1[2]);
        pqNodes.offer(new int[]{0, 0, A[0][0]});
        while (!pqNodes.isEmpty()) {
            int[] node = pqNodes.poll();
            if (A[node[0]][node[1]] < 0) {
                continue;
            }
            if (node[0] == A.length - 1 && node[1] == A[0].length - 1) {
                return node[2];
            }

            A[node[0]][node[1]] = -1;
            if (node[0] < A.length - 1) {
                pqNodes.offer(new int[]{node[0] + 1, node[1], Math.min(node[2], A[node[0] + 1][node[1]])});
            }
            if (node[1] < A[0].length - 1) {
                pqNodes.offer(new int[]{node[0], node[1] + 1, Math.min(node[2], A[node[0]][node[1] + 1])});
            }
            if (node[0] > 0) {
                pqNodes.offer(new int[]{node[0] - 1, node[1], Math.min(node[2], A[node[0] - 1][node[1]])});
            }
            if (node[1] > 0) {
                pqNodes.offer(new int[]{node[0], node[1] - 1, Math.min(node[2], A[node[0]][node[1] - 1])});
            }
        }
        return 0;
    }


}
