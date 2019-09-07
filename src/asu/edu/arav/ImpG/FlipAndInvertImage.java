package asu.edu.arav.ImpG;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class FlipAndInvertImage {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length / 2; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;

                } else {
                    A[i][j] = 0;
                }
                if (A[i][A[0].length - 1 - j] == 0) {
                    A[i][A[0].length - 1 - j] = 1;
                } else {
                    A[i][A[0].length - 1 - j] = 0;
                }
                int temp = A[i][j];
                A[i][j] = A[i][A[0].length - 1 - j];
                A[i][A[0].length - 1 - j] = temp;
            }
            if(A[0].length % 2 != 0){
                if (A[i][A[0].length/2] == 0) {
                    A[i][A[0].length/2] = 1;
                } else {
                    A[i][A[0].length/2] = 0;
                }
            }
        }
        return A;
    }
}
