package asu.edu.arav.amazon.interview.arraystring;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/
 */
public class FindWinneronaTicTacToeGame {

    /**
     * @algo - ArraysString
     * @time-complexity - O(1)
     * @space-complexity - O(1)
     */

    public String tictactoe(int[][] moves) {
        int result = 0;
        if (moves == null || moves.length == 0) return "Pending";
        int[] rowsSum = new int[3];
        int[] colSum = new int[3];
        int diagonalSum = 0;
        int antiDiagonal = 0;
        int noMoves = moves.length;
        int lrow = 0;
        int lcol = 0;
        for (int i = 0; i < moves.length; i++) {
            int movValue = i % 2 == 0 ? 1 : -1;
            lrow = moves[i][0];
            lcol = moves[i][1];
            rowsSum[moves[i][0]] += movValue;
            colSum[moves[i][1]] += movValue;
            if (moves[i][0] == moves[i][1]) diagonalSum += movValue;
            if (moves[i][0] + moves[i][1] == 2) antiDiagonal += movValue;
        }

        if (Math.abs(rowsSum[lrow]) == 3 || Math.abs(colSum[lcol]) == 3 || Math.abs(antiDiagonal) == 3
                || Math.abs(diagonalSum) == 3)
            if (moves.length % 2 == 0) result = -1;
            else result = 1;

        return result == 0 ? (noMoves == 9 ? "Draw" : "Pending") : result == 1 ? "A" : "B";
    }

    /**
     * @algo - ArraysString Concise
     * @time-complexity - O(1)
     * @space-complexity - O(1)
     */

    public String tictactoe1(int[][] moves) {
        if (moves == null || moves.length == 0) return "Pending";
        int[][] rolSum = new int[2][3];
        int[][] colSum = new int[2][3];
        int[] diagonal = new int[3];
        int[] antiDiagonal = new int[3];

        for(int i = 0; i < moves.length; i++){
            int id = i % 2 == 0 ? 0 : 1;
            int r = moves[i][0];
            int c = moves[i][1];
            if(++rolSum[id][r] == 3 || ++colSum[id][c] == 3 || r == c && ++diagonal[id] == 3
                    || r + c == 2 && ++antiDiagonal[id] == 3){
                return id == 0 ? "A" : "B";
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }

}
