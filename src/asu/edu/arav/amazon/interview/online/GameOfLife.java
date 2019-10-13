package asu.edu.arav.amazon.interview.online;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 1) {
            return;
        }
        int[] dirs = {-1, 0, 1};

        int rows = board.length;
        int cols = board[0].length;

        int[][] temp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                temp[row][col] = board[row][col];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int nL = 0;
                for (int i = 0; i < dirs.length; i++) {
                    for (int j = 0; j < dirs.length; j++) {
                        if(!(dirs[i] == 0 && dirs[j]==0)){
                            int nr = row + dirs[i];
                            int nc = col + dirs[j];
                            if(nr >= 0 && nc >= 0 && nr < rows && nc <cols
                                && temp[row][col] == 1){
                                nL++;
                            }
                        }
                    }
                }
                if ((temp[row][col] == 1) && (nL < 2 || nL > 3)) {
                    board[row][col] = 0;
                }

                if (temp[row][col] == 0 && nL == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }
}
