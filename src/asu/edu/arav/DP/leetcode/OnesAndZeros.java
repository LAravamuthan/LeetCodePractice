package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        if ((m == 0 && n == 0) || strs == null || strs.length == 0) {
            return 0;
        }
        int [][] countOfStringAtThatZerosOnes = new int[m+1][n+1];
        for(String s : strs){
            int [] counts = countZerosOnes(s);
            for(int zeros = m; zeros >= counts[0]; zeros--){
                for(int ones = n; ones >= counts[1]; ones--){
                    countOfStringAtThatZerosOnes[zeros][ones] = Math.max(
                            countOfStringAtThatZerosOnes[zeros - counts[0]][ones - counts[1]] + 1,
                            countOfStringAtThatZerosOnes[zeros][ones]);
                }
            }
        }
        return countOfStringAtThatZerosOnes[m][n];
    }

    public int[] countZerosOnes(String s) {
        int[] counts = new int[2];
        for (char c : s.toCharArray()) {
            if (c == '0') {
                counts[0]++;
            } else if (c == '1') {
                counts[1]++;
            }
        }
        return counts;
    }
}
