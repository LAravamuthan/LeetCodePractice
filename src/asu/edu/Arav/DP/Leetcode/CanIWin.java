package asu.edu.Arav.DP.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class CanIWin {
    public static Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    public static boolean[] used;

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        int maxSum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (maxSum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;
        used = new boolean[maxChoosableInteger + 1];
        return recursion(desiredTotal);
    }

    public static boolean recursion(int desiredTotal) {
        if(desiredTotal <= 0){
            return false;
        }
        int key = hashcode();
        if(map.get(key) != null){
            return map.get(key);
        }
        boolean currentKeyDesiredTotalResult = false;
        for(int i = 1; i < used.length && !currentKeyDesiredTotalResult; i++){
            if(used[i]){
                continue;
            }
            used[i] = true;
            currentKeyDesiredTotalResult = currentKeyDesiredTotalResult || !recursion(desiredTotal - i);
            used[i] = false;
        }
        map.put(key, currentKeyDesiredTotalResult);
        return map.get(key);
    }

    private static int hashcode() {
        int res = 0;
        for (int num = 1; num < used.length; ++num) {
            if (used[num]) {
                continue;
            }
            res |= (1 << num);
        }
        return res;
    }

    public static void main(String [] args){
        System.out.println(canIWin(10, 47));
    }
}
