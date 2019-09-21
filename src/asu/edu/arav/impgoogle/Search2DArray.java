package asu.edu.arav.impgoogle;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 * @Link https://leetcode.com/problems/search-a-2d-matrix-ii/
 */
public class Search2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int currRow = matrix.length - 1;
        int currCol = 0;

        while (currRow >= 0 && currCol < matrix[0].length) {
            if (matrix[currRow][currCol] < target) {
                currCol++;
            } else if (matrix[currRow][currCol] > target) {
                currRow--;
            } else {
                return true;
            }
        }
        return false;
    }
    public boolean searchMatrixNew(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 1) {
            return false;
        }
        int columns = 0;
        int rows = matrix.length - 1;

        while (rows >= 0 && columns < matrix[0].length) {
            if(target > matrix[rows][columns]){
                columns++;
            }else if(target < matrix[rows][columns]){
                rows--;
            }else{
                return true;
            }
        }
        return false;
    }
}