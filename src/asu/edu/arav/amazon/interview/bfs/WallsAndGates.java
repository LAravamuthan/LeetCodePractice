package asu.edu.arav.amazon.interview.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/walls-and-gates/
 */
public class WallsAndGates {

    /**
     * @algo - BFS
     * @time-complexity - O(mn)
     * @space-complexity - O(mn)
     */
    class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }

        Queue<Point> que = new ArrayDeque<Point>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    que.offer(new Point(i, j));
                }
            }
        }

        int[] dirRows = {1, 0, -1, 0};
        int[] dirCols = {0, 1, 0, -1};
        int rows = rooms.length;
        int cols = rooms[0].length;

        for (int dist = 0; !que.isEmpty(); dist++) {
            int levelSize = que.size();
            for (int i = 0; i < levelSize; i++) {
                Point p = que.poll();
                if (rooms[p.r][p.c] == Integer.MAX_VALUE) {
                    rooms[p.r][p.c] = dist;
                }
                for (int j = 0; j < dirRows.length; j++) {
                    int nr = p.r + dirRows[j];
                    int nc = p.c + dirCols[j];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && rooms[nr][nc] == Integer.MAX_VALUE) {
                        que.offer(new Point(nr, nc));
                    }
                }
            }
        }
    }
}
