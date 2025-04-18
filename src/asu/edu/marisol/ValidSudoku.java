package asu.edu.marisol;

import java.util.HashSet;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class ValidSudoku {

    /**
     * TODO: Bit Manipulation approach is pending here, do that ASAP.
     *
     * @time-complexity - O (n^2)
     * @space-complexity - O (n^2)
     */
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        HashSet<Character>[] rows = new HashSet[n];
        HashSet<Character>[] cols = new HashSet[n];
        HashSet<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                char val = board[i][j];

                if (rows[i].contains(val)) return false;
                rows[i].add(val);

                if (cols[j].contains(val)) return false;
                cols[j].add(val);

                int boxIdx = (i / 3) * 3 + j / 3;

                if (boxes[boxIdx].contains(val)) return false;
                boxes[boxIdx].add(val);
            }
        }

        return true;
    }
}
