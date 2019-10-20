package asu.edu.arav.nutanix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 */
public class PaintFence {
    public static int minWays(int n, int[] arr) {
        List<Integer> inBetweenZeros = new ArrayList<Integer>();
        int currentZeros = 1;
        boolean isFirst = false;
        for (int i = 0; i < arr.length; i++) {
            if (!isFirst && arr[i] == 1) {
                isFirst = true;
            } else if (arr[i] == 1) {
                inBetweenZeros.add(currentZeros);
                currentZeros = 1;
            } else if (arr[i] == 0) {
                currentZeros++;
            }
        }
        int res = isFirst ? 1 : 0;
        for(int zeros : inBetweenZeros){
            res *= zeros;
        }
        return res;
    }

    public static void main(String [] args){
        System.out.println(minWays(5, new int[] {1,0,1,1,1,1,1,1}));
    }
}
