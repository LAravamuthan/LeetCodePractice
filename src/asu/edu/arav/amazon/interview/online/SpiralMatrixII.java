package asu.edu.arav.amazon.interview.online;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/spiral-matrix-ii/
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int counterValue = 1;
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1;
        boolean isHorizontal = true, isleft = true, isDown = true;
        while (up <= down || left <= right) {
            if (isHorizontal) {
                if (isleft) {
                    for (int i = left; i <= right; i++) {
                        res[up][i] = counterValue++;
                    }
                    isleft = !isleft;
                    up++;
                } else {
                    for (int i = right; i >= left; i--) {
                        res[down][i] = counterValue++;
                    }
                    isleft = !isleft;
                    down--;
                }
                isHorizontal = !isHorizontal;
            } else {
                if (isDown) {
                    for (int i = up; i <= down; i++) {
                        res[i][right] = counterValue++;
                    }
                    isDown = !isDown;
                    right--;
                } else {
                    for (int i = down; i >= up; i--) {
                        res[i][left] = counterValue++;
                    }
                    isDown = !isDown;
                    left++;
                }
                isHorizontal = !isHorizontal;
            }
        }
        return res;
    }


    public static void main(String [] args){
        generateMatrix(4);
    }
}
