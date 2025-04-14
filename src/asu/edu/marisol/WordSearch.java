package asu.edu.marisol;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class WordSearch {

    /**
     * Do the backTrack approach, really don't know how to calculate time-complexity.
     *
     * @time-complexity - O (N 3^L).
     * @space-complexity - O (L).
     */
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.rows = board.length;
        this.cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(backtrack(0, i, j)) return true;
            }
        }

        return false;
    }

    private char[][] board;
    private String word;
    private int rows;
    private int cols;

    private boolean backtrack(int idx, int r, int c) {
        if (idx == word.length()) return true;
        if (r < 0 || c < 0 || r >= rows || c >= cols || board[r][c] != word.charAt(idx)) return false;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        char temp = board[r][c];
        boolean returnValue = false;
        board[r][c] = '#';
        for (int i = 0; i < dirs.length; i++) {
            if (backtrack(idx + 1, r + dirs[i][0], c + dirs[i][1])) {
                returnValue = true;
                break;
            }
        }
        board[r][c] = temp;
        return returnValue;
    }

}
