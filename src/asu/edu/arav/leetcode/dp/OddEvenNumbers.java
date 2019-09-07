package asu.edu.arav.leetcode.dp;

import java.util.TreeMap;

public class OddEvenNumbers {

    public static int oddEvenJumps(int[] A) {

        int n = A.length;
        int ans = 0;
        int[][] ansArray = new int[A.length][2];
        TreeMap<Integer, Integer> valuesToInteger = new TreeMap<Integer, Integer>();
        ansArray[n - 1][0] = ansArray[n - 1][1] = 1;
        valuesToInteger.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if(valuesToInteger.containsKey(A[i])){
                ansArray[i][0] = ansArray[valuesToInteger.get(A[i])][1];
                ansArray[i][1] = ansArray[valuesToInteger.get(A[i])][0];
            }
            else {
                Integer lowerIndex = valuesToInteger.lowerKey(A[i]);
                Integer higherIndex = valuesToInteger.higherKey(A[i]);

                if (lowerIndex != null) {
                    ansArray[i][1] = ansArray[valuesToInteger.get(lowerIndex)][0];
                }
                if (higherIndex != null) {
                    ansArray[i][0] = ansArray[valuesToInteger.get(higherIndex)][1];
                }
            }
            valuesToInteger.put(A[i], i);
        }

        for(int [] oddOrEven: ansArray){
            if(oddOrEven[0] == 1){
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int [] inp = new int[]{10,13,12,14,15};
        System.out.println(oddEvenJumps(inp));

    }


}
