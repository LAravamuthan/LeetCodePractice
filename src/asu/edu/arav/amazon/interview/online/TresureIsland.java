package asu.edu.arav.amazon.interview.online;

import asu.edu.aravl.utility.TwoDPoint;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class TresureIsland {
    public static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int minSteps(char[][] grid) {

        Queue<TwoDPoint> q = new ArrayDeque<TwoDPoint>();
        q.offer(new TwoDPoint(0, 0));
        grid[0][0] = 'D';
        int steps = 0;
        while (!q.isEmpty()) {
            TwoDPoint p = q.poll();
            if (grid[p.r][p.c] == 'X') {
                return steps;
            }
            for (int[] dir : dirs) {
                if (isSafe(p.r + dir[0], p.c + dir[1], grid)) {
                    q.offer(new TwoDPoint(p.r + dir[0], p.c + dir[1]));
                }
            }
            steps++;
        }
        return -1;
    }

    public static boolean isSafe(int r, int c, char[][] grid) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 'D') {
            return true;
        }
        return false;
    }
}
