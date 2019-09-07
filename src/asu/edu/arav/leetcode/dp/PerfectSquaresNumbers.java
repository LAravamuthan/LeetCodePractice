package asu.edu.arav.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquaresNumbers {
    public static int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        int[] digitsAtSum = new int[n + 1];
        digitsAtSum[0] = 0;

        List<Integer> squares = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        for (int i = 1; i <= n; i++) {
            int tempDigits = Integer.MAX_VALUE;
            for (int j = 0; j < squares.size() && squares.get(j) <= i ; j++) {
                tempDigits = Math.min(tempDigits, digitsAtSum[i - squares.get(j)] + 1);
            }
            digitsAtSum[i] = tempDigits;
        }
        return digitsAtSum[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(9));
        System.out.println(numSquares(10));
        System.out.println(numSquares(13));
    }
}
