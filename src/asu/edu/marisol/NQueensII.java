package asu.edu.marisol;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class NQueensII {

    /**
     * Backtrack nQueensII problem.
     *
     * @time-complexity - O (N!).
     * @space-complexity - O (N).
     */
    public int totalNQueens(int n) {

        this.n = n;
        this.cols = new HashSet<>();
        this.antiDiagonals = new HashSet<>();
        this.diagonals = new HashSet<>();

        backTrack(0);

        return ans;
    }

    private int n;
    private Set<Integer> cols;
    private Set<Integer> diagonals;
    private Set<Integer> antiDiagonals;
    private int ans = 0;

    private void backTrack(int row) {
        if (row == n) {
            ans++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int diagonal = row - col;
            int antiDiagonal = row + col;
            if (cols.contains(col) || diagonals.contains(diagonal) || antiDiagonals.contains(antiDiagonal)) continue;
            else {
                cols.add(col);
                diagonals.add(diagonal);
                antiDiagonals.add(antiDiagonal);

                backTrack(row + 1);

                cols.remove(col);
                diagonals.remove(diagonal);
                antiDiagonals.remove(antiDiagonal);
            }
        }
    }
}
