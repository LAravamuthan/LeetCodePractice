package asu.edu.arav.amazon.interview.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/rotting-oranges/
 */
public class RottingOranges {

    /**
     * @algo - BFS
     * @time-complexity - O(nm)
     * @space-complexity - O(nm)
     */

    int[] dirsR = {0, 1, 0, -1};
    int[] dirsC = {1, 0, -1, 0};

    class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int days = 1;
        int r = grid.length;
        int c = grid[0].length;
        Queue<Point> queue = new ArrayDeque<>();
        int freshOranges = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Point(i, j));
                }
            }
        }
        if (freshOranges == 0) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                Point p = queue.poll();
                for (int j = 0; j < dirsR.length; j++) {
                    int nr = p.r + dirsR[j];
                    int nc = p.c + dirsC[j];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        freshOranges--;
                        if (freshOranges == 0) return days;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
            days++;
        }
        return -1;
    }
}
