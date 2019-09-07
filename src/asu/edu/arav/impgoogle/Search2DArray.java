package asu.edu.arav.impgoogle;
/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class Search2DArray {
    public boolean searchMatrix(int[][] matrix, int target) {
        int currRow = matrix.length -1;
        int currCol = 0;

        while(currRow >= 0 && currCol < matrix[0].length){
            if(matrix[currRow][currCol] < target){
                currCol++;
            }else if(matrix[currRow][currCol] > target){
                currRow--;
            }else{
                return true;
            }
        }
        return false;
    }
}