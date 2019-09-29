package asu.edu.arav.leetcode.competition;

import asu.edu.aravl.utility.TwoPoint;

import java.util.HashSet;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/
 */
public class SnakeTraversal {

    public static int minMoves = Integer.MAX_VALUE;
    public static int r = 0, c = 0;
    public static HashSet<TwoPoint> tPS = new HashSet<TwoPoint>();

    public static int minimumMoves(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int [][] p = new int[2][2];
        p[0][0] = 0;
        p[0][1] = 0;
        p[1][0] = 0;
        p[1][1] = 1;
        dfs(0, grid, p);
        return minMoves;
    }

    public static void dfs(int m, int[][] g, int[][] p) {
        TwoPoint tp = new TwoPoint(p);
        boolean result = tPS.contains(tp);
        if(tPS.contains(tp))return;

        if (p[0][0] == r - 1 && p[0][1] == r - 2 && p[1][0] == r - 1 && p[1][0] == r - 1) {
            minMoves = Math.min(minMoves, m);
            return;
        }
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[0].length; j++) {
                if (p[i][j] < 0 || p[i][j] > r - 1) {
                    return;
                }
            }
        }
        for(int i = 0; i < p.length; i++){
            if(g[p[i][0]][p[i][1]]==1){
                return;
            }
        }


        tPS.add(tp);

        if (p[0][0] == p[1][0]) {
            if (p[0][1] > p[1][1]) {
                int[][] newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1] - 1;
                newP[1][0] = p[1][0];
                newP[1][1] = p[1][1] - 1;
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] - 1;
                newP[1][1] = p[1][1] + 1;
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] + 1;
                newP[1][1] = p[1][1] + 1;
                dfs(m + 1, g, newP);
            } else {
                int[][] newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1] + 1;
                newP[1][0] = p[1][0];
                newP[1][1] = p[1][1] + 1;
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] + 1;
                newP[1][1] = p[1][1] - 1;
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] - 1;
                newP[1][1] = p[1][1] - 1;
                dfs(m + 1, g, newP);
            }
        } else if (p[0][1] == p[1][1]) {
            if (p[0][0] < p[1][0]) {
                int[][] newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0] + 1;
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] + 1;
                newP[1][1] = p[1][1];
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] - 1;
                newP[1][1] = p[1][1] + 1;
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] - 1;
                newP[1][1] = p[1][1] - 1;
                dfs(m + 1, g, newP);
            } else {
                int[][] newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0] - 1;
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] - 1;
                newP[1][1] = p[1][1];
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] + 1;
                newP[1][1] = p[1][1] + 1;
                dfs(m + 1, g, newP);
                newP = new int[p.length][p[0].length];
                newP[0][0] = p[0][0];
                newP[0][1] = p[0][1];
                newP[1][0] = p[1][0] + 1;
                newP[1][1] = p[1][1] - 1;
                dfs(m + 1, g, newP);
            }
        }
        tPS.remove(tp);
    }
}
