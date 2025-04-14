package asu.edu.marisol;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NQueens {

    /**
     * Backtrack nQueens problem.
     *
     * @time-complexity - O (N!).
     * @space-complexity - O (N).
     */
    public List<List<String>> solveNQueens(int n) {
        this.n = n;

        this.cols = new HashSet<>();
        this.diagonals = new HashSet<>();
        this.antiDiagonals = new HashSet<>();
        this.ans = new ArrayList<>();

        char [][] state = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                state[i][j] = '.';
            }
        }

        backtrack(0, state);
        return ans;
    }

    private void addAns(char[][] state) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < state.length; i++) {
            board.add(new String(state[i]));
        }
        ans.add(board);
    }

    private int n;
    private Set<Integer> cols;
    private Set<Integer> diagonals;
    private Set<Integer> antiDiagonals;
    private List<List<String>> ans;

    private void backtrack(int row, char[][] state) {
        if (row == this.n) {
            addAns(state);
        }

        for (int col = 0; col < state[0].length; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }
            cols.add(col);
            diagonals.add(diagonal);
            antiDiagonals.add(antiDiagonal);
            state[row][col] = 'Q';

            backtrack(row + 1, state);

            cols.remove(col);
            diagonals.remove(diagonal);
            antiDiagonals.remove(antiDiagonal);
            state[row][col] = '.';
        }

    }

}
