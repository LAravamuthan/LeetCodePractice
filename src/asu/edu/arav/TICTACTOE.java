package asu.edu.arav;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class TICTACTOE {
    int[][] boardValues;

    TICTACTOE() {
        boardValues = new int[3][3];
    }


    public void addToken(char ch, int x, int y) {
        if (ch == 'X') {
            boardValues[x - 1][y - 1] = 1;
        } else if (ch == 'O') {
            boardValues[x - 1][y - 1] = -1;
        } else {
            System.out.println("invalid selection");
        }
    }

    public void printBoard() {
        for (int i = 0; i < boardValues.length; i++) {
            for (int j = 0; j < boardValues[0].length; j++) {
                String precursor = "|";
                if (boardValues[i][j] == 1) {
                    System.out.print(j != 0 ? precursor + "X" : "X");
                } else if (boardValues[i][j] == -1) {
                    System.out.print(j != 0 ? precursor + "O" : "O");
                } else {
                    System.out.print(j != 0 ? precursor + "-" : "-");
                }
            }
            System.out.println();
        }
    }

    public boolean isBoarcFull() {
        int cUnplayed = 0;
        for (int i = 0; i < boardValues.length; i++) {
            for (int j = 0; j < boardValues[0].length; j++) {
                if (boardValues[i][j] == 0) {
                    cUnplayed++;
                }
                if (cUnplayed > 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void compMove() throws Exception {
        if(isBoarcFull()){
            throw new Exception();
        }
        for (int i = 0; i < boardValues.length; i++) {
            for (int j = 0; j < boardValues[0].length; j++) {
                if(boardValues[i][j] == 0){
                    boardValues[i][j] = 1;
                    return;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        TICTACTOE tc = new TICTACTOE();
        tc.printBoard();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        tc.compMove();
        System.out.println(tc.isBoarcFull());
        tc.printBoard();
    }
}
