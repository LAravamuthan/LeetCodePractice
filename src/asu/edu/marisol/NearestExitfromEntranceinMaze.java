package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NearestExitfromEntranceinMaze {

    /**
     * BFS approach for finding the exit.
     *
     * @time-complexity - O (N*M).
     * @space-complexity - O (N*M).
     */
    public int nearestExit(char[][] maze, int[] entrance) {
        if (maze.length == 0) return 0;
        int m = maze.length, n = maze[0].length, steps = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] { entrance[0], entrance[1] });
        maze[entrance[0]][entrance[1]] = '+';

        while (!queue.isEmpty()) {
            steps++;
            for (int level = queue.size(); level > 0; level--) {
                int [] node = queue.poll();
                int row = node[0], col = node[1];
                for (int[] dir : DIRS) {
                    int nrow = row + dir[0], ncol = col + dir[1];
                    if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] == '.'){
                        if (nrow == 0 || col == 0 || row < m - 1 || col < n -1 ) return steps;
                        maze[nrow][ncol] = '+';
                        queue.offer(new int[] { nrow, ncol });
                    }
                }
            }
        }

        return -1;
    }

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

}
