package asu.edu.arav.amazon.interview.design;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/valid-tic-tac-toe-state/
 */
public class ValidTicTacToeState {

    public boolean validTicTacToe(String[] board) {
        // count x and o s
        int xCount = 0;
        int oCount = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length();j++){
                if(board[i].charAt(j) == 'X'){
                    xCount++;
                }else if(board[i].charAt(j) == 'O'){
                    oCount++;
                }
            }
        }
        // x count and o count dont match then then x == o+1
        if(xCount != oCount && xCount != oCount + 1)return false;
        // if x wins then for sure x count > o and x = o +1
        if(isWinner(board,'X') && xCount != oCount + 1)return false;
        // if o wins then for sure o count == x count
        if(isWinner(board, 'O') && xCount != oCount)return false;

        return true;
    }

    // this method tells whether the given player is the winner or not
    public boolean isWinner(String[] board, char player){
        // for each row and column check the winner
        for(int i = 0; i < board.length; i++){
            // ith row check
            if(board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player){
                return true;
            }
            // ith column check
            if(board[0].charAt(i) == player && board[1].charAt(i) == player && board[2].charAt(i) == player){
                return true;
            }
        }

        // diagonal and anti-diagonal check

        if(board[0].charAt(0)== player && board[1].charAt(1)== player && board[2].charAt(2)== player){
            return true;
        }

        if(board[0].charAt(2)== player && board[1].charAt(1)== player && board[2].charAt(0)== player){
            return true;
        }

        // if all options fail, the player didnt win
        return false;
    }


}
