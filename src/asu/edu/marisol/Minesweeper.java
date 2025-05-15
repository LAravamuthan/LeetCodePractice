package asu.edu.marisol;

import asu.edu.arav.nutanix.PaintFence;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Minesweeper {

    /**
     * Minesweeper problem, dfs approach.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0 || click == null || click.length == 0)
            return board;
        if (board[click[0]][click[1]] != 'M' && board[click[0]][click[1]] != 'E')
            return board;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        revealBoard(board, click[0], click[1]);

        return board;
    }

    private int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    private void revealBoard(char[][] board, int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'E')
            return;

        int mines = getMinesAround(board, row, col);
        if (mines > 0) {
            board[row][col] = (char) (mines + '0');
            return;
        }

        board[row][col] = 'B';
        for (int[] dir: dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length)
                revealBoard(board, nrow, ncol);
        }
    }

    private int getMinesAround(char[][] board, int row, int col) {
        int mines = 0;

        for (int[] dir : dirs) {
            int nrow = row + dir[0];
            int ncol = col + dir[1];
            if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && board[nrow][ncol] == 'M')
                mines++;
        }

        return mines;
    }


    /**
     * Minesweeper problem, BFS approach.
     *
     * @time-complexity - O (M * N).
     * @space-complexity - O (M * N).
     */
    public char[][] updateBoard2(char[][] board, int[] click) {
        if (board == null || board.length == 0 || click == null || click.length == 0)
            return board;
        if (board[click[0]][click[1]] != 'M' && board[click[0]][click[1]] != 'E')
            return board;
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        int mines = getMinesAround(board, click[0], click[1]);
        if (mines > 0) {
            board[click[0]][click[1]] = (char) (mines + '0');
            return board;
        }

        board[click[0]][click[1]] = 'B';

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);

        while (!queue.isEmpty()) {

            int [] coordinates = queue.poll();
            int row = coordinates[0];
            int col = coordinates[1];

            for (int[] dir : dirs) {
                int nrow = row + dir[0];
                int ncol = col + dir[1];

                if (nrow < 0 || nrow >= board.length || ncol < 0 || ncol >= board[0].length || board[nrow][ncol] != 'E')
                    continue;

                mines = getMinesAround(board, nrow, ncol);
                if (mines > 0) {
                    board[nrow][ncol] = (char) (mines + '0');
                    continue;
                }

                board[nrow][ncol] = 'B';
                queue.offer(new int[] {nrow, ncol});
            }

        }

        return board;
    }
}
