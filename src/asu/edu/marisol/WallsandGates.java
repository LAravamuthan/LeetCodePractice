package asu.edu.marisol;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class WallsandGates {

    /**
     * Multi source BFS approach, lazy setting
     * cons
     *  - distance variable
     *  - level checking
     *  - revisits to same cells possible
     *  - have to add min clause
     *
     * @time-complexity - O (N * M)
     * @space-complexity - O (N * M)
     */
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length, cols = rooms[0].length;

        Queue<int[]> bfsQueue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0)
                    bfsQueue.offer(new int[] {row, col});
            }
        }

        int distance = 0;

        while (!bfsQueue.isEmpty()) {
            for (int level = bfsQueue.size(); level > 0; level--) {
               int[] cell = bfsQueue.poll();
               int row = cell[0], col = cell[1];
               rooms[row][col] = Math.min(rooms[row][col], distance);

               for (int[] dir : DIRS) {
                   int nrow = row + dir[0], ncol = col + dir[1];
                   if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && rooms[nrow][ncol] == Integer.MAX_VALUE)
                       bfsQueue.offer(new int[] {nrow, ncol});
               }
            }
            distance++;
        }
    }

    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * Multi source BFS approach, pre setting and trying to avoid previous problems like.
     *  cons
     *      *  - distance variable
     *      *  - level checking
     *      *  - revisits to same cells possible
     *      *  - have to add min clause
     * @time-complexity - O (N * M)
     * @space-complexity - O (N * M)
     */
    public void wallsAndGates2(int[][] rooms) {
        int rows = rooms.length, cols = rooms[0].length;

        Queue<int[]> bfsQueue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0)
                    bfsQueue.offer(new int[]{row, col});
            }
        }


        while (!bfsQueue.isEmpty()) {
            int[] cell = bfsQueue.poll();
            int row = cell[0], col = cell[1];

            for (int[] dir : DIRS) {
                int nrow = row + dir[0], ncol = col + dir[1];
                if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && rooms[nrow][ncol] == Integer.MAX_VALUE) {
                    rooms[nrow][ncol] = rooms[row][col] + 1;
                    bfsQueue.offer(new int[]{nrow, ncol});
                }
            }
        }
    }

}
