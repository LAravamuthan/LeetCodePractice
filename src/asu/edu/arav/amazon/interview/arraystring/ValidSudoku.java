package asu.edu.arav.amazon.interview.arraystring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    /**
     *
     * @algo - Hash Table usage
     * @time-complexity - O(1)
     * @space-complexity - O(1)
     */

    public boolean isValidSudoku(char[][] board) {

        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int digitIdx = Character.getNumericValue(board[i][j]) - 1;
                if(digitIdx >= 0 && digitIdx <= 8){
                    int boxIndex = i/3 * 3 + j/3;
                    if(++row[i][digitIdx] > 1 || ++col[j][digitIdx] > 1 || ++box[boxIndex][digitIdx] > 1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
