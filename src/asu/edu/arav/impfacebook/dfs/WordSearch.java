package asu.edu.arav.impfacebook.dfs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word.toCharArray(), 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean dfs(char[][] board, char[] word, int toBeMatchedElementIndex, int row_index, int column_index) {
        if (toBeMatchedElementIndex == word.length) {
            return true;
        }
        if (row_index < 0 || column_index < 0 || row_index == board.length || column_index == board[0].length) {
            return false;
        }
        if (board[row_index][column_index] != word[toBeMatchedElementIndex]) {
            return false;
        }

        board[row_index][column_index] ^= 256;
        boolean result = dfs(board, word, toBeMatchedElementIndex + 1, row_index, column_index+1)
                || dfs(board, word, toBeMatchedElementIndex + 1, row_index, column_index-1)
                || dfs(board, word, toBeMatchedElementIndex + 1, row_index-1, column_index)
                || dfs(board, word, toBeMatchedElementIndex + 1, row_index+1, column_index);

        board[row_index][column_index] ^= 256;
        return result;
    }
}
